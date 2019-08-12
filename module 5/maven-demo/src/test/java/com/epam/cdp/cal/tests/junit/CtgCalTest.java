package com.epam.cdp.cal.tests.junit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CtgCalTest extends BaseTest {
    @Test(dataProvider = "valuesForCtgTest")
    public void TgTest(double a, double expectedValue) {
        double result = calculator.ctg(a);
        Assert.assertEquals(result, expectedValue, "Invalid result of ctg operation!");
    }

    @DataProvider(name = "valuesForCtgTest")
    public Object[][] valuesForCtgTest() {
        return new Object[][] {
                {45,  1},
                {90, 0},
                {270,0}
        };
    }

}
