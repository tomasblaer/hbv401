package com.example.hbv.util;

import com.example.hbv.tour.Tour;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class MockTourDAO {

    private static final ArrayList<Tour> tours =
            new ArrayList<>() {{
                add(new Tour(4, "Hike", 10, LocalDate.parse("2024-05-01"), "Hiking up Úlfarsfell", null, "Relaxed hike with a great view of Reykjavik"));
                add(new Tour(5, "Hike", 10, LocalDate.parse("2024-05-01"), "Hiking up Esja", null, "Hike up the mountain Esja"));
                add(new Tour(6, "Sailing", 10, LocalDate.parse("2024-06-02"), "Kayaking in Eyjaförður", null, "Kayaking in the ocean with guides"));
                add(new Tour(7, "Northern Lights", 50, LocalDate.parse("2024-09-15"), "Northern Lights Expedition", null, "Guided tour to see the spectacular northern lights"));
                add(new Tour(8, "Glacier Hike", 8, LocalDate.parse("2024-08-20"), "Exploring Vatnajökull Glacier", null, "Experience hiking on the largest glacier in Iceland"));
            }};

    public static ArrayList<Tour> listTours() {
        return tours;
    }

    public static ArrayList<Tour> getToursByName(String name) {
        for (Tour tour : tours) {
            if (tour.getName().toUpperCase().contains(name.toUpperCase())) {
                tours.add(tour);
            }
        }
        return tours;
    }

    public static ArrayList<Tour> getToursOrderedByDate() {
        tours.sort(Comparator.comparing(Tour::getDate));
        return tours;
    }

    public static void databaseFailed() throws SQLException {
        throw new SQLException("Database connection failed");
    }

}
