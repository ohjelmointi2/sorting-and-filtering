package exercise;

import java.util.List;

import model.Post;
import model.User;
import model.UserWithPosts;

public class Mapping {

    public static List<UserWithPosts> combineUsersAndPosts(List<User> users, List<Post> posts) {
        // hint: use the filterPostsByUser from Filter class
        return users
                .stream()
                .map(u -> new UserWithPosts(
                        u,
                        posts.subList(0, 20) // FIXME: take only posts that belong to the user!
                ))
                .toList();
    }
}
