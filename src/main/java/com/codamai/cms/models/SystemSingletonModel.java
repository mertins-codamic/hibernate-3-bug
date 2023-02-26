package com.codamai.cms.models;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 * Singleton object, where you can only have one object in the system. (Example: System-Settings) System wide data object. All users in all tenants with access can read / edit. Data will be stored in the main database in multiple tenant systems. It results in a table with only one entry.
 * 
 * @author Daniel M.
 */
@Getter
@Setter
@MappedSuperclass
public abstract class SystemSingletonModel extends AbstractModel {
  // just a wrapper for system data model subclasses.
}
