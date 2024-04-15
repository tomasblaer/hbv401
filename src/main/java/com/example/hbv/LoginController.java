package com.example.hbv;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.hbv.user.User;
import com.example.hbv.user.UserDAO;
import com.example.hbv.util.UserSession;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/*
    Mock login klasi, má taka út en við notum usersession singleton til þess að boka
    userinn við ferðina sem hann bætir i körfuna.
 */

public class LoginController {
    public TextField usernameInput;
    public PasswordField passwordInput;

    public void switchScene() throws IOException {
        Stage stage = (Stage) usernameInput.getScene().getWindow();
        Parent root =  FXMLLoader.load(getClass().getResource("tour-view.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Tours");
        stage.show();
    }

    public void onLogin() {
        String username = usernameInput.getText();

        User loginUser = UserDAO.getUser(username);

        if (loginUser == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login failed");
            alert.setHeaderText("No user found");
            alert.show();
        } else {
            try {
                UserSession.getInstance(loginUser);
                switchScene();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}