package esi.atl.g52196.view;

import esi.atl.g52196.model.Observer;
import esi.atl.g52196.model.Game;
import esi.atl.g52196.model.Model;
import esi.atl.g52196.model.PlayerColor;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 *
 * @author 52196
 */
public class Scores extends HBox implements Observer {

    private final Model game;
    private final Label whiteScoreValue;
    private final Label blackScoreValue;

    Scores(Model game) {
        this.game = game;
        game.registerObserver(this);
        Rectangle blackRec = new Rectangle(225, 50, Color.TOMATO);

        Text blackNameLabel = new Text("Name");
        Text blackPlayerName = new Text(game.getPlayerName(PlayerColor.BLACK));
        VBox blackName = new VBox(10, blackNameLabel, blackPlayerName);

        Label blackPawnLabel = new Label("Pawn");
        Circle blackPawnCircle = new Circle(5, Color.BLACK);
        VBox blackPawnColor = new VBox(10, blackPawnLabel, blackPawnCircle);

        Label blackScoreLabel = new Label("Score");
        blackScoreValue = new Label(String.valueOf(
                game.getScore(PlayerColor.BLACK)));
        VBox blackScoreBox = new VBox(10, blackScoreLabel, blackScoreValue);

        StackPane blackScore = new StackPane(blackRec,
                new HBox(10, blackName, blackPawnColor, blackScoreBox));

        Rectangle whiteRec = new Rectangle(225, 50, Color.LIGHTGREEN);

        Text whiteNameLabel = new Text("Name");
        Text whitePlayerName = new Text(game.getPlayerName(PlayerColor.WHITE));
        VBox whiteName = new VBox(10, whiteNameLabel, whitePlayerName);

        Label whitePawnLabel = new Label("Pawn");
        Circle whitePawnCircle = new Circle(5, Color.WHITE);
        VBox whitePawnColor = new VBox(10, whitePawnLabel, whitePawnCircle);

        Label whiteScoreLabel = new Label("Score");
        whiteScoreValue = new Label(String.valueOf(
                game.getScore(PlayerColor.WHITE)));
        VBox whiteScoreBox = new VBox(10, whiteScoreLabel, whiteScoreValue);

        StackPane whiteScore = new StackPane(whiteRec,
                new HBox(10, whiteName, whitePawnColor, whiteScoreBox));

        whiteScore.setAlignment(Pos.TOP_CENTER);
        blackScore.setAlignment(Pos.TOP_CENTER);

        getChildren().addAll(blackScore, whiteScore);
        setSpacing(10);
    }

    @Override
    public void update() {
        blackScoreValue.setText(String.valueOf(game.getScore(PlayerColor.BLACK)));
        whiteScoreValue.setText(String.valueOf(game.getScore(PlayerColor.WHITE)));
    }
}
