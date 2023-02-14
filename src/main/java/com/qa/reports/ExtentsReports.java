package com.qa.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public final class ExtentsReports {

    private static ExtentReports extent;
    private static ExtentTest test;

    private ExtentsReports() {

    }

    public static void initReport() {
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("reports/" + System.currentTimeMillis() +".html");
        extent.attachReporter(spark);
    }

    public static void setupReport(Method methodName) {
        extent.createTest(methodName.getName())
                .log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
        createTest(methodName.getName());
    }

    public static void createTest(String methodName) {
        test = extent.createTest(methodName);
        ExtentManager.setExTest(test);
    }

    public static void tearDownReports() {
        extent.flush();
    }


    public static void addAuthor(String authors[]) {
        for(String author :authors){
            ExtentManager.getTest().assignAuthor(author);
        }
    }

    public static void addCategories(String categories[]) {
        for(String category :categories){
            ExtentManager.getTest().assignAuthor(category);
        }
    }
}
