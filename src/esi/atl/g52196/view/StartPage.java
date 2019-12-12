package esi.atl.g52196.view;

import esi.atl.g52196.model.Game;
import esi.atl.g52196.model.PlayerColor;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author 52196
 */
public class StartPage extends GridPane {

    private TextField blackNameField;
    private TextField whiteNameField;
    private CheckBox isWhiteIA;
    private CheckBox isBlackIA;

    private Game game;

    public StartPage(Game game) {
        this.game = game;

        Label blackNameLabel = new Label("Black player name: ");
        blackNameField = new TextField("");
        isBlackIA = new CheckBox("IA ?");
        isBlackIA.setOnAction(e -> handleBoxClicked(isWhiteIA, e));

        Label whiteNameLabel = new Label("White player name: ");
        whiteNameField = new TextField("");
        isWhiteIA = new CheckBox("IA ?");
        isWhiteIA.setOnAction(e -> handleBoxClicked(isBlackIA, e));

        Button submitButton = new Button("Submit");
        submitButton.setMinWidth(250);
        submitButton.setOnAction(e -> handleSubmit(e));

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

    private void handleSubmit(ActionEvent e) {
        game.setPlayerName(PlayerColor.BLACK, blackNameField.getText());
        game.setPlayerName(PlayerColor.WHITE, whiteNameField.getText());
        if (isBlackIA.isSelected()) {
            game.setBot(PlayerColor.BLACK);
        }
        if (isWhiteIA.isSelected()) {
            game.setBot(PlayerColor.WHITE);
        }

        hideAndInitialize(e);
    }

    private void hideAndInitialize(ActionEvent e) {
        Button src = (Button) e.getSource();
        Stage stage = (Stage) src.getScene().getWindow();
        stage.hide();
        initializeGame(stage);
    }

    private void initializeGame(Stage stage) {
        BorderPane root = new BorderPane();
        CustomMenu menu = new CustomMenu();
        LeftPane leftPane = new LeftPane(20, game);
        RightPane rightPane = new RightPane(20, game);

        root.setTop(menu);
        root.setLeft(leftPane);
        root.setRight(rightPane);
        Scene scene = new Scene(root, 999, 749);

        stage.setScene(scene);
        stage.setX(300);
        stage.setY(200);
        stage.show();
    }

    private void handleBoxClicked(CheckBox other, ActionEvent event) {
        CheckBox self = (CheckBox) event.getSource();
        other.setSelected(!self.isSelected());
    }
}
