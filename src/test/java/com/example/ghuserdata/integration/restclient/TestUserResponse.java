package com.example.ghuserdata.integration.restclient;

public record TestUserResponse(
        String id,
        String login,
        String name,
        String type,
        String avatarUrl,
        String createdAt,
        String calculations
) {

    public static TestUserResponseBuilder builder() {
        return new TestUserResponseBuilder();
    }
}
