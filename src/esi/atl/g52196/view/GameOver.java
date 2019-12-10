package esi.atl.g52196.view;

import esi.atl.g52196.model.Game;
import esi.atl.g52196.model.PlayerColor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author 52196
 */
public class GameOver extends Stage {

    public GameOver(Game game, boolean givingUp) {
        PlayerColor winner = givingUp
                ? game.getOpponentColor()
                : game.getWinner();

        Label textWinner = new Label(game.getPlayerName(winner) + " wins with "
                + game.getScore(winner) + " points");
        setScene(new Scene(new VBox(textWinner), 200, 150));
    }
}
