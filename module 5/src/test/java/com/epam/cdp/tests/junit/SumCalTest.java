package com.epam.cdp.tests.junit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SumCalTest extends BaseTest {
	private double firstNumber;
	private double secondNumber;
	private double expectedResult;

	public SumCalTest(double firstNumber, double secondNumber, double expectedResult) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
		this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection primeNumbers() {
		return Arrays.asList(new Object[][] {
				{10, 23, 33},
				{10, -1, 9},
				{0, 0, 0},
				{-1, 10, 9},
				{10.6, 23.4, 34.0},
				{10.56, -1.56, 9.0},
				{0.0, 0.0, 0.0},
				{-1.45, 10.45, 9.0},
				{-1.5, -10.5, -12.0}
		});
	}

	@Test
	public void TestSum() {
		double result = calculator.sum(firstNumber,secondNumber);
		Assert.assertEquals(expectedResult, result, DELTA);

	}
}
	
