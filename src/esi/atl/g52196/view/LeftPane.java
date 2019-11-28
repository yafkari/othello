package esi.atl.g52196.view;

import esi.atl.g52196.model.Game;
import javafx.scene.layout.VBox;

/**
 *
 * @author 52196
 */
public class LeftPane extends VBox {

    //TODO will contains board + progressbar + buttons
    public LeftPane(double padding, Game game) {
        super(padding);
        GameBoard board = new GameBoard(game.getBoard());

        getChildren().add(board);
    }
}
