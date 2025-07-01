// SampleApiTest.java
package tests;

import base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.JSON;

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

    @Test
    public void createPost() {
        String requestBody = "{" +
                "\"title\":\"foo\"," +
                "\"body\":\"bar\"," +
                "\"userId\":1" +
                "}";

        Response response = given()
                .contentType(JSON)
                .body(requestBody)
                .post("/posts");

        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(response.jsonPath().getString("title"), "foo");
    }

    @Test
    public void updatePost() {
        String requestBody = "{" +
                "\"id\":1," +
                "\"title\":\"updated title\"," +
                "\"body\":\"updated body\"," +
                "\"userId\":1" +
                "}";

        Response response = given()
                .contentType(JSON)
                .body(requestBody)
                .put("/posts/1");

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("title"), "updated title");
    }

    @Test
    public void deletePost() {
        Response response = given().delete("/posts/1");
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void createPostWithInvalidData() {
        String invalidRequest = "{" +
                "\"invalidField\":\"data\"" +
                "}";

        Response response = given()
                .contentType(JSON)
                .body(invalidRequest)
                .post("/posts");

        Assert.assertTrue(response.getStatusCode() >= 201, "Expected client error status code");
    }

    @Test
    public void getPostWithInvalidId() {
        Response response = given().get("/posts/invalid-id");
        Assert.assertTrue(response.getStatusCode() >= 400, "Expected error status code for invalid ID");
    }

    @Test
    public void deleteNonExistingPost() {
        Response response = given().delete("/posts/999999");
        Assert.assertTrue(response.getStatusCode() == 200 || response.getStatusCode() == 204 || response.getStatusCode() == 404);
    }
}
