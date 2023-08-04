package com.github.savely03.strategy.impl;

import com.github.savely03.exception.DivideOnZeroException;
import com.github.savely03.strategy.CalculatorStrategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum CalculatorStrategies implements CalculatorStrategy {
    DIVISION_STRATEGY((num1, num2) -> {
        if (num2.compareTo(BigDecimal.ZERO) == 0) { // Не стал создавать отдельную стратегию для проверки num2 (для простоты)
            throw new DivideOnZeroException();
        }
        return num1.divide(num2, 2, RoundingMode.HALF_UP);
    }),
    MULTIPLICATION_STRATEGY(BigDecimal::multiply),
    SUBTRACTION_STRATEGY(BigDecimal::subtract),
    SUMMATION_STRATEGY(BigDecimal::add);

    private final CalculatorStrategy strategy;

    CalculatorStrategies(CalculatorStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public BigDecimal calculate(BigDecimal num1, BigDecimal num2) {
        return strategy.calculate(num1, num2);
    }
}
