package com.github.savely03;

import com.github.savely03.context.CalculatorContext;
import com.github.savely03.service.Calculator;
import com.github.savely03.service.impl.CalculatorImpl;
import com.github.savely03.service.impl.CalculatorProxy;
import com.github.savely03.strategy.CalculatorStrategyDefiner;
import com.github.savely03.validation.CalculatorValidator;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl(new CalculatorContext(), new CalculatorStrategyDefiner());
        Calculator calculatorProxy = new CalculatorProxy(calculator);
        CalculatorRunner calculatorRunner = new CalculatorRunner(new CalculatorValidator(), calculatorProxy);
        calculatorRunner.run();
    }
}
