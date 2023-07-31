package com.github.savely03.service;

import java.util.concurrent.ThreadLocalRandom;

public class Constants {
    public static int NUM_1 = ThreadLocalRandom.current().nextInt(1000);
    public static int NUM_2 = ThreadLocalRandom.current().nextInt(1, 1000);
    public static String SUM_RES = String.valueOf((double) NUM_1 + NUM_2);
    public static String MUL_RES = String.valueOf((double) NUM_1 * NUM_2);
    public static String SUB_RES = String.valueOf((double) NUM_1 - NUM_2);
    public static String DIV_RES = String.valueOf((double) NUM_1 / NUM_2);
}
