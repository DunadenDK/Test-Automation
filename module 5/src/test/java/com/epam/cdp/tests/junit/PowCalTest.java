package com.epam.cdp.tests.junit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class PowCalTest extends BaseTest {
    private double firstNumber;
    private double secondNumber;
    private double expectedResult;

    public PowCalTest(double firstNumber, double secondNumber, double expectedResult) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][] {
                {7, 2, 49},
                {4, -2, 2},
                {0, 0, 1},
                {-1, 2, 1}
        });
    }

    @Test
    public void TestPow() {
        double result = calculator.pow(firstNumber,secondNumber);
        Assert.assertEquals(expectedResult, result, DELTA);

    }
}
