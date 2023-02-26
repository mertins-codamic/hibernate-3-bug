package com.codamai.cms.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * Some Invoice.
 * 
 * @author mertins-d
 */
@Getter
@Setter
@Entity
public class TestCustomerInvoice extends TenantDataModel {
  /** invoice number. */
  private String invoiceNumber;
  /** hook on type. */
  @NotNull
  private String hookOnClass;
  /** hook direct on field. */
  @NotNull
  private String hookOnField;

  @Override
  public void init() {
    // TODO Auto-generated method stub

  }
}
