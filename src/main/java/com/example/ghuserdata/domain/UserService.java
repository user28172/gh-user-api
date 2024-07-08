package com.example.ghuserdata.domain;

import com.example.ghuserdata.domain.ports.UserExternalRepository;
import com.example.ghuserdata.domain.ports.UserQuery;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserQuery {
    private final UserExternalRepository repository;

    public UserService(UserExternalRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<User> findUserByLogin(String login) {
        Optional<UserData> externalUser = repository.findUserByLogin(login);
        return externalUser.map(User::from);
    }
}

