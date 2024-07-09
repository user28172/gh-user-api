package com.example.ghuserdata.application;

import com.example.ghuserdata.domain.user.User;
import com.example.ghuserdata.domain.counter.ports.QueryRegistry;
import com.example.ghuserdata.domain.user.ports.UserQuery;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserFetchService {
    private final UserQuery userQuery;
    private final QueryRegistry queryRegistry;

    public UserFetchService(UserQuery userQuery, QueryRegistry queryRegistry) {
        this.userQuery = userQuery;
        this.queryRegistry = queryRegistry;
    }

    public Optional<User> findUserByLogin(String login) {
        queryRegistry.register(login);
        return userQuery.findUserByLogin(login);
    }
}
