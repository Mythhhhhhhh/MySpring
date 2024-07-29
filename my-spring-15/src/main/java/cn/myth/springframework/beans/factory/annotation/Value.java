package cn.myth.springframework.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * Annotation at the field or method/constructor parameter level
 * that indicates a default value expression for the affected argument.
 * <p>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Documented
public @interface Value {

    /**
     * The actual value expression: e.g. "#{systemProperties.myProp}".
     */
    String value();

}
