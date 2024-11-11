package com.javaupskill.others;

import java.util.Objects;

public final record Game(String name, int rating) {
    public static int staticVar = 3;

    public Game {
        if (rating < 0 || rating > 5) {
            throw new IllegalArgumentException("rating not valid");
        }
        Objects.requireNonNull(name);
    }
    public Game(int rating) {
        this("Unknown", rating);
    }

    public void test() {

    }

    public static void test2() {

    }
}
