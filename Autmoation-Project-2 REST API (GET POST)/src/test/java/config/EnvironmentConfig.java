package config;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class EnvironmentConfig {
    private static JsonObject getJsonObject(){
        try{
            FileReader reader = new FileReader("src/test/resources/environment.json");
            Gson gson = new Gson();
            return gson.fromJson(reader, JsonObject.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found", e);
        }
    }

    public static String getUrl(String key) {
        JsonObject jsonObject= getJsonObject();
        if(jsonObject!= null && jsonObject.has(key)){
            return jsonObject.get(key).getAsString();
        }
        return null;
    }
}
