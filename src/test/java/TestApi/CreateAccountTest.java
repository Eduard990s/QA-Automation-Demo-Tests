
package TestAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * NOTE: The target website does NOT actually create new users via this API endpoint.
 * This test is developed solely to verify API communication, request/response handling,
 * and integration with the test framework.
 * To test this functionality, modify the information below as needed.
 */

public class CreateAccountTest {


    private final String FIRST_NAME = "John";
    private final String LAST_NAME = "Doe";
    private final String EMAIL = "john.doe@gmail.com"; // change this before each positive test
    private final String PASSWORD = "Test12345";

    @Test
    public void createNewAccountPositive() {
        String requestBody = String.format(
                "{\n" +
                        "  \"firstname\": \"%s\",\n" +
                        "  \"lastname\": \"%s\",\n" +
                        "  \"email\": \"%s\",\n" +
                        "  \"password\": \"%s\",\n" +
                        "  \"confirm\": \"%s\",\n" +
                        "  \"agree\": true\n" +
                        "}",
                FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, PASSWORD); // Modify these values to test API communication
        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("https://auto.pragmatic.bg/index.php?route=account/register&language=en-gb")
                .then()
                .extract().response();

        System.out.println(response.asString());
        assertEquals(200, response.statusCode(), "Account creation failed!");
        System.out.println("Response body: " + response.getBody().asString());
        System.out.println("Status code: " + response.getStatusCode());
    }
}