package com.github.savely03.strategy;

import java.math.BigDecimal;

@FunctionalInterface
public interface CalculatorStrategy {
    BigDecimal calculate(BigDecimal num1, BigDecimal num2);
}
