package com.epam.cdp.tests.junit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith (Parameterized.class)
public class CtgCalTest extends BaseTest {

    private double firstNumber;
    private double expectedResult;

    public CtgCalTest(double firstNumber, double expectedResult) {
        this.firstNumber = firstNumber;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {45,  1},
                {90, 0},
                {270,0}
        });
    }

    @Test
    public void TestCtgCal() {
        double result = calculator.ctg(firstNumber);
        Assert.assertEquals(expectedResult, result, DELTA);

    }
}