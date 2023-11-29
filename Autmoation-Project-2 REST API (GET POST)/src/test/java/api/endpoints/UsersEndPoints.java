package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UsersEndPoints {
    public static Response createUser(User payload) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.usersUrl);
    }

    public static Response getUser(int Id) {
        return given()
                .pathParam("Id", Id)
                .when()
                .get(Routes.rud_usersUrl);
    }

    public static Response getAllUser() {
        return given()
                .when()
                .get(Routes.usersUrl);
    }

    public static Response updateUser(int Id, User payload) {
        return given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("id", Id)
                .body(payload)
                .when()
                .put(Routes.rud_usersUrl);
    }

    public static Response deleteUser(int Id) {
        return given()
                .pathParam("id", Id)
                .when()
                .delete(Routes.rud_usersUrl);
    }
}
