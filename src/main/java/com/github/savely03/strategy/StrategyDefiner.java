package com.github.savely03.strategy;

import com.github.savely03.exception.DefineOperationException;
import com.github.savely03.strategy.impl.Division;
import com.github.savely03.strategy.impl.Multiplication;
import com.github.savely03.strategy.impl.Subtraction;
import com.github.savely03.strategy.impl.Summation;

import java.util.Map;
import java.util.Optional;

public class StrategyDefiner {
    private final Map<String, CalculatorStrategy> strategies = Map.of(
            "+", new Summation(),
            "-", new Subtraction(),
            "*", new Multiplication(),
            "/", new Division()
    );
    public CalculatorStrategy defineStrategyByOperation(String operation) {
        return Optional.ofNullable(strategies.get(operation))
                .orElseThrow(() -> new DefineOperationException(operation));
    }
}
