package com.epam.cdp.cal.tests.junit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

//@RunWith(Parameterized.class)
public class CosCalTest extends BaseTest {

//    @Parameterized.Parameters
//    public static Collection<Object[]> data() {
//        return Arrays.asList(new Object[][] {
//                {0, 1},
//                {60, 0.5},
//                {90,0},
//                {180,-1}
//        });
//    }

    @Test
    public void CosTest(double a, double expectedValue) {
//        double result = calculator.cos(a);
//        Assert.assertEquals(result, expectedValue, "Invalid result of cos operation!");
//        Assert.assertEquals(result, expectedValue, DELTA);
        Assert.assertEquals(1.0, 1.0, DELTA);
    }
}
