package esi.atl.g52196.view;

import esi.atl.g52196.model.Game;
import esi.atl.g52196.view.GiveUpPage;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author 52196
 */
public class LeftPane extends VBox {

    Game game;

    //TODO will contains progressbar
    public LeftPane(double padding, Game game) {
        super(padding);
        this.game = game;
        GameBoard board = new GameBoard(game);

        Button giveUpButton = new Button("Give up");
        giveUpButton.setOnAction(e -> handleGiveUp(e));
        Button skipTurnButton = new Button("Skip Turn");
        Button restartButton = new Button("Restart");
        HBox buttons = new HBox(20, giveUpButton, skipTurnButton, restartButton);
        buttons.setAlignment(Pos.CENTER);

        getChildren().addAll(board, buttons);
    }

    private void handleGiveUp(ActionEvent event) {
        getScene().getWindow().hide();
        GiveUpPage end = new GiveUpPage(game);
        end.show();
    }
}
