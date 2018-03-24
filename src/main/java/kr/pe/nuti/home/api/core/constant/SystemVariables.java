package kr.pe.nuti.home.api.core.constant;

public class SystemVariables {

  private SystemVariables() {
    throw new IllegalAccessError("illegal access");
  }

  public static final String APPLICATION_ENVIRONMENT = System.getProperty("application.environment", "develop");
}
