package com.example.ghuserdata.domain.counter;

import com.example.ghuserdata.domain.counter.ports.CountersRepository;
import com.example.ghuserdata.domain.counter.ports.QueryRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class QueryCounter implements QueryRegistry {

    private final CountersRepository countersRepository;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public QueryCounter(CountersRepository countersRepository) {
        this.countersRepository = countersRepository;
    }

    @Transactional
    @Override
    public void register(String login) {
        increment(login);
    }

    private void increment(String login) {
        Counter counter = countersRepository.findCounter(login).orElse(Counter.create(login));
        logger.info("found counter {}", counter);
        Counter incremented = counter.increment();
        countersRepository.save(incremented);
        logger.info("counter incremented {}", incremented);
    }
}
