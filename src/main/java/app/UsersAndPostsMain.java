package app;

import java.util.List;

import exercise.Filtering;
import exercise.Mapping;
import exercise.Sorting;
import json.JsonFileReader;
import json.PostReader;
import json.UserReader;
import model.Post;
import model.User;
import model.UserWithPosts;

public class UsersAndPostsMain {

    private static final JsonFileReader<User> userReader = new UserReader();
    private static final JsonFileReader<Post> postReader = new PostReader();

    public static void main(String[] args) {
        List<User> users = getUsers();
        List<Post> activePosts = getActivePosts();

        List<UserWithPosts> usersAndPosts = Mapping.combineUsersAndPosts(users, activePosts);

        MarkdownBlog blog = new MarkdownBlog();
        blog.printIndexToOutput(usersAndPosts, System.out);
    }

    private static List<User> getUsers() {
        List<User> users = userReader.readAll();
        return Sorting.sortUsersByRegistrationDate(users);
    }

    private static List<Post> getActivePosts() {
        List<Post> all = postReader.readAll();
        return Filtering.filterOutDeletedPosts(all);
    }
}
