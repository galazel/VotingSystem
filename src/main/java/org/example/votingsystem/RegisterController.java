package org.example.votingsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
    protected void clickRegister(ActionEvent e)
    {
        VoterModel voterModel = new VoterModel.Builder()
                .setName(name.getText())
                .setEmail(email.getText())
                .setContactNum(contactNum.getText())
                .setPassword(password.getText())
                .build();



    }


}
