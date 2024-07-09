package com.example.ghuserdata.api;

import com.example.ghuserdata.application.UserFetchService;
import com.example.ghuserdata.domain.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class UsersEndpoint {

    private final UserFetchService service;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public UsersEndpoint(UserFetchService service) {
        this.service = service;
    }

    @GetMapping(path = "/users/{login}", produces = APPLICATION_JSON_VALUE)
    ResponseEntity<UserResponse> getUserData(@PathVariable("login") String login) {
        logger.info("received get for login <{}>", login);
        Optional<User> result = service.findUserByLogin(login);
        return result.map(user -> ResponseEntity.ok(UserResponse.from(user)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
