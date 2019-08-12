package com.epam.cdp.cal.tests.testng;

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
                {10, 23, 33},
                {10, -1, 9},
                {0, 0, 0},
                {-1, 10, 9}
        };
    }
}
