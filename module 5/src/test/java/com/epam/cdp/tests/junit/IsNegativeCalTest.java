package com.epam.cdp.tests.junit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IsNegativeCalTest extends BaseTest {
    private long firstNumber;
    private boolean expectedResult;

    public IsNegativeCalTest(long firstNumber, boolean expectedResult) {
        this.firstNumber = firstNumber;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {0, false},
                {1, false},
                {90, true},
                {-2, true}
        });
    }

    @Test
    public void TestNegative() {
        boolean result = calculator.isNegative(firstNumber);
        Assert.assertEquals(expectedResult, result);

    }
}