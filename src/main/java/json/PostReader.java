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

import model.Post;

public class PostReader implements JsonFileReader<Post> {
    // The path to the JSON file containing the Posts.
    private static final Path jsonFilePath = Path.of("data", "posts.json");

    @Override
    public List<Post> readAll() {
        Gson gson = new Gson();

        try {
            // https://github.com/google/gson/blob/main/UserGuide.md#collections-examples
            TypeToken<ArrayList<Post>> listType = new TypeToken<ArrayList<Post>>() {
            };
            BufferedReader reader = Files.newBufferedReader(jsonFilePath, StandardCharsets.UTF_8);
            return gson.fromJson(reader, listType.getType());

        } catch (IOException e) {
            // If there's an exception reading the file, we can't continue.
            throw new RuntimeException(e);
        }
    }
}
