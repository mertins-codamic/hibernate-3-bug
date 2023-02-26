package com.codamai.cms.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 * Some Child Information.
 * 
 * @author mertins-d
 */
@Getter
@Setter
@Entity
@DiscriminatorValue("TestDeepB")
public class TestDeepB extends TestDeepAbstract {
  /** some test string. */
  private String someDeepB;

  @Override
  public void init() {
    // nothing
  }
}
