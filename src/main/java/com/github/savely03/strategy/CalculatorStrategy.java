package com.github.savely03.strategy;

import java.math.BigDecimal;

@FunctionalInterface
public interface CalculatorStrategy {
    BigDecimal calculate(double num1, double num2);
}
