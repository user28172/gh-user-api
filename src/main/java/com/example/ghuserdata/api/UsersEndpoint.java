package com.example.ghuserdata.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class UsersEndpoint {

    private final UserResponse stubUserResponse = new UserResponse(
            "583231",
            "octocat",
            "The Octocat",
            "User",
            "https://avatars.githubusercontent.com/u/583231?v=4",
            "2011-01-25T18:44:36Z",
            "412.4212222"
    );

    @GetMapping(path = "/users/{login}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<UserResponse> getUserData(@PathVariable("login") String login) {
        return ResponseEntity.ok(stubUserResponse);
    }
}

record UserResponse(
        String id,
        String login,
        String name,
        String type,
        String avatarUrl,
        String createdAt,
        String calculations
) {
}
