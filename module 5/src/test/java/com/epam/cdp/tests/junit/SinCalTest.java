package com.epam.cdp.tests.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith (Parameterized.class)
public class SinCalTest extends BaseTest {

    private double firstNumber;
    private double expectedResult;

    public SinCalTest(double firstNumber, double expectedResult) {
        this.firstNumber = firstNumber;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {0, 0},
                {30, 0.5},
                {90, 1},
                {270, -1}
        });
    }

    @Test
    public void TestSin() {
        double result = calculator.sin(firstNumber);
        assertEquals(expectedResult, result, DELTA);
    }
}
