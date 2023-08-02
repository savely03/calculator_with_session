package com.github.savely03;

import com.github.savely03.exception.BaseException;
import com.github.savely03.exception.InputDataException;
import com.github.savely03.service.CalculatorService;
import com.github.savely03.service.impl.CalculatorServiceProxy;

import java.util.Scanner;

import static com.github.savely03.constant.Regex.INPUT_DATA_REGEX;

public class CalculatorRunner {
    public void run() {
        CalculatorService calculatorService = new CalculatorServiceProxy();
        try (Scanner in = new Scanner(System.in)) {
            while (true) {
                String inputData = in.nextLine();
                try {
                    checkInputData(inputData);
                    System.out.println(calculatorService.invoke(inputData.trim()));
                } catch (BaseException e) {
                    System.out.println(e.getMessage());
                }
                if ("/end".equals(inputData)) {
                    return;
                }
            }
        }
    }

    public void checkInputData(String inputData) {
        if (!inputData.matches(INPUT_DATA_REGEX)) {
            throw new InputDataException();
        }
    }
}
