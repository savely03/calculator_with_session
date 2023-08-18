package com.github.savely03;

import com.github.savely03.context.CalculatorContext;
import com.github.savely03.service.CalculatorService;
import com.github.savely03.service.impl.CalculatorServiceImpl;
import com.github.savely03.service.impl.CalculatorServiceProxy;
import com.github.savely03.strategy.CalculatorStrategyDefiner;
import com.github.savely03.util.CalculatorValidator;

public class Main {
    public static void main(String[] args) {
        CalculatorService calculatorService = new CalculatorServiceImpl(new CalculatorContext(), new CalculatorStrategyDefiner());
        CalculatorService calculatorServiceProxy = new CalculatorServiceProxy(calculatorService);
        CalculatorRunner calculatorRunner = new CalculatorRunner(new CalculatorValidator(), calculatorServiceProxy);
        calculatorRunner.run();
    }
}
