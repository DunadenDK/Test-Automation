package com.epam.cdp.cal.tests.junit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class IsNegativeCalTest extends BaseTest {
    @Test(dataProvider = "valuesForIsNegativeTest")
    public void IsNegativeTest(long val, boolean expectedValue) {
        boolean result = calculator.isNegative(val);
        Assert.assertEquals(result, expectedValue, "Invalid result of isNegative operation!");
    }

    @DataProvider(name = "valuesForIsNegativeTest")
    public Object[][] valuesForIsNegativeTest() {
        return new Object[][] {
                {0,  false},
                {1, false},
                {90,false},
                {-2,true}
        };
    }

}
