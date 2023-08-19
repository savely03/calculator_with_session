package com.github.savely03.service.impl;

import com.github.savely03.service.Calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculatorProxy implements Calculator {
    private final Calculator calculator;
    private final Map<String, String> cache;
    private final List<String> sessions;

    public CalculatorProxy(Calculator calculatorService) {
        this.calculator = calculatorService;
        cache = new HashMap<>();
        sessions = new ArrayList<>();
    }

    @Override
    public String calculate(String inputData) {
        if ("/end".equals(inputData)) {
            return getSessions();
        }

        if (cache.containsKey(inputData)) {
            sessions.add(String.format("%s = %s", inputData, cache.get(inputData)));
            return cache.get(inputData);
        }

        String result = calculator.calculate(inputData);
        cache.put(inputData, result);
        sessions.add(String.format("%s = %s", inputData, result));

        return result;
    }

    private String getSessions() {
        return String.join("\n", sessions);
    }
}
