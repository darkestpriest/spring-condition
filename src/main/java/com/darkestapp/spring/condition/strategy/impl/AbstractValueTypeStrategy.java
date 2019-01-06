package com.darkestapp.spring.condition.strategy.impl;

import com.darkestapp.spring.condition.strategy.ValueTypeStrategy;

import java.util.Map;
import java.util.Optional;

import static java.util.Optional.ofNullable;

/**
 * Helps to obtain values from specified properties values.
 *
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 06/01/19.
 */
abstract class AbstractValueTypeStrategy implements ValueTypeStrategy {

    private static final String VALUE_PARAMETER_NAME = "value";

    Optional getValue(Map<String, Object> attributes) {
        return ofNullable(attributes.get(VALUE_PARAMETER_NAME));
    }
}
