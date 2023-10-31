package json;

import java.util.List;

/**
 * This interface is "generic", meaning that it can be used to read any type of
 * objects from a JSON file. The UserReader implements this interface to read
 * Users and the PostReader implements this interface to read Posts.
 *
 * The type parameter T is a placeholder for the type and is replaced with the
 * actual type when the interface is implemented.
 *
 * You do not need to modify this file.
 */
public interface JsonFileReader<T> {

    public abstract List<T> readAll();

}
