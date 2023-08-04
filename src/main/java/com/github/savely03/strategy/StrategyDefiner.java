package com.github.savely03.strategy;

import com.github.savely03.exception.DefineOperationException;

import java.util.Map;
import java.util.Optional;

import static com.github.savely03.strategy.impl.CalculatorStrategies.*;

public class StrategyDefiner {

    private final Map<String, CalculatorStrategy> strategies = Map.of(
            "+", SUMMATION_STRATEGY,
            "-", SUBTRACTION_STRATEGY,
            "*", MULTIPLICATION_STRATEGY,
            "/", DIVISION_STRATEGY
    );
    public CalculatorStrategy defineStrategyByOperation(String operation) {

        return Optional.ofNullable(strategies.get(operation))
                .orElseThrow(() -> new DefineOperationException(operation));
    }

}
