package exercise;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.Post;
import model.User;

public class FilteringPostsByUserTest {
    private final User user1 = new User(1001L, "Lloyd", "Christmas", "lloyd", "2022-01-01T01:01:01Z");
    private final User user2 = new User(1002L, "Truman", "Burbank", "truman", "2022-01-01T01:01:01Z");
    private final User user3 = new User(1003L, "Bruce", "Nolan", "bruce", "2022-01-01T01:01:01Z");

    private final Post user1Post1 = new Post(1L, "Test post", "post body...",
            1001L, "2022-02-02T02:02:02Z", null);
    private final Post user1Post2 = new Post(2L, "Test post", "post body...",
            1001L, "2023-03-03T03:03:03Z", null);
    private final Post user2Post3 = new Post(3L, "Test post", "post body...",
            1002L, "2022-02-02T02:02:02Z", "2022-02-03T02:02:02Z");
    private final Post user1Post4 = new Post(4L, "Test post", "post body...",
            1001L, "2023-02-02T02:02:02Z", "2023-02-03T02:02:02Z");

    private final List<Post> posts = List.of(user1Post1, user2Post3, user1Post2, user1Post4);

    @Test
    void postsWrittenByTheUserAreIncludedInTheResult() {
        List<Post> result = Filtering.filterPostsByUser(user1, posts);

        assertTrue(result.contains(user1Post1));
        assertTrue(result.contains(user1Post2));
        assertTrue(result.contains(user1Post4));
    }

    @Test
    void postsWrittenByOtherUsersAreExcludedFromTheResult() {
        List<Post> result = Filtering.filterPostsByUser(user2, posts);

        assertFalse(result.contains(user1Post1));
        assertFalse(result.contains(user1Post2));
        assertFalse(result.contains(user1Post4));
    }

    @Test
    void emptyListIsReturnedWhenTheUserHasNoPosts() {
        List<Post> result = Filtering.filterPostsByUser(user3, posts);

        assertTrue(result.isEmpty());
    }

    @Test
    void emptyListIsReturnedWhenThePostsListIsEmpty() {
        List<Post> result = Filtering.filterPostsByUser(user1, Collections.emptyList());

        assertTrue(result.isEmpty());
    }
}
