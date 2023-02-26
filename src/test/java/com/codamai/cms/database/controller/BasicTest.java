package com.codamai.cms.database.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlConfig;

import com.codamai.cms.models.TestCustomerPerson;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Selection;

/**
 * basic jakarta test.
 * 
 * @author mertins-d
 */
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
@TestPropertySource(locations = "classpath:test-single-tenant-database.properties")
@ExtendWith(MockitoExtension.class)
@ActiveProfiles({ "test" })
public class BasicTest {
  @PersistenceContext
  private EntityManager em;

  @Test
  @Sql(config = @SqlConfig(dataSource = "SingleTenantDataSource"), statements = "INSERT INTO test_customer_person (id, firstname, lastname, _CREATED_ON) VALUES ('1', 'hans', 'meister', '1986-12-30 12:00:00')", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
  @Sql(config = @SqlConfig(dataSource = "SingleTenantDataSource"), statements = "INSERT INTO test_customer_person (id, firstname, lastname, _CREATED_ON) VALUES ('2', 'bob', 'burger', '1986-12-30 12:00:00')", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
  @Sql(config = @SqlConfig(dataSource = "SingleTenantDataSource"), statements = "INSERT INTO test_customer_person (id, firstname, lastname, _CREATED_ON) VALUES ('3', 'hans', 'burger', '1986-12-30 12:00:00')", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
  @Sql(config = @SqlConfig(dataSource = "SingleTenantDataSource"), statements = "DELETE FROM test_customer_person", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
  void testWhere() {
    CriteriaBuilder cb = this.em.getCriteriaBuilder();

    CriteriaQuery<Tuple> query = cb.createTupleQuery();
    Root<TestCustomerPerson> root = query.from(TestCustomerPerson.class);
    List<Selection<?>> selectFields = new ArrayList<Selection<?>>();
    selectFields.add(root.get("id").alias("id"));
    query.multiselect(selectFields);

    List<Predicate> exps = new ArrayList<Predicate>();
    exps.add(cb.equal(root.get("firstname"), "hans"));
    exps.add(cb.equal(root.get("lastname"), "meister"));
    Predicate andClaus = cb.and(exps.toArray(new Predicate[0]));


    List<Predicate> exps1 = new ArrayList<Predicate>();
    exps1.add(cb.equal(root.get("firstname"), "bob"));
    exps1.add(cb.equal(root.get("lastname"), "burger"));
    Predicate andClaus1 = cb.and(exps1.toArray(new Predicate[0]));

    
    List<Predicate> ober = new ArrayList<Predicate>();
    ober.add(andClaus);
    ober.add(andClaus1);
    Predicate orClaus = cb.or(ober.toArray(new Predicate[0]));
    
    query.where(orClaus);

//    try (EntityManager em = this.emf.createEntityManager()) {
      TypedQuery<Tuple> listQueryWithoutPagination = em.createQuery(query);

      List<Tuple> tupleResult = listQueryWithoutPagination.getResultList();
      assertEquals(2, tupleResult.size());
      
      TestCustomerPerson tcp = em.find(TestCustomerPerson.class, "1");
      assertNotNull(tcp);
//    }
  }
}
