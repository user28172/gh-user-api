package com.example.ghuserdata.integration;

import com.example.ghuserdata.integration.configuration.IntegrationTest;
import com.example.ghuserdata.integration.restclient.TestApiClient;
import com.example.ghuserdata.integration.restclient.TestUserResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.example.ghuserdata.integration.assertions.AssertionsEntryPoint.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

@IntegrationTest
class UsersEndpointTest {

    private final TestApiClient client;
    private final String login = "octocat";

    @Autowired
    UsersEndpointTest(TestApiClient client) {
        this.client = client;
    }

    @Test
    void shouldReturn200() {
        ResponseEntity<TestUserResponse> response = client.getUser(login);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(TestUserResponse.builder().build());
    }
}
