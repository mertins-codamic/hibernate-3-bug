package com.codamai.cms.models;

import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
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
public class TestCustomerAddress extends TenantDataModel {
  /** persons on this address. */
  @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  private Collection<TestCustomerPerson> persons;
  /** company name. */
  private String street = null;
  /** company name. */
  private String city = null;
  /** company name. */
  private Integer zip = null;

  @Override
  public void init() {
    // TODO Auto-generated method stub

  }

}
