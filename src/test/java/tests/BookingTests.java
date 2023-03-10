package tests;

import io.qameta.allure.Feature;
import models.Booking;
import models.BookingDates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import specs.Specs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@Feature("Realization of booking service")
public class BookingTests {
    private int bookingId;

    @BeforeEach
    void setUp() {
        Booking booking = Booking.builder()
                .bookingdates(BookingDates.builder().checkin("2018-01-01").checkout("2018-01-09").build())
                .firstname("Jim")
                .lastname("Brown")
                .totalprice(1000)
                .depositpaid(true)
                .additionalneeds("Breakfast")
                .build();
        bookingId = given(Specs.request)
                .when()
                .body(booking)
                .post("/booking")
                .then()
                .spec(Specs.response)
                .body("bookingid", notNullValue())
                .extract().body().jsonPath().get("bookingid");
    }

    @DisplayName("Create and checking booking in common list")
    @Test
    void createBookingTest() {
        given(Specs.request)
                .when()
                .get("/booking/" + bookingId)
                .then()
                .spec(Specs.response)
                .body("firstname", is("Jim"));
    }

    @DisplayName("Update booking")
    @Test
    void partialUpdateBookingTest() {
        String data = "{\"firstname\" : \"James\"}";
        TokenService token = new TokenService();
        String cookieToken = token.getAuthorizationToken("admin", "password123");
        given(Specs.request)
                .cookies("token", cookieToken)
                .when()
                .body(data)
                .patch("/booking/" + bookingId)
                .then()
                .spec(Specs.response)
                .body("firstname", is("James"));
    }

    @DisplayName("Delete booking")
    @Test
    void deleteBookingTest() {
        TokenService token = new TokenService();
        String cookieToken = token.getAuthorizationToken("admin", "password123");
        given(Specs.request)
                .cookies("token", cookieToken)
                .when()
                .delete("/booking/" + bookingId)
                .then()
                .log().body()
                .log().status()
                .statusCode(201);
    }
}