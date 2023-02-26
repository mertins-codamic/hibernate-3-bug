package com.codamai.cms.models;

import com.codamai.cms.enums.EnumTest;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
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
@DiscriminatorValue("TestDeepA")
public class TestDeepA extends TestDeepAbstract {
  /** some test string. */
  private String someDeepA;

  /** some enumeration to test in abstract. */
  @Enumerated(EnumType.STRING)
  private EnumTest type;

  /** link to settings. */
  @OneToOne
  private TestDeepA reference;

  /** link to settings. */
  @OneToOne(mappedBy = "reference")
  private TestDeepA reference_map;

  @Override
  public void init() {
    // nothing
  }
}
