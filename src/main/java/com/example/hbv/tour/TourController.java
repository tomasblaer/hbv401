package com.example.hbv.tour;

import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class TourController {
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
        Tour selectedTour = tourList.getSelectionModel().getSelectedItem();
        if (selectedTour == null) {
            return;
        }
        System.out.println(selectedTour);
    };
}
