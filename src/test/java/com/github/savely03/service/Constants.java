package com.github.savely03.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;

public class Constants {
    public static double NUM_1 = ThreadLocalRandom.current().nextInt(10000);
    public static double NUM_2 = ThreadLocalRandom.current().nextInt(1, 10000);
    public static String SUM_RES = BigDecimal.valueOf(NUM_1).add(BigDecimal.valueOf(NUM_2)).toString();
    public static String MUL_RES = BigDecimal.valueOf(NUM_1).multiply(BigDecimal.valueOf(NUM_2)).toString();
    public static String SUB_RES = BigDecimal.valueOf(NUM_1).subtract(BigDecimal.valueOf(NUM_2)).toString();
    public static String DIV_RES = BigDecimal.valueOf(NUM_1).divide(BigDecimal.valueOf(NUM_2), 2, RoundingMode.HALF_UP).toString();
}
