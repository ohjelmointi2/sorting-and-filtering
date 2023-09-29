package json;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import model.Post;

public class PostReaderTest {
    @Test
    void testReadAll() {
        PostReader reader = new PostReader();
        List<Post> posts = reader.readAll();
        assertEquals(150, posts.size());
    }
}
