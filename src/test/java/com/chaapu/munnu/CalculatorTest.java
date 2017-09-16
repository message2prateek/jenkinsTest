package com.chaapu.munnu;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Tests Calculator.java
 *
 * @see com.chaapu.munnu.Calculator
 */
public class CalculatorTest {

    @Test
    public void canAddTwoPositiveIntegers() {
        assertEquals("10 + 20 should return 30", 30, Calculator.add(10, 20));
    }

    @Test
    public void canSubtractTwoPositiveIntegers() {
        assertEquals("20 - 10 shoukd return 10", 11, Calculator.substract(20, 10));
    }

    @Test(expected = ArithmeticException.class)
    public void verifyDivisionByZeroReturnsException() {
        Calculator.divide(10, 0);
    }
}
