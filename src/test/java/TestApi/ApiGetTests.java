package TestApi;

import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("API Tests")
@Feature("GET Requests")
public class ApiGetTests {

    @Test
    @Story("Get post by ID")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the post with ID 1 can be fetched and contains the correct userId")
    public void testGetPost() {

        Response response = Allure.step("Send GET request to fetch post with ID 1", () ->
                RestAssured.get("https://jsonplaceholder.typicode.com/posts/1")
        );

        Allure.step("Verify status code is 200", () ->
                assertEquals(200, response.getStatusCode(), "Expected status code 200")
        );

        int userId = Allure.step("Extract userId from response", () ->
                response.jsonPath().getInt("userId")
        );

        Allure.step("Verify userId is 1", () ->
                assertEquals(1, userId, "Expected userId 1")
        );

        Allure.step("Attach full response for reference", () -> {
            String responseBody = response.getBody().asString();
            System.out.println("Response body: " + responseBody);
            Allure.addAttachment("GET Post Response", "application/json", responseBody, ".json");
        });
    }
}