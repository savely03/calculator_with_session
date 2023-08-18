package com.github.savely03.util;

import com.github.savely03.exception.InvalidInputDataException;

import static com.github.savely03.constant.CalculatorRegex.INPUT_DATA_REGEX;

public class CalculatorValidator {
    public void validateInputData(String inputData) {
        if (!inputData.matches(INPUT_DATA_REGEX)) {
            throw new InvalidInputDataException();
        }
    }
}
