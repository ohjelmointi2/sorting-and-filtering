package exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import model.User;

public class SortingUsersTest {
    // Test users that have an ISO formatted registeredAt time:
    private final User iso2020 = new User(1001L, "Jim", "Harper", "jim", "2020-06-01T08:07:20.410Z");
    private final User iso2022 = new User(1001L, "Pam", "Beesly", "pam", "2022-06-01T08:07:20.410Z");
    private final User iso2024 = new User(1001L, "Michael", "Scott", "michael", "2024-06-01T08:07:20.410Z");

    // Test users that have an Unix timestamp as registeredAt at time:
    private final User unix2021 = new User(1001L, "Dwight", "Schrute", "dwight", "1609459200");
    private final User unix2023 = new User(1001L, "Ryan", "Howard", "ryan", "1672531200");
    private final User unix2025 = new User(1001L, "Andy", "Bernard", "andy", "1735689600");

    @Test
    void usersWithIsoDatesAreSortedCorrectly() {
        List<User> users = List.of(iso2022, iso2024, iso2020);
        List<User> result = Sorting.sortUsersByRegistrationDate(users);

        assertEquals(List.of(iso2020, iso2022, iso2024), result);
    }

    @Test
    void usersWithUnixTimestampsAreSortedCorrectly() {
        List<User> users = List.of(unix2025, unix2023, unix2021);
        List<User> result = Sorting.sortUsersByRegistrationDate(users);

        assertEquals(List.of(unix2021, unix2023, unix2025), result);
    }

    @Test
    void listOfUsersWithMixedDateFormatsIsSortedCorrectly() {
        List<User> users = List.of(iso2022, unix2023, iso2020, unix2025, iso2024, unix2021);
        List<User> result = Sorting.sortUsersByRegistrationDate(users);

        assertEquals(List.of(iso2020, unix2021, iso2022, unix2023, iso2024, unix2025), result);
    }

    @Test
    void listWithIdenticalDatesIsSortedCorrectly() {
        List<User> users = List.of(iso2022, unix2023, iso2022, unix2023, iso2022, unix2023);
        List<User> result = Sorting.sortUsersByRegistrationDate(users);

        assertEquals(List.of(iso2022, iso2022, iso2022, unix2023, unix2023, unix2023), result);
    }

    @Test
    void emptyListIsReturnedWhenTheOriginalListIsEmpty() {
        List<User> result = Sorting.sortUsersByRegistrationDate(List.of());
        assertTrue(result.isEmpty());
    }
}
