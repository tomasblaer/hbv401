package com.example.hbv;

import com.example.hbv.user.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    public TextField usernameInput;
    public PasswordField passwordInput;

    private User 

    public void onLogin(ActionEvent actionEvent) throws Exception {
        Stage stage = (Stage) usernameInput.getScene().getWindow();
        Parent root =  FXMLLoader.load(getClass().getResource("tour-view.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Tours");
        stage.show();
    }
}