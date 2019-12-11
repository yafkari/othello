package esi.atl.g52196.view;

import esi.atl.g52196.model.Observer;
import static esi.atl.g52196.model.Board.BOARD_SIZE;
import esi.atl.g52196.model.Game;
import esi.atl.g52196.model.Position;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 *
 * @author 52196
 */
public class GameBoard extends GridPane implements Observer {

    private Game game;
    public static final int SIDE_SIZE = 50;

    public GameBoard(Game game) {
        this.game = game;
        game.registerObserver(this);
        setPadding(new Insets(20));

        initializeBoard();
    }

    private void initializeBoard() {
        initializeRowIndexes();
        initializeColIndexes();

        for (int row = 1; row < BOARD_SIZE + 1; row++) {
            for (int col = 1; col < BOARD_SIZE + 1; col++) {
                add(new Tile(50, 50, new Position(row - 1, col - 1), game),
                        col, row);
            }
        }
    }

    private void initializeRowIndexes() {
        for (int i = 1; i < BOARD_SIZE + 1; i++) {
            Text text = new Text(String.valueOf(i - 1));
            text.setFill(Color.WHITE);
            Rectangle tile = new Rectangle(SIDE_SIZE, SIDE_SIZE);
            StackPane stack = new StackPane(tile, text);
            add(stack, i, 0);
        }
    }

    private void initializeColIndexes() {
        for (int i = 1; i < BOARD_SIZE + 1; i++) {
            Text text = new Text(String.valueOf(i - 1));
            text.setFill(Color.WHITE);
            StackPane stack = new StackPane(
                    new Rectangle(SIDE_SIZE, SIDE_SIZE), text);
            add(stack, 0, i);
        }
    }

    @Override
    public void update() {
        getChildren().clear();
        initializeBoard();
    }
}
