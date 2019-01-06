package com.darkestapp.spring.condition.utils;

import com.darkestapp.spring.condition.annotation.Conditional;
import com.darkestapp.spring.condition.exception.SpringConditionException;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static java.util.Optional.ofNullable;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 06/01/19.
 */
public class AnnotationAttributeUtil {

    private AnnotationAttributeUtil() {
        //Just to avoid public instantiation.
    }

    public static String getConditionalValue(
            AnnotatedTypeMetadata annotatedTypeMetadata,
            String key) {
        Optional value = getValue(getAttributes(annotatedTypeMetadata), key);
        if(value.isPresent()) {
            return value.get().toString();
        }
        throw handleNullValue();
    }

    public static Optional getValue(Map<String, Object> attributes, String key) {
        return ofNullable(attributes.get(key));
    }

    public static Map<String, Object> getAttributes(AnnotatedTypeMetadata annotatedTypeMetadata) {
        String annotationCanonicalType = Conditional.class.getCanonicalName();
        if(annotatedTypeMetadata.isAnnotated(annotationCanonicalType)) {
            return Objects
                    .requireNonNull(
                            annotatedTypeMetadata.getAnnotationAttributes(
                                    annotationCanonicalType)
                    );
        }
        return Collections.emptyMap();
    }

    private static SpringConditionException handleNullValue() {
        return new SpringConditionException("Conditional value cannot be null");
    }
}
