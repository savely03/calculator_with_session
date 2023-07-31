package com.github.savely03.service.impl;

import com.github.savely03.context.Calculator;
import com.github.savely03.exception.InputDataException;
import com.github.savely03.service.CalculatorService;
import com.github.savely03.strategy.StrategyDefiner;

import static com.github.savely03.constant.Regex.INPUT_DATA_REGEX;

public class CalculatorServiceImpl implements CalculatorService {
    private final Calculator calculator;
    private final StrategyDefiner definer;

    public CalculatorServiceImpl(Calculator calculator, StrategyDefiner definer) {
        this.calculator = calculator;
        this.definer = definer;
    }

    @Override
    public String invoke(String inputData) {
        if (!inputData.matches(INPUT_DATA_REGEX)) {
            throw new InputDataException();
        }

        String[] args = inputData.split(" ");
        calculator.setCalculatorStrategy(definer.defineStrategyByOperation(args[1]));

        return String.valueOf(calculator.calculate(Integer.parseInt(args[0]), Integer.parseInt(args[2])));
    }

}
