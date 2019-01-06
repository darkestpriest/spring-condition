package com.darkestapp.spring.condition.strategy.impl;

import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 06/01/19.
 */
public class PropertyValueTypeStrategy extends AbstractValueTypeStrategy {

    private final ConditionContext conditionContext;

    public PropertyValueTypeStrategy(
            AnnotatedTypeMetadata annotatedMetadata,
            ConditionContext conditionContext) {
        super(annotatedMetadata);
        this.conditionContext = conditionContext;
    }

    @Override
    public String getValue() {
        String propertyKey = super.getValue();
        return conditionContext
                .getEnvironment()
                .getProperty(propertyKey);
    }
}
