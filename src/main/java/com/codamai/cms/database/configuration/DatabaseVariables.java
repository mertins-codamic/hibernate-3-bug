package com.codamai.cms.database.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.codamai.cms.system.ApplicationEnvironmentKeys;

import lombok.Getter;

/**
 * Database configuration variables.
 * 
 * @author mertins-d
 */
@Component
@Getter
public class DatabaseVariables {
  /** split the alias fields of JPA tuples with this char. */
  public static final String aliasFieldSplitter = ".";
  /** split the alias references of JPA tuples with this char. */
  public static final String aliasReferenceSplitter = "___";
  /** The database prefix name. */
  @Value("${" + ApplicationEnvironmentKeys.DATABASE_NAME + "}")
  private String DATABASE_NAME;
  /** The database password. */
  @Value("${" + ApplicationEnvironmentKeys.DATABASE_PASSWORD + "}")
  private String DATABASE_PASSWORD;
  /** The database driver. */
  @Value("${" + ApplicationEnvironmentKeys.DATABASE_DRIVER + "}")
  private String DATABASE_DRIVER;
  /** The database user. */
  @Value("${" + ApplicationEnvironmentKeys.DATABASE_USER + "}")
  private String DATABASE_USER;
  /** The database URL. */
  @Value("${" + ApplicationEnvironmentKeys.DATABASE_URL + "}")
  private String DATABASE_URL;
  /** The database URL. */
  private boolean DATABASE_DEBUG = true;
  /** connection details. */
  private static final String connectionDetails = ";DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;";

  @SuppressWarnings("static-method")
  @Bean(name = "SingleTenantDataSource")
  protected DataSource getDataSource() {
    return DataSourceBuilder.create().driverClassName("org.h2.Driver")
        .url("jdbc:h2:mem:testdb/cms" + connectionDetails).username("sa")
        .password("").build();
  }
  
  /**
   * Configuration for database source.
   * 
   * @param pTenant tenant or null
   * @return configuration map
   */
  public Map<String, String> getConfiguration(String pTenant) {
    Map<String, String> configuration = new HashMap<String, String>();
    configuration.put("jakarta.persistence.jdbc.driver", this.getDATABASE_DRIVER());
    configuration.put("jakarta.persistence.jdbc.url", this.getDatabaseUrl(pTenant));
    configuration.put("jakarta.persistence.jdbc.user", this.getDATABASE_USER());
    configuration.put("jakarta.persistence.jdbc.password", this.getDATABASE_PASSWORD());
    configuration.put("jakarta.persistence.schema-generation.database.action", "update");
    return configuration;
  }

  /**
   * full Uri of database.
   * 
   * @param pTenant tenant id or null
   * @return url to database
   */
  public String getDatabaseUrl(String pTenant) {
    String url = this.DATABASE_URL;
    if (!url.endsWith("/")) {
      url += "/";
    }
    url += getDatabaseName(pTenant);
    return url;
  }

  /**
   * Database name with tenant.
   * 
   * @param pTenant null if system
   * @return Database name
   */
  public String getDatabaseName(String pTenant) {
    String dbName = this.DATABASE_NAME;
    if (pTenant != null) {
      dbName += "-" + pTenant;
    }
    return dbName;
  }
}
