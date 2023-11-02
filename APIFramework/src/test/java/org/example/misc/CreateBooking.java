package org.example.misc;

import java.util.Iterator;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.assertj.core.api.Assertions;
import org.example.actions.AssertActions;
import org.example.base.BaseTest;
import org.example.endpoints.APIConstants;
import org.example.modules.PayloadManager;
import org.example.payloads.request.Booking;
import org.example.payloads.response.BookingResponse;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;


public class CreateBooking extends BaseTest {
    String bookingId;
    String bookingIdPojo;

    @Test(groups = "P0")
    @Owner("Prathamesh")
    @Description("Verify that create booking works and ID is generates")
    public void testCreateBooking_Positive() throws JsonProcessingException {
        //Call Request Block
        //Call Payload
        //Call Assertion block
        payloadManager = new PayloadManager();
        actions = new AssertActions();
        requestSpecification = RestAssured.given()
                .baseUri(APIConstants.BASE_URL)
                .contentType(ContentType.JSON).log().all();
        requestSpecification.basePath(APIConstants.CREATE_BOOKING);
        response = requestSpecification.when().body(payloadManager.createPayload()).post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        String bookingId=jsonPath.getString("bookingId");
        BookingResponse bookingResponse = payloadManager.JsonToObject(response.asString());
        Assertions.assertThat(bookingResponse.getBookingid().toString()).isNotEmpty().isNotNull();
    }
    @Test(groups = "P0")
    @Owner("Prathamesh")
    @Description("Verify that create booking with no payload")
    public void testCreateBooking_Negative() throws JsonProcessingException {
        //Call Request Block
        //Call Payload
        //Call Assertion block


        payloadManager = new PayloadManager();
        actions = new AssertActions();
        requestSpecification = RestAssured.given()
                .baseUri(APIConstants.BASE_URL)
                .contentType(ContentType.JSON).log().all();
        requestSpecification.basePath(APIConstants.CREATE_BOOKING);
        response = requestSpecification.when().body("").post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(500);


    }
}
