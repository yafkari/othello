package esi.atl.g52196.view;

import esi.atl.g52196.model.Observer;
import esi.atl.g52196.model.Game;
import esi.atl.g52196.model.PlayerColor;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;

/**
 *
 * @author g52196
 */
public class Progresses extends GridPane implements Observer {  //TODOProgressIndicator

    private Game game;
    private ProgressBar blackProgress;
    private ProgressBar whiteProgress;

    Progresses(Game game) {
        this.game = game;
        game.registerObserver(this);
        blackProgress = new ProgressBar();
        blackProgress.setStyle("-fx-accent: black;");

        whiteProgress = new ProgressBar();
        whiteProgress.setStyle("-fx-accent: grey;");

        add(new Label("Black:"), 0, 0, 2, 1);
        add(new Label("White:"), 2, 0, 2, 1);
        add(blackProgress, 0, 1, 2, 1);
        add(whiteProgress, 2, 1, 2, 1);

        setHgap(50);
        setPadding(new Insets(0, 0, 0, 140));
    }

    @Override
    public void update() {
        blackProgress.setProgress(game.getScore(PlayerColor.BLACK) / 72F);
        whiteProgress.setProgress(game.getScore(PlayerColor.WHITE) / 72F);
    }
}
