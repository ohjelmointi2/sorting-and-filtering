package model;

public record User(
        long id,
        String firstName,
        String lastName,
        String username,
        String registeredAt) {
}
