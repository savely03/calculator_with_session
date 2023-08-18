package com.github.savely03;

import com.github.savely03.exception.BaseException;
import com.github.savely03.service.CalculatorService;
import com.github.savely03.validation.CalculatorValidator;

import java.util.Scanner;

public class CalculatorRunner {

    private final CalculatorValidator calculatorValidator;
    private final CalculatorService calculatorService;

    public CalculatorRunner(CalculatorValidator calculatorValidator, CalculatorService calculatorService) {
        this.calculatorValidator = calculatorValidator;
        this.calculatorService = calculatorService;
    }

    public void run() {
        try (Scanner in = new Scanner(System.in)) {
            while (true) {
                String inputData = in.nextLine();
                try {
                    calculatorValidator.validateInputData(inputData);
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
}
