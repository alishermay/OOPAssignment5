package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Doctors extends Human{
    Connection c = null;
    Statement stmt = null;
    public void insertMethod(int id, String name, String surname) {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/assignment 4",
                    "postgres", "1724");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "INSERT INTO doctors(doc_id, doc_name, doc_surname) " +
                    "VALUES(" + id + "," + name + "," + surname + ")";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }


    public void updateMethod(int id, String name, String surname) {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/assignment 4",
                    "postgres", "1724");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "UPDATE doctors SET doc_name = '" + name + "', doc_surname = '"
                    + surname + "' WHERE doc_id = " + id;
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }


    @Override
    public void deleteMethod(int id) {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/assignment 4",
                    "postgres", "1724");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "DELETE FROM doctors WHERE doc_id = " + id;
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    @Override
    public void readMethod(int id) {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/assignment 4",
                    "postgres", "1724");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "SELECT FROM doctors WHERE doc_id = " + id;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int doc_id = rs.getInt("doc_id");
                String doc_name = rs.getString("doc_name");
                String doc_surname = rs.getString("doc_surname");


                System.out.println("doc_id: " + doc_id);
                System.out.println("doc_name: " + doc_name);
                System.out.println("doc_surname: " + doc_surname);
            }

            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
