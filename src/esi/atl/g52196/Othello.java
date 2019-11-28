package esi.atl.g52196;

import esi.atl.g52196.model.Game;
import esi.atl.g52196.view.CustomMenu;
import esi.atl.g52196.view.GameBoard;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author g52196
 */
public class Othello extends Application {

    @Override
    public void start(Stage primaryStage) {
        Game game = new Game();
        game.initialize();

        BorderPane root = new BorderPane();
        CustomMenu menu = new CustomMenu();
        VBox leftPane = new VBox(20);
        GameBoard board = new GameBoard(game.getBoard());

        leftPane.getChildren().add(board);
        root.setTop(menu);
        root.setLeft(leftPane);
        Scene scene = new Scene(root, 999, 749);
        primaryStage.setTitle("OthelloFX++");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}