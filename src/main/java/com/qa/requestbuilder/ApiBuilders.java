package com.qa.requestbuilder;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.qa.utility.PropertyType;
import com.qa.utility.PropertyUtils;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public final class ApiBuilders {

    private ApiBuilders() {

    }


    public static RequestSpecification getAPIRequestBuilder() {
        return given().log().all().baseUri(PropertyUtils.getValues(PropertyType.BASEURL));
    }

    public static RequestSpecification postAPIRequestBuilder() {
        return given().log().all().baseUri(PropertyUtils.getValues(PropertyType.BASEURL));
    }


}
