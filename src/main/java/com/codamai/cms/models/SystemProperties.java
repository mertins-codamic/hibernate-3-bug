package com.codamai.cms.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 * multiple per system.
 * 
 * @author mertins-d
 */
@Getter
@Setter
@Entity
public class SystemProperties extends SystemDataModel {
  /** a system version. */
  @Column(name = "column_key")
  private String key;
  /** a system version. */
  @Column(name = "column_value")
  private String value;

  @Override
  public void init() {
    // nothing here
  }
}
