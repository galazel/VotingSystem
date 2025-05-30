package org.example.votingsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.Set;

public class MainController {

    @FXML
    public void loginButton(ActionEvent e)
    {
        SetUpAccountController.loginButton(e);
    }
    @FXML
    public void registerButton(ActionEvent e)
    {
        SetUpAccountController.registerButton(e);
    }

}