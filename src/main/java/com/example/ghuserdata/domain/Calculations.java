package com.example.ghuserdata.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculations {
    public final int followers;
    public final int following;

    private Calculations(int followers, int following) {
        if(followers <= 0) throw new NotPositiveFollowersNumberException();
        this.followers = followers;
        this.following = following;
    }

    public static Calculations from(UserData userData) {
        return new Calculations(userData.followers(), userData.following());
    }

    public BigDecimal calculate() {
        double followersDouble = followers;
        double followingDouble = following;
        double result = 6*(2+followingDouble)/followersDouble;
        return new BigDecimal(result).setScale(5, RoundingMode.HALF_DOWN);
    }
}

