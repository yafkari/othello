package esi.atl.g52196.view;

import esi.atl.g52196.model.Model;
import esi.atl.g52196.model.Player;
import javafx.scene.control.Alert;

/**
 *
 * @author 52196
 */
public class GameOver extends Alert {

    public GameOver(Model game, boolean givingUp) {
        super(AlertType.INFORMATION);
        Player winner = givingUp
                ? game.getOpponent()
                : game.getWinner();

        setTitle("Game over");
        setHeaderText("We have a winner !");
        String text = winner.getName() + " wins with "
                + winner.getScore() + " points";
        setContentText(text);
        show();
    }
}
