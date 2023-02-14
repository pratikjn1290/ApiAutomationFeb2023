package com.qa.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.qa.reports.ExtentLogger;
import com.qa.reports.ExtentsReports;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class BaseTest{

@BeforeSuite
    public void setupReport() {
        ExtentsReports.initReport();
    }


    @AfterSuite
    public void tearDownReport() {
        ExtentsReports.tearDownReports();
    }

    @BeforeMethod
    public void setupReportMethod(Method m) {
        ExtentsReports.createTest(m.getName());
    }

    @AfterMethod
    public void tearDown(ITestResult result)
    {

        if(!result.isSuccess())
        {
            ExtentLogger.fail(String.valueOf(result.getThrowable()));
        }

    }


}
