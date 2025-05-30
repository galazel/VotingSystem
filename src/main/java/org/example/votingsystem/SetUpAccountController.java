package org.example.votingsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SetUpAccountController
{
    public static void loginButton(ActionEvent e) {
        try {
            FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("login-view.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            stage.setTitle("Login");
            stage.setScene(scene);
            stage.show();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void registerButton(ActionEvent e)
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("register-view.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage)((Node) e.getSource()).getScene().getWindow();
            stage.setTitle("Register");
            stage.setScene(scene);
            stage.show();

        }catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

}
