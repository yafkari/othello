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
public class GiveUpPage extends Stage {

    public GiveUpPage(Game game) {
        PlayerColor winnerColor = game.getCurrentColor() == PlayerColor.BLACK
                ? PlayerColor.WHITE
                : PlayerColor.BLACK;
        Label textWinner = new Label(winnerColor.toString() + " wins with "
                + game.getScore(winnerColor) + " points");
        setScene(new Scene(new VBox(textWinner), 200, 150));
    }
}
