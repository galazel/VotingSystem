package org.example.votingsystem;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class NavigateStageController {

    public static void navigateMain(AnchorPane mainPane)
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) mainPane.getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Dashboard Admin");
            stage.show();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

}
