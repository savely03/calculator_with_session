package com.github.savely03.service.impl;

import com.github.savely03.context.CalculatorContext;
import com.github.savely03.service.Calculator;
import com.github.savely03.strategy.CalculatorStrategyDefiner;

import java.math.BigDecimal;

public class CalculatorImpl implements Calculator {
    private final CalculatorContext calculatorContext;
    private final CalculatorStrategyDefiner definer;

    public CalculatorImpl(CalculatorContext calculator, CalculatorStrategyDefiner definer) {
        this.calculatorContext = calculator;
        this.definer = definer;
    }

    @Override
    public String calculate(String inputData) {
        String[] args = inputData.split(" ");
        calculatorContext.setCalculatorStrategy(definer.defineStrategyByOperation(args[1]));
        return calculatorContext.calculate(new BigDecimal(args[0]), new BigDecimal(args[2])).toString();
    }
}
