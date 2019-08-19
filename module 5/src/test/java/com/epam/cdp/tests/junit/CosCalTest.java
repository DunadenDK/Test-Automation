package com.epam.cdp.tests.junit;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Date;

public class CosCalTest extends BaseTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void cosBug() throws InterruptedException { //returns sinus of 'a' as the result : return Math.sin(a);
        Thread.sleep(1000);
        System.out.println("Junit Time is: " + new Date(System.currentTimeMillis()));
        double result = calculator.cos(-5.0);
        System.out.println("Actual result is: " + result);
        System.out.println("Expected result is: " + Math.cos(-5.0));
        Assert.assertTrue(result == Math.cos(-5.0));
    }
}
