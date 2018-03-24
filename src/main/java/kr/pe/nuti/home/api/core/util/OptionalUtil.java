package kr.pe.nuti.home.api.core.util;

import java.util.Optional;

public final class OptionalUtil {

  private OptionalUtil() {
    throw new IllegalAccessError();
  }

  public static String emptyStringIfNotPresent(String value) {
    return Optional.ofNullable(value).orElse("");
  }

  public static Integer zeroIfNotPresent(Integer value) {
    return Optional.ofNullable(value).orElse(0);
  }

  public static Long zeroIfNotPresent(Long value) {
    return Optional.ofNullable(value).orElse(0L);
  }

  public static Float zeroIfNotPresent(Float value) {
    return Optional.ofNullable(value).orElse(0.0F);
  }

  public static Double zeroIfNotPresent(Double value) {
    return Optional.ofNullable(value).orElse(0.0);
  }

  public static Boolean falseIfNotPresent(Boolean value) {
    return Optional.ofNullable(value).orElse(Boolean.FALSE);
  }

  public static <T> T throwIllegalArgumentExceptionIfNotPresent(T value) {
    return Optional.ofNullable(value).orElseThrow(IllegalArgumentException::new);
  }
}
