package esi.atl.g52196;

import esi.atl.g52196.model.Game;
import esi.atl.g52196.view.CustomMenu;
import esi.atl.g52196.view.LeftPane;
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

    @Override
    public void start(Stage primaryStage) {

        StartPage startPage = new StartPage();
        startPage.show();
        startPage.setOnHiding(e -> primaryStage.show());

        Game game = new Game(startPage.getBlackName(), startPage.getWhiteName());
        game.initialize();

        BorderPane root = new BorderPane();
        CustomMenu menu = new CustomMenu();
        LeftPane leftPane = new LeftPane(20, game);

        root.setTop(menu);
        root.setLeft(leftPane);
        Scene scene = new Scene(root, 999, 749);
        primaryStage.setTitle("OthelloFX++");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
