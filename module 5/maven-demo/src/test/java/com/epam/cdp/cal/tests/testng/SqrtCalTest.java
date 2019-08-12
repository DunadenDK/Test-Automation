package com.epam.cdp.cal.tests.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SqrtCalTest extends BaseTest{
    @Test(dataProvider = "valuesForSqrtTest")
    public void SqrtTest(double a, double expectedValue) {
        double result = calculator.sqrt(a);
        Assert.assertEquals(result, expectedValue, "Invalid result of sqrt operation!");
    }

    @DataProvider(name = "valuesForSqrtTest")
    public Object[][] valuesForSqrtTest() {
        return new Object[][] {
                {4, 2},
                {9, 3},
                {16, 4},
                {100, 10}
        };
    }
}
