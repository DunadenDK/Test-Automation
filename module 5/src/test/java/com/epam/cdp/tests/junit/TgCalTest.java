package com.epam.cdp.tests.junit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TgCalTest extends BaseTest {
    @Test(dataProvider = "valuesForTgTest")
    public void TgTest(double a, double expectedValue) {
        double result = calculator.tg(a);
        Assert.assertEquals(result, expectedValue, "Invalid result of tg operation!");
    }

    @DataProvider(name = "valuesForTgTest")
    public Object[][] valuesForTgTest() {
        return new Object[][] {
                {0,  0},
                {45, 1},
                {180,0},
                {360,0}
        };
    }

}
