package com.epam.cdp.tests.junit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumCalTest extends BaseTest {

	@Test(dataProvider = "valuesForSunTest")
	public void onePlusTwoTest(long a, long b, long expectedValue) {
		long result = calculator.sum(a, b);
		Assert.assertEquals(result, expectedValue, "Invalid result of sum operation!");
	}
	
	@DataProvider(name = "valuesForSunTest") 
	public Object[][] valuesForSum() {
		return new Object[][] {
				{10, 23, 33},
				{10, -1, 9},
				{0, 0, 0},
				{-1, 10, 9}
		};
	}

	@Test(dataProvider = "doubleValuesForSunTest")
	public void doubleOnePlusTwoTest(double a, double b, double expectedValue) {
		double result = calculator.sum(a, b);
		Assert.assertEquals(result, expectedValue, "Invalid result of sum operation!");
	}

	@DataProvider(name = "doubleValuesForSunTest")
	public Object[][] doubleValuesForSum() {
		return new Object[][] {
				{10.6, 23.4, 34.0},
				{10.56, -1.56, 9.0},
				{0.0, 0.0, 0.0},
				{-1.45, 10.45, 9.0},
				{-1.5, -10.5, -12.0}
		};
	}


}
