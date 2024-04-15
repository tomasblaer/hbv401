package com.example.hbv.user;

public class User {
    private final int id;
    private final String name;
    private final String email;
    private final String phoneNumber;
    private final Boolean isGuide;


    public User(int id, String name, String email, String phoneNumber, Boolean isGuide) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.isGuide = isGuide;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Boolean isGuide() {
        return isGuide;
    }
}
