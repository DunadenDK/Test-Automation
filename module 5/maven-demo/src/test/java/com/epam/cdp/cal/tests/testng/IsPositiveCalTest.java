package com.epam.cdp.cal.tests.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IsPositiveCalTest extends BaseTest{
    @Test(dataProvider = "valuesForIsPositiveTest")
    public void IsPositiveTest(long val, boolean expectedValue) {
        boolean result = calculator.isPositive(val);
        Assert.assertEquals(result, expectedValue, "Invalid result of isPositive operation!");
    }

    @DataProvider(name = "valuesForIsPositiveTest")
    public Object[][] valuesForIsPositiveTest() {
        return new Object[][] {
                {0,  false},
                {1, true},
                {90,true},
                {-2,false}
        };
    }

}
