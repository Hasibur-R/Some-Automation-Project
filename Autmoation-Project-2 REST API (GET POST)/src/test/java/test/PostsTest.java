package test;

import api.endpoints.PostsEndPoints;
import api.payload.Posts;
import com.github.javafaker.Faker;
import com.google.common.collect.Ordering;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class PostsTest {
    Faker faker;
    Posts postPayload;

    //Send GET Request to get all posts (/posts).
    @Test(priority = 1)
    public void testGetAllPosts() {
        Response response = PostsEndPoints.getAllPosts();

        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);

        String contentType = response.getContentType();
        Assert.assertTrue(contentType.startsWith("application/json"), "Content type is not JSON");

        List<Integer> postIds = response.jsonPath().getList("id");
        boolean sorted = Ordering.natural().isOrdered(postIds);
        Assert.assertTrue(sorted, "Post are not sorted ascending by id");
    }

    //Send GET request to get post with id=99 (/posts/99).
    @Test(priority = 2)
    public void testGetPost() {
        int postId = 99;
        Response response = PostsEndPoints.getPosts(postId);

        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);

        int userId = response.jsonPath().getInt("userId");
        int id = response.jsonPath().getInt("id");
        String title = response.jsonPath().getString("title");
        String body = response.jsonPath().getString("body");

        Assert.assertEquals(userId, 10);
        Assert.assertEquals(id, postId);
        Assert.assertFalse(title.isEmpty(), "Title is empty");
        Assert.assertFalse(body.isEmpty(), "Body is empty");
    }

    //Send GET request to get post with id=150 (/posts/150)
    @Test(priority = 3)
    public void testGetPostSecond() {
        int Id = 150;
        Response response = PostsEndPoints.getPosts(Id);

        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 404);
        Assert.assertFalse(response.getBody().asString().isEmpty(), "Response body is not empty");
    }

    //Send POST request to create post with userId=1 and random body and random title (/posts).
    @BeforeClass
    public void setupData() {
        int userId = 1;
        faker = new Faker();
        postPayload = new Posts();

        postPayload.setUserId(userId);
        postPayload.setId(faker.idNumber().hashCode());
        postPayload.setTitle(faker.lorem().sentence());
        String bodyWithBackslashes = String.join("\\" + " ", faker.lorem().words(5));
        postPayload.setBody(bodyWithBackslashes);
    }
    //Send POST request to create post with userId=1 and random body and random title (/posts).
    @Test(priority = 4)
    public void testPostingPosts() {
        int userId = 1;
        Response response = PostsEndPoints.createPosts(postPayload);

        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 201);

        int postId = response.jsonPath().getInt("id");
        Assert.assertEquals(response.jsonPath().getInt("userId"), userId, "UserId is not present in the response");
        Assert.assertEquals(response.jsonPath().getString("title"), postPayload.getTitle(), "Title is not present in the response");
        Assert.assertEquals(response.jsonPath().getString("body"), postPayload.getBody(), "Body is not present in the response");
        Assert.assertTrue(postId > 0, "Id is not present in the response");
    }
}
