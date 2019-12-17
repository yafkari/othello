package esi.atl.g52196.view;

import esi.atl.g52196.model.Model;
import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 *
 * @author 52196
 */
public class CustomMenu extends MenuBar {

    public CustomMenu(Model game) {
        Menu menuFile = new Menu("File");
        MenuItem menuItemExit = new MenuItem("Exit");
        menuItemExit.setOnAction((ActionEvent e) -> {
            System.exit(0);
        });
        MenuItem menuItemInfo = new MenuItem("Info");
        menuItemInfo.setOnAction((ActionEvent e) -> {
            new InformationWindow(game).show();
        });
        menuFile.getItems().addAll(menuItemInfo, menuItemExit);
        getMenus().add(menuFile);
    }
}
