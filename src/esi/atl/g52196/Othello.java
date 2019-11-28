package esi.atl.g52196;

import esi.atl.g52196.view.CustomMenu;
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
        BorderPane root = new BorderPane();

        CustomMenu menu = new CustomMenu();

        root.setTop(menu);
        Scene scene = new Scene(root, 1000, 750);
        primaryStage.setTitle("Othello");
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
