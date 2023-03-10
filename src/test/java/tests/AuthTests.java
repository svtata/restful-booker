package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import specs.Specs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;

@Feature("Authorization")
public class AuthTests {
    private final TokenService tokenService = new TokenService();

    @DisplayName("Successful login")
    @Test
    void successfulLoginTest(){
        String tokenAuth = tokenService.getAuthorizationToken("admin", "password123");
        assertThat(tokenAuth).isNotEmpty();
    }

    @DisplayName("Unsuccessful login (wrong password)")
    @Test
    void unsuccessfulLoginTest(){
        tokenService
                .tokenRequest("admin", "1234")
                .then()
                .spec(Specs.response)
                .body("reason", is("Bad credentials"));
    }
}
