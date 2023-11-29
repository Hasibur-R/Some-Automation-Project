package config;

import api.payload.User;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class UserDataConfig {
    private static final String FILE_PATH = "src/test/resources/userData.json";

    private static JsonObject getJsonObject() {
        try {
            FileReader reader = new FileReader(FILE_PATH);
            Gson gson = new Gson();
            return gson.fromJson(reader, JsonObject.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        }
    }

    public static User getUserData() {
        JsonObject jsonObject = getJsonObject();
        if (jsonObject != null) {
            return new Gson().fromJson(jsonObject, User.class);
        }
        return null;
    }
}