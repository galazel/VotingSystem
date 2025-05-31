package org.example.votingsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DashboardVoterController {

    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private AnchorPane rightPane;
    @FXML
    private VBox vBox;


    @FXML
    protected void initialize()
    {
        LoginAccount login = new LoginAccount();
        name.setText(login.getVotersName());
        id.setText("Identification Number: "+Integer.toString(login.getVotersId()));
        if(isBoxEmpty(vBox))
            vBox.getChildren().add(new Label("You have not voted yet."));

    }

    @FXML
    protected void clickViewResult(ActionEvent event)
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("result-view.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) rightPane.getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    protected void clickVoteNow(ActionEvent event)
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("vote-now-view.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) rightPane.getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    protected boolean isBoxEmpty(VBox vBox)
    {
        return vBox.getChildren().isEmpty();
    }
}
