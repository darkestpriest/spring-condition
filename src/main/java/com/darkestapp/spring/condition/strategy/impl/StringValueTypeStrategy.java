package com.darkestapp.spring.condition.strategy.impl;

import com.darkestapp.spring.condition.SpringConditionException;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Optional;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 06/01/19.
 */
public class StringValueTypeStrategy extends AbstractValueTypeStrategy {

    private final AnnotatedTypeMetadata annotatedMetadata;

    public StringValueTypeStrategy(AnnotatedTypeMetadata annotatedMetadata) {
        this.annotatedMetadata = annotatedMetadata;
    }

    @Override
    public String getValue() {
        Optional value = getValue(getAttributes(annotatedMetadata));
        if(value.isPresent()) {
            return value.get().toString();
        }
        throw handleNullValue();
    }

    private SpringConditionException handleNullValue() {
        return new SpringConditionException("Conditional value cannot be null");
    }
}
