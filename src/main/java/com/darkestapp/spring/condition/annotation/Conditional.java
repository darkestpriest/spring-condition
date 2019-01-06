package com.darkestapp.spring.condition.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.darkestapp.spring.condition.annotation.Conditional.ValueType.STRING;

/**
 * This annotation indicates the condition that must be validated from Spring to instantiate a Bean.
 *
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 06/01/19.
 *
 * @since 0.1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
public @interface Conditional {

    /**
     * Value to check by condition.
     *
     * @return String with the value to check.
     */
    String value();

    /**
     * Property key to get from application.properties.
     *
     * @return String with the property key.
     */
    String property();

    /**
     * This indicates where Condition value is available.
     * The default value is {@link ValueType#STRING}
     *
     * @return where the value is available.
     */
    ValueType type() default STRING;

    public enum ValueType {

        /**
         * This value indicates that the value to check is embedded in application.property.
         */
        PROPERTY,

        /**
         * This value indicates that the value to check is provided directly to annotation.
         */
        STRING
    }
}
