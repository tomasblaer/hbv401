package com.example.hbv.tour;

import javafx.scene.control.ListView;


import java.util.ArrayList;

public class TourController {

    private Tour selectedTour;
    public ListView<Tour> tourList = new ListView<>();

    public void initialize() {
        ArrayList<Tour> tours =  TourDAO.listTours();
        if (tours != null) {
            for (Tour tour : tours) {
                tourList.getItems().add(tour);
            }
        }
    }

    public void onTourListClicked() {
        selectedTour = tourList.getSelectionModel().getSelectedItem();
        if (selectedTour == null) {
            return;
        }
        System.out.println(selectedTour);
    }


}
