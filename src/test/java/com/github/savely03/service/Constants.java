package com.github.savely03.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;

public class Constants {
    public static BigDecimal NUM_1 = BigDecimal.valueOf(ThreadLocalRandom.current().nextDouble(10000));
    public static BigDecimal NUM_2 = BigDecimal.valueOf(ThreadLocalRandom.current().nextDouble(1, 10000));
    public static String SUM_RES = NUM_1.add(NUM_2).toString();
    public static String MUL_RES = NUM_1.multiply(NUM_2).toString();
    public static String SUB_RES = NUM_1.subtract(NUM_2).toString();
    public static String DIV_RES = NUM_1.divide(NUM_2, 2, RoundingMode.HALF_UP).toString();

    private Constants() {
    }
}
