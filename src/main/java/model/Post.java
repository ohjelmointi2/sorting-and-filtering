package model;

/**
 * This class represents Posts.
 *
 * The class is implemented as a Record, which is a new feature in Java 16.
 * The Record is a compact class that is used to declare classes that are used
 * mainly for storing data.
 *
 * You don't need to understand the details of the Record class, it's enough
 * that you know that it's a class that has a set of fields and
 * that it has a constructor that takes the values for thos fields as
 * parameters.
 *
 * The attributes can be accessed using the automatically generated "getter"
 * methods such as id() and title(). The Record class also has automatically
 * generated toString(), equals() and hashCode() methods.
 *
 * See more at https://dev.java/learn/records/
 */
public record Post(
        long id,
        String title,
        String body,
        long userId,

        /** Time of publishing in ISO format, for example "2023-04-10T09:45:00Z" */
        String publishedAt,

        /** Optional time of deletion in ISO format */
        String deletedAt) {

    /*
     * You do not need to modify this class in the exercise. If you want, you can
     * add your own methods here.
     *
     * If you want to see how this class is used, see the tests in
     * src/test/java/model/PostTest.java.
     */

}
