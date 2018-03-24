package kr.pe.nuti.home.api.core.helper;

import kr.pe.nuti.home.api.core.expression.DeducibleData;
import kr.pe.nuti.home.api.core.util.OptionalUtil;

import java.util.LinkedHashMap;
import java.util.Map;

import static kr.pe.nuti.home.api.core.util.OptionalUtil.throwIllegalArgumentExceptionIfNotPresent;

public class DeducibleDataHelper implements DeducibleData {
  private Map<String, Object> data;

  public DeducibleDataHelper() {
    data = new LinkedHashMap<>();
  }


  @Override
  public void set(Map<String, Object> data) {
    data = throwIllegalArgumentExceptionIfNotPresent(data);
    this.data = data;
  }

  @Override
  public void put(Map<String, Object> data) {
    data = throwIllegalArgumentExceptionIfNotPresent(data);
    this.data.putAll(data);
  }

  @Override
  public void put(String key, Object value) {
    this.data.put(key, value);
  }

  @Override
  public Map<String, Object> get() {
    return data;
  }

  @Override
  public Object get(String key) {
    return data.get(key);
  }

  @Override
  public Object remove(String key) {
    return data.remove(key);
  }
}
