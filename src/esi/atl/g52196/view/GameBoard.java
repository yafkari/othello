package esi.atl.g52196.view;

import esi.atl.g52196.dp.Observer;
import static esi.atl.g52196.model.Board.BOARD_SIZE;
import esi.atl.g52196.model.Game;
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
public class GameBoard extends GridPane implements Observer {

    private Game game;

    public GameBoard(Game game) {
        this.game = game;
        game.registerObserver(this);

        setBackground(new Background(new BackgroundFill(Color.BLACK,
                CornerRadii.EMPTY, new Insets(20))));
        setPadding(new Insets(20));

        initializeBoard();
    }
    
    private void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                add(new Tile(60, 60, new Position(i, j), game), j, i);
            }
        }
    }

    @Override
    public void update() {
        this.getChildren().clear();
        initializeBoard();
    }
}
