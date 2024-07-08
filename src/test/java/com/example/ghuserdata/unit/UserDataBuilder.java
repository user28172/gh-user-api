package com.example.ghuserdata.unit;

import com.example.ghuserdata.domain.UserData;

public class UserDataBuilder {
    String id = "583231";
    String login = "octocat";
    String name = "The Octocat";
    String type = "User";
    String avatarUrl = "https://avatars.githubusercontent.com/u/583231?v=4";
    String createdAt = "2011-01-25T18:44:36Z";
    int following = 2;
    int followers = 4;

    static UserDataBuilder create() {
        return new UserDataBuilder();
    }

    public UserDataBuilder setFollowing(int following) {
        this.following = following;
        return this;
    }

    public UserDataBuilder setFollowers(int followers) {
        this.followers = followers;
        return this;
    }

    UserData build() {
        return new UserData(id, login, name, type, avatarUrl, createdAt, following, followers);
    }
}
