package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * The purpose of this test class is to demonstrate how the User class can be
 * used. There is really nothing to test in the User class, as it simply
 * contains data and no logic.
 */
public class UserTest {

    @Test
    void usersCanBeCreatedJustLikeAnyOtherObjects() {
        User u = new User(1, "first", "last", "username", "2024-01-01T00:00:00Z");

        assertTrue(u instanceof User);
    }

    @Test
    void usersHaveAutomaticallyGeneratedGetters() {
        User u = new User(1, "first", "last", "username", "2024-01-01T00:00:00Z");

        assertEquals(1, u.id());
        assertEquals("first", u.firstName());
        assertEquals("last", u.lastName());
        assertEquals("username", u.username());
        assertEquals("2024-01-01T00:00:00Z", u.registeredAt());
    }
}
