package com.codamai.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * ** DONT MODIFY THIS FILE **.
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@ComponentScan
@EnableAutoConfiguration
public class StartTest {
  /**
   * This is your start class. See required Environments in Documentation to start.
   * 
   * @param args argument
   **/
  @SuppressWarnings("resource")
  public static void main(String[] args) {
    SpringApplication.run(StartTest.class, args);
  }
}
