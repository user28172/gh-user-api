package com.example.ghuserdata.clients;

import com.example.ghuserdata.domain.user.UserData;
import com.example.ghuserdata.domain.user.ports.UserExternalRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import java.util.Optional;

@Component
public class GithubApiUserExternalRepository implements UserExternalRepository {

    private final RestClient restClient;

    public GithubApiUserExternalRepository(GithubApiUserExternalRepositoryConfig config) {
        this.restClient = RestClient.builder().baseUrl(config.getBaseUrl()).build();
    }

    @Override
    public Optional<UserData> findUserByLogin(String login) {
        return Optional.ofNullable(doFindUserByLogin(login));
    }

    private UserData doFindUserByLogin(String login) {
        try {
            return restClient.get()
                    .uri("/users/" + login)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .body(UserData.class);
        } catch (HttpClientErrorException.NotFound e) {
            return null;
        }
    }
}
