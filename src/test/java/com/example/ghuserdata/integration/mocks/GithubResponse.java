package com.example.ghuserdata.integration.mocks;

public record GithubResponse(
        int id,
        String login,
        String name,
        String type,
        String avatarUrl,
        String createdAt,
        int publicReposCount,
        int followers
) {
    public static GithubResponseBuilder builder() {
        return new GithubResponseBuilder();
    }
}
