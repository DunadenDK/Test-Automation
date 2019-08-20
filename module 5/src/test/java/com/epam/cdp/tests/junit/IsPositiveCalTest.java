package com.epam.cdp.tests.junit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IsPositiveCalTest extends BaseTest {
    private long firstNumber;
    private boolean expectedResult;

    public IsPositiveCalTest(long firstNumber, boolean expectedResult) {
        this.firstNumber = firstNumber;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {0,  false},
                {1, true},
                {90,true},
                {-2,false}
        });
    }

    @Test
    public void TestPositive() {
        boolean result = calculator.isPositive(firstNumber);
        Assert.assertEquals(expectedResult, result);

    }
}
