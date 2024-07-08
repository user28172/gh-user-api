package com.example.ghuserdata.domain;

public record User(
        String id,
        String login,
        String name,
        String type,
        String avatarUrl,
        String createdAt,
        Calculations calculations
) {
    public static User from(UserData userData) {
        return new User(userData.id(),
                userData.login(),
                userData.name(),
                userData.type(),
                userData.avatarUrl(),
                userData.createdAt(),
                Calculations.from(userData));
    }
}
