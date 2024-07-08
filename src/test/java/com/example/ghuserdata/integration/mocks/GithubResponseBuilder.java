package com.example.ghuserdata.integration.mocks;

public class GithubResponseBuilder {
    private int id = 583231;
    private String login = "octocat";
    private String name = "The Octocat";
    private String type = "User";
    private String avatarUrl = "https://avatars.githubusercontent.com/u/583231?v=4";
    private String createdAt = "2011-01-25T18:44:36Z";
    private int publicReposCount = 424;
    private int followers = 84;

    public GithubResponseBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public GithubResponseBuilder setLogin(String login) {
        this.login = login;
        return this;
    }

    public GithubResponseBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public GithubResponseBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public GithubResponseBuilder setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        return this;
    }

    public GithubResponseBuilder setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public GithubResponseBuilder setPublicReposCount(int publicReposCount) {
        this.publicReposCount = publicReposCount;
        return this;
    }

    public GithubResponseBuilder setFollowers(int followers) {
        this.followers = followers;
        return this;
    }

    public GithubResponse build() {
        return new GithubResponse(id, login, name, type, avatarUrl, createdAt, publicReposCount, followers);
    }
}