package com.codamai.cms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

/**
 * Once per tenant.
 * 
 * @author mertins-d
 */
@Getter
@Setter
@Entity
public class CompanySettings extends TenantSingletonModel {
  /** name of the company. */
  private String companyName;

  /** Abstract recursive test. */
  @OneToOne(mappedBy = "someSettings")
  private TestDeepAbstract someAbstract;

  @Override
  public void init() {
    // nothing for test
  }

}
