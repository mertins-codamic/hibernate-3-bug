package com.codamai.cms.models;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@DiscriminatorValue("TestAbstractB")
public class TestAbstractB extends TestAbstract {
  /** some test string. */
  private String someInfoForBChild;

  /** multiple TestDeepA references. */
  @OneToMany(mappedBy = "someBackReference", cascade = {}, fetch = FetchType.LAZY)
  private Collection<TestDeepAbstract> someReferenceList;

  /**
   * add item to persons.
   * 
   * @param item object
   * @return success
   */
  public boolean someReferenceListAdd(TestDeepAbstract item) {
    if (item == null)
      return false;
    if (this.someReferenceList == null)
      this.someReferenceList = new ArrayList<TestDeepAbstract>();
    if (this.someReferenceList.contains(item))
      return false;
    if (this.equals(item.getSomeBackReference()))
      return false;
    item.setSomeBackReference(this);
    this.someReferenceList.add(item);
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
  public boolean someReferenceListRemove(TestDeepAbstract item) {
    if (item == null)
      return false;
    if (!this.someReferenceList.contains(item))
      return false;
    item.setSomeBackReference(null);
    this.someReferenceList.remove(item);
    return true;
  }

  @Override
  public void init() {
    // nothing
  }
}
