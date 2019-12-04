package esi.atl.g52196.view;

import esi.atl.g52196.dp.Observer;
import esi.atl.g52196.model.Game;
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

    private Game game;
    private Label whiteScoreValue;
    private Label blackScoreValue;

    Scores(Game game) {
        this.game = game;
        game.registerObserver(this);
        Rectangle blackRec = new Rectangle(225, 50, Color.DARKGREY);

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

        HBox unnamed = new HBox(10, blackName, blackPawnColor, blackScoreBox);
        StackPane blackScore = new StackPane(blackRec, unnamed);

        Rectangle whiteRec = new Rectangle(225, 50, Color.LIGHTGREY);

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

        HBox unnamed2 = new HBox(10, whiteName, whitePawnColor, whiteScoreBox);
        StackPane whiteScore = new StackPane(whiteRec, unnamed2);

        whiteScore.setAlignment(Pos.TOP_CENTER);
        blackScore.setAlignment(Pos.TOP_CENTER);

        getChildren().addAll(whiteScore, blackScore);
        setSpacing(10);
    }

    @Override
    public void update() {
        System.out.println(game.getScore(PlayerColor.BLACK));
        blackScoreValue.setText(String.valueOf(game.getScore(PlayerColor.BLACK)));
        whiteScoreValue.setText(String.valueOf(game.getScore(PlayerColor.WHITE)));
    }
}