package app;

import java.util.List;

import exercise.Filtering;
import model.Post;
import model.User;

public class MarkdownBlog {

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

    private String formatPost(Post post) {
        return " - %s".formatted(post.title());
    }

    private String formatUser(User user) {
        return "# %s %s (%s)".formatted(user.firstName(), user.lastName(), user.registeredAt());
    }
}
