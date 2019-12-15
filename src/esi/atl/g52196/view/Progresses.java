package esi.atl.g52196.view;

import esi.atl.g52196.model.Observer;
import esi.atl.g52196.model.Model;
import esi.atl.g52196.model.PlayerColor;
import esi.atl.g52196.model.Position;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.GridPane;

/**
 *
 * @author g52196
 */
public class Progresses extends GridPane implements Observer {  //TODO ProgressIndicator + refaire

    private final Model game;
    private final ProgressBar progressBar;
    private final ProgressIndicator progressIndicator;

    Progresses(Model game) {
        this.game = game;
        game.registerObserver(this);
        progressBar = new ProgressBar();
        progressIndicator = new ProgressIndicator();

        progressBar.setStyle("-fx-accent: black;");

        add(new Label("Black VS White"), 0, 0, 2, 1);
        add(progressBar, 0, 1, 2, 1);

        setHgap(50);
        setPadding(new Insets(0, 0, 0, 140));
    }

    private int getNbPawns() {
        int nbPieces = 0;

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                if (game.getBoard().isEmpty(new Position(row, col))) {
                    ++nbPieces;
                }
            }
        }

        return nbPieces;
    }

    @Override
    public void update() {
        double blackScore = game.getPlayer(PlayerColor.BLACK).getScore();
        double whiteScore = game.getPlayer(PlayerColor.WHITE).getScore();

        progressBar.setProgress(blackScore / (blackScore + whiteScore));

        progressIndicator.setProgress(getNbPawns() / 64F);
    }
}
