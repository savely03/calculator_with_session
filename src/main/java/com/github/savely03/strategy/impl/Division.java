package com.github.savely03.strategy.impl;

import com.github.savely03.exception.DivideOnZeroException;
import com.github.savely03.strategy.CalculatorStrategy;

public class Division implements CalculatorStrategy {
    @Override
    public double calculate(int num1, int num2) {
        if (num2 == 0) {
            throw new DivideOnZeroException();
        }
        return num1 / (double) num2;
    }
}
