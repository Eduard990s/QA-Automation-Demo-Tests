package TestApi;

import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("API Tests")
@Feature("POST Requests")
public class ApiPostTests {

    @Test
    @Story("Create a new user")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that a new user can be created via POST request")
    public void createNewUserTest() {

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        String requestBody = "{\n" +
                "  \"name\": \"John Doe\",\n" +
                "  \"username\": \"johndoe\",\n" +
                "  \"email\": \"john@example.com\"\n" +
                "}";

        Response response = Allure.step("Send POST request to create a new user", () ->
                given()
                        .header("Content-type", "application/json")
                        .and()
                        .body(requestBody)
                        .when()
                        .post("/users")
                        .then()
                        .extract().response()
        );

        Allure.step("Verify response status code is 201", () ->
                assertEquals(201, response.getStatusCode(), "Expected status code 201")
        );

        Allure.step("Attach response body for reference", () -> {
            String responseBody = response.getBody().asString();
            System.out.println(responseBody);
            Allure.addAttachment("POST User Response", "application/json", responseBody, ".json");
        });
    }
}