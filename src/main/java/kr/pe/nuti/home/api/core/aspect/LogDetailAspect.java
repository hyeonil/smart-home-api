package kr.pe.nuti.home.api.core.aspect;

import kr.pe.nuti.home.api.core.annotation.LogDetail;
import kr.pe.nuti.home.api.core.util.LogUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogDetailAspect {

  private static final Logger logger = LoggerFactory.getLogger(LogDetailAspect.class);

  @Around("execution(* kr.pe.nuti.home.api..*.*(..)) && @annotation(logDetail)")
  public Object aroundTargetObject(ProceedingJoinPoint joinPoint, LogDetail logDetail) throws Throwable {
    Object target = joinPoint.getTarget();
    Object[] args = joinPoint.getArgs();

    String className = target.getClass().getName();
    String methodName = joinPoint.getSignature().getName();
    StringBuilder argBuilder = new StringBuilder();

    for (Object arg : args) {
      argBuilder.append(LogUtil.argValues(arg, 0))
          .append("\n");
    }
    String argString = argBuilder.toString();

    logger.debug("invoke method {}${}", className, methodName);
    logger.debug("method arguments: {}", argString);

    Object result  = joinPoint.proceed(args);

    logger.debug("finish the method {}${}", className, methodName);

    return result;
  }
}


