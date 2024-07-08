package com.example.ghuserdata.domain.ports;

import com.example.ghuserdata.domain.User;

import java.util.Optional;

public interface UserQuery {
    Optional<User> findUserByLogin(String login);
}
