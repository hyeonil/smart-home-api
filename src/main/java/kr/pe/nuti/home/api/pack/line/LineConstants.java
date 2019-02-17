package kr.pe.nuti.home.api.pack.line;

public class LineConstants {
  private LineConstants() {
    throw new IllegalAccessError("illegal access");
  }

  public static final String URL_API_BASE = "https://api.line.me/v2/bot";

  public static final String URL_MESSAGE_PUSH = "/message/push";

  public static final String AUTH_HEADER = "Authorization";
}
