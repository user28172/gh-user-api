package com.example.ghuserdata.domain.counter;

public record Counter(String login, int value) {

    public static Counter create(String login) {
        return new Counter(login, 0);
    }

    Counter increment() {
        return new Counter(login, value + 1);
    }
}
