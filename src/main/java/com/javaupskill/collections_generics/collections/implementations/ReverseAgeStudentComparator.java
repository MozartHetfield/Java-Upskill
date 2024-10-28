package com.javaupskill.collections_generics.collections.implementations;

import java.util.Comparator;

public class ReverseAgeStudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return -1 * Integer.compare(o1.getAge(), o2.getAge());
    }
}
