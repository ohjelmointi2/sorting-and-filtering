package exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import model.Post;

public class SortingPostsTest {
    private final Post post2022 = new Post(5L, "Test post", "post body...",
            1L, "2022-02-02T02:02:02Z", null);
    private final Post post2023 = new Post(4L, "Test post", "post body...",
            1L, "2023-03-03T03:03:03Z", null);
    private final Post post2024 = new Post(3L, "Test post", "post body...",
            1L, "2024-02-02T02:02:02Z", null);
    private final Post post2025 = new Post(2L, "Test post", "post body...",
            1L, "2025-02-02T02:02:02Z", null);

    private final List<Post> unordered = List.of(post2023, post2025, post2022, post2024);

    @Test
    void postsAreReturnedInAscendingOrder() {
        List<Post> result = Sorting.sortPostsByPublishedDate(unordered);

        assertEquals(4, result.size());
        assertEquals(post2022, result.get(0));
        assertEquals(post2023, result.get(1));
        assertEquals(post2024, result.get(2));
        assertEquals(post2025, result.get(3));
    }

    @Test
    void emptyListIsReturnedWhenTheOriginalListIsEmpty() {
        List<Post> result = Sorting.sortPostsByPublishedDate(List.of());
        assertTrue(result.isEmpty());
    }

    @Test
    void sortingHandlesPostsWithIdenticalDatesCorrectly() {
        List<Post> duplicates = Stream.concat(unordered.stream(), unordered.stream()).toList();
        List<Post> result = Sorting.sortPostsByPublishedDate(duplicates);

        assertEquals(List.of(post2022, post2022, post2023, post2023, post2024, post2024, post2025, post2025), result);
    }

    @Test
    void theFunctionDoesNotModifyTheOriginalList() {
        List<Post> result = Sorting.sortPostsByPublishedDate(unordered);

        assertEquals(unordered, List.of(post2023, post2025, post2022, post2024));
    }
}
