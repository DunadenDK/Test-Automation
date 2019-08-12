package com.epam.cdp.cal.tests.junit;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SubCalTest extends BaseTest {

	@Test
	public void twoMinusOne() {
		Assert.assertTrue(calculator.sub(2, 1) == 1);
	}

	@Test
	public void doubleThreeMinusOne() {
		Assert.assertTrue(calculator.sub(3.5, 1) == 2.5);
	}

}
