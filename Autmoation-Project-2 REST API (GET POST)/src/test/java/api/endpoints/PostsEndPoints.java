package api.endpoints;

import api.payload.Posts;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostsEndPoints {
    public static Response createPosts(Posts payload) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.postsUrl);
    }

    public static Response getPosts(int Id) {
        return given()
                .pathParam("Id", Id)
                .when()
                .get(Routes.rud_postsUrl);
    }

    public static Response getAllPosts() {
        return given()
                .when()
                .get(Routes.postsUrl);
    }

    public static Response updatePosts(int Id, Posts payload) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("id", Id)
                .body(payload)
                .when()
                .put(Routes.rud_postsUrl);
    }

    public static Response deletePosts(int Id) {
        return given()
                .pathParam("id", Id)
                .when()
                .delete(Routes.rud_postsUrl);
    }
}
