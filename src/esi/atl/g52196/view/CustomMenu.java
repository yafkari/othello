package esi.atl.g52196.view;

import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 *
 * @author 52196
 */
public class CustomMenu extends MenuBar {

    public CustomMenu() {
        Menu menuFile = new Menu("File");
        MenuItem menuItemExit = new MenuItem("Exit");
        menuItemExit.setOnAction((ActionEvent e) -> {
            System.exit(0);
        });
        menuFile.getItems().add(menuItemExit);
        getMenus().add(menuFile);
    }
}
