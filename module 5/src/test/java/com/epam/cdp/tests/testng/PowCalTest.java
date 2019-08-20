package com.epam.cdp.tests.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PowCalTest extends BaseTest {
    @Test(dataProvider = "valuesForPowTest")
    public void PowTest(double a, double b, double expectedValue) {
        double result = calculator.pow(a, b);
        Assert.assertEquals(result, expectedValue, "Invalid result of pow operation!");
    }

    @DataProvider(name = "valuesForPowTest")
    public Object[][] valuesForPowTest() {
        return new Object[][] {
                {7, 2, 49},
                {4, -2, 2},
                {0, 0, 1},
                {4, 2.5, 32}
        };
    }
}
