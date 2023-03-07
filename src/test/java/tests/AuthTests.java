package tests;

import models.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import specs.Specs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.is;

public class AuthTests {
    @DisplayName("Successful login")
    @Test
    void successfulLoginTest(){

        User data = new User();
        data.setUsername("admin");
        data.setPassword("password123");
        given(Specs.request)
                .body(data)
                .when()
                .post("/auth")
                .then()
                .spec(Specs.response)
                .body("token", notNullValue());


    }

    @DisplayName("Unsuccessful login (wrong password)")
    @Test
    void unsuccessfulLoginTest(){

        User data = new User();
        data.setUsername("admin");
        data.setPassword("1234");
        given(Specs.request)
                .body(data)
                .when()
                .post("/auth")
                .then()
                .spec(Specs.response)
                .body("reason", is("Bad credentials"));
    }
}
