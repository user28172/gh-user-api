package com.example.ghuserdata.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculations {
    public final int followers;
    public final int publicReposCount;

    private Calculations(int followers, int publicReposCount) {
        if(followers <= 0) throw new NotPositiveFollowersNumberException();
        this.followers = followers;
        this.publicReposCount = publicReposCount;
    }

    public static Calculations from(UserData userData) {
        return new Calculations(userData.followers(), userData.publicReposCount());
    }

    public BigDecimal calculate() {
        double followersDouble = followers;
        double publicReposCountDouble = publicReposCount;
        double result = 6*(2+publicReposCountDouble)/followersDouble;
        return new BigDecimal(result).setScale(5, RoundingMode.HALF_DOWN);
    }
}

