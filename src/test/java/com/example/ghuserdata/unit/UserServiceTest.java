package com.example.ghuserdata.unit;

import com.example.ghuserdata.domain.user.NotPositiveFollowersNumberException;
import com.example.ghuserdata.domain.user.User;
import com.example.ghuserdata.domain.user.UserData;
import com.example.ghuserdata.domain.user.UserService;
import com.example.ghuserdata.domain.user.ports.UserQuery;
import com.example.ghuserdata.unit.mocks.MockUserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Stream;

import static com.example.ghuserdata.unit.assertions.AssertionsEntryPoint.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserServiceTest {

    private final MockUserRepository repositoryMock = new MockUserRepository();
    private final UserQuery query = new UserService(repositoryMock);
    private final String login = "userLogin";

    @Test
    void shouldFindUserByLoginWhenUserDataPresent() {
        UserData userData = UserDataBuilder.create().build();
        repositoryMock.givenDataForLogin(login, userData);

        Optional<User> result = query.findUserByLogin(login);

        assertThat(result).isOriginatedFrom(userData);
    }

    @Test
    void shouldNotFindUserByLoginWhenUserDataNotPresent() {
        repositoryMock.givenNoDataForLogin(login);

        Optional<User> result = query.findUserByLogin(login);

        Assertions.assertThat(result).isEmpty();
    }

    @Test
    void shouldThrowExceptionWhenUserHasNoFollowers() {
        UserData userData = UserDataBuilder.create().setFollowers(0).build();
        repositoryMock.givenDataForLogin(login, userData);

        assertThatThrownBy(() -> query.findUserByLogin(login))
                .isInstanceOf(NotPositiveFollowersNumberException.class);
    }

    @Test
    void shouldThrowOnNegativePublicReposCount() {

    }

    @Test
    void shouldRoundResultToGivenScale() {

    }

    @ParameterizedTest
    @MethodSource("calculationArguments")
    void shouldCalculateResult(int followers, int publicReposCount, String expected) {
        UserData userData = UserDataBuilder.create()
                .setFollowers(followers)
                .setpublicReposCount(publicReposCount)
                .build();
        repositoryMock.givenDataForLogin(login, userData);

        Optional<User> result = query.findUserByLogin(login);

        assertThat(result).calculations().hasResult(new BigDecimal(expected));
    }

    private static Stream<Arguments> calculationArguments() {
        return Stream.of(
                Arguments.of(1, 1, "18.00000"),
                Arguments.of(1, 0, "12.00000"),
                Arguments.of(21747, 98882, "27.28211")
        );
    }
}
