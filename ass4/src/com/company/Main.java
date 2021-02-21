//Here you can see my homework. I created a program that interacts with a database of supposedly medical clinic. 
//There are separate tables for patients, doctors, and appointments.
//Each of them has its own class, which has methods for inserting, updating, deleting, and reading the Database. Used all that was required in a text file assignment-5.
package com.company;
import java.sql.*;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("1. Appointments\n2. Patients\n3. Doctors\n");
            int menu = sc.nextInt();

            if (menu == 1) {
                Appointments app = new Appointments();
                System.out.println("1. New appointment\n2. Update appointment\n3. Delete appointment\n"
                        + "4. Show appointments by doctor's id");
                menu = sc.nextInt();


                if (menu == 1) {
                    System.out.println("Insert the appointment time in next format: YYYY-MM-DD HH:MI:SS");
                    String app_date = sc.next();
                    String app_time = sc.next();


                    System.out.println("Insert the patient's id");
                    int pat_id = sc.nextInt();


                    System.out.println("Insert the doctor's id");
                    int doc_id = sc.nextInt();


                    app.insertMethod(app_date, app_time, pat_id, doc_id);

                } else if (menu == 2) {
                    System.out.println("Insert doctor's id");
                    int doc_id = sc.nextInt();


                    System.out.println("Insert patient's id");
                    int pat_id = sc.nextInt();


                    System.out.println("Insert new appointment time");
                    String app_time = sc.next();


                    app.updateMethod(doc_id, pat_id, app_time);
                } else if (menu == 3) {
                    System.out.println("Insert doctor's id");
                    int doc_id = sc.nextInt();


                    System.out.println("Insert patient's id");
                    int pat_id = sc.nextInt();


                    System.out.println("Insert new appointment time");
                    String app_time = sc.next();


                    app.deleteMethod(doc_id, pat_id, app_time);
                } else if (menu == 4) {
                    System.out.println("1. By doctor's id\n2. By patient's id");
                    menu = sc.nextInt();


                    if (menu == 1) {
                        System.out.println("Input doctor's id");
                        int id = sc.nextInt();


                        app.readByDocMethod(id);
                    }
                    else if (menu == 2) {
                        System.out.println("Input patient's id");
                        int id = sc.nextInt();


                        app.readByPatMethod(id);
                    }
                }
            } else if (menu == 2) {
                Patients pat = new Patients();
                System.out.println("1. New patient\n2. Update patient by id\n3. Delete patient by id\n4. Read from patients");
                menu = sc.nextInt();


                if (menu == 1) {
                    System.out.println("Insert the patient's id");
                    int id = sc.nextInt();


                    System.out.println("Insert the patient's name");
                    String name = sc.next();


                    System.out.println("Insert the patient's surname");
                    String surname = sc.next();


                    pat.insertMethod(id, name, surname);
                } else if (menu == 2) {
                    System.out.println("Insert the id of the patient you want to update");
                    int id = sc.nextInt();


                    System.out.println("Insert new patient name");
                    String name = sc.next();


                    System.out.println("Insert new patient surname");
                    String surname = sc.next();


                    pat.updateMethod(id, name, surname);
                } else if (menu == 3) {
                    System.out.println("Insert the id of the patient you want to delete");
                    int id = sc.nextInt();


                    pat.deleteMethod(id);
                } else if (menu == 4) {
                    System.out.println("Insert the patient's id");
                    int id = sc.nextInt();


                    pat.readMethod(id);
                }
            } else if (menu == 3) {
                Doctors doc = new Doctors();
                System.out.println("1. New doctor\n2. Update doctor by id\n3. Delete doctor by id\n4. Read from doctors");
                menu = sc.nextInt();


                if (menu == 1) {
                    System.out.println("Insert the doctor's id");
                    int id = sc.nextInt();


                    System.out.println("Insert the doctor's name");
                    String name = sc.next();


                    System.out.println("Insert the doctor's surname");
                    String surname = sc.next();


                    doc.insertMethod(id, name, surname);
                } else if (menu == 2) {
                    System.out.println("Insert the id of the doctor you want to update");
                    int id = sc.nextInt();


                    System.out.println("Insert new doctor name");
                    String name = sc.next();


                    System.out.println("Insert new doctor surname");
                    String surname = sc.next();


                    doc.updateMethod(id, name, surname);
                } else if (menu == 3) {
                    System.out.println("Insert the id of the doctor you want to delete");
                    int id = sc.nextInt();


                    doc.deleteMethod(id);
                } else if (menu == 4) {
                    System.out.println("Insert the doctor's id");
                    int id = sc.nextInt();


                    doc.readMethod(id);
                }
            }
        }
    }
}
