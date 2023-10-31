package json;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import model.User;

public class UserReaderTest {

    private UserReader loader = new UserReader();

    @Test
    void testReadingUsers() {
        List<User> users = loader.readAll();

        assertEquals(100, users.size());
    }

    @Test
    void theUsersHaveCorrectData() {
        List<User> users = loader.readAll();

        User first = users.get(0);

        // this information can be found in the JSON file
        assertEquals(1, first.id());
        assertEquals("Terry", first.firstName());
        assertEquals("Medhurst", first.lastName());
    }
}
