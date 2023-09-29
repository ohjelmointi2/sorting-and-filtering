package model;

import java.util.List;

/**
 * This class represents an User and their posts.
 *
 * The class is implemented as a Record, which is a new feature in Java 16.
 * The Record is a compact class that is used to declare classes that are used
 * mainly for storing data.
 *
 * You don't need to understand the details of the Record class, it's enough
 * that you know that it's a class that has two fields (user and posts) and
 * that it has a constructor that takes two parameters (user and posts).
 *
 * The user and posts can be accessed using the automatically generated
 * user() and posts() methods. The Record class also has automatically generated
 * toString(), equals() and hashCode() methods.
 *
 * See more at https://dev.java/learn/records/
 */
public record UserWithPosts(User user, List<Post> posts) {

}
