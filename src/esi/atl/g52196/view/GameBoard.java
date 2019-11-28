package esi.atl.g52196.view;

import esi.atl.g52196.model.Board;
import static esi.atl.g52196.model.Board.BOARD_SIZE;
import esi.atl.g52196.model.Position;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 *
 * @author 52196
 */
public class GameBoard extends GridPane {

    public GameBoard(Board board) {
        setBackground(new Background(new BackgroundFill(Color.BLACK,
                CornerRadii.EMPTY, new Insets(20))));
        setPadding(new Insets(20));

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                add(new Tile(60, 60, board.getPawn(new Position(i, j))), i, j); //j, i);
            }
        }
    }
}
