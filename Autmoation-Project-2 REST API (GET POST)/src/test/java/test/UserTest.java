package test;

import api.endpoints.UsersEndPoints;
import api.payload.User;
import com.github.javafaker.Faker;
import config.UserDataConfig;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.UserAssertions;

import java.util.List;
import java.util.Optional;

public class UserTest {
    Faker faker;
    User userPayload;

    @BeforeClass
    public void setupData() {
        faker = new Faker();
        userPayload = new User();

        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setName(faker.name().name());
        userPayload.setUsername(faker.name().username());
        userPayload.setEmail(faker.internet().emailAddress());
        userPayload.setPhone(faker.phoneNumber().cellPhone());
        userPayload.setWebsite(faker.internet().url());

        User.Address address = new User.Address();
        address.setStreet(faker.address().streetName());
        address.setSuite(faker.address().secondaryAddress());
        address.setCity(faker.address().city());
        address.setZipcode(faker.address().zipCode());

        User.Geo geo = new User.Geo();
        geo.setLat(faker.address().latitude());
        geo.setLng(faker.address().longitude());

        address.setGeo(geo);
        userPayload.setAddress(address);

        User.Company company = new User.Company();
        company.setName(faker.company().name());
        company.setCatchPhrase(faker.lorem().sentence());
        String bs = String.join(" ", faker.lorem().words(5));
        company.setBs(bs);

        userPayload.setCompany(company);
    }

    @Test(priority = 1)
    public void testGetAllUsers() {
        Response response = UsersEndPoints.getAllUser();

        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);

        String contentType = response.getContentType();
        Assert.assertTrue(contentType.startsWith("application/json"), "Content type is not JSON");

        // for user id = 5
        List<User> users = response.jsonPath().getList("$", User.class);
        Optional<User> optionalUser = users.stream()
                .filter(user -> user.getId() == 5)
                .findFirst();

        Assert.assertTrue(optionalUser.isPresent(), "User with id=5 not found");

        User expectedUserFromJSON = UserDataConfig.getUserData();
        Assert.assertNotNull(expectedUserFromJSON, "Expected user data is null");
        User userFromReadData = optionalUser.get();

        UserAssertions.assertUserData(userFromReadData, expectedUserFromJSON);
    }

    @Test(priority = 2)
    public void testPostUser() {
        int userId = 5;
        Response response = UsersEndPoints.getUser(userId);

        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);

        String contentType = response.getContentType();
        Assert.assertTrue(contentType.startsWith("application/json"), "Content type is not JSON");

        User expectedUserFromJSON = UserDataConfig.getUserData();
        Assert.assertNotNull(expectedUserFromJSON, "Expected user data is not null");

        // Assertions comparing JSON values with expectedUser
        User userFromReadData = response.as(User.class);
        UserAssertions.assertUserData(userFromReadData, expectedUserFromJSON);
    }
}
