package org.example.base;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.http.ContentType;
import org.example.actions.AssertActions;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.example.endpoints.APIConstants;
import org.example.modules.PayloadManager;
import org.testng.annotations.BeforeMethod;
import io.restassured.RestAssured;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BaseTest {

    //before running method
    //rest assured .given with the Base URI


    public RequestSpecification requestSpecification;
    public AssertActions actions;
    public PayloadManager payloadManager;
    public JsonPath jsonPath;
    public Response response;

    public ValidatableResponse validatableResponse;
    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        //Base URI
        //COntent type Json

        payloadManager=new PayloadManager();
        actions=new AssertActions();
      requestSpecification= RestAssured.given()
                .baseUri(APIConstants.BASE_URL)
                .contentType(ContentType.JSON);
      /*  requestSpecification=new RequestSpecBuilder()
                .setBaseUri(APIConstants.BASE_URL)
                .addHeader("Content-Type","application/json")
                .build().log().all();
*/

    }

    //Get Token
    public String getToken() throws JsonProcessingException {
        requestSpecification=RestAssured.given().baseUri(APIConstants.BASE_URL).basePath("/auth");
        String payload= payloadManager.setToken();
        response=requestSpecification.contentType(ContentType.JSON)
        .body(payload)
        .when().post();
        jsonPath=new JsonPath(response.toString());
        return payload;
    }
}
