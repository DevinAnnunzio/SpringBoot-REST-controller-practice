package com.annunzio.restcontrollerpractice.entity;

public class User {
    private String firstName;
    private String lastName;
    private int age;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private int userId;

    public User(int userId){

        this.userId = userId;
    }

    public User(String firstName, String lastName, int age, int userId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
