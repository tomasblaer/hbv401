package com.example.hbv.user;

public class User {
    private final String id;
    private final String name;
    private final String username;
    private final String password;
    private final String phoneNumber;
    private final String email;
    private final Boolean isAgent; // isGuide?
    /*
    ?
    private final Array<Tour> bookedTours;
    private final Array<int> bookedTours;
     */

    public User(String id, String name, String username, String password, String phoneNumber, String email, Boolean isAgent) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.isAgent = isAgent;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getAgent() {
        return isAgent;
    }
}
