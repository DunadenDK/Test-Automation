package com.epam.cdp.tests.junit;

import com.epam.tat.module4.Calculator;
import org.junit.After;
import org.junit.Before;



public class BaseTest {
public static double DELTA = 0.000001;

	protected Calculator calculator;

	@Before
	public void setUp() {
		calculator = new Calculator();
	}

	@After
	public void tearDown() {
		calculator = null;
	}

}
