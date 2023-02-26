package com.codamai.cms.models;

import jakarta.persistence.DiscriminatorValue;
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
@Entity(name = "UserSettings")
@DiscriminatorValue("UserSettings")
public class UserSettings extends UserSingletonModel {
  /** special user background. */
  private String wallpaperBackgroundUrl;

  @Override
  public void init() {
    // TODO Auto-generated method stub
  }

}
