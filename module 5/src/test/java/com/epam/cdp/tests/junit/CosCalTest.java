package com.epam.cdp.tests.junit;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith (Parameterized.class)
public class CosCalTest extends BaseTest {

    private double firstNumber;
    private double expectedResult;

    public CosCalTest(double firstNumber, double expectedResult) {
        this.firstNumber = firstNumber;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {0, 1},
                {60, 0.5},
                {90, 0},
                {180, -1}
        });
    }

    @Test
    public void TestCos() {
        double result = calculator.cos(firstNumber);
        assertEquals(expectedResult, result, DELTA);
    }
}