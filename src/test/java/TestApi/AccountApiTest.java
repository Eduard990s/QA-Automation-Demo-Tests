package TestApi;

import io.qameta.allure.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("API Tests")
@Feature("Account API")
public class AccountApiTest {

    @Test
    @Story("Get account details")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that account details can be fetched successfully with a valid customer token")
    public void getAccountDetailsTest() {

        String customerToken = "87cf934d99aad695fc2560dfb4";

        Response response = Allure.step("Send GET request to fetch account details", () ->
                RestAssured
                        .given()
                        .queryParam("customer_token", customerToken)
                        .when()
                        .get("https://auto.pragmatic.bg/index.php?route=account/account&language=en-gb")
                        .then()
                        .extract().response()
        );

        Allure.step("Log response for debug", () -> {
            String responseBody = response.asString();
            System.out.println(responseBody);
            Allure.addAttachment("Account API Response", "application/json", responseBody, ".json");
        });

        Allure.step("Verify that status code is 200", () ->
                assertEquals(200, response.statusCode(), "Expected status code 200")
        );
    }
}