package com.example.hbv;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.hbv.user.User;
import com.example.hbv.user.UserDAO;
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

//    private User

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
        String password = passwordInput.getText();

        User loginUser = UserDAO.getUser(username);

        if (loginUser == null) {
            System.out.println("User not found / TODO");
            return;
        }

        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), loginUser.getPassword());

        if (result.verified) {
            try {
                switchScene();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }




    }
}