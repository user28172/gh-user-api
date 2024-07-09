package com.example.ghuserdata.domain.user.ports;

import com.example.ghuserdata.domain.user.User;

import java.util.Optional;

public interface UserQuery {
    Optional<User> findUserByLogin(String login);
}
