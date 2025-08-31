package TestAPI;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountApiTest {

    @Test
    public void getAccountDetailsTest() {
        String customerToken = "87cf934d99aad695fc2560dfb4"; // Inserisci il token valido

        Response response = RestAssured
                .given()
                .queryParam("customer_token", customerToken)
                .when()
                .get("https://auto.pragmatic.bg/index.php?route=account/account&language=en-gb")
                .then()
                .extract().response();

        System.out.println(response.asString());
        assertEquals(200, response.statusCode());
    }
}