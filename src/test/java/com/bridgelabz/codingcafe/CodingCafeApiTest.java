package com.bridgelabz.codingcafe;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CodingCafeApiTest {

    private  String tokenValue="eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiUUEiLCJlbWFpbElkIjoidGVzdGluZ3Rlc3RkYXRhYmx6QGdtYWlsLmNvbSIsImlkIjoiNWRjZmRiYmRjNTgzNmIwMDA2OTc4YWFhIiwiZXhwIjoxNTgwOTYxNjY0fQ.8KaZq5aXgmxc4_M8SE-029gldj9sUMwslwR941TrYLE";
    Response response;


    @Before
    public void setUp()  {
        RestAssured.baseURI="https://cccampdash.incubation.bridgelabz.com";

    }

    @Test
    public void givenMethodForgetCampaignByCampaignShortname() {
        response= RestAssured.given()
                .when()
                .get("/campaign/dashbaord/campaign/ABH");
        response.prettyPrint();
            int statusCode=response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }

    @Test
    public void givenMethodForGetCount() {
         response=RestAssured.given()
                .header("token",tokenValue)
                .when()
                .get("/campaign/dashboard");
        response.prettyPrint();
        int statusCode=response.getStatusCode();
        Assert.assertEquals(statusCode,200);

    }

    @Test
    public void givenMethodForGetListOfCampianType() {
        response=RestAssured.given()
                .pathParam("campaignType","Registration")
                .header("token",tokenValue)
                .when()
                .get("campaign/dashboard/Registration");
        response.prettyPrint();
        int statusCode=response.getStatusCode();
        Assert.assertEquals(statusCode,200);

    }

    @Test
    public void givenmethodForGetCampianShortname() throws ParseException {
        response=RestAssured.given()
                .header("token",tokenValue)
                .when()
                .get("/campaign/dashboard/campaign/shortname");
         int statusCode=response.getStatusCode();
        ResponseBody body=response.getBody();
        JSONObject object =(JSONObject) new JSONParser().parse(body.prettyPrint());;
         String message= (String) object.get("message");
         Assert.assertEquals(statusCode,200);
         Assert.assertEquals("Campaign retrieved successfully",message);
    }
}
