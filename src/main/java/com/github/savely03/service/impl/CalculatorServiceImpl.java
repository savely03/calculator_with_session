package com.github.savely03.service.impl;

import com.github.savely03.context.CalculatorContext;
import com.github.savely03.service.CalculatorService;
import com.github.savely03.strategy.CalculatorStrategyDefiner;

import java.math.BigDecimal;

public class CalculatorServiceImpl implements CalculatorService {
    private final CalculatorContext calculator;
    private final CalculatorStrategyDefiner definer;

    public CalculatorServiceImpl(CalculatorContext calculator, CalculatorStrategyDefiner definer) {
        this.calculator = calculator;
        this.definer = definer;
    }

    @Override
    public String invoke(String inputData) {
        String[] args = inputData.split(" ");
        calculator.setCalculatorStrategy(definer.defineStrategyByOperation(args[1]));
        return calculator.calculate(new BigDecimal(args[0]), new BigDecimal(args[2])).toString();
    }
}
