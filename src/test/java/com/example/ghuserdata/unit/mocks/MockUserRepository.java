package com.example.ghuserdata.unit.mocks;

import com.example.ghuserdata.domain.user.UserData;
import com.example.ghuserdata.domain.user.ports.UserExternalRepository;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockUserRepository implements UserExternalRepository {
    private final UserExternalRepository repositoryMock = mock();

    public void givenDataForLogin(String login, UserData userData) {
        when(repositoryMock.findUserByLogin(eq(login))).thenReturn(Optional.of(userData));
    }

    public void givenNoDataForLogin(String login) {
        when(repositoryMock.findUserByLogin(login)).thenReturn(Optional.empty());
    }

    @Override
    public Optional<UserData> findUserByLogin(String login) {
        return repositoryMock.findUserByLogin(login);
    }
}
