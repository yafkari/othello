package esi.atl.g52196;

import esi.atl.g52196.model.Observer;
import esi.atl.g52196.model.Game;
import esi.atl.g52196.view.CustomMenu;
import esi.atl.g52196.view.GameOver;
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
public class Othello extends Application implements Observer {

    private Game game;
    private Stage stage;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        StartPage startPage = new StartPage();
        startPage.submitButton.setOnAction(e -> {
            game = (Game) startPage.getData();
            game.registerObserver(this);
            game.initialize();
            stage.hide();
            initializeGame();
        });

        stage.setScene(new Scene(startPage, 300, 150));
        stage.setTitle("OthelloFX++");
        stage.setResizable(false);
        stage.show();
    }

    private void initializeGame() {
        BorderPane root = new BorderPane();
        CustomMenu menu = new CustomMenu(game);
        LeftPane leftPane = new LeftPane(20, game);
        RightPane rightPane = new RightPane(20, game);

        root.setTop(menu);
        root.setLeft(leftPane);
        root.setRight(rightPane);
        Scene scene = new Scene(root, 999, 749);

        stage.setScene(scene);
        stage.setX(300);
        stage.setY(200);
        stage.show();
    }

    @Override
    public void update() {
        if (game.isOver()) {
            GameOver end = new GameOver(game, false);
            end.setOnHidden(e -> stage.close());
        }
    }
}
