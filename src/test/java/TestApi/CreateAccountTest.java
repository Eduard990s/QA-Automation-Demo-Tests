package TestApi;

import io.qameta.allure.*;
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

@Epic("API Tests")
@Feature("Account Creation")
public class CreateAccountTest {

    private final String FIRST_NAME = "John";
    private final String LAST_NAME = "Doe";
    private final String EMAIL = "john.doe@gmail.com"; // change this before each positive test
    private final String PASSWORD = "Test12345";

    @Test
    @Story("Create new account with valid data")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that a new account can be created via the account/register API endpoint")
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
                FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, PASSWORD);

        Response response = Allure.step("Send POST request to create new account", () ->
                RestAssured
                        .given()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .when()
                        .post("https://auto.pragmatic.bg/index.php?route=account/register&language=en-gb")
                        .then()
                        .extract().response()
        );

        Allure.step("Verify response status code is 200", () ->
                assertEquals(200, response.statusCode(), "Account creation failed!")
        );

        Allure.step("Attach response body for reference", () -> {
            String responseBody = response.getBody().asString();
            System.out.println(responseBody);
            Allure.addAttachment("Create Account Response", "application/json", responseBody, ".json");
        });

        System.out.println("Status code: " + response.getStatusCode());
    }
}