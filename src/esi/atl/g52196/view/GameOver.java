package esi.atl.g52196.view;

import esi.atl.g52196.model.Model;
import esi.atl.g52196.model.PlayerColor;
import javafx.scene.control.Alert;

/**
 *
 * @author 52196
 */
public class GameOver extends Alert {

    public GameOver(Model game, boolean givingUp) {
        super(AlertType.INFORMATION);
        PlayerColor winner = givingUp
                ? game.getOpponent().getColor()
                : game.getWinner();

        setTitle("Game over");
        setHeaderText("We have a winner !");
        String text = game.getPlayerName(winner) + " wins with "
                + game.getScore(winner) + " points";
        setContentText(text);
        show();
    }
}
