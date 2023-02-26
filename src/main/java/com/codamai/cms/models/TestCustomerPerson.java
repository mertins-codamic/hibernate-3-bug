package com.codamai.cms.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;

import org.hibernate.validator.constraints.Length;

import com.codamai.cms.enums.EnumTest;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeName;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

/**
 * Model for tests.
 * 
 * @author mertins-d
 */
@Getter
@Setter
@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = As.EXISTING_PROPERTY, property = "@type", defaultImpl = TestCustomerPerson.class)
@DiscriminatorValue("TestCustomerPerson")
@JsonTypeName("TestCustomerPerson")
public class TestCustomerPerson extends TenantDataModel {
  /** persons on this address. */
  @ManyToMany(mappedBy = "persons", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  private Collection<TestCustomerAddress> addresses;
  /** persons on this address. */
  @OneToMany(mappedBy = "ceo", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  private Collection<TestCustomerCompany> ceoOfCompany;
  /** simple example field firstname. */
  private String firstname;
  /** simple example field lastname. */
  @NotNull
  private String lastname;

  /** The double test. */
  private Double someDouble;

  /** The age. */
  @Min(value = 0)
  private Integer age;

  /** The percent. */
  @Min(value = 0)
  @Max(value = 100)
  private Integer percent;

  /** The iban. */
  @Pattern(regexp = "DE[A-Z0-9]{12}")
  private String IBAN;

  /** The some date. */
  private LocalDate dateOnly;

  /** The some time. */
  private LocalTime timeOnly;

  /** The some date in past. */
  @Past
  private LocalDateTime someDateInPast;

  /** The some date in past or now. */
  @PastOrPresent
  private LocalDateTime someDateInPastOrNow;

  /** The some future date. */
  @Future
  private LocalDateTime someFutureDate;

  /** The some future date or now. */
  @FutureOrPresent
  private LocalDateTime someFutureDateOrNow;

  /** The special role. */
  @Length(min = 5, max = 120)
  private String specialRole;

  /** The special role. */
  private String specialWriteRole;

  /** The special role. */
  private String specialReadRole;

  /** The no update. */
  private String noUpdate;

  /** The no read. */
  private String noRead;

  /** The no read. */
  private String updateOnlyNoDefault;

  /** a customer company. */
  @ManyToOne(cascade = CascadeType.MERGE)
  private TestCustomerCompany company;

  /** a customer company. */
  @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  private TestCustomerCompany companyRekuPersist;

  /** a customer company. */
  @ManyToOne(cascade = CascadeType.PERSIST)
  private TestCustomerCompany companyCreate;

  /** a customer company. */
  @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REMOVE })
  private TestCustomerCompany companyDelete;

  /** a customer company required two AND . */
  @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  private TestCustomerCompany companyCreateTwoAnd;

  /** a customer company. */
  @ManyToOne(cascade = CascadeType.PERSIST)
  private TestCustomerCompany companyCreateTwoOr;

  /** a parent person. */
  @ManyToOne(optional = true)
  private TestCustomerPerson parent;

  /** persons on this address. */
  @OneToMany(mappedBy = "parent", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  private Collection<TestCustomerPerson> children;

  /** an enum test. */
  private EnumTest enumTest;

  /** an boolean test. */
  private Boolean boolTest;

  @Override
  public void init() {
    // TODO Auto-generated method stub
    
  }
}