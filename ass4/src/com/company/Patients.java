package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Patients extends Human{
    Connection c = null;
    Statement stmt = null;

    public void insertMethod(int id, String name, String surname) {

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/assignment 4",
                    "postgres", "1724");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "INSERT INTO patients(pat_id, pat_name, pat_surname) " +
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
            String sql = "UPDATE patients SET pat_name = '" + name + "', pat_surname = '"
                    + surname + "' WHERE pat_id = " + id;
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
            String sql = "DELETE FROM patients WHERE pat_id = " + id;
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
                int pat_id = rs.getInt("pat_id");
                String pat_name = rs.getString("pat_name");
                String pat_surname = rs.getString("pat_surname");


                System.out.println("pat_id: " + pat_id);
                System.out.println("pat_name: " + pat_name);
                System.out.println("pat_surname: " + pat_surname);
            }

            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
