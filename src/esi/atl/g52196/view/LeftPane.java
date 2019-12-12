package esi.atl.g52196.view;

import esi.atl.g52196.model.Game;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DialogEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author 52196
 */
public class LeftPane extends VBox {

    Game game;

    public LeftPane(double padding, Game game) {
        super(padding);
        this.game = game;
        GameBoard board = new GameBoard(game);

        Button giveUpButton = new Button("Give up");
        giveUpButton.setOnAction(e -> handleGiveUp());
        Button skipTurnButton = new Button("Skip Turn");
        skipTurnButton.setOnAction(e -> handleSkip());
        Button restartButton = new Button("Restart");
        restartButton.setOnAction(e -> handleRestart());

        HBox buttons = new HBox(20, giveUpButton, skipTurnButton, restartButton);
        buttons.setAlignment(Pos.CENTER);

        Progresses progress = new Progresses(game);

        getChildren().addAll(board, progress, buttons);
    }

    private void handleGiveUp() {
        GameOver end = new GameOver(game, true);
        end.setOnHidden(e -> handleQuit());
    }

    private void handleSkip() {
        game.skipTurn();
    }

    private void handleRestart() {
        game.reset();
    }

    private void handleQuit() {
        Stage s = (Stage) getScene().getWindow();
        s.close();
    }
}
