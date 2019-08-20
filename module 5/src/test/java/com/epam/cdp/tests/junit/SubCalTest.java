package com.epam.cdp.tests.junit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SubCalTest extends BaseTest {
	private double firstNumber;
	private double secondNumber;
	private double expectedResult;

	public SubCalTest(double firstNumber, double secondNumber, double expectedResult) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
		this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection primeNumbers() {
		return Arrays.asList(new Object[][] {
				{10, 23, -13},
				{10, -1, 11},
				{0, 0, 0},
				{21, 10, 11}
		});
	}

	@Test
	public void TestSub() {
		double result = calculator.sub(firstNumber,secondNumber);
		Assert.assertEquals(expectedResult, result, DELTA);

	}
}
