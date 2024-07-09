package com.example.ghuserdata.domain.user.ports;

import com.example.ghuserdata.domain.user.UserData;

import java.util.Optional;

public interface UserExternalRepository {

    Optional<UserData> findUserByLogin(String login);
}
