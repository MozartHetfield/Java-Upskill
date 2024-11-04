package com.javaupskill.design_patterns.singleton;

public class Logger {
    private static Logger instance;

    private Logger() { }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void printSomething() {
        System.out.println("text");
    }

}
