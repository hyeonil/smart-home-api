package kr.pe.nuti.home.api.core.annotation;

import java.lang.annotation.*;

@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({
    ElementType.CONSTRUCTOR,
    ElementType.METHOD
})
public @interface LogDetail {
  
}
