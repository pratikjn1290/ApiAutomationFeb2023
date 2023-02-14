package com.qa.tests;

import com.qa.annotations.FrameworkAnnotation;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DPTest {


//Data provider return object array in return is not always right
    //number of test will be only one when we run in for loop

    @DataProvider
    public Object[][] getData() {

        //first dim number of time want to execute
        //second dim indicated number of parameters


        return new Object[][]{
                {"qa", "test"},
                {"qaaa", "test2"}
        };

    }

    @Test(dataProvider = "getData")
    @FrameworkAnnotation(author = "Pratik", category = "Smoke")
    public void DataProviderTest(String fName, String lName) {
        System.out.println(fName +" " + lName);

    }

}
