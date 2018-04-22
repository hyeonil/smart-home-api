package kr.pe.nuti.home.api.core.constant;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Collection of Constant
 *
 * @since 1.0.0
 */
public final class Constants {

  private Constants() {
    throw new IllegalAccessError("illegal access");
  }

  /**
   * spring-security-redirect-login-failure
   */
  public static final String SECURITY_REDIRECT_LOGIN_FAILURE = "spring-security-redirect-login-failure";


  /**
   * xml
   */
  public static final String STRING_XML = "xml";

  /**
   * html
   */
  public static final String STRING_HTML = "html";

  /**
   * json
   */
  public static final String STRING_JSON = "json";




  /**
   * CharacterSet UTF-8
   */
  public static final String CHARSET_UTF8 = "UTF-8";




  /**
   * XML HTTP REQUEST(Ajax 요청)
   */
  public static final String XML_HTTP_REQUEST = "XMLHttpRequest";




  /**
   * Request Header X-Requested-With
   */
  public static final String REQUEST_HEADER_X_REQUESTED_WITH = "X-Requested-With";

  public static final String REQUEST_HEADER_X_FORWARDED_FOR = "X-Forwarded-For";

  /**
   * Request Header accept
   */
  public static final String REQUEST_HEADER_ACCEPT = "accept";


  public static final String RESPONSE_HEADER_LOCATION = "Location";

  public static final String RESPONSE_HEADER_ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";

  public static final String RESPONSE_HEADER_ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";

  public static final String RESPONSE_HEADER_ACCESS_CONTROL_MAX_AGE = "Access-Control-Max-Age";

  public static final String RESPONSE_HEADER_ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";

  public static final String RESPONSE_HEADER_ACCESS_CONTROL_ALLOW_CREDENTIALS = "Access-Control-Allow-Credentials";



  public static final String CONTENT_TYPE_APPLICATION_URL_FOROM_ENCODED = "application/x-www-form-urlencoded";

  /**
   * Content Type application/octet-stream
   */
  public static final String CONTENT_TYPE_APPLICATION_OCTET = "application/octet-stream";

  /**
   * Content Type application/xml
   */
  public static final String CONTENT_TYPE_APPLICATION_XML = "application/xml";

  /**
   * Content Type application/xml; charset=UTF-8
   */
  public static final String CONTENT_TYPE_APPLICATION_XML_UTF8 = "application/xml; charset=UTF-8";

  /**
   * Content Type application/json
   */
  public static final String CONTENT_TYPE_APPLICATION_JSON = "application/json";

  /**
   * Content Type application/json; charset=UTF8
   */
  public static final String CONTENT_TYPE_APPLICATION_JSON_UTF8 = "application/json; charset=UTF-8";

  /**
   * Content Type application/vnd.ms-excel
   */
  public static final String CONTENT_TYPE_APPLICATION_EXCEL = "application/vnd.ms-excel";

  /**
   * Content Type image/gif
   */
  public static final String CONTENT_TYPE_IMAGE_GIF = "image/gif";

  /**
   * Content Type image/jpeg
   */
  public static final String CONTENT_TYPE_IMAGE_JPEG = "image/jpeg";

  /**
   * Content Type image/png
   */
  public static final String CONTENT_TYPE_IMAGE_PNG = "image/png";

  public static final String CONTENT_TYPE_TEXT_HTML = "text/html";


  private static final Map<String, Object> nameToValueMap = createNameToValueMap();

  private static Map<String, Object> createNameToValueMap() {
    Map<String, Object> result = new HashMap();
    Field[] publicFields = Constants.class.getFields();
    for (int i = 0; i < publicFields.length; i++) {
      Field field = publicFields[i];
      String name = field.getName();
      try {
        result.put(name, field.get(null));
      } catch (Exception e) {
        e.printStackTrace(System.err);
      }
    }

    return result;
  }

  public static Map<String, Object> getNameToValueMap() {
    return nameToValueMap;
  }
}
