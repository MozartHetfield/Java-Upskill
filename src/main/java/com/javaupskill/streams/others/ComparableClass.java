package com.javaupskill.streams.others;

public class ComparableClass implements Comparable<ComparableClass> {
    int field = 3;

    @Override
    public int compareTo(ComparableClass o) {
        return Integer.compare(this.field, o.field);
    }
}
