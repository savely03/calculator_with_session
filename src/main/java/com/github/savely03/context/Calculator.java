package com.github.savely03.context;

import com.github.savely03.strategy.CalculatorStrategy;

public class Calculator {
    private CalculatorStrategy calculatorStrategy;

    public void setCalculatorStrategy(CalculatorStrategy calculatorStrategy) {
        this.calculatorStrategy = calculatorStrategy;
    }

    public double calculate(int num1, int num2) {
        return calculatorStrategy.calculate(num1, num2);
    }
}
