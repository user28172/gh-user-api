package com.example.ghuserdata.integration.assertions;

import com.example.ghuserdata.integration.restclient.TestUserResponse;
import org.assertj.core.api.AbstractAssert;

import java.util.Objects;

public class TestUserResponseAssert extends AbstractAssert<TestUserResponseAssert, TestUserResponse> {

    protected TestUserResponseAssert(TestUserResponse testUserResponse) {
        super(testUserResponse, TestUserResponseAssert.class);
    }

    public TestUserResponseAssert hasId(String expected) {
        isNotNull();
        if (!Objects.equals(actual.id(), expected))
            failWithMessage("Expected user's id to be <%s> but was <%s>", expected, actual.id());
        return this;
    }

    public TestUserResponseAssert hasId(int expected) {
        return hasId(String.valueOf(expected));
    }

    public TestUserResponseAssert hasLogin(String expected) {
        isNotNull();
        if (!Objects.equals(actual.login(), expected))
            failWithMessage("Expected user's login to be <%s> but was <%s>", expected, actual.login());
        return this;
    }

    public TestUserResponseAssert hasName(String expected) {
        isNotNull();
        if (!Objects.equals(actual.name(), expected))
            failWithMessage("Expected user's name to be <%s> but was <%s>", expected, actual.name());
        return this;
    }

    public TestUserResponseAssert hasType(String expected) {
        isNotNull();
        if (!Objects.equals(actual.type(), expected))
            failWithMessage("Expected user's type to be <%s> but was <%s>", expected, actual.type());
        return this;
    }

    public TestUserResponseAssert hasAvatarUrl(String expected) {
        isNotNull();
        if (!Objects.equals(actual.avatarUrl(), expected))
            failWithMessage("Expected user's avatarUrl to be <%s> but was <%s>", expected, actual.avatarUrl());
        return this;
    }

    public TestUserResponseAssert hasCreatedAt(String expected) {
        isNotNull();
        if (!Objects.equals(actual.createdAt(), expected))
            failWithMessage("Expected user's createdAt to be <%s> but was <%s>", expected, actual.createdAt());
        return this;
    }

    public TestUserResponseAssert hasCalculations(String expected) {
        isNotNull();
        if (!Objects.equals(actual.calculations(), expected))
            failWithMessage("Expected user's calculations to be <%s> but was <%s>", expected, actual.calculations());
        return this;
    }

    public TestUserResponseAssert isEqualTo(TestUserResponse expected) {
        this.hasId(expected.id());
        this.hasLogin(expected.login());
        this.hasName(expected.name());
        this.hasType(expected.type());
        this.hasAvatarUrl(expected.avatarUrl());
        this.hasCreatedAt(expected.createdAt());
        this.hasCalculations(expected.calculations());
        return this;
    }
}
