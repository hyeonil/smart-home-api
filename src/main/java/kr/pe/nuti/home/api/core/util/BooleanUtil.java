package kr.pe.nuti.home.api.core.util;

/**
 * Boolean 관련 Util
 *
 * @since 1.0.0
 */
public final class BooleanUtil {

  private BooleanUtil() {

  }

  /**
   * 파라미터의 반대 값을 반환
   *
   * @param value boolean 값
   *
   * @return 파라미터의 반대 값<br>
   *   true 일 경우: false<br>
   *   false 일 경우: true
   *
   * @since 1.0.0
   */
  public static boolean not(boolean value) {
    return ! value;
  }
}
