package com.codamai.cms.models;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

/**
 * Some abstract testing.
 * 
 * @author mertins-d
 */
@Getter
@Setter
@Entity
@DiscriminatorColumn(name = "_MODELTYPE")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class TestAbstract extends TenantDataModel {
  /** set model type for JPA. */
  @JsonIgnore
  @Column(name = "_MODELTYPE", insertable = false, updatable = false)
  private String _MODELTYPE;

  /** test string 1. */
  private String test = "";

  /** company. */
  @ManyToOne(cascade = {})
  private TestCustomerCompany company;

  /** company. */
  @ManyToOne(cascade = {})
  private TestCustomerCompany company1;

  /** multiple company. */
  @OneToMany(mappedBy = "abstractTest")
  private Collection<TestCustomerCompany> companyList;

  /** multiple abstracts. */
  @OneToMany(mappedBy = "deepListAnchor", cascade = {}, fetch = FetchType.LAZY)
  private Collection<TestDeepAbstract> someList;
}
