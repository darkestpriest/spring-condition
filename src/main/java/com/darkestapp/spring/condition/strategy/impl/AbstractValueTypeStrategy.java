package com.darkestapp.spring.condition.strategy.impl;

import com.darkestapp.spring.condition.strategy.ValueTypeStrategy;
import org.springframework.core.type.AnnotatedTypeMetadata;

import static com.darkestapp.spring.condition.utils.AnnotationAttributeUtil.getConditionalValue;

/**
 * Helps to obtain values from specified properties values.
 *
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 06/01/19.
 */
abstract class AbstractValueTypeStrategy implements ValueTypeStrategy {

    private static final String VALUE_PARAMETER_NAME = "value";

    private final AnnotatedTypeMetadata annotatedMetadata;

    AbstractValueTypeStrategy(AnnotatedTypeMetadata annotatedMetadata) {
        this.annotatedMetadata = annotatedMetadata;
    }

    @Override
    public String getValue() {
        return getConditionalValue(annotatedMetadata, VALUE_PARAMETER_NAME);
    }
}
