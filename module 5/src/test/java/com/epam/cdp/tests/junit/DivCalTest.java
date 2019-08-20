package com.epam.cdp.tests.junit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class DivCalTest extends BaseTest {
    private double firstNumber;
    private double secondNumber;
    private double expectedResult;

    public DivCalTest(double firstNumber, double secondNumber, double expectedResult) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][] {
                {6, 3, 2},
                {10, -1, -10},
                {0, 1, 0},
                {-10, -2.5, 4}
        });
    }

    @Test
    public void TestDiv() {
        double result = calculator.div(firstNumber,secondNumber);
        Assert.assertEquals(expectedResult, result, DELTA);

    }
}

