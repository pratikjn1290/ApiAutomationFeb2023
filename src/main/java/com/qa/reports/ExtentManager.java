package com.qa.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

    public ExtentManager() {}

    private static ThreadLocal<ExtentTest> exTest = new ThreadLocal<ExtentTest>();

    public static ExtentTest getTest() {
        return exTest.get();
    }

    public static void setExTest(ExtentTest test) {
        exTest.set(test);
    }



}
