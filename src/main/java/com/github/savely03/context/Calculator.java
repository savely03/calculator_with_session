package com.github.savely03.context;

import com.github.savely03.strategy.CalculatorStrategy;

import java.math.BigDecimal;

public class Calculator {
    private CalculatorStrategy calculatorStrategy;

    public void setCalculatorStrategy(CalculatorStrategy calculatorStrategy) {
        this.calculatorStrategy = calculatorStrategy;
    }

    public BigDecimal calculate(double num1, double num2) {
        return calculatorStrategy.calculate(num1, num2);
    }
}
