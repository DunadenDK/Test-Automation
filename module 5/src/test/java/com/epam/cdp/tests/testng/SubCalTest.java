package com.epam.cdp.tests.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubCalTest extends BaseTest {

    @Test(dataProvider = "valuesForSubTest")
    public void twoMinusOne(long a, long b, long expectedValue) {
        long result = calculator.sub(a, b);
        Assert.assertEquals(result, expectedValue, "Invalid result of subtraction operation!");
    }

    @DataProvider(name = "valuesForSubTest")
    public Object[][] valuesForSub() {
        return new Object[][]{
                {10, 23, -13},
                {10, -1, 11},
                {0, 0, 0},
                {21, 10, 11}
        };
    }
}
