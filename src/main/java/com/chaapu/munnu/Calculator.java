package com.chaapu.munnu;

public class Calculator {
    /**
     * Add two integers
     *
     * @param int1 first integer
     * @param int2 second integer
     * @return sum of both integers
     */
    public static int add(int int1, int int2) {
        return int1 + int2;
    }

    /**
     * Substract two integers
     *
     * @param int1 first integer
     * @param int2 second integer
     * @return first integer minus second integer
     */
    public static int substract(int int1, int int2) {
        return int1 - int2;
    }

    /**
     * Multiply two integers
     *
     * @param int1 first integer
     * @param int2 second integer
     * @return first integer multiplied by second integer
     */
    public int multiply(int int1, int int2) {
        return int1 * int2;
    }

    /**
     * Divides one integer value by another integer value
     *
     * @param int1 first integer
     * @param int2 second integer
     * @return first integer divided by second
     */
    public double divide(int int1, int int2) {
        return int1 / int2;
    }
}
