package tests;

import models.Booking;
import models.BookingDates;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import specs.Specs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class CreateBookingTests {
    @DisplayName("Creating booking and checking booking in common list")
    @Test
    void createBookingTest() {
        Booking booking = Booking.builder()
                .bookingdates(BookingDates.builder().checkin("2018-01-01").checkout("2018-01-09").build())
                .firstname("Jim")
                .lastname("Brown")
                .totalprice(1000)
                .depositpaid(true)
                .additionalneeds("Breakfast")
                .build();
        int bookingId = given(Specs.request)
                .when()
                .body(booking)
                .post("/booking")
                .then()
                .spec(Specs.response)
                .body("bookingid", notNullValue())
                .extract().body().jsonPath().get("bookingid");

        given(Specs.request)
                .when()
                .get("/booking/" + bookingId)
                .then()
                .spec(Specs.response)
                .body("firstname", is("Jim"));
    }
}





