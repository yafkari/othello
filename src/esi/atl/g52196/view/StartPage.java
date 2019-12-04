package esi.atl.g52196.view;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author 52196
 */
public class StartPage extends Stage {  //TODO Check values

    private String blackPlayerName;
    private String whitePlayerName;
    private TextField blackNameField;
    private TextField whiteNameField;

    public StartPage() {
        setTitle("Player names");

        GridPane layout = new GridPane();
        layout.setVgap(10);
        layout.setPadding(new Insets(20));
        Label blackNameLabel = new Label("Black player name: ");
        blackNameField = new TextField();
        Label whiteNameLabel = new Label("White player name: ");
        whiteNameField = new TextField();
        Button submitButton = new Button("Submit");
        submitButton.setMinWidth(250);
        submitButton.setOnAction(e -> handleSubmit(e));

        layout.add(blackNameLabel, 0, 0);
        layout.add(blackNameField, 1, 0, 2, 1);
        layout.add(whiteNameLabel, 0, 1);
        layout.add(whiteNameField, 1, 1, 2, 1);
        layout.add(submitButton, 0, 2, 2, 1);

        setScene(new Scene(layout, 300, 150));
    }

    /**
     * Returns black player name
     * 
     * @return black player name
     */
    public String getBlackName() {
        return blackPlayerName;
    }

    /**
     * Returns black player name
     * 
     * @return black player name
     */
    public String getWhiteName() {
        return whitePlayerName;
    }

    private void handleSubmit(ActionEvent e) {
        blackPlayerName = blackNameField.getText();
        whitePlayerName = whiteNameField.getText();
        hide();
    }
}