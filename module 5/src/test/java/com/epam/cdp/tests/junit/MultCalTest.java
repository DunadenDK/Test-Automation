package com.epam.cdp.tests.junit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MultCalTest extends BaseTest {
    private double firstNumber;
    private double secondNumber;
    private double expectedResult;

    public MultCalTest(double firstNumber, double secondNumber, double expectedResult) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][] {
                {5, 3, 15},
                {10, -1, -10},
                {0, 0, 0},
                {6, 10, 60}
        });
    }

    @Test
    public void TestMult() {
        double result = calculator.mult(firstNumber,secondNumber);
        Assert.assertEquals(expectedResult, result, DELTA);

    }
}

