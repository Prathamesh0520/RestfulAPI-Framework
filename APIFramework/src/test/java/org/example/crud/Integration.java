package org.example.crud;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.assertj.core.api.Assertions;
import org.example.base.BaseTest;
import org.example.endpoints.APIConstants;
import org.example.payloads.request.Booking;
import org.example.payloads.response.BookingResponse;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Integration extends BaseTest {
    String token;
    String bookingId;
    String bookingIdPojo;

    //Create Booking
    @Test(groups = "P0")
    public void testCreateBooking() throws JsonProcessingException {
        token = getToken();
        Assertions.assertThat(token).isNotNull().isNotEmpty();

        requestSpecification.basePath(APIConstants.CREATE_BOOKING);
        response = RestAssured.given().spec(requestSpecification)
                .when().body(payloadManager.createPayload()).post();
        validatableResponse = response.then().log().all();
        jsonPath = JsonPath.from(response.asString());
        validatableResponse.statusCode(200);
        // Direct Extraction from json Path
        bookingId = jsonPath.getString("bookingid");
        // Booking Response Class
        BookingResponse bookingRespons = payloadManager.JsonToObject(response.asString());
        bookingIdPojo = bookingRespons.getBookingid().toString();
        //log.info("This is My Booking ID"+bookingIdPojo);
        Assertions.assertThat(bookingId).isNotNull().isNotEmpty();

    }

    //Update booking with token and ID
    @Test(groups = "P0",dependsOnMethods = "testCreateBooking")
    public void testUpdateBooking() throws JsonProcessingException {
        System.out.println("testUpdateBooking"+token);
        System.out.println("JSON Booking ID:" +bookingId);
        System.out.println("bookingIDPojo :"+bookingIdPojo);
        requestSpecification.basePath(APIConstants.UPDATE_BOOKING + "/" + bookingId);
        response = RestAssured.given().spec(requestSpecification).cookie("token",token)
                .when().body(payloadManager.updatedPayload()).put();
        validatableResponse = response.then().log().all();
        //validatableResponse.body("firstname", Matchers.is("Lucky"));

        Booking bookingRespons = payloadManager.JsonToObjectPUT(response.asString());
        Assertions.assertThat(bookingRespons.getFirstname()).isEqualTo("Lucky").isNotNull();
        Assertions.assertThat(bookingRespons.getLastname()).isNotNull();
        Assertions.assertThat(bookingRespons.getDepositpaid()).isNotNull();
        Assertions.assertThat(bookingRespons.getBookingdates().getCheckin()).isNotNull();
        Assertions.assertThat(bookingRespons.getBookingdates().getCheckout()).isNotEmpty();
    }

    //Delete booking with token and ID
    @Test(groups = "P0",dependsOnMethods = "testCreateBooking")
    public void testDeleteBooking(){
        requestSpecification.basePath(APIConstants.UPDATE_BOOKING+"/"+bookingId);
        response = RestAssured.given().spec(requestSpecification)
                .when().get();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(404);
    }
}
