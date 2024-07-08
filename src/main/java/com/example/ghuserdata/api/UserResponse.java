package com.example.ghuserdata.api;

import com.example.ghuserdata.domain.User;

public record UserResponse(
        String id,
        String login,
        String name,
        String type,
        String avatarUrl,
        String createdAt,
        String calculations
) {
    static UserResponse from(User user) {
        return new UserResponse(user.id(),
                user.login(),
                user.name(),
                user.type(),
                user.avatarUrl(),
                user.createdAt(),
                user.calculations().calculate().toString());
    }
}
