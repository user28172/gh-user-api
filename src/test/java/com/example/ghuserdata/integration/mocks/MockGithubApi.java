package com.example.ghuserdata.integration.mocks;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;

public class MockGithubApi {
    private final WireMockServer wireMockServer;

    public MockGithubApi(WireMockServer wireMockServer) {
        this.wireMockServer = wireMockServer;
    }

    public void stubUserDataPresent(String login, GithubResponse userData) {
        wireMockServer.stubFor(WireMock.get("/users/" + login)
                .willReturn(okFor(userData)));
    }

    public void stubUserDataNotPresent(String login) {
        wireMockServer.stubFor(WireMock.get("/users/" + login)
                .willReturn(notFound()));
    }

    private ResponseDefinitionBuilder okFor(GithubResponse userData) {
        return ResponseDefinitionBuilder.responseDefinition()
                .withStatus(200)
                .withHeader("Content-Type", "application/json")
                .withBody("""
                        {
                        	"login": "%s",
                        	"id": %d,
                        	"avatar_url": "%s",
                        	"type": "%s",
                        	"name": "%s",
                        	"followers": %d,
                        	"public_repos": %d,
                        	"created_at": "%s"
                        }
                        """.formatted(userData.login(),
                        userData.id(),
                        userData.avatarUrl(),
                        userData.type(),
                        userData.name(),
                        userData.followers(),
                        userData.publicReposCount(),
                        userData.createdAt()));
    }

    private ResponseDefinitionBuilder notFound() {
        return ResponseDefinitionBuilder.responseDefinition()
                .withStatus(404)
                .withHeader("Content-Type", "application/json");
    }
}
