package esi.atl.g52196.view;

import esi.atl.g52196.model.Model;
import esi.atl.g52196.model.Pawn;
import esi.atl.g52196.model.PlayerColor;
import esi.atl.g52196.model.Position;
import static java.lang.Math.sqrt;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author 52196
 */
public class Tile extends StackPane {

    private final Model game;
    private final Position position;

    Tile(double width, double height, Position position, Model game) {
        this.game = game;
        this.position = position;

        setPrefSize(width + 2, height + 2);
        Rectangle tile = new Rectangle(width, height);
        Circle circle = new Circle(sqrt(width * width + height * height) / 3);
        if (game.getBonusPositions().contains(position)) {
            tile.setFill(Color.BURLYWOOD);
        } else {
            tile.setFill(Color.DARKGREEN);
        }

        Pawn pawn = game.getBoard().getPawn(position);
        if (pawn != null) {
            Text valueText = new Text(String.valueOf(pawn.getValue()));
            valueText.setFont(Font.font(30));
            if (pawn.getColor() == PlayerColor.BLACK) {
                valueText.setFill(Color.BLACK);
                circle.setFill(Color.rgb(0, 0, 0, 0.3));
            } else {
                valueText.setFill(Color.WHITE);
                circle.setFill(Color.rgb(255, 255, 255, 0.3));
            }
            getChildren().addAll(tile, circle, valueText);
        } else {
            getChildren().add(tile);
        }

        addEventHandler(MouseEvent.MOUSE_ENTERED, e -> handleMouseEntered(e));
        addEventHandler(MouseEvent.MOUSE_EXITED, e -> handleMouseExited(e));
        setOnMouseClicked(e -> handleMouseClicked(e));
    }

    private void handleMouseEntered(MouseEvent event) {
        StackPane tile1 = (StackPane) event.getSource();
        Rectangle r = (Rectangle) tile1.getChildren().get(0);
        if (game.getBoard().isEmpty(position)) {
            if (game.getPossibleMoves().contains(this.position)) {
                r.setFill(Color.LIGHTGREEN);
            } else {
                r.setFill(Color.RED);
            }
        }
    }

    private void handleMouseExited(MouseEvent event) {
        StackPane tile1 = (StackPane) event.getSource();
        Shape tile = (Shape) tile1.getChildren().get(0);
        if (game.getBonusPositions().contains(position)) {
            tile.setFill(Color.BURLYWOOD);
        } else {
            tile.setFill(Color.DARKGREEN);
        }
    }

    private void handleMouseClicked(MouseEvent event) {
        if (game.getPossibleMoves().contains(position)) {
            game.play(position);
        }
        event.consume();
    }
}
