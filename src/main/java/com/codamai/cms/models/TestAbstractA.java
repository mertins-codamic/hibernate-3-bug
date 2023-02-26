package com.codamai.cms.models;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@DiscriminatorValue("TestAbstractA")
public class TestAbstractA extends TestAbstract {
  /** some test string. */
  private String someInfoForAChild;

  /** The no read. */
  private String encryption;

  /** company. */
  @ManyToOne(cascade = {})
  private TestCustomerCompany companyA;

  /** multiple company. */
  @OneToMany(mappedBy = "abstractATest", cascade = {})
  private Collection<TestCustomerCompany> companyAList;

  /**
   * add item to persons.
   * 
   * @param item object
   * @return success
   */
  public boolean companyAListAdd(TestCustomerCompany item) {
    if (item == null)
      return false;
    if (this.companyAList == null)
      this.companyAList = new ArrayList<TestCustomerCompany>();
    if (this.companyAList.contains(item))
      return false;
    if (this.equals(item.getAbstractATest()))
      return false;
    item.setAbstractATest(this);
    this.companyAList.add(item);
    this.set_processed(true);
    item.set_processed(true);
    return true;
  }

  /**
   * remove item from persons.
   * 
   * @param item object
   * @return success
   */
  public boolean companyAListRemove(TestCustomerCompany item) {
    if (item == null)
      return false;
    if (!this.companyAList.contains(item))
      return false;
    item.setAbstractATest(null);
    this.companyAList.remove(item);
    return true;
  }

  @Override
  public void init() {
    // nothing
  }
}
