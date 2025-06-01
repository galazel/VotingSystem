package org.example.votingsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.nio.file.Files;

public class RegisterController {

    @FXML
    private TextField name;
    @FXML
    private TextField email;
    @FXML
    private TextField contactNum;
    @FXML
    private PasswordField password;
    @FXML
    private AnchorPane mainPane;

    @FXML
    private ImageView imageView;
    private byte [] profile;



    @FXML
    protected void clickRegister(ActionEvent e)
    {
        if(name.getText().isEmpty() || email.getText().isEmpty() || contactNum.getText().isEmpty() || password.getText().isEmpty() || imageView == null)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText(null);
            alert.setContentText("Please, fill in the required fields");
            alert.showAndWait();
            return;
        }else
        {
            VoterModel voterModel = new VoterModel.Builder()
                    .setName(name.getText())
                    .setEmail(email.getText())
                    .setContactNum(contactNum.getText())
                    .setPassword(password.getText())
                    .setProfile(profile)
                    .build();
            AccountService accountService = new AccountService();
            if(accountService.isAccountAlreadyExisted(voterModel))
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Account Status");
                alert.setHeaderText(null);
                alert.setContentText("Account already existed!");
                alert.showAndWait();
                name.setText("");
                email.setText("");
                contactNum.setText("");
                password.setText("");
                return;
            }else {
                if(accountService.addAccount(voterModel))
                {
                    accountService.getVotersId(voterModel.getName(), voterModel.getEmail());
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Account Status");
                    alert.setHeaderText(null);
                    alert.setContentText("Account successfully created!Your ID will be "+ accountService.getVotersId(voterModel.getName(), voterModel.getEmail()));
                    alert.showAndWait();
                    try
                    {
                        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("login-view.fxml"));
                        Scene scene = new Scene(loader.load());
                        Stage stage = (Stage) mainPane.getScene().getWindow();
                        stage.setScene(scene);
                        stage.setTitle("Login");
                        stage.show();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }

                }
            }
        }
    }
    @FXML
    protected void clickReturn(ActionEvent event)
    {
        NavigateStageController.navigateMain(mainPane);
    }

    @FXML
    protected void clickImage(MouseEvent event) {
        FileChooser choose = new FileChooser();
        choose.setTitle("Upload Profile Picture");
        choose.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files","*.jpeg","*.png"));
        Stage stage = (Stage) mainPane.getScene().getWindow();
        File selectedFile = choose.showOpenDialog(stage);

        try {
            if (selectedFile != null) {
                Image image = new Image(selectedFile.toURI().toString());
                imageView.setImage(image);
                profile = Files.readAllBytes(selectedFile.toPath());
            }else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Fields");
                alert.setHeaderText(null);
                alert.setContentText("No Profile Selected!");
                alert.showAndWait();
                return;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
