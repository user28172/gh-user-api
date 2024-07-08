package com.example.ghuserdata.api;

import com.example.ghuserdata.domain.User;
import com.example.ghuserdata.domain.ports.UserQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class UsersEndpoint {

    private final UserQuery userQuery;

    public UsersEndpoint(UserQuery userQuery) {
        this.userQuery = userQuery;
    }

    @GetMapping(path = "/users/{login}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<UserResponse> getUserData(@PathVariable("login") String login) {
        Optional<User> result = userQuery.findUserByLogin(login);
        return result.map(user -> ResponseEntity.ok(UserResponse.from(user)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

