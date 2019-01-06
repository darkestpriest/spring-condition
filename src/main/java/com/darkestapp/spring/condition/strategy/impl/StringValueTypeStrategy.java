package com.darkestapp.spring.condition.strategy.impl;

import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 06/01/19.
 */
public class StringValueTypeStrategy extends AbstractValueTypeStrategy {

    public StringValueTypeStrategy(AnnotatedTypeMetadata annotatedMetadata) {
        super(annotatedMetadata);
    }
}
