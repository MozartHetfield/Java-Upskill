package com.javaupskill.streams;

@FunctionalInterface
public interface NumbersProcessor {
    void function(int x);
    default void function2(int x, int y) {

    }
//    void function3(int x);

}
