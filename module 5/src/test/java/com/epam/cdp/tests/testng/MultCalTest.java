package com.epam.cdp.tests.testng;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultCalTest extends BaseTest {
    @Test(dataProvider = "valuesForMultTest")
    public void oneMultTwoTest(long a, long b, long expectedValue) {
        long result = calculator.mult(a, b);
        Assert.assertEquals(result, expectedValue, "Invalid result of mult operation!");
    }

    @DataProvider(name = "valuesForMultTest")
    public Object[][] valuesForMult() {
        return new Object[][] {
                {5, 3, 15},
                {10, -1, -10},
                {0, 0, 0},
                {2.2, 5.5, 12.1}
        };
    }

    @Test(dataProvider = "doubleValuesForMultTest")
    public void doubleOneMultTwoTest(double a, double b, double expectedValue) {
        double result = calculator.mult(a, b);
        Assert.assertEquals(result, expectedValue, "Invalid result of mult operation!");
    }

    @DataProvider(name = "doubleValuesForMultTest")
    public Object[][] doubleValuesForMult() {
        return new Object[][] {
                {1.5, 3, 4.5},
                {10, -1.5, -15.0},
                {0.0, 0.0, 0.0},
                {-1.55, -100, 155.0}
        };
    }
}
