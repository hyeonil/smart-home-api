package kr.pe.nuti.home.api.core.expression;

import java.util.Map;

/**
 * Deducible data Class.
 *
 */
public interface DeducibleData {

  void set(Map<String, Object> data);

  void put(Map<String, Object> data);

  void put(String key, Object value);

  Map<String, Object> get();

  Object get(String key);

  Object remove(String key);
}
