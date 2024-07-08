package com.example.ghuserdata.integration.restclient;

public class TestUserResponseBuilder {
    String id = "583231";
    String login = "octocat";
    String name = "The Octocat";
    String type = "User";
    String avatarUrl = "https://avatars.githubusercontent.com/u/583231?v=4";
    String createdAt = "2011-01-25T18:44:36Z";
    String calculations = "412.421222200000000000000000";

    public TestUserResponse build() {
        return new TestUserResponse(
                this.id, this.login, this.name, this.type, this.avatarUrl, this.createdAt, this.calculations
        );
    }

    TestUserResponseBuilder withId(String id) {
        this.id = id;
        return this;
    }
}
