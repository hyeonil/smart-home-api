package kr.pe.nuti.home.api.pack.line;

public class LineEnvironmentVariables {
  private LineEnvironmentVariables() {
    throw new IllegalAccessError("illegal access");
  }

  public static final String AUTH_TOKEN = "LINE_AUTH_TOKEN";

  public static final String OWNER_ID = "LINE_OWNER_ID";
}
