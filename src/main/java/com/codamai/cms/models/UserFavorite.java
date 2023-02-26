package com.codamai.cms.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 * Once per user.
 * 
 * @author mertins-d
 */
@Getter
@Setter
@Entity
public class UserFavorite extends UserDataModel {
  /** module. */
  private String module;

  @Override
  public void init() {
    // TODO Auto-generated method stub
  }

}
