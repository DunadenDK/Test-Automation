package com.epam.cdp.tests.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CosCalTest extends BaseTest {
    @Test(dataProvider = "valuesForCosTest")
    public void CosTest(double a, double expectedValue) {
        double result = calculator.cos(a);
        Assert.assertEquals(result, expectedValue, "Invalid result of cos operation!");
 System.out.println(result);
    }

    @DataProvider(name = "valuesForCosTest")
    public Object[][] valuesForCosTest() {
        return new Object[][] {
                {0,  1},
                {60, 0.5},
                {90,0},
                {180,-1}
        };
    }

}
