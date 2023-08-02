package com.github.savely03.strategy.impl;

import com.github.savely03.exception.DivideOnZeroException;
import com.github.savely03.strategy.CalculatorStrategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum CalculatorStrategies implements CalculatorStrategy {
    DIVISION_STRATEGY((num1, num2) -> {
        if (num2 == 0) { // Не стал создавать отдельный класс для проверки num2 (для простоты)
            throw new DivideOnZeroException();
        }
        return BigDecimal.valueOf(num1).divide(BigDecimal.valueOf(num2), 2, RoundingMode.HALF_UP);
    }),
    MULTIPLICATION_STRATEGY((num1, num2) -> BigDecimal.valueOf(num1).multiply(BigDecimal.valueOf(num2))),
    SUBTRACTION_STRATEGY((num1, num2) -> BigDecimal.valueOf(num1).subtract(BigDecimal.valueOf(num2))),
    SUMMATION_STRATEGY((num1, num2) -> BigDecimal.valueOf(num1).add(BigDecimal.valueOf(num2)));

    private final CalculatorStrategy strategy;

    CalculatorStrategies(CalculatorStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public BigDecimal calculate(double num1, double num2) {
        return strategy.calculate(num1, num2);
    }
}
