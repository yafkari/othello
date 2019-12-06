package esi.atl.g52196;

import esi.atl.g52196.model.Game;
import esi.atl.g52196.view.CustomMenu;
import esi.atl.g52196.view.LeftPane;
import esi.atl.g52196.view.RightPane;
import esi.atl.g52196.view.StartPage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author g52196
 */
public class Othello extends Application {

    Game game;

    @Override
    public void start(Stage primaryStage) {
        game = new Game();
        StartPage startPage = new StartPage(game);
        startPage.show();
        startPage.setOnHiding(e -> initializeGame(primaryStage));

    }

    private void initializeGame(Stage primaryStage) {
        game.initialize();

        BorderPane root = new BorderPane();
        CustomMenu menu = new CustomMenu();
        LeftPane leftPane = new LeftPane(20, game);
        RightPane rightPane = new RightPane(20, game);

        root.setTop(menu);
        root.setLeft(leftPane);
        root.setRight(rightPane);
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
