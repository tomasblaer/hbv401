package com.example.hbv;

import com.example.hbv.tour.Tour;
import com.example.hbv.tour.TourDAO;
import com.example.hbv.util.UserSession;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.ArrayList;

public class TourController {

    public TextField searchField;
    public AnchorPane infoPane;
    public Label dateLabel;
    public Label capacityLabel;
    public ListView<Tour> tourList = new ListView<>();
    public Text infoText;
    public Label infoTitle;
    public Button bookButton;

    public void initialize() {
        ArrayList<Tour> tours =  TourDAO.listAvailableTours();
        if (tours != null) {
            for (Tour tour : tours) {
                tourList.getItems().add(tour);
            }
        }
        searchField.setOnKeyPressed(e -> {
            if (e.getCode().toString().equals("ENTER")) {
                onSearch();
            }
        });
    }

    private void setInfo(Tour tour) {
        infoTitle.setText(tour.getName());
        dateLabel.setText(tour.getDate().toString().formatted("%d/%m/%Y"));
        capacityLabel.setText(String.valueOf(tour.getCapacity()));
        infoText.setText(tour.getInfo());
        if (infoPane.isVisible()) {
            return;
        }
        infoPane.setVisible(true);
    }

    public void onTourListClicked() {
        Tour selectedTour = tourList.getSelectionModel().getSelectedItem();
        if (selectedTour == null) {
            return;
        }
        setInfo(selectedTour);
    }

    public void switchScene(Tour tour) throws IOException {
        Stage stage = (Stage) searchField.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("checkout-view.fxml"));

        Parent root =  fxmlLoader.load();

        Scene scene = new Scene(root);

        CheckoutController controller = fxmlLoader.getController();
        controller.setTour(tour);
        controller.hydrateView();

        stage.setScene(scene);
        stage.setTitle("Checkout");
        stage.show();
    }

    public void onBookTour() {
        Tour selectedTour = tourList.getSelectionModel().getSelectedItem();
        if (selectedTour == null) {
            return;
        }
        try {
            switchScene(selectedTour);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void onSearch() {
        String name = searchField.getText();
        ArrayList<Tour> tours = search(name);
        tourList.getItems().clear();
        if (tours == null) {
            return;
        }
        for (Tour tour : tours) {
            tourList.getItems().add(tour);
        }
    }

    public static ArrayList<Tour> getToursOrderedByDate() {
        return TourDAO.getToursOrderedByDate();
    }

    public static ArrayList<Tour> search(String name) {
        return TourDAO.getToursByName(name);
    }

    public void onViewBooked() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        ArrayList<Tour> bookedTours = TourDAO.listBookedToursForUser(UserSession.getInstance().getUser().getId());
        StringBuilder bookedTourNames = new StringBuilder();
        bookedTours.forEach(tour -> bookedTourNames.append(tour.getName()).append(" - ").append(tour.getDate().format(java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy"))).append("\n"));
        alert.setTitle("Booked tours");
        alert.setHeaderText("Your booked tours: \n" + bookedTourNames);
        alert.show();
    }
}
