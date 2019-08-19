package com.epam.cdp.tests.junit;

import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;

 

public class TestClassParallel {

    @Test
    public void test() {
        Class[] cls = { DivCalTest.class, MultCalTest.class };

        JUnitCore.runClasses(ParallelComputer.classes(), cls);
        System.out.println("Divided correclly");


        JUnitCore.runClasses(ParallelComputer.methods(), cls);
        System.out.println("Multiplied correctly");



        JUnitCore.runClasses(new ParallelComputer(true, true), cls);

    }

}
