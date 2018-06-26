package kr.pe.nuti.home.api.core.handler;

import kr.pe.nuti.home.api.core.annotation.LogDetail;
import kr.pe.nuti.home.api.core.util.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import static kr.pe.nuti.home.api.core.util.BooleanUtil.not;

public class LogDetailMethodInvocationHandler implements InvocationHandler {

  private static final Logger logger = LoggerFactory.getLogger(LogDetailMethodInvocationHandler.class);

  private Object target;

  public LogDetailMethodInvocationHandler(Object target) {
    this.target = target;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    if (not(method.isAnnotationPresent(LogDetail.class))) {
      return method.invoke(target, args);
    }
    String className = method.getDeclaringClass().getName();
    String methodName = method.getName();
    StringBuilder argBuilder = new StringBuilder();

    for (Object arg : args) {
      argBuilder.append(LogUtil.argValues(arg, 0))
          .append("\n");
    }
    String argString = argBuilder.toString();

    logger.info("invoke method {}${}", className, methodName);
    logger.info("method arguments: {}", argString);

    Object result  = method.invoke(target, args);

    logger.info("finish the method {}${}", className, methodName);

    return result;
  }
}
