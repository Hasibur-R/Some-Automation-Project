package utils;

import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class ConfigReader {

	private static JsonObject getJsonObject() {
		try {
			FileReader reader = new FileReader("src/main/java/configANDtest/config.json");
			Gson gson = new Gson();
			JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
			reader.close();
			return jsonObject;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getStringValue(String key) {
		JsonObject jsonObject = getJsonObject();
		if (jsonObject != null && jsonObject.has(key)) {
			return jsonObject.get(key).getAsString();
		}
		return null;
	}

	public static int getIntValue(String key) {
		JsonObject jsonObject = getJsonObject();
		if (jsonObject != null && jsonObject.has(key)) {
			JsonElement element = jsonObject.get(key);
			if (element.isJsonPrimitive() && element.getAsJsonPrimitive().isNumber()) {
				return element.getAsInt();
			} else {
				System.err.println("Value associated with key '" + key + "' is not a valid integer.");
			}
		} else {
			System.err.println("Key '" + key + "' not found in JSON.");
		}
		return 0;
	}

}
