package esi.atl.g52196.view;

import esi.atl.g52196.model.Game;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author 52196
 */
public class LeftPane extends VBox {

    //TODO will contains progressbar
    public LeftPane(double padding, Game game) {
        super(padding);
        GameBoard board = new GameBoard(game);

        Button giveUpButton = new Button("Give up");
        Button skipTurnButton = new Button("Skip Turn");
        Button restartButton = new Button("Restart");
        HBox buttons = new HBox(20, giveUpButton, skipTurnButton, restartButton);
        buttons.setAlignment(Pos.CENTER);

        getChildren().addAll(board, buttons);
    }
}
