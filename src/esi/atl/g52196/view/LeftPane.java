package esi.atl.g52196.view;

import esi.atl.g52196.model.Game;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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
        giveUpButton.setOnAction(e -> handleGiveUp(e));
        Button skipTurnButton = new Button("Skip Turn");
        skipTurnButton.setOnAction(e -> handleSkip(e));
        Button restartButton = new Button("Restart");
        restartButton.setOnAction(e -> handleRestart(e));
        HBox buttons = new HBox(20, giveUpButton, skipTurnButton, restartButton);
        buttons.setAlignment(Pos.CENTER);

        getChildren().addAll(board, buttons);
    }

    private void handleGiveUp(ActionEvent event) {
        getScene().getWindow().hide();
        GameOver end = new GameOver(game, true);
        end.show();
    }

    private void handleSkip(ActionEvent event) {
        game.skip();
    }
    
    private void handleRestart(ActionEvent event) {
        game.reset();
    }
}
