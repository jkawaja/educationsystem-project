package com.example.educationsystemproject;

import java.sql.*;
import java.util.Calendar;

/**
 * A Java MySQL PreparedStatement INSERT example.
 * Demonstrates the use of a SQL INSERT statement against a
 * MySQL database, called from a Java program, using a
 * Java PreparedStatement.
 * <p>
 * Created by Alvin Alexander, http://alvinalexander.com
 */
public class RunScript {

    public static void main(String[] args) {
        try {
            // create a mysql database connection
            String myDriver = "org.mariadb.jdbc.Driver";
            String myUrl = "jdbc:mariadb://localhost:3300/educationsystem";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");

            // the mysql insert statement
            String query = " insert into student (address, city, email, first_name, last_name, phone, postal)"
                    + " values (?, ?, ?, ?, ?, ?, ?)";


            //PreparedStatement preparedStmtCourse = conn.prepareStatement(courseQuery);

            // create the mysql insert preparedstatement 1
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, "123 Shire Street");
            preparedStmt.setString(2, "The Shire");
            preparedStmt.setString(3, "bilbo@lotr.com");
            preparedStmt.setString(4, "Bilbo");
            preparedStmt.setString(5, "Bagins");
            preparedStmt.setString(6, "709-123-4567");
            preparedStmt.setString(7, "a1h2b3");
            // execute the preparedstatement
            preparedStmt.execute();
            // create the mysql insert preparedstatement 2
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, "456 Fake Street");
            preparedStmt.setString(2, "Some place");
            preparedStmt.setString(3, "someemail@fakeemail.com");
            preparedStmt.setString(4, "Sam");
            preparedStmt.setString(5, "Lake");
            preparedStmt.setString(6, "709-123-4567");
            preparedStmt.setString(7, "a1h2b3");
            // execute the preparedstatement
            preparedStmt.execute();
            // create the mysql insert preparedstatement 3
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, "893 School Street");
            preparedStmt.setString(2, "Danbury");
            preparedStmt.setString(3, "HeidiCFay@dayrep.com");
            preparedStmt.setString(4, "Heidi");
            preparedStmt.setString(5, "Fay");
            preparedStmt.setString(6, "709-123-4567");
            preparedStmt.setString(7, "a1h2b3");
            // execute the preparedstatement
            preparedStmt.execute();
            // create the mysql insert preparedstatement 4
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, "123 Shire Street");
            preparedStmt.setString(2, "The Shire");
            preparedStmt.setString(3, "bilbo@lotr.com");
            preparedStmt.setString(4, "Bilbo");
            preparedStmt.setString(5, "Bagins");
            preparedStmt.setString(6, "709-123-4567");
            preparedStmt.setString(7, "a1h2b3");
            // execute the preparedstatement
            preparedStmt.execute();
            // create the mysql insert preparedstatement 5
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, "818 Williams Avenue");
            preparedStmt.setString(2, "Saugus");
            preparedStmt.setString(3, "TomSJordon@teleworm.us");
            preparedStmt.setString(4, "Tom");
            preparedStmt.setString(5, "Jordon");
            preparedStmt.setString(6, "709-123-4567");
            preparedStmt.setString(7, "a1h2b3");
            // execute the preparedstatement
            preparedStmt.execute();

            String courseQuery = "insert into course (capacity, course_name, course_number, pid, semester, year) values (?, ?, ?, ?, ?, ?)";
            // create the mysql insert preparedstatement 5
            preparedStmt = conn.prepareStatement(courseQuery);
            preparedStmt.setString(1, "30");
            preparedStmt.setString(2, "Intro to English");
            preparedStmt.setString(3, "1");
            preparedStmt.setString(4, "1");
            preparedStmt.setString(5, "Fall");
            preparedStmt.setString(6, "2023");
            // execute the preparedstatement
            preparedStmt.execute();

            // create the mysql insert preparedstatement 5
            preparedStmt = conn.prepareStatement(courseQuery);
            preparedStmt.setString(1, "25");
            preparedStmt.setString(2, "Intro to Software Development");
            preparedStmt.setString(3, "2");
            preparedStmt.setString(4, "2");
            preparedStmt.setString(5, "Winter");
            preparedStmt.setString(6, "2024");
            // execute the preparedstatement
            preparedStmt.execute();

            String programQuery = "insert into programs (campus, program_name) values (?, ?)";
            // create the mysql insert preparedstatement 5
            preparedStmt = conn.prepareStatement(programQuery);
            preparedStmt.setString(1, "Main Campus");
            preparedStmt.setString(2, "English");
            // execute the preparedstatement
            preparedStmt.execute();

            // create the mysql insert preparedstatement 5
            preparedStmt = conn.prepareStatement(programQuery);
            preparedStmt.setString(1, "Side Campus");
            preparedStmt.setString(2, "Computer Science");
            // execute the preparedstatement
            preparedStmt.execute();

            String enrollmentQuery = "insert into enrollment (courseID, studentID) values (?, ?)";
            // create the mysql insert preparedstatement 1
            preparedStmt = conn.prepareStatement(enrollmentQuery);
            preparedStmt.setInt(1, 1);
            preparedStmt.setInt(2, 1);
            // execute the preparedstatement
            preparedStmt.execute();

            // create the mysql insert preparedstatement 2
            preparedStmt = conn.prepareStatement(enrollmentQuery);
            preparedStmt.setInt(1, 2);
            preparedStmt.setInt(2, 2);
            // execute the preparedstatement
            preparedStmt.execute();

            // create the mysql insert preparedstatement 3
            preparedStmt = conn.prepareStatement(enrollmentQuery);
            preparedStmt.setInt(1, 1);
            preparedStmt.setInt(2, 3);
            // execute the preparedstatement
            preparedStmt.execute();

            // create the mysql insert preparedstatement 4
            preparedStmt = conn.prepareStatement(enrollmentQuery);
            preparedStmt.setInt(1, 2);
            preparedStmt.setInt(2, 4);
            // execute the preparedstatement
            preparedStmt.execute();

            // create the mysql insert preparedstatement 5
            preparedStmt = conn.prepareStatement(enrollmentQuery);
            preparedStmt.setInt(1, 1);
            preparedStmt.setInt(2, 5);
            // execute the preparedstatement
            preparedStmt.execute();

            String gradesQuery = "insert into grades (courseID, grade, studentID) values (?, ?, ?)";
            // create the mysql insert preparedstatement 1
            preparedStmt = conn.prepareStatement(gradesQuery);
            preparedStmt.setInt(1, 1);
            preparedStmt.setString(2, "85");
            preparedStmt.setInt(3, 1);
            // execute the preparedstatement
            preparedStmt.execute();

            // create the mysql insert preparedstatement 2
            preparedStmt = conn.prepareStatement(gradesQuery);
            preparedStmt.setInt(1, 2);
            preparedStmt.setString(2, "85");
            preparedStmt.setInt(3, 2);
            // execute the preparedstatement
            preparedStmt.execute();

            // create the mysql insert preparedstatement 3
            preparedStmt = conn.prepareStatement(gradesQuery);
            preparedStmt.setInt(1, 1);
            preparedStmt.setString(2, "85");
            preparedStmt.setInt(3, 3);
            // execute the preparedstatement
            preparedStmt.execute();

            // create the mysql insert preparedstatement 4
            preparedStmt = conn.prepareStatement(gradesQuery);
            preparedStmt.setInt(1, 2);
            preparedStmt.setString(2, "85");
            preparedStmt.setInt(3, 4);
            // execute the preparedstatement
            preparedStmt.execute();

            // create the mysql insert preparedstatement 5
            preparedStmt = conn.prepareStatement(gradesQuery);
            preparedStmt.setInt(1, 1);
            preparedStmt.setString(2, "85");
            preparedStmt.setInt(3, 5);
            // execute the preparedstatement
            preparedStmt.execute();


            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
}