package esi.atl.g52196.view;

import esi.atl.g52196.model.Observer;
import esi.atl.g52196.model.Model;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author 52196
 */
public class RightPane extends VBox implements Observer {

    private final Label turn;
    private final Model game;
    private final History history;

    public RightPane(double padding, Model game) {
        super(padding);
        this.game = game;
        game.registerObserver(this);

        Label turnLabel = new Label("Turn: ");
        turn = new Label(game.getPlayerName(game.getCurrent().getColor()));
        Scores scores = new Scores(game);
        history = new History(game.getHistory());

        setPrefSize(500, 600);
        setPadding(new Insets(10));
        getChildren().addAll(
                new VBox(new HBox(20, turnLabel, turn), scores), history);
    }

    @Override
    public void update() {
        turn.setText(game.getPlayerName(game.getCurrent().getColor()));
        history.setItems(game.getHistory());
        history.scrollTo(history.getItems().size() - 1);
    }
}
