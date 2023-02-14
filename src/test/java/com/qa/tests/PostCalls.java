package com.qa.tests;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.qa.annotations.FrameworkAnnotation;
import com.qa.pojos.Employee;
import com.qa.reports.ExtentLogger;
import com.qa.reports.ExtentManager;
import com.qa.reports.ExtentsReports;
import com.qa.requestbuilder.ApiBuilders;
import com.qa.utility.FileUtils;
import com.qa.utility.FrameworkConstants;
import com.qa.utility.RandomUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class PostCalls extends  BaseTest{

    @Test
    @FrameworkAnnotation(author = "Pratik", category = "Smoke")
    public void postCallTest() {
        Employee emp = Employee.builder().
                city(RandomUtils.getCity()).id(RandomUtils.getId()).
                fName(RandomUtils.getFirstName()).
                lName(RandomUtils.getLastName()).build();
        Response res = ApiBuilders.postAPIRequestBuilder().
                contentType(ContentType.JSON).body(emp).post("/employees");
        ExtentLogger.logResponse(res.asPrettyString());
        System.out.println(res.prettyPrint());
        Assert.assertEquals(res.getStatusCode(), 201);
    }

    @Test
    @FrameworkAnnotation(author = "Pratik", category = "Smoke")
    public void postCallWithExternalFile() {
        String req = FileUtils.readJsonAndReturnString(FrameworkConstants.REQUEST_FOLDER_PATH).
                replace("Firstname", RandomUtils.getFirstName())
                .replace("id", String.valueOf(RandomUtils.getId()));

        Response res = ApiBuilders.postAPIRequestBuilder().body(req).post("/employees");
        res.prettyPrint();
        ExtentLogger.logResponse(res.asPrettyString());
        FileUtils.storeJsonResponseInFile(FrameworkConstants.RESPONSE_FOLDER_PATH, res);
        Assert.assertEquals(res.getStatusCode(), 201);
    }

}
