package com.epam.cdp.tests.testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumCalTest extends BaseTest {

    @Test(dataProvider = "valuesForSumTest")
    public void onePlusTwo(long a, long b, long expectedValue) {
        long result = calculator.sum(a, b);
        Assert.assertEquals(result, expectedValue, "Invalid result of sum operation!");
    }

    @DataProvider(name = "valuesForSumTest")
 public Object[][] valuesForSum() {
        return new Object [][] {
                {10, 23 ,33},
                {10, -1, 9},
                {0, 0, 0},
                {-1, 10, 9}
        };

    }
}