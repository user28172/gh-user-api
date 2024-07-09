package com.example.ghuserdata.unit.mocks;

import com.example.ghuserdata.domain.counter.Counter;
import com.example.ghuserdata.domain.counter.ports.CountersRepository;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class MockCounterRepository implements CountersRepository {
    private final CountersRepository repositoryMock = mock();


    @Override
    public Optional<Counter> findCounter(String login) {
        return repositoryMock.findCounter(login);
    }

    @Override
    public void save(Counter counter) {
        repositoryMock.save(counter);
    }

    public void assertCounterSaved(Counter counter) {
        verify(repositoryMock).save(eq(counter));
    }

    public void stubCounter(Counter counter) {
        when(repositoryMock.findCounter(eq(counter.login()))).thenReturn(Optional.of(counter));
    }
}
