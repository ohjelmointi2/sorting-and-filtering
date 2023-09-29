package json;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import model.User;

public class UserLoaderTest {
    @Test
    void testReadingUsers() {
        UserReader loader = new UserReader();

        List<User> users = loader.readAll();

        assertEquals(100, users.size());
        assertEquals(100, users.get(99).id());
    }
}
