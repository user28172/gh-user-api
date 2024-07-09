package com.example.ghuserdata.domain.counter.ports;

import com.example.ghuserdata.domain.counter.Counter;

import java.util.Optional;

public interface CountersRepository {
    Optional<Counter> findCounter(String login);

    void save(Counter counter);
}
