package org.example.payloads.request;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;

public class Booking {

    @io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty("firstname")
    private String firstname;
    @io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty("lastname")
    private String lastname;
    @io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty("totalprice")
    private Integer totalprice;
    @io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty("depositpaid")
    private Boolean depositpaid;
    @io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty("bookingdates")
    private Bookingdates bookingdates;
    @io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty("additionalneeds")
    private String additionalneeds;

    @io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty("firstname")
    public String getFirstname() {
        return firstname;
    }

    @io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty("firstname")
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty("lastname")
    public String getLastname() {
        return lastname;
    }

    @io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty("lastname")
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty("totalprice")
    public Integer getTotalprice() {
        return totalprice;
    }

    @io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty("totalprice")
    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

    @io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty("depositpaid")
    public Boolean getDepositpaid() {
        return depositpaid;
    }

    @io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty("depositpaid")
    public void setDepositpaid(Boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    @io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty("bookingdates")
    public Bookingdates getBookingdates() {
        return bookingdates;
    }

    @io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty("bookingdates")
    public void setBookingdates(Bookingdates bookingdates) {
        this.bookingdates = bookingdates;
    }

    @io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty("additionalneeds")
    public String getAdditionalneeds() {
        return additionalneeds;
    }

    @JsonProperty("additionalneeds")
    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

}