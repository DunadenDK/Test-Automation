package com.epam.cdp.tests.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;


import static org.junit.Assert.assertEquals;


@RunWith (Parameterized.class)
public class SqrtCalTest extends BaseTest {

    private double firstNumber;
    private double expectedResult;

    public SqrtCalTest(double firstNumber, double expectedResult) {
        this.firstNumber = firstNumber;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {4, 2},
                {9, 3},
                {-5, 0},
                {100, 10}
        });
    }

    @Test
    public void TestSqrt() {
        double result = calculator.sqrt(firstNumber);
        assertEquals(expectedResult, result, DELTA);
    }
}
