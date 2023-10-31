package json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import model.Post;

public class PostReaderTest {

    private PostReader reader = new PostReader();

    @Test
    void postReaderReturnsAllPostsInTheJSONFile() {
        List<Post> posts = reader.readAll();
        assertEquals(150, posts.size());
    }

    @Test
    void theReturnedPostsHaveCorrectData() {
        List<Post> posts = reader.readAll();

        Post first = posts.get(0);

        // this information can be found in the JSON file
        assertEquals(1, first.id());
        assertTrue(first.body().contains("His mother had always taught him"));
        assertEquals(9, first.userId());
        assertEquals("2023-07-13T09:33:37.100Z", first.publishedAt());
        assertEquals(null, first.deletedAt());
    }
}
