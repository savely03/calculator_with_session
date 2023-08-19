package com.github.savely03.strategy;

import com.github.savely03.exception.DefineOperationException;
import com.github.savely03.exception.DivideByZeroException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Optional;

public class CalculatorStrategyDefiner {
    private final Map<String, CalculatorStrategy> strategies = Map.of(
            "+", BigDecimal::add,
            "-", BigDecimal::subtract,
            "*", BigDecimal::multiply,
            "/", (num1, num2) -> { // Не очень гуд, но не стал создавать отдельную стратегию (для простоты)
                if (num2.equals(BigDecimal.ZERO)) {
                    throw new DivideByZeroException();
                }
                return num1.divide(num2, 2, RoundingMode.HALF_UP);
            }
    );
    public CalculatorStrategy defineStrategyByOperation(String operation) {
        return Optional.ofNullable(strategies.get(operation))
                .orElseThrow(() -> new DefineOperationException(operation));
    }

}
