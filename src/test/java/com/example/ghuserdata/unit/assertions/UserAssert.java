package com.example.ghuserdata.unit.assertions;

import com.example.ghuserdata.domain.User;
import com.example.ghuserdata.domain.UserData;
import org.assertj.core.api.AbstractAssert;

import java.util.Objects;

public class UserAssert extends AbstractAssert<UserAssert, User> {

    protected UserAssert(User user) {
        super(user, UserAssert.class);
    }


    public UserAssert hasId(String expected) {
        isNotNull();
        if (!Objects.equals(actual.id(), expected))
            failWithMessage("Expected user's id to be <%s> but was <%s>", expected, actual.id());
        return this;
    }

    public UserAssert hasLogin(String expected) {
        isNotNull();
        if (!Objects.equals(actual.login(), expected))
            failWithMessage("Expected user's login to be <%s> but was <%s>", expected, actual.login());
        return this;
    }

    public UserAssert hasName(String expected) {
        isNotNull();
        if (!Objects.equals(actual.name(), expected))
            failWithMessage("Expected user's name to be <%s> but was <%s>", expected, actual.name());
        return this;
    }

    public UserAssert hasType(String expected) {
        isNotNull();
        if (!Objects.equals(actual.type(), expected))
            failWithMessage("Expected user's type to be <%s> but was <%s>", expected, actual.type());
        return this;
    }

    public UserAssert hasAvatarUrl(String expected) {
        isNotNull();
        if (!Objects.equals(actual.avatarUrl(), expected))
            failWithMessage("Expected user's avatarUrl to be <%s> but was <%s>", expected, actual.avatarUrl());
        return this;
    }

    public UserAssert hasCreatedAt(String expected) {
        isNotNull();
        if (!Objects.equals(actual.createdAt(), expected))
            failWithMessage("Expected user's createdAt to be <%s> but was <%s>", expected, actual.createdAt());
        return this;
    }

    public CalculationsAssert calculations() {
        return new CalculationsAssert(this.actual.calculations());
    }

    public UserAssert isEqualTo(User expected) {
        hasId(expected.id())
        .hasLogin(expected.login())
        .hasName(expected.name())
        .hasType(expected.type())
        .hasAvatarUrl(expected.avatarUrl())
        .hasCreatedAt(expected.createdAt())
        .calculations()
                .isEqualTo(expected.calculations());
        return this;
    }

    public UserAssert isOriginatedFrom(UserData expected) {
        hasId(expected.id())
        .hasLogin(expected.login())
        .hasName(expected.name())
        .hasType(expected.type())
        .hasAvatarUrl(expected.avatarUrl())
        .hasCreatedAt(expected.createdAt())
        .calculations()
                .hasPublicReposCount(expected.publicReposCount())
                .hasFollowers(expected.followers());
        return this;
    }
}