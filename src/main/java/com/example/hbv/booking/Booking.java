package com.example.hbv.booking;

public class Booking {
    private final int id;
    private final int tourId;
    private final int userId;

    public Booking(int id, int tourId, int userId) {
        this.id = id;
        this.tourId = tourId;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public int getTourId() {
        return tourId;
    }

    public int getUserId() {
        return userId;
    }
}
