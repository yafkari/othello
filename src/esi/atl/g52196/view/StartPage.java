package esi.atl.g52196.view;

import esi.atl.g52196.model.Game;
import esi.atl.g52196.model.Model;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author 52196
 */
public class StartPage extends GridPane {

    private final TextField blackNameField;
    private final TextField whiteNameField;
    private CheckBox isWhiteIA;
    private CheckBox isBlackIA;
    public Button submitButton;

    public StartPage() {

        Label blackNameLabel = new Label("Black player name: ");
        blackNameField = new TextField("");
        isBlackIA = new CheckBox("IA ?");
        isBlackIA.setOnAction(e -> handleBoxClicked(isWhiteIA, e));

        Label whiteNameLabel = new Label("White player name: ");
        whiteNameField = new TextField("");
        isWhiteIA = new CheckBox("IA ?");
        isWhiteIA.setOnAction(e -> handleBoxClicked(isBlackIA, e));

        submitButton = new Button("Submit");
        submitButton.setMinWidth(250);

        add(blackNameLabel, 0, 0);
        add(blackNameField, 1, 0, 2, 1);
        add(isBlackIA, 3, 0);

        add(whiteNameLabel, 0, 1);
        add(whiteNameField, 1, 1, 2, 1);
        add(isWhiteIA, 3, 1);

        add(submitButton, 0, 2, 2, 1);

        setVgap(10);
        setHgap(10);
        setPadding(new Insets(20));
    }

    public Model getData() {
        return new Game(blackNameField.getText(), isBlackIA.isSelected(),
                whiteNameField.getText(), isWhiteIA.isSelected());
    }

    private void handleBoxClicked(CheckBox other, ActionEvent event) {
        CheckBox self = (CheckBox) event.getSource();
        other.setSelected(!self.isSelected());
    }
}
