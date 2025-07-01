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
        createTest("Validate Status Code");
        Response response = given().get("/posts/1");
        getTest().info("GET /posts/1 - Status: " + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);
        getTest().pass("Status code is 200 OK");
    }

    @Test
    public void validateHeaders() {
        createTest("Validate Headers");
        Response response = given().get("/posts/1");
        String contentType = response.getHeader("Content-Type");
        getTest().info("Content-Type: " + contentType);
        Assert.assertTrue(contentType.contains("application/json"));
        getTest().pass("Header contains application/json");
    }

    @Test
    public void validateJsonBody() {
        createTest("Validate JSON Body");
        Response response = given().get("/posts/1");
        String userId = response.jsonPath().getString("userId");
        getTest().info("User ID: " + userId);
        Assert.assertEquals(userId, "1");
        getTest().pass("Correct userId found in response");
    }

    @Test
    public void createPost() {
        createTest("Create Post API Test");
        String requestBody = "{" + "\"title\":\"foo\"," + "\"body\":\"bar\"," + "\"userId\":1" + "}";
        getTest().info("Sending POST request to /posts");
        Response response = given().contentType(JSON).body(requestBody).post("/posts");
        getTest().info("Response status: " + response.getStatusCode());
        getTest().info("Response body: " + response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 201);
        getTest().pass("Post created successfully");
    }

    @Test
    public void updatePost() {
        createTest("Update Post API Test");
        String requestBody = "{" + "\"id\":1," + "\"title\":\"updated title\"," + "\"body\":\"updated body\"," + "\"userId\":1" + "}";
        Response response = given().contentType(JSON).body(requestBody).put("/posts/1");
        getTest().info("PUT /posts/1 - Status: " + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("title"), "updated title");
        getTest().pass("Post updated successfully");
    }

    @Test
    public void deletePost() {
        createTest("Delete Post API Test");
        Response response = given().delete("/posts/1");
        getTest().info("DELETE /posts/1 - Status: " + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);
        getTest().pass("Post deleted successfully");
    }

    @Test
    public void createPostWithInvalidData() {
        createTest("Create Post With Invalid Data");
        String invalidRequest = "{" + "\"invalidField\":\"data\"" + "}";
        Response response = given().contentType(JSON).body(invalidRequest).post("/posts");
        getTest().info("POST /posts with invalid field - Status: " + response.getStatusCode());
        Assert.assertTrue(response.getStatusCode() == 201);
        getTest().pass("Mock API accepted invalid field as expected");
    }

    @Test
    public void getPostWithInvalidId() {
        createTest("Get Post With Invalid ID");
        Response response = given().get("/posts/invalid-id");
        getTest().info("GET /posts/invalid-id - Status: " + response.getStatusCode());
        Assert.assertTrue(response.getStatusCode() >= 400);
        getTest().pass("Handled invalid ID with expected error response");
    }

    @Test
    public void deleteNonExistingPost() {
        createTest("Delete Non-existing Post");
        Response response = given().delete("/posts/999999");
        getTest().info("DELETE /posts/999999 - Status: " + response.getStatusCode());
        Assert.assertTrue(response.getStatusCode() == 200 || response.getStatusCode() == 204 || response.getStatusCode() == 404);
        getTest().pass("Handled deletion of non-existent post gracefully");
    }
}
