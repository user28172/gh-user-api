package com.example.ghuserdata.domain.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserData(
        String id,
        String login,
        String name,
        String type,
        @JsonProperty("avatar_url")
        String avatarUrl,
        @JsonProperty("created_at")
        String createdAt,
        @JsonProperty("public_repos")
        int publicReposCount,
        int followers
) {}
