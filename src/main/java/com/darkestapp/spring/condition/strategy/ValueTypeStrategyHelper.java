package com.darkestapp.spring.condition.strategy;

import com.darkestapp.spring.condition.annotation.Conditional;
import com.darkestapp.spring.condition.annotation.Conditional.ValueType;
import com.darkestapp.spring.condition.exception.SpringConditionException;
import com.darkestapp.spring.condition.strategy.impl.PropertyValueTypeStrategy;
import com.darkestapp.spring.condition.strategy.impl.StringValueTypeStrategy;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import static com.darkestapp.spring.condition.utils.AnnotationAttributeUtil.getConditionalValue;

/**
 * Created by Manuel Perez P. (darkpriestrelative@gmail.com) on 06/01/19.
 */
public class ValueTypeStrategyHelper {

    private static final String TYPE_PARAMETER_NAME = "type";

    private ValueTypeStrategyHelper() {
        //Just to avoid public instantiation.
    }

    public static String getValue(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        ValueTypeStrategy strategy;
        ValueType valueType = ValueType.valueOf(getConditionalValue(annotatedTypeMetadata, TYPE_PARAMETER_NAME));
        switch (valueType) {
            case PROPERTY:
                strategy = new PropertyValueTypeStrategy(annotatedTypeMetadata, conditionContext);
                break;
            case STRING:
                strategy = new StringValueTypeStrategy(annotatedTypeMetadata);
                break;
            default:
                throw new SpringConditionException(String.format("Cannot process %s type", valueType));
        }
        return strategy.getValue();
    }
}
