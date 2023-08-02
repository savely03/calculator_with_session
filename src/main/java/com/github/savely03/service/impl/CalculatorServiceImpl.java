package com.github.savely03.service.impl;

import com.github.savely03.context.Calculator;
import com.github.savely03.service.CalculatorService;
import com.github.savely03.strategy.StrategyDefiner;

public class CalculatorServiceImpl implements CalculatorService {
    private final Calculator calculator;
    private final StrategyDefiner definer;

    public CalculatorServiceImpl(Calculator calculator, StrategyDefiner definer) {
        this.calculator = calculator;
        this.definer = definer;
    }

    @Override
    public String invoke(String inputData) {
        String[] args = inputData.split(" ");
        calculator.setCalculatorStrategy(definer.defineStrategyByOperation(args[1]));
        return calculator.calculate(Double.parseDouble(args[0]), Double.parseDouble(args[2])).toString();
    }

}
