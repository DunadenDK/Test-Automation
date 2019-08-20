package com.epam.cdp.tests.junit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith (Parameterized.class)
public class TgCalTest extends BaseTest {

    private double firstNumber;
    private double expectedResult;

    public TgCalTest(double firstNumber, double expectedResult) {
        this.firstNumber = firstNumber;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {0,  0},
                {45, 1},
                {180,0},
                {360,0}
        });
    }

    @Test
    public void TestTgCal() {
        double result = calculator.tg(firstNumber);
        Assert.assertEquals(expectedResult, result, DELTA);

    }
}