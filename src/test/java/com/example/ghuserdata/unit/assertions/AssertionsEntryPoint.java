package com.example.ghuserdata.unit.assertions;

import com.example.ghuserdata.domain.user.Calculations;
import com.example.ghuserdata.domain.user.User;
import org.assertj.core.api.Assertions;

import java.util.Optional;

public class AssertionsEntryPoint {
    public static UserAssert assertThat(User user) {
        return new UserAssert(user);
    }

    public static UserAssert assertThat(Optional<User> user) {
        Assertions.assertThat(user).isNotEmpty();
        return assertThat(user.get());
    }

    public static CalculationsAssert assertThat(Calculations calculations) {
        return new CalculationsAssert(calculations);
    }
}
