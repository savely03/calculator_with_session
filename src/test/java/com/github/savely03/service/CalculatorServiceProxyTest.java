package com.github.savely03.service;

import com.github.savely03.exception.DivideOnZeroException;
import com.github.savely03.exception.InputDataException;
import com.github.savely03.service.impl.CalculatorServiceProxy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.github.savely03.service.Constants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CalculatorServiceProxyTest {
    private final CalculatorService out = new CalculatorServiceProxy();

    static Stream<Arguments> provideArguments_PositiveCase() {
        return Stream.of(
                Arguments.of(NUM_1 + " + " + NUM_2, SUM_RES),
                Arguments.of(NUM_1 + " - " + NUM_2, SUB_RES),
                Arguments.of(NUM_1 + " * " + NUM_2, MUL_RES),
                Arguments.of(NUM_1 + " / " + NUM_2, DIV_RES)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArguments_PositiveCase")
    void invokeTest(String inputData, String expected) {
        assertThat(out.invoke(inputData)).isEqualTo(expected);
    }

    static Stream<Arguments> provideArguments_NegativeCase() {
        return Stream.of(
                Arguments.of(NUM_1 + "  " + NUM_2),
                Arguments.of(" - " + NUM_2),
                Arguments.of(" * "),
                Arguments.of(NUM_1 + " / ")
        );
    }

    @ParameterizedTest
    @MethodSource("provideArguments_NegativeCase")
    void invokeWhenDefineOperationExceptionTest(String inputData) {
        assertThatExceptionOfType(InputDataException.class).isThrownBy(
                () -> out.invoke(inputData)
        );

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
