package com.epam.cdp.tests.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SinCalTest extends BaseTest{
    @Test(dataProvider = "valuesForSinTest")
    public void SinTest(double a, double expectedValue) {
        double result = calculator.sin(a);
        Assert.assertEquals(result, expectedValue, "Invalid result of sin operation!");
    }

    @DataProvider(name = "valuesForSinTest")
    public Object[][] valuesForSinTest() {
        return new Object[][] {
                {0, 0},
                {30, 0.5},
                {90, 1},
                {270, -1}
        };
    }
}
