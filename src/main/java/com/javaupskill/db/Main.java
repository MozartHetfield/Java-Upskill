package com.javaupskill.db;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws Exception {
//        selectQuery();
//        preTransaction();
//        postTransaction();
        lombok();
    }

    private static void lombok() {
        Student student = new Student();
        System.out.println(student);
//        System.out.println(student.getAge());
// -DskipTests=true -> use it to skip tests when building (lifecycle). e.g.: mvn clean install
        // 1. mvn clean package
        // 2. java -cp .\javaupskill-1.0-SNAPSHOT.jar com.javaupskill.db.Main
    }

    private static void postTransaction() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", "root");
        try {
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();

            statement.execute("INSERT into students (`name`, `age`) values (\"Balance10\", 200)");
//            if (2 > 1) throw new Exception("something bad happened");
            statement.execute("INSERT into students (`name`, `age`) values (\"George10\", 31)");
            System.out.println("end of try");
            connection.commit();

        } catch (Exception e) {
            System.out.println("exception");
            connection.rollback();
//            connection.commit(); // not here!
        }
        finally {
            System.out.println("finally");
//            connection.commit(); // not here!
            connection.close();
        }
    }

    private static void preTransaction() throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", "root");
        try {
//            connection.setAutoCommit(true); // this is the default behavior
            Statement statement = connection.createStatement();
            // scenario: buy something online (we pretend)
            // 1. take credits from user's account
            statement.execute("INSERT into students (`name`, `age`) values (\"Balance\", 200)");
//            connection.commit(); // with auto-commit = true => this is run as the default behavior

            // something bad happens..
            if (2 > 1) throw new Exception("something bad happened");

            // 2. register the bought products in user's DB
            statement.execute("INSERT into students (`name`, `age`) values (\"George\", 31)");
//            connection.commit(); // with auto-commit = true => this is run as the default behavior

            // 3. do any other actions that makes sense here
            // ...
        } finally {
            connection.commit(); // invalid. with auto-commit = true, we have nothing statement execute to commit for here
            connection.close();
        }
    }

    private static void selectQuery() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", "root"))
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * from students");

            while (rs.next()) {
                System.out.print(rs.getInt("id") + " ");
                System.out.print(rs.getString("name") + " ");
                System.out.println(rs.getInt("age"));
            }
        }
    }
}
