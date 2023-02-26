package com.codamai.cms.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

/**
 * Some middle abstract testing. (parent and this class booth abstract)
 * 
 * @author mertins-d
 */
@Getter
@Setter
@Entity
@DiscriminatorColumn(name = "_MODELTYPE")
// FIXME: With extends "TestAbstract" creation of table schema not possible, with "TenantDataModel" possible, but test failed.
public abstract class TestDeepAbstract extends TenantDataModel {
  /** set model type for JPA. */
  @JsonIgnore
  @Column(name = "_MODELTYPE", insertable = false, updatable = false)
  private String _MODELTYPE;
  /** test string 1. */
  private String deep = "";
  /** link to settings. */
  @OneToOne
  private CompanySettings someSettings;
  /** anchor. */
  @ManyToOne
  private TestAbstract deepListAnchor;
  /** reference to abstract model. */
  @OneToOne
  private TestAbstractB someBackReference;
}
