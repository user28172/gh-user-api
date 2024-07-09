package com.example.ghuserdata.unit;

import com.example.ghuserdata.domain.counter.Counter;
import com.example.ghuserdata.domain.counter.QueryCounter;
import com.example.ghuserdata.unit.mocks.MockCounterRepository;
import org.junit.jupiter.api.Test;

public class QueryRegistryTest {

    private final MockCounterRepository repository = new MockCounterRepository();
    private final QueryCounter queryCounter = new QueryCounter(repository);
    private final String login = "userLogin";
    private final Counter initialCounter = new Counter(login, 0);
    private final Counter counterValueOne = new Counter(login, 1);
    private final Counter counterValueTwo = new Counter(login, 2);

    @Test
    void shouldIncrementCounter() {
        //0 -> 1
        repository.stubCounter(initialCounter);
        queryCounter.register(login);
        repository.assertCounterSaved(counterValueOne);

        //1 -> 2
        repository.stubCounter(counterValueOne);
        queryCounter.register(login);
        repository.assertCounterSaved(counterValueTwo);
    }
}
