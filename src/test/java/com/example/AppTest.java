package com.example;

import static org.junit.Assert.*;

import org.junit.Test;
// import static org.junit.Assert.*;

public class AppTest {

    // Test for squareRoot function
    @Test
    public void testSquareRoot() {
        assertEquals(4.0, Calculator.squareRoot(16), 0.0001);
        assertEquals(3.0, Calculator.squareRoot(9), 0.0001);
        assertEquals(0.0, Calculator.squareRoot(0), 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSquareRootNegative() {
        Calculator.squareRoot(-4);
    }

    // Test for factorial function
    @Test
    public void testFactorial() {
        assertEquals(120, Calculator.factorial(5));
        assertEquals(1, Calculator.factorial(0)); // Factorial of 0 is 1
        assertEquals(1, Calculator.factorial(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFactorialNegative() {
        Calculator.factorial(-1);
    }

    // Test for naturalLog function
    @Test
    public void testNaturalLog() {
        assertEquals(1.0, Calculator.naturalLog(Math.E), 0.0001); // ln(e) = 1
        assertEquals(0.0, Calculator.naturalLog(1), 0.0001); // ln(1) = 0
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNaturalLogNonPositive() {
        Calculator.naturalLog(0);   // Should throw exception for ln(0)
        Calculator.naturalLog(-1);  // Should throw exception for negative numbers
    }

    // Test for power function
    @Test
    public void testPower() {
        assertEquals(8.0, Calculator.power(2, 3), 0.0001);
        assertEquals(1.0, Calculator.power(2, 0), 0.0001); // x^0 = 1
        assertEquals(0.25, Calculator.power(2, -2), 0.0001); // 2^-2 = 1/4
    }
}
