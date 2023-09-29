package app;

import java.io.PrintStream;
import java.util.List;

import model.Post;
import model.User;
import model.UserWithPosts;

public class MarkdownBlog {

    public void printIndexToOutput(List<UserWithPosts> usersAndPosts, PrintStream out) {

        for (UserWithPosts u : usersAndPosts) {
            User user = u.user();
            List<Post> posts = u.posts();

            out.println(formatUser(user));

            posts.forEach(post -> {
                out.println(formatPost(post));
            });

            out.println();
        }
    }

    private String formatPost(Post post) {
        return " - %s".formatted(post.title());
    }

    private String formatUser(User user) {
        return "# %s %s (%s)".formatted(user.firstName(), user.lastName(), user.registeredAt());
    }
}
