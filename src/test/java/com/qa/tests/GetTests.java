package com.qa.tests;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.qa.annotations.FrameworkAnnotation;
import com.qa.reports.ExtentLogger;
import com.qa.reports.ExtentManager;
import com.qa.reports.ExtentsReports;
import com.qa.requestbuilder.ApiBuilders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;

public class GetTests extends  BaseTest{

    @Test
    @FrameworkAnnotation(author = "Pratik", category = "Smoke")
    public void getEmployeeDetails()
    {

        Response response = ApiBuilders.getAPIRequestBuilder().get("/employees");
        response.prettyPrint();
        ExtentLogger.logResponse(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
