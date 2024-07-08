package com.example.ghuserdata.integration.configuration;

import com.example.ghuserdata.clients.GithubApiUserExternalRepository;
import com.example.ghuserdata.clients.GithubApiUserExternalRepositoryConfig;
import com.example.ghuserdata.integration.mocks.MockGithubApi;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.util.TestSocketUtils;

@TestConfiguration
public class WireMockConfiguration {

    private final int wiremockPort = TestSocketUtils.findAvailableTcpPort();

    @Bean
    WireMockServer wireMockServer() {
        return new WireMockServer(wiremockPort);
    }

    @Bean
    GithubApiUserExternalRepositoryConfig config() {
        return new TestGithubApiUserExternalRepositoryConfig(wiremockPort);
    }

    @Bean
    MockGithubApi mockGithubApi() {
        return new MockGithubApi(wireMockServer());
    }
}

class TestGithubApiUserExternalRepositoryConfig implements GithubApiUserExternalRepositoryConfig {

    private final int port;

    public TestGithubApiUserExternalRepositoryConfig(int port) {
        this.port = port;
    }

    @Override
    public String getBaseUrl() {
        return "http://localhost:" + port + "/";
    }
}