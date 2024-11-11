package com.javaupskill.streams.optional;

public class UserSession {
    private int key;

    public UserSession(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "UserSession{" +
                "key=" + key +
                '}';
    }
}
