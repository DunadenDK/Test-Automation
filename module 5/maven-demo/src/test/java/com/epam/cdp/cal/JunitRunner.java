package com.epam.cdp.cal;

import org.junit.extensions.cpsuite.ClasspathSuite;
import org.junit.extensions.cpsuite.SuiteType;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;

@RunWith(ClasspathSuite.class)
@ClasspathSuite.SuiteTypes({SuiteType.RUN_WITH_CLASSES, SuiteType.TEST_CLASSES, SuiteType.JUNIT38_TEST_CLASSES})
public class JunitRunner {

    public static void main(String args[]) {
        JUnitCore.runClasses(JunitRunner.class);
    }
}
