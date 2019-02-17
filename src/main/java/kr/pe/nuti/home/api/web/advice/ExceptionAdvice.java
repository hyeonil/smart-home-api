package kr.pe.nuti.home.api.web.advice;

import kr.pe.nuti.home.api.core.constant.Constants;
import kr.pe.nuti.home.api.core.exception.FlexibleException;
import kr.pe.nuti.home.api.core.exception.StrictException;
import kr.pe.nuti.home.api.core.expression.DeducibleData;
import kr.pe.nuti.home.api.core.util.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Arrays;

@ControllerAdvice
public class ExceptionAdvice {

  private static final Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);

  @ExceptionHandler(FlexibleException.class)
  @ResponseBody
  public Object handleFlexibleException(HttpServletRequest request, HttpServletResponse response, FlexibleException e) {
    return handleDeducibleData(request, response, e);
  }

  @ExceptionHandler(StrictException.class)
  @ResponseBody
  public Object handleStrictException(HttpServletRequest request, HttpServletResponse response, StrictException e) {
    return handleDeducibleData(request, response, e);
  }

  @ExceptionHandler(Exception.class)
  public Object handleException() {
    return null;
  }

  @ExceptionHandler(RuntimeException.class)
  public Object handleRuntimeException() {
    return null;
  }

  private Object handleDeducibleData(HttpServletRequest request, HttpServletResponse response, DeducibleData data) {
    response.setCharacterEncoding(Constants.CHARSET_UTF8);
    response.setContentType(Constants.CONTENT_TYPE_APPLICATION_JSON_UTF8);

    return data.get();
  }
}
