package com.codamai.cms.models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 * A user data model has the owner id. One user can have multiple objects, no one else can see or change (except technical users). Data will be stored in one table for each tenant.
 * 
 * @author mertins-d
 */
@Getter
@Setter
@MappedSuperclass
public abstract class UserDataModel extends AbstractModel {
  /**
   * id of object owner. Once set, no update should be possible.
   */
  @Column(name = "_ownerId", nullable = false, updatable = false)
  private String _ownerId;
}
