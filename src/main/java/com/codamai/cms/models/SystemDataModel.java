package com.codamai.cms.models;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 * System wide data object. All users in all tenants with access can read / edit. Data will be stored in the main database in multiple tenant systems.
 * 
 * @author Daniel M.
 */
@Getter
@Setter
@MappedSuperclass
public abstract class SystemDataModel extends AbstractModel {
  // just a wrapper for system data model subclasses.
}
