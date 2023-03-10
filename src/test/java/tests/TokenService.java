package tests;

import io.restassured.response.Response;
import models.User;
import specs.Specs;

import static io.restassured.RestAssured.given;

public class TokenService {
    public String getAuthorizationToken(String username, String password) {
        return tokenRequest(username, password)
                .then()
                .spec(Specs.response)
                .extract()
                .body()
                .jsonPath().get("token");
    }

    public Response tokenRequest(String username, String password) {
        User data = User.builder()
                .username(username)
                .password(password)
                .build();
        return given(Specs.request)
                .body(data)
                .when()
                .post("/auth");
    }
}