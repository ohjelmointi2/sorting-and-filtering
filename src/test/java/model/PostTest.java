package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * The purpose of this test class is to demonstrate how the Post class can be
 * used. There is really nothing to test in the Post class, as it simply
 * contains data and no logic.
 */
public class PostTest {

    @Test
    void postsCanBeCreatedJustLikeAnyOtherObjects() {
        Post p = new Post(1, "title", "body", 42, "2024-01-01T00:00:00Z", null);

        assertTrue(p instanceof Post);
    }

    @Test
    void postsHaveAutomaticallyGeneratedGetters() {
        Post p = new Post(1, "title", "body", 42, "2024-01-01T00:00:00Z", null);

        assertEquals(1, p.id());
        assertEquals("title", p.title());
        assertEquals("body", p.body());
        assertEquals(42, p.userId());
        assertEquals("2024-01-01T00:00:00Z", p.publishedAt());
        assertEquals(null, p.deletedAt());
    }
}
