package com.codamai.cms.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 * Once per user.
 * 
 * @author mertins-d
 */
@Getter
@Setter
@Entity
public class SystemSettings extends SystemSingletonModel {
  /** a system version. */
  private String version;

  @Override
  public void init() {
    // nothing here
  }
}
