package com.codamai.cms.models;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

/**
 * The tenant data model is available for all users with access. In multiple tenant systems only the current tenant have access. Data will be stored in separate databases for each tenant.
 * 
 * @author Daniel M.
 */
@Getter
@Setter
@MappedSuperclass
public abstract class TenantDataModel extends AbstractModel {
  // currently only a wrapper
}
