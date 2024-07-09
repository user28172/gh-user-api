package com.example.ghuserdata.integration.database;

import com.example.ghuserdata.domain.counter.Counter;
import com.example.ghuserdata.domain.counter.ports.CountersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@TestComponent
public class TestCountersRepository {

    @Autowired
    private CountersRepository prodRepository;

    @Transactional
    public TestCounter findByLogin(String login) {
        Counter counter = prodRepository.findCounter(login).orElse(Counter.create(login));
        return new TestCounter(login, counter.value());
    }

    @Transactional
    public void assertCounterIncrementedFromInitial(String login, TestCounter initialCounter) {
        TestCounter currentCounter = findByLogin(login);
        assertThat(initialCounter.value() + 1).isEqualTo(currentCounter.value());
    }
}
