package com.github.savely03.service;

import com.github.savely03.context.CalculatorContext;
import com.github.savely03.exception.DivideOnZeroException;
import com.github.savely03.service.impl.CalculatorServiceImpl;
import com.github.savely03.service.impl.CalculatorServiceProxy;
import com.github.savely03.strategy.CalculatorStrategyDefiner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.github.savely03.service.CalculatorTestConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

// Тесты на CalculatorServiceProxy одновременно покрывают CalculatorServiceImpl
class CalculatorServiceProxyTest {
    private final CalculatorService out = new CalculatorServiceProxy(
            new CalculatorServiceImpl(
                    new CalculatorContext(),
                    new CalculatorStrategyDefiner()
            )
    );

    static Stream<Arguments> provideArguments() {
        return Stream.of(
                Arguments.of(NUM_1 + " + " + NUM_2, SUM_RES),
                Arguments.of(NUM_1 + " - " + NUM_2, SUB_RES),
                Arguments.of(NUM_1 + " * " + NUM_2, MUL_RES),
                Arguments.of(NUM_1 + " / " + NUM_2, DIV_RES)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    void invokeTest(String inputData, String expected) {
        assertThat(out.invoke(inputData)).isEqualTo(expected);
    }

    @Test
    void invokeWhenDivideOnZeroExceptionTest() {
        assertThatExceptionOfType(DivideOnZeroException.class).isThrownBy(
                () -> out.invoke(NUM_1 + " / " + 0)
        );
    }

    @Test
    void invokeWhenInputEndTest() {
        out.invoke(NUM_1 + " + " + NUM_2);
        out.invoke(NUM_1 + " + " + NUM_2);

        String expected = String.format("""
                        %s + %s = %s
                        %s + %s = %s""",
                NUM_1, NUM_2, SUM_RES,
                NUM_1, NUM_2, SUM_RES
        );

        assertThat(out.invoke("/end")).isEqualTo(expected);
    }
}
