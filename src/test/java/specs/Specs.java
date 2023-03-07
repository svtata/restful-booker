package specs;

import helpers.CustomApiListener;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.*;

public class Specs {
    public static RequestSpecification request = with()
            .log().uri()
            .log().headers()
            .log().body()
            .filter(CustomApiListener.withCustomTemplates())
            .contentType(ContentType.JSON)
            .baseUri("https://restful-booker.herokuapp.com");

    public static ResponseSpecification response = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .build();
}
