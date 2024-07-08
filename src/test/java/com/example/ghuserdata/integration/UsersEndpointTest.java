package com.example.ghuserdata.integration;

import com.example.ghuserdata.integration.configuration.IntegrationTest;
import com.example.ghuserdata.integration.mocks.GithubResponse;
import com.example.ghuserdata.integration.mocks.MockGithubApi;
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
    private final MockGithubApi mockGithubApi;
    private final String login = "octocat";

    @Autowired
    UsersEndpointTest(TestApiClient client, MockGithubApi mockGithubApi) {
        this.client = client;
        this.mockGithubApi = mockGithubApi;
    }

    @Test
    void shouldReturn200() {
        GithubResponse userData = GithubResponse.builder().setPublicReposCount(424).setFollowers(84).build();
        mockGithubApi.stubUserDataPresent(login, userData);

        ResponseEntity<TestUserResponse> response = client.getUser(login);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody())
                .hasId(userData.id())
                .hasLogin(userData.login())
                .hasName(userData.name())
                .hasType(userData.type())
                .hasAvatarUrl(userData.avatarUrl())
                .hasCreatedAt(userData.createdAt())
                .hasCalculations("30.42857");
    }

    @Test
    void shouldReturn404WhenUserNotFound() {
        mockGithubApi.stubUserDataNotPresent(login);

        ResponseEntity<TestUserResponse> response = client.getUser(login);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void shouldReturn422WhenUserHasNoFollowers() {
        GithubResponse userData = GithubResponse.builder().setFollowers(0).build();
        mockGithubApi.stubUserDataPresent(login, userData);

        ResponseEntity<TestUserResponse> response = client.getUser(login);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
