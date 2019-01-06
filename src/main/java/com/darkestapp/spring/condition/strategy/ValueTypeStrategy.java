package com.darkestapp.spring.condition.strategy;

/**
 * Represents the strategy to use to obtain the value to check.
 *
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 06/01/19.
 *
 * @since 0.1.0
 */
public interface ValueTypeStrategy {

    /**
     * Returns the value to check by condition.
     *
     * @return the value to check.
     */
    String getValue();
}
