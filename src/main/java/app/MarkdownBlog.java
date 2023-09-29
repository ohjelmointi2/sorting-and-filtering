package app;

import java.util.List;

import exercise.Filtering;
import model.Post;
import model.User;

/**
 * A simple blog application that prints a Markdown-formatted index of users and
 * their posts.
 */
public class MarkdownBlog {

    /**
     * Prints a Markdown-formatted index of users and their posts. The index is
     * printed to the standard output.
     */
    public void printIndex(List<User> users, List<Post> allPosts) {

        for (User user : users) {
            List<Post> posts = Filtering.filterPostsByUser(user, allPosts);

            System.out.println(formatUser(user));

            posts.forEach(post -> {
                System.out.println(formatPost(post));
            });

            System.out.println();
        }
    }

    /**
     * Formats a user as a Markdown heading. The format is as follows:
     * # firstName lastName (registeredAt)
     */
    private String formatUser(User user) {
        return "# %s %s (%s)".formatted(user.firstName(), user.lastName(), user.registeredAt());
    }

    /**
     * Formats a post as a Markdown list item. The format is as follows:
     * - Post title
     * ..publishedAt deletedAt
     */
    private String formatPost(Post post) {
        return """
                 - %s
                   %s %s
                """.formatted(post.title(), post.publishedAt(), post.deletedAt() == null ? "" : post.deletedAt());
    }

}
