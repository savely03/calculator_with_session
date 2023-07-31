package com.github.savely03.strategy.impl;

import com.github.savely03.strategy.CalculatorStrategy;

public class Subtraction implements CalculatorStrategy {
    @Override
    public double calculate(int num1, int num2) {
        return num1 - num2;
    }
}
