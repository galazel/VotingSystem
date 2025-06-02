package org.example.votingsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DashboardAdminController {

    @FXML
    private Label electionLabel;
    @FXML
    private VBox box;

    @FXML
    protected void initialize()
    {
        if(box.getChildren().isEmpty())
            electionLabel.setText("No election is currently running.");
    }


    @FXML
    protected void createElection(ActionEvent event)
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("create-election-view.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setTitle("Create Election");
            stage.setScene(scene);
            stage.showAndWait();

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }



}
