package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Hello world!");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbdl_test", "root", "");
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE if not exists users(id int, name varchar(30))");

        while(true){
        }

    }

    // /Users/piyush/Downloads/L13_Intro_to_Maven/target/L13_Maven_Final-1.0-SNAPSHOT.jar


    /**
     * Repositories: Central, Remote, Local
     * Lifecycle / phases of maven:
     */

    /**
     * All the phases in mvn lifecycle are sequential i.e if you  run phase(nth), all the phases from i = 1 to i=n-1 will also run
     */
}