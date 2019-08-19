package com.epam.cdp.tests.junit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class PositiveNumberTest extends BaseTest {

    private long number;
    private boolean expectedResult;

    public PositiveNumberTest(long number, boolean expectedResult) {
        this.number = number;
        this.expectedResult = expectedResult;
    }

    @Test
    public void numberIsPositiveTest() {
        boolean result = calculator.isPositive(number);
        Assert.assertEquals(expectedResult, result);
    }

    @Parameterized.Parameters
    public static Object[][] dataForPositiveNumbersTest() {
        return new Object[][]{
                {9, true},
                {0, false},
                {7, true},
                {-14, false}
        };
    }


}
