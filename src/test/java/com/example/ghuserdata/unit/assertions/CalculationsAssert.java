package com.example.ghuserdata.unit.assertions;

import com.example.ghuserdata.domain.Calculations;
import org.assertj.core.api.AbstractAssert;

import java.math.BigDecimal;
import java.util.Objects;

public class CalculationsAssert extends AbstractAssert<CalculationsAssert, Calculations> {

    protected CalculationsAssert(Calculations calculations) {
        super(calculations, CalculationsAssert.class);
    }

    public CalculationsAssert hasResult(BigDecimal expected) {
        isNotNull();
        if (!Objects.equals(actual.calculate(), expected))
            failWithMessage("Expected user's calculations to be <%s> but was <%s>", expected, actual.calculate());
        return this;
    }

    public CalculationsAssert hasFollowers(int expected) {
        isNotNull();
        if (!Objects.equals(actual.followers, expected))
            failWithMessage("Expected user's followers to be <%s> but was <%s>", expected, actual.followers);
        return this;
    }

    public CalculationsAssert hasFollowing(int expected) {
        isNotNull();
        if (!Objects.equals(actual.following, expected))
            failWithMessage("Expected user's following to be <%s> but was <%s>", expected, actual.following);
        return this;
    }

    public CalculationsAssert isEqualTo(Calculations expected) {
        this.hasFollowers(expected.followers)
                .hasFollowing(expected.following)
                .hasResult(expected.calculate());
        return this;
    }
}
