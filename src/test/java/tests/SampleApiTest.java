package tests;

import base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SampleApiTest extends BaseTest {

    @Test
    public void validateStatusCode() {
        Response response = given().get("/posts/1");
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void validateHeaders() {
        Response response = given().get("/posts/1");
        String contentType = response.getHeader("Content-Type");
        Assert.assertTrue(contentType.contains("application/json"));
    }

    @Test
    public void validateJsonBody() {
        Response response = given().get("/posts/1");
        String userId = response.jsonPath().getString("userId");
        Assert.assertEquals(userId, "1");
    }
}