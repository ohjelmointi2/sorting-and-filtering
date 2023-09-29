package app;

import java.util.List;

import exercise.Filtering;
import exercise.Sorting;
import json.JsonFileReader;
import json.PostReader;
import json.UserReader;
import model.Post;
import model.User;

/**
 * A simple blog application that prints a Markdown-formatted index of users and
 * their posts.
 */
public class UsersAndPostsMain {

    private static final JsonFileReader<User> userReader = new UserReader();
    private static final JsonFileReader<Post> postReader = new PostReader();

    /**
     * The main method of the application. This is the entry point of the program.
     */
    public static void main(String... args) {
        List<User> users = getUsers();
        List<Post> activePosts = getActivePosts();

        MarkdownBlog blog = new MarkdownBlog();
        blog.printIndex(users, activePosts);
    }

    /**
     * Returns a list of users sorted by their registration date in ascending order
     * (oldest first).
     */
    private static List<User> getUsers() {
        List<User> users = userReader.readAll();
        return Sorting.sortUsersByRegistrationDate(users);
    }

    /**
     * Returns a list of active posts. A post is considered active if it has not
     * been deleted.
     */
    private static List<Post> getActivePosts() {
        List<Post> all = postReader.readAll();
        return Filtering.filterOutDeletedPosts(all);
    }
}
