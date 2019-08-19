package com.epam.cdp.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivCalTest extends BaseTest {
    @Test(dataProvider = "valuesForDivTest")
    public void oneDivTwoTest(long a, long b, long expectedValue) {
        long result = calculator.div(a, b);
        Assert.assertEquals(result, expectedValue, "Invalid result of div operation!");
    }

    @DataProvider(name = "valuesForDivTest")
    public Object[][] valuesForDiv() {
        return new Object[][] {
                {6, 3, 2},
                {10, -1, -10},
                {0, 1, 0},
                {-10, -10, 1}
 //             {-10, 0, }
        };
    }

    @Test(dataProvider = "doubleValuesForDivTest")
    public void doubleOneDivTwoTest(double a, double b, double expectedValue) {
        double result = calculator.div(a, b);
        Assert.assertEquals(result, expectedValue, "Invalid result of div operation!");
    }

    @DataProvider(name = "doubleValuesForDivTest")
    public Object[][] doubleValuesForDiv() {
        return new Object[][] {
                {1.5, 3, 0.5},
                {3, -1.5, -2.0},
                {0.0, 1, 0.0},
                {-1.55, -1.55, 1.0}
 //               {4,0}
        };
    }
}
