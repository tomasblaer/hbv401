package com.example.hbv;

import com.example.hbv.booking.BookingDAO;
import com.example.hbv.tour.Tour;
import com.example.hbv.tour.TourDAO;
import com.example.hbv.util.UserSession;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class CheckoutController {
    public Label tourGuideLabel;
    public Label tourNameLabel;
    public Label capacityLabel;
    public Label tourDateLabel;
    public Label tourInfoLabel;
    public ComboBox monthSelect;
    public ComboBox yearSelect;
    private Tour tour;

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public void hydrateView() {
        tourGuideLabel.setText("Guided by: " + tour.getGuide().getName());
        tourNameLabel.setText(tour.getName());
        capacityLabel.setText("Remaining slots: " + tour.getCapacity());
        tourDateLabel.setText(tour.getDate().format(java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        tourInfoLabel.setText(tour.getInfo());
        monthSelect.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");
        yearSelect.getItems().addAll("2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030");
    }

    private void switchScene() throws IOException {
        Stage stage = (Stage) tourGuideLabel.getScene().getWindow();
        Parent root =  FXMLLoader.load(getClass().getResource("tour-view.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Tours");
        stage.show();
    }


    public void onSubmit() {
        TourDAO.decrementTourCapacity(tour.getId());
        BookingDAO.addBooking(tour.getId(), UserSession.getInstance().getUser().getId());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Booking confirmation");
        alert.setHeaderText("Booking successful, click OK to return to the tour page");
        alert.show();
        alert.setOnCloseRequest(dialogEvent -> {
            try {
                switchScene();
                alert.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void onBack() {
        try {
            switchScene();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
