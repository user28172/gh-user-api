package com.example.ghuserdata.integration.restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

@TestComponent
public class TestApiClient {
    private final TestRestTemplate testRestTemplate;

    @Autowired
    TestApiClient(TestRestTemplate testRestTemplate) {
        this.testRestTemplate = testRestTemplate;
    }

    public ResponseEntity<TestUserResponse> getUser(String login) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        return testRestTemplate.exchange("/users/" + login, HttpMethod.GET, new HttpEntity<>(headers), TestUserResponse.class);
    }
}
