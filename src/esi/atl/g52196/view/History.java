package esi.atl.g52196.view;

import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author 52196
 */
public class History extends TableView {

    public History(ObservableList list) {
        super(list);
        setPlaceholder(new Label("No rows to display"));
        setEditable(false);
        TableColumn idCol = new TableColumn("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn nameCol = new TableColumn("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("playerName"));

        TableColumn actionCol = new TableColumn("Action");
        actionCol.setCellValueFactory(new PropertyValueFactory<>("action"));

        TableColumn positionCol = new TableColumn("Position");
        positionCol.setCellValueFactory(new PropertyValueFactory<>("position"));

        idCol.setMinWidth(30);
        nameCol.setMinWidth(120);
        actionCol.setMinWidth(175);
        positionCol.setMinWidth(30);

        getColumns().setAll(idCol, nameCol, actionCol, positionCol);
    }
}
