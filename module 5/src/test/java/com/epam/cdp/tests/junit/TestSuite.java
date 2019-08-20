package com.epam.cdp.tests.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({CosCalTest.class, CtgCalTest.class, DivCalTest.class, IsNegativeCalTest.class, IsPositiveCalTest.class,
        MultCalTest.class, PowCalTest.class, SinCalTest.class, SqrtCalTest.class, SubCalTest.class, SumCalTest.class, TgCalTest.class})

public class TestSuite {

}
