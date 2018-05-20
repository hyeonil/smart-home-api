package kr.pe.nuti.home.api.core.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public final class JSONUtil {

  private static final Logger logger = LoggerFactory.getLogger(JSONUtil.class);

  private JSONUtil() {
    throw new IllegalAccessError("illegal access");
  }

  public static String mapToJsonString(Map<String, Object> dataMap) {
    final ObjectMapper objectMapper = new ObjectMapper();
    String jsonString = null;

    try {
      jsonString = objectMapper.writeValueAsString(dataMap);
    } catch (JsonProcessingException e) {
      logger.error("exception is occurred while parsing to json string", e);
    }

    return jsonString;
  }
}
