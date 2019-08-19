package com.epam.cdp.tests.junit;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class CosCalTest extends BaseTest {

    @Test(dataProvider = "valuesForCosTest")
    public void CosTest(double a, double expectedValue) {
        double result = calculator.cos(a);
        Assert.assertEquals(result, expectedValue, "Invalid result of cos operation!");
    }

    @DataProvider(name = "valuesForCosTest")
    public Object[][] valuesForSinTest() {
        return new Object[][]{
                {0,  1},
                {60, 0.5},
                {90,0},
                {180,-1}
        };
    }
}
