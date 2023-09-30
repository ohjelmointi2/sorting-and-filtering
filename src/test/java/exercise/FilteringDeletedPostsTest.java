package exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import model.Post;

public class FilteringDeletedPostsTest {
        private final Post active2022 = new Post(1L, "Test post", "post body...",
                        1L, "2022-02-02T02:02:02Z", null);
        private final Post active2023 = new Post(2L, "Test post", "post body...",
                        1L, "2023-03-03T03:03:03Z", null);
        private final Post deleted2022 = new Post(3L, "Test post", "post body...",
                        1L, "2022-02-02T02:02:02Z", "2022-02-03T02:02:02Z");
        private final Post deleted2023 = new Post(4L, "Test post", "post body...",
                        1L, "2023-02-02T02:02:02Z", "2023-02-03T02:02:02Z");

        private final List<Post> posts = List.of(active2022, deleted2023, active2023, deleted2022);

        @Test
        void activePostsAreIncludedInTheResult() {
                List<Post> activePosts = Filtering.filterOutDeletedPosts(posts);

                assertEquals(2, activePosts.size());
                assertEquals(active2022, activePosts.get(0));
                assertEquals(active2023, activePosts.get(1));
        }

        @Test
        void postsMarkedAsDeletedAreExcludedFromTheResult() {
                List<Post> deletedPosts = List.of(deleted2022, deleted2023);
                List<Post> result = Filtering.filterOutDeletedPosts(deletedPosts);

                assertTrue(result.isEmpty());
        }

        @Test
        void theFunctionDoesNotModifyTheOriginalList() {
                List<Post> original = List.of(active2022, deleted2023, active2023, deleted2022);
                List<Post> result = Filtering.filterOutDeletedPosts(original);

                assertEquals(original, List.of(active2022, deleted2023, active2023, deleted2022));
        }

        @Test
        void emptyListIsReturnedWhenTheOriginalListIsEmpty() {
                List<Post> result = Filtering.filterOutDeletedPosts(List.of());

                assertTrue(result.isEmpty());
        }
}
