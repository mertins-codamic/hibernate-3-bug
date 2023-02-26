package com.codamai.cms.models;

import java.util.ArrayList;
import java.util.Collection;

import com.codamai.cms.enums.EnumTest;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

/**
 * a simple company.
 * 
 * @author mertins-d
 */
@Getter
@Setter
@Entity
public class TestCustomerCompany extends TenantDataModel {
  /** company name. */
  private String companyname = null;
  /** employees in company. */
  @OneToMany(mappedBy = "company", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
  private Collection<TestCustomerPerson> employees;
  /** employees in company. */
  @OneToMany(mappedBy = "companyRekuPersist", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE })
  private Collection<TestCustomerPerson> employeesRekuPersist;
  /** a read only field. */
  private String readOnly = null;
  /** a read only with "special-read-role" field. */
  private String readOnlyWithRole;
  /** some boolean to work with. */
  private Boolean someBoolean;
  /** some enumeration to work with. */
  @Enumerated(EnumType.STRING)
  private EnumTest someEnum;
  /** The no read. */
  private String encryption;
  /** CEO of company. */
  @ManyToOne(cascade = CascadeType.MERGE)
  TestCustomerPerson ceo = null;
  /** test abstract model list. */
  @OneToMany(mappedBy = "company1", cascade = {}, fetch = FetchType.LAZY)
  private Collection<TestAbstract> companyList;
  /** test abstract model. */
  @ManyToOne
  private TestAbstract abstractTest = null;
  /** test abstract model. */
  @ManyToOne
  private TestAbstractA abstractATest = null;
  /** test abstract model list. */
  @OneToMany(mappedBy = "companyA", cascade = {}, fetch = FetchType.LAZY)
  private Collection<TestAbstractA> companyAList;

  /**
   * add item to persons.
   * 
   * @param item object
   * @return success
   */
  public boolean employeesAdd(TestCustomerPerson item) {
    if (item == null)
      return false;
    if (this.employees == null)
      this.employees = new ArrayList<TestCustomerPerson>();
    if (this.employees.contains(item))
      return false;
    if (this.equals(item.getCompany()))
      return false;
    item.setCompany(this);
    this.employees.add(item);
    this.set_processed(true);
    item.set_processed(true);
    return true;
  }

  /**
   * remove item from persons.
   * 
   * @param item object
   * @return success
   */
  public boolean employeesRemove(TestCustomerPerson item) {
    if (item == null)
      return false;
    if (!this.employees.contains(item))
      return false;
    item.setCompany(null);
    this.employees.remove(item);
    return true;
  }

  /**
   * add item to persons.
   * 
   * @param item object
   * @return success
   */
  public boolean employeesRekuPersistAdd(TestCustomerPerson item) {
    if (item == null)
      return false;
    if (this.employeesRekuPersist == null)
      this.employeesRekuPersist = new ArrayList<TestCustomerPerson>();
    if (this.employeesRekuPersist.contains(item))
      return false;
    item.setCompanyRekuPersist(this);
    this.employeesRekuPersist.add(item);
    this.set_processed(true);
    item.set_processed(true);
    return true;
  }

  /**
   * remove item from persons.
   * 
   * @param item object
   * @return success
   */
  public boolean employeesRekuPersistRemove(TestCustomerPerson item) {
    if (item == null)
      return false;
    if (!this.employeesRekuPersist.contains(item))
      return false;
    item.setCompanyRekuPersist(this);
    this.employeesRekuPersist.remove(item);
    return true;
  }

  /**
   * add item to persons.
   * 
   * @param item object
   * @return success
   */
  public boolean companyListAdd(TestAbstract item) {
    if (item == null)
      return false;
    if (this.companyList == null)
      this.companyList = new ArrayList<TestAbstract>();
    if (this.companyList.contains(item))
      return false;
    if (this.equals(item.getCompany()))
      return false;
    item.setCompany(this);
    this.companyList.add(item);
    this.set_processed(true);
    item.set_processed(true);
    return true;
  }

  /**
   * remove item from persons.
   * 
   * @param item object
   * @return success
   */
  public boolean companyListRemove(TestAbstract item) {
    if (item == null)
      return false;
    if (!this.companyList.contains(item))
      return false;
    item.setCompany(null);
    this.companyList.remove(item);
    return true;
  }

  /**
   * add item to persons.
   * 
   * @param item object
   * @return success
   */
  public boolean companyAListAdd(TestAbstractA item) {
    if (item == null)
      return false;
    if (this.companyAList == null)
      this.companyAList = new ArrayList<TestAbstractA>();
    if (this.companyAList.contains(item))
      return false;
    if (this.equals(item.getCompany()))
      return false;
    item.setCompany(this);
    this.companyAList.add(item);
    this.set_processed(true);
    item.set_processed(true);
    return true;
  }

  /**
   * remove item from persons.
   * 
   * @param item object
   * @return success
   */
  public boolean companyAListRemove(TestAbstractA item) {
    if (item == null)
      return false;
    if (!this.companyAList.contains(item))
      return false;
    item.setCompany(null);
    this.companyAList.remove(item);
    return true;
  }

  @Override
  public void init() {
    // ...
  }
}
