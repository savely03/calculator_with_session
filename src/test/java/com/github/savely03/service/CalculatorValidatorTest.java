package com.github.savely03.service;

import com.github.savely03.exception.InvalidInputDataException;
import com.github.savely03.util.CalculatorValidator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.github.savely03.service.Constants.NUM_1;
import static com.github.savely03.service.Constants.NUM_2;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CalculatorValidatorTest {

    private final CalculatorValidator out = new CalculatorValidator();

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
    void validateInputDataWhenInputDataExceptionTest(String inputData) {
        assertThatExceptionOfType(InvalidInputDataException.class).isThrownBy(
                () -> out.validateInputData(inputData)
        );
    }
}
