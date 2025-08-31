package TestApi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiPostTests {

    @Test
    public void createNewUserTest() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        String requestBody = "{\n" +
                "  \"name\": \"John Doe\",\n" +
                "  \"username\": \"johndoe\",\n" +
                "  \"email\": \"john@example.com\"\n" +
                "}";

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/users")
                .then()
                .extract().response();

        assertEquals(201, response.getStatusCode());

        System.out.println(response.getBody().asString());
    }
}
