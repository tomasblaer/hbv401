package com.example.hbv.tour;

import com.example.hbv.user.User;

import java.time.LocalDate;
import java.util.Date;

public class Tour {
    private final int id;
    private final String category;
    private final int capacity;
    private final LocalDate date;
    private final String name;
    private final User guide;
    private final String info;

    public Tour(int id, String category, int capacity, LocalDate date, String name, User guide, String info) {
        this.id = id;
        this.category = category;
        this.capacity = capacity;
        this.date = date;
        this.name = name;
        this.guide = guide;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public int getCapacity() {
        return capacity;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public User getGuide() {
        return guide;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return name + " - " + category;
    }
}
