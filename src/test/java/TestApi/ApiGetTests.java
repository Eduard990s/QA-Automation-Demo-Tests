package TestApi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiGetTests {

    @Test
    public void testGetPost() {
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/1");

        assertEquals(200, response.getStatusCode());

        int userId = response.jsonPath().getInt("userId");
        assertEquals(1, userId);

        System.out.println("Response body: " + response.getBody().asString());
    }
}