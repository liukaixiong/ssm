package spring.anno;

import java.lang.annotation.*;

/**
 * 自定义注解
 *
 * @author Liukx
 * @create 2018-01-11 17:36
 * @email liukx@elab-plus.com
 **/
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MyQualifier {

    String value() default "";

}