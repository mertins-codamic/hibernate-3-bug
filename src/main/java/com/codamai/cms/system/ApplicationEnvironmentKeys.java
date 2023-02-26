package com.codamai.cms.system;

/**
 * global environment keys for application, not specific to clients or modules.
 * 
 * @author Daniel
 */
public class ApplicationEnvironmentKeys {
	/** cms.database.mode. */
	public static final String DATABASE_MODE = "cms_database_mode";
	/** cms.database.driver. */
	public static final String DATABASE_DRIVER = "cms_database_driver";
	/** cms.database.user. */
	public static final String DATABASE_USER = "cms_database_user";
	/** cms.database.password. */
	public static final String DATABASE_PASSWORD = "cms_database_password";
	/** cms.database.url. */
	public static final String DATABASE_URL = "cms_database_url";
  /** cms.database.prefix. */
  public static final String DATABASE_NAME = "cms_database_prefix";
  /** cors configuration allowed origins. */
  public static final String CORS_ALLOWED_ORIGINS = "cors_allowed_origins";
  /** time format. */
  public static final String FORMAT_DATE = "format_date";
  /** date format. */
  public static final String FORMAT_TIME = "format_time";
  /** date time format. */
  public static final String FORMAT_DATETIME = "format_datetime";
  /** service account tenant header key name of HTTP requests. */
  public static final String SERVICE_ACCOUNT_TENANT_HEADER_KEY = "tenant";
  /** debug all. TODO Change to log level */
  public static final String DEBUG = "DEBUG";
}
