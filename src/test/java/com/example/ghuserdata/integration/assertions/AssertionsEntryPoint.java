package com.example.ghuserdata.integration.assertions;

import com.example.ghuserdata.integration.restclient.TestUserResponse;

public class AssertionsEntryPoint {
    public static TestUserResponseAssert assertThat(TestUserResponse testUserResponse) {
        return new TestUserResponseAssert(testUserResponse);
    }
}
