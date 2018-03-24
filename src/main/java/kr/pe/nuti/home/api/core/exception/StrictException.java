package kr.pe.nuti.home.api.core.exception;

import kr.pe.nuti.home.api.core.expression.DeducibleData;
import kr.pe.nuti.home.api.core.helper.DeducibleDataHelper;

import java.util.Map;

public class StrictException extends Exception implements DeducibleData {
  private DeducibleDataHelper helper;

  public StrictException() {
    super();
    this.helper = new DeducibleDataHelper();
  }

  @Override
  public void set(Map<String, Object> data) {
    helper.set(data);
  }

  @Override
  public void put(Map<String, Object> data) {
    helper.put(data);
  }

  @Override
  public void put(String key, Object value) {
    helper.put(key, value);
  }

  @Override
  public Map<String, Object> get() {
    return helper.get();
  }

  @Override
  public Object get(String key) {
    return helper.get(key);
  }

  @Override
  public Object remove(String key) {
    return helper.remove(key);
  }
}
