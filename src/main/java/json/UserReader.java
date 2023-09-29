package json;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.User;

public class UserReader implements JsonFileReader<User> {
    // The path to the JSON file containing the Users.
    private static final Path jsonFilePath = Path.of("data", "users.json");

    @Override
    public List<User> readAll() {
        Gson gson = new Gson();

        try {
            // https://github.com/google/gson/blob/main/UserGuide.md#collections-examples
            TypeToken<ArrayList<User>> listType = new TypeToken<ArrayList<User>>() {
            };
            BufferedReader reader = Files.newBufferedReader(jsonFilePath, StandardCharsets.UTF_8);
            return gson.fromJson(reader, listType.getType());

        } catch (IOException e) {
            // If there's an exception reading the file, we can't continue.
            throw new RuntimeException(e);
        }
    }
}
