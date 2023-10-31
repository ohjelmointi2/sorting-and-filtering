package exercise;

import java.util.List;

import model.Post;
import model.User;

public class Sorting {

    /**
     * Returns a new List with the Post objects in the given list sorted by their
     * publishedAt date in ascending order (oldest first).
     *
     * This method does not modify the given list.
     *
     * @param posts list of posts to sort
     * @return a new list of posts sorted by their published date in ascending order
     */
    public static List<Post> sortPostsByPublishedDate(List<Post> posts) {
        /*
         * The purpose of this exercise is to implement the sorting logic yourself.
         * Therefore, you are not allowed to use existing implementations of sorting
         * algorithms.
         *
         * Note that the `publishedAt` values can be compared by using the
         * alphabetical ordering of the string values. You can also convert the string
         * values to other data types, for example, to objects in the java.time package.
         */
        return posts; // TODO: return a new list with the posts sorted
    }

    /**
     * Returns a new list with the given users sorted by their registration date in
     * ascending order (oldest first).
     *
     * This method does not modify the given list.
     *
     * @param users list of users to sort
     * @return a new list of users sorted by their registration date
     */
    public static List<User> sortUsersByRegistrationDate(List<User> users) {
        /*
         * Note that each User can have different data types for `registeredAt` field:
         * - numeric (seconds since epoch), for example "1632225600"
         * - string (ISO 8601), for example "2021-09-21T12:00:00Z"
         *
         * This time a simple alphabetical ordering of the string values is not enough.
         */
        return users; // TODO: You are allowed to use existing implementations.
    }
}
