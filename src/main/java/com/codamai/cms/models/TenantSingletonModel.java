package com.codamai.cms.models;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 * Singleton object, where you can only have one object per tenant. (Example: Company-Settings) The tenant data model is available for all users with access. In multiple tenant systems only the current tenant have access. Data will be stored in separate databases for each tenant. It results in a table with only one entry.
 * 
 * @author Daniel M.
 */
@Getter
@Setter
@MappedSuperclass
public abstract class TenantSingletonModel extends AbstractModel {
  // just a mapper, because in multi tenant always one in a database
}
