package com.example.hbv.tour;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TourControllerTester {
    private Tour expectedTour;


    @BeforeEach
    public void setUp() {
        // Guide is set to null because we have not started mapping guides to the tour result mapper
        expectedTour = new Tour("4", "Hike", 10, LocalDate.parse("2024-05-01"), "Hiking up Úlfarsfell", null, "Relaxed hike with a great view of Reykjavik");
    }

    @Test
    void testSearch() {
        Tour foundTour = TourController.search("Hiking up Úlfarsfell").get(0);
        assertEquals(expectedTour.toString(), foundTour.toString());
    }

    @Test
    void testSearchSubstringMixedCase() {
        Tour foundTour = TourController.search("úlfaRs").get(0);
        assertEquals(expectedTour.toString(), foundTour.toString());
    }

    @Test
    void testSearchNoResults() {
        ArrayList<Tour> foundTour = TourController.search("Non existent tour");
        assertTrue(foundTour.isEmpty());
    }

    @Test
    void testGetToursOrderedByDate() {
        ArrayList<Tour> foundTours = TourController.getToursOrderedByDate();
        assertEquals(expectedTour.toString(), foundTours.get(0).toString());
    }
}
