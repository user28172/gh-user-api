package com.example.ghuserdata.clients;

import org.springframework.boot.context.properties.ConfigurationProperties;

public interface GithubApiUserExternalRepositoryConfig {

    String getBaseUrl();
}

@ConfigurationProperties("clients.github")
class YamlBasedGithubApiUserExternalRepository implements GithubApiUserExternalRepositoryConfig {

    String baseUrl;

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String getBaseUrl() {
        return baseUrl;
    }
}