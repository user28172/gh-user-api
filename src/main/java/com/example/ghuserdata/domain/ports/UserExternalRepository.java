package com.example.ghuserdata.domain.ports;

import com.example.ghuserdata.domain.UserData;

import java.util.Optional;

public interface UserExternalRepository {

    Optional<UserData> findUserByLogin(String login);
}
