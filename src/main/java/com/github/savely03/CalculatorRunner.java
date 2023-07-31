package com.github.savely03;

import com.github.savely03.exception.BaseException;
import com.github.savely03.service.CalculatorService;
import com.github.savely03.service.impl.CalculatorServiceProxy;

import java.util.Scanner;

public class CalculatorRunner {

    public static void main(String[] args) {
        CalculatorService calculatorService = new CalculatorServiceProxy();
        try (Scanner in = new Scanner(System.in)) {
            while (true) {
                String inputData = in.nextLine();
                try {
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
