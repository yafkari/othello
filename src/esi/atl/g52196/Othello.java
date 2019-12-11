package esi.atl.g52196;

import esi.atl.g52196.model.Observer;
import esi.atl.g52196.model.Game;
import esi.atl.g52196.view.GameOver;
import esi.atl.g52196.view.StartPage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author g52196
 */
public class Othello extends Application implements Observer {

    Game game;
    Scene scene;

    @Override
    public void start(Stage primaryStage) {
        game = new Game();
        game.initialize();
        game.registerObserver(this);

        StartPage startPage = new StartPage(game);
        primaryStage.setScene(new Scene(startPage, 300, 150));
        primaryStage.setTitle("OthelloFX++");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void update() {
        if (game.isOver()) {
            try {
                scene.getWindow().hide();
                GameOver end = new GameOver(game, false);
                end.show();
            } catch (Exception ex) {
            }
        }
    }
}
