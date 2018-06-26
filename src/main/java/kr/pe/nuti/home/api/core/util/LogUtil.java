package kr.pe.nuti.home.api.core.util;

import kr.pe.nuti.home.api.core.annotation.TrackLog;

import java.lang.reflect.Field;

import static kr.pe.nuti.home.api.core.util.BooleanUtil.not;

public final class LogUtil {

  private LogUtil() {
    throw new IllegalAccessError();
  }

  public static String argValues(Object arg, int depth) throws IllegalAccessException {
    if (arg == null) {
      return "null";
    }
    final Class<?> cls = arg.getClass();

    if (cls.isPrimitive() || cls.isAssignableFrom(String.class) || not(cls.isAnnotationPresent(TrackLog.class))) {
      return arg.toString();
    }

    StringBuilder builder = new StringBuilder();
    builder.append(whiteSpace(depth)).append(cls.getName()).append("{\n");

    for (Field field : cls.getDeclaredFields()) {
      field.setAccessible(true);
      Object fieldObj = field.get(arg);
      builder.append(whiteSpace(depth + 1))
          .append(field.getName())
          .append(" : ")
          .append(argValues(fieldObj, depth + 1))
          .append("\n");
    }

    builder.append("}");

    return builder.toString();
  }

  public static String whiteSpace(int depth) {
    final String appender = "  ";
    StringBuilder builder = new StringBuilder();

    for (int i = 0; i < depth; i++) {
      builder.append(appender);
    }

    return builder.toString();
  }
}
