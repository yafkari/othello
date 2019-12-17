package esi.atl.g52196.view;

import esi.atl.g52196.model.Model;
import esi.atl.g52196.model.Observer;
import esi.atl.g52196.model.PlayerColor;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author 52196
 */
public class InformationWindow extends Stage implements Observer {

    Model game;
    Label blackPlayerNameLabel;
    Label whitePlayerNameLabel;
    Label blackPlayerScoreLabel;
    Label whitePlayerScoreLabel;
    Label blackPlayerCountLabel;
    Label whitePlayerCountLabel;

    InformationWindow(Model game) {
        this.game = game;
        game.registerObserver(this);

        HBox root = new HBox(20);

        VBox blackPlayerName = new VBox(10);
        blackPlayerNameLabel = new Label(game.getPlayerName(PlayerColor.BLACK));
        blackPlayerScoreLabel = new Label(
                String.valueOf(game.getScore(PlayerColor.BLACK)));
        blackPlayerCountLabel = new Label(
                String.valueOf(game.getNbPawnsOnBoard(PlayerColor.BLACK)));

        blackPlayerName.getChildren().addAll(new Label("Black player name:"),
                blackPlayerNameLabel, new Label("Score:"), blackPlayerScoreLabel,
                new Label("Number of pawns:"), blackPlayerCountLabel);

        VBox whitePlayerName = new VBox(10);
        whitePlayerNameLabel = new Label(game.getPlayerName(PlayerColor.WHITE));
        whitePlayerScoreLabel = new Label(
                String.valueOf(game.getScore(PlayerColor.WHITE)));
        whitePlayerCountLabel = new Label(
                String.valueOf(game.getNbPawnsOnBoard(PlayerColor.WHITE)));

        whitePlayerName.getChildren().addAll(new Label("White player name: "),
                whitePlayerNameLabel, new Label("Score:"), whitePlayerScoreLabel,
                new Label("Number of pawns:"), whitePlayerCountLabel);

        root.getChildren().addAll(blackPlayerName, whitePlayerName);
        setScene(new Scene(root, 300, 200));
        setTitle("Informations");
    }

    @Override
    public void update() {
        blackPlayerNameLabel.setText(game.getPlayerName(PlayerColor.BLACK));
        whitePlayerNameLabel.setText(game.getPlayerName(PlayerColor.WHITE));
        blackPlayerScoreLabel.setText(
                String.valueOf(game.getScore(PlayerColor.BLACK)));
        whitePlayerScoreLabel.setText(
                String.valueOf(game.getScore(PlayerColor.WHITE)));
        blackPlayerCountLabel.setText(
                String.valueOf(game.getNbPawnsOnBoard(PlayerColor.BLACK)));
        whitePlayerCountLabel.setText(
                String.valueOf(game.getNbPawnsOnBoard(PlayerColor.WHITE)));
    }
}
