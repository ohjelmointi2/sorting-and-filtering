package exercise;

import java.util.List;

import model.Post;
import model.User;

public class Sorting {

    /**
     * Sorts the given list of posts by their publishedAt date in ascending order
     * (oldest first).
     *
     * @param posts list of posts to sort
     * @return a new list of posts sorted by their published date in ascending
     */
    public static List<Post> sortPostsByPublishedDate(List<Post> posts) {
        return posts; // TODO: Implement sorting logic
    }

    /**
     * Sorts the given list of users by their registration date in ascending order
     * (oldest first).
     *
     * Note that each User can have different data types for `registeredAt` field:
     * - numeric (epoch seconds), for example "1632225600"
     * - string (ISO 8601), for example "2021-09-21T12:00:00Z"
     *
     * @param users list of users to sort
     * @return a new list of users sorted by their registration date
     */
    public static List<User> sortUsersByRegistrationDate(List<User> users) {
        return users; // TODO: Implement manual sorting logic
    }
}
