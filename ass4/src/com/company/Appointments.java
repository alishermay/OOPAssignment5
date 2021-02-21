package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Appointments{
    Connection c = null;
    Statement stmt = null;
    public void insertMethod(String app_date, String app_time, int pat_id, int doc_id) {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/assignment 4",
                    "postgres", "1724");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "INSERT INTO appointments(app_time,pat_id,doc_id) "
                    + "VALUES ('" + app_date + " " + app_time + "'," + pat_id + "," + doc_id + ")";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public void updateMethod(int doc_id, int pat_id, String app_time) {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/assignment 4",
                    "postgres", "1724");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "UPDATE appointments SET app_time = '" + app_time
                    + "' WHERE pat_id = " + pat_id + "and doc_id = " + doc_id;
            stmt.executeUpdate(sql);


            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }


    public void deleteMethod(int doc_id, int pat_id, String app_time) {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/assignment 4",
                    "postgres", "1724");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "DELETE FROM appointments WHERE doc_id = "
                    + doc_id + "and pat_id = " + pat_id + "and app_time = '" + app_time + "'";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }


    public void readByDocMethod(int id) {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/assignment 4",
                    "postgres", "1724");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "SELECT FROM appointments WHERE doc_id = " + id;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int doc_id = rs.getInt("doc_id");
                int pat_id = rs.getInt("pat_id");
                String app_time = rs.getString("app_time");

                System.out.println("doc_id: " + doc_id);
                System.out.println("pat_id: " + pat_id);
                System.out.println("app_time: " + app_time);
            }

            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
    public void readByPatMethod(int id) {
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/assignment 4",
                    "postgres", "1724");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            String sql = "SELECT FROM appointments WHERE pat_id = " + id;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int pat_id = rs.getInt("pat_id");
                int doc_id = rs.getInt("doc_id");
                String app_time = rs.getString("app_time");

                System.out.println("pat_id: " + pat_id);
                System.out.println("doc_id: " + doc_id);
                System.out.println("app_time: " + app_time);
            }

            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
