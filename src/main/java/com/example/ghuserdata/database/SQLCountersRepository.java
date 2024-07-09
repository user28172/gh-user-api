package com.example.ghuserdata.database;

import com.example.ghuserdata.domain.counter.Counter;
import com.example.ghuserdata.domain.counter.ports.CountersRepository;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnTransformer;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class SQLCountersRepository implements CountersRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Counter> findCounter(String login) {
        CounterTable result = entityManager.find(CounterTable.class, login.toLowerCase(), LockModeType.PESSIMISTIC_WRITE);
        if (result != null) return Optional.of(new Counter(result.login, result.requestCount));
        else return Optional.empty();
    }

    @Override
    public void save(Counter counter) {
        entityManager.merge(new CounterTable(counter.login(), counter.value()));
    }
}

@Table(name = "COUNTER")
@Entity
class CounterTable {
    @Id
    @ColumnTransformer(write = "LOWER(?)")
    String login;
    int requestCount;

    CounterTable() {
    }

    CounterTable(String login, int requestCount) {
        this.login = login;
        this.requestCount = requestCount;
    }
}