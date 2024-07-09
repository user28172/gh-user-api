package com.example.ghuserdata.domain.user;

import com.example.ghuserdata.domain.user.ports.UserExternalRepository;
import com.example.ghuserdata.domain.user.ports.UserQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserQuery {
    private final UserExternalRepository repository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public UserService(UserExternalRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<User> findUserByLogin(String login) {
        Optional<UserData> externalUser = repository.findUserByLogin(login);
        logger.info("found user in repository {}", externalUser);
        return externalUser.map(User::from);
    }
}

