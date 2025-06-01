package org.example.votingsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private TextField votersId;
    @FXML
    private PasswordField password;
    @FXML
    private AnchorPane mainPane;

    @FXML
    protected void clickLogin(ActionEvent e)
    {
        if(votersId.getText().isEmpty() || password.getText().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Empty Fields");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in the required fields");
            alert.showAndWait();
            return;
        }

        try
        {
            int id = Integer.parseInt(votersId.getText());
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid ID");
            alert.setHeaderText(null);
            alert.setContentText("ID should be a number!");
            alert.showAndWait();
            votersId.setText("");
            password.setText("");

            return;
        }

            AccountService service = new AccountService();
            if(service.isAccountExisted(Integer.parseInt(votersId.getText()), password.getText()))
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Account Status");
                alert.setHeaderText(null);
                alert.setContentText("Successfully logging in");
                alert.showAndWait();

                if(votersId.getText().equals("1"))
                {
                    try
                    {
                        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("dashboard-admin-view.fxml"));
                        Scene scene = new Scene(loader.load());
                        Stage stage = (Stage) mainPane.getScene().getWindow();
                        stage.setScene(scene);
                        stage.setTitle("Dashboard Admin");
                        stage.show();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }

                }else {
                    LoginAccount loginAccount = new LoginAccount();
                    loginAccount.setVotersId(Integer.parseInt(votersId.getText()));
                    loginAccount.setVotersName(Integer.parseInt(votersId.getText()));
                    loginAccount.setProfile(service.getProfile(Integer.parseInt(votersId.getText()), password.getText()));

                    try {
                        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("dashboard-voter-view.fxml"));
                        Scene scene = new Scene(loader.load());
                        Stage stage = (Stage) mainPane.getScene().getWindow();
                        stage.setScene(scene);
                        stage.setTitle("Dashboard Voter");
                        stage.show();


                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }

                return;
            }else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Account Status");
                alert.setHeaderText(null);
                alert.setContentText("Invalid Credentials");
                alert.showAndWait();
                votersId.setText("");
                password.setText("");
                return;
            }


    }


    @FXML
    protected void clickReturn(ActionEvent event)
    {
        NavigateStageController.navigateMain(mainPane);
    }

}
