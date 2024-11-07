package com.javaupskill.streams.others;

import java.util.function.Consumer;

//@FunctionalInterface
public interface ConsumerChild<T> extends Consumer<T> {
    void accept(int x, int y);
//    void accept(T t); can't create lambda because of this
}
