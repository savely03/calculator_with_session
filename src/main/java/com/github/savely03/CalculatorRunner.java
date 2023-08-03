package com.github.savely03;

import com.github.savely03.exception.BaseException;
import com.github.savely03.service.CalculatorService;
import com.github.savely03.service.impl.CalculatorServiceProxy;
import com.github.savely03.util.CalculatorValidator;

import java.util.Scanner;

public class CalculatorRunner {

    private final CalculatorValidator calculatorValidator;

    public CalculatorRunner() {
        calculatorValidator = new CalculatorValidator();
    }

    public void run() {
        CalculatorService calculatorService = new CalculatorServiceProxy();
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
