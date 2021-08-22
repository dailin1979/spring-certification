package ioc.bean.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@Documented
@Inherited
public @interface MyFirstAutoWired {

}
