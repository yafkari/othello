package esi.atl.g52196.view;

import esi.atl.g52196.dp.Observer;
import esi.atl.g52196.model.Game;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author 52196
 */
public class RightPane extends VBox implements Observer {

    private Label turn;
    private Game game;
    private Historic history;

    public RightPane(double padding, Game game) {
        super(padding);
        this.game = game;
        game.registerObserver(this);

        Label turnLabel = new Label("Turn: ");
        turn = new Label(game.getPlayerName(game.getCurrentColor()));
        Scores scores = new Scores(game);
        history = new Historic(game.getHistory());

        setPrefSize(500, 600);
        setPadding(new Insets(10));
        getChildren().addAll(
                new VBox(new HBox(20, turnLabel, turn), scores), history);
    }

    @Override
    public void update() {
        turn.setText(game.getPlayerName(game.getCurrentColor()));
        history.setItems(game.getHistory());
    }
}
