package esi.atl.g52196.view;

import esi.atl.g52196.model.Pawn;
import esi.atl.g52196.model.PlayerColor;
import static java.lang.Math.sqrt;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author 52196
 */
public class Tile extends StackPane {

    Tile(double width, double height, Pawn pawn) {
        setPrefSize(width + 2, height + 2);
        Rectangle tile = new Rectangle(width, height);
        Circle circle = new Circle(sqrt(width * width + height * height) / 3);
        tile.setFill(Color.DARKGREEN);
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
    }
}
