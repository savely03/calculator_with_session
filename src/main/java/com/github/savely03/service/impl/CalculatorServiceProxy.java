package com.github.savely03.service.impl;

import com.github.savely03.service.CalculatorService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculatorServiceProxy implements CalculatorService {
    private final CalculatorService calculatorService;
    private final Map<String, String> cache;
    private final List<String> sessions;

    public CalculatorServiceProxy(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
        cache = new HashMap<>();
        sessions = new ArrayList<>();
    }

    @Override
    public String invoke(String inputData) {
        if ("/end".equals(inputData)) {
            return getSessions();
        }

        if (cache.containsKey(inputData)) {
            sessions.add(String.format("%s = %s", inputData, cache.get(inputData)));
            return cache.get(inputData);
        }

        String result = calculatorService.invoke(inputData);
        cache.put(inputData, result);
        sessions.add(String.format("%s = %s", inputData, result));

        return result;
    }

    private String getSessions() {
        return String.join("\n", sessions);
    }
}
