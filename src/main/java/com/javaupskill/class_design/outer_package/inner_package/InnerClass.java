package com.javaupskill.class_design.outer_package.inner_package;

import com.javaupskill.class_design.outer_package.OuterClass;

public class InnerClass {
    OuterClass outerClass = new OuterClass();
    OuterClass outerClass2 = new OuterClass();


    public void accessOuterMembers() {
        outerClass.publicInt = 5;
        outerClass2.publicInt = 7;
        System.out.println(outerClass.publicInt); // 5
        System.out.println(outerClass2.publicInt); // 7

        OuterClass.fridgeTemperature = 10;
        System.out.println(OuterClass.fridgeTemperature);
        // not the same package. inner packages are not taken into account
//        System.out.println(outerClass.defaultAccessInt);
//        System.out.println(outerClass.protectedInt);
    }
}
