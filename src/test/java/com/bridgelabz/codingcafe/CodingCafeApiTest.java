package com.bridgelabz.codingcafe;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CodingCafeApiTest {

    @Before
    public void setUp() throws Exception {
        RestAssured.baseURI="https://cccampdash.incubation.bridgelabz.com";
    }

    @Test
    public void givenMethodForgetCampaignByCampaignShortname() {
        Response response= RestAssured.given()
                //.param("campaignShortName",12231)
                .when()
                .get("/campaign/dashbaord/campaign/12231");
        response.prettyPrint();
            int statusCode=response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }
}
