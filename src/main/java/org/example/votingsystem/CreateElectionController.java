package org.example.votingsystem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class CreateElectionController {

    @FXML
    private TextField electionName;
    @FXML
    private TextArea description;
    @FXML
    private VBox box;

    @FXML
    protected void addPosition(ActionEvent event)
    {
        var positionBox = new VBox();
        var position = new Label("Position");
        var positionField = new TextField();
        var candidate = new Label("Candidate");
        var candidateField = new TextField();
        var addCandidate = new Button("Add Candidate");
        var deleteCandidate = new Button("Delete Candidate");
        var deletePosition = new Button("Delete Position");
        var listView = new ListView<String>();
        addCandidate.setOnAction(s ->
        {
            listView.getItems().add(candidateField.getText());
            candidateField.clear();
        });
        deleteCandidate.setOnAction(e ->
        {
            String remove = listView.getSelectionModel().getSelectedItem();
            if(remove != null)
                listView.getItems().remove(remove);
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("No Selection");
                alert.setHeaderText(null);
                alert.setContentText("Select the candidate to be deleted first");
                alert.showAndWait();

            }
        });
        deletePosition.setOnAction(e ->
        {
            box.getChildren().remove(positionBox);
        });

        positionBox.getChildren().addAll(position,positionField,candidate,candidateField,addCandidate,listView,deletePosition,deleteCandidate);

        box.getChildren().add(positionBox);

    }


}
