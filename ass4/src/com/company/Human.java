package com.company;

public abstract class Human {
    public abstract void insertMethod(int id, String name, String surname);
    public abstract void updateMethod(int id, String name, String surname);
    public abstract void deleteMethod(int id);
    public abstract void readMethod(int id);
}
