package kr.pe.nuti.home.api.web.advice;

import kr.pe.nuti.home.api.core.exception.FlexibleException;
import kr.pe.nuti.home.api.core.exception.StrictException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {

  @ExceptionHandler(FlexibleException.class)
  public Object handleFlexibleException() {
    return null;
  }

  @ExceptionHandler(StrictException.class)
  public Object handleStrictException() {
    return null;
  }

  @ExceptionHandler(Exception.class)
  public Object handleException() {
    return null;
  }

  @ExceptionHandler(RuntimeException.class)
  public Object handleRuntimeException() {
    return null;
  }
}
