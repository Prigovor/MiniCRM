package com.crm.menu.storekeeper.main;

import com.crm.database.entity.good.Good;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.lang.reflect.Field;

/**
 * Created by Bohdan on 26.02.2017.
 */
public class StorekeeperMainMenuController
{
    public TableView tableViewGoods;

    public Button buttonGiveGoods;
    public Button buttonRefresh;
    public Button buttonLogOut;

    private StorekeeperMainMenuModel model = new StorekeeperMainMenuModel();

    @FXML
    public void initialize()
    {
        refreshView();

        buttonGiveGoods.setOnAction(event ->
        {
            model.openGiveGoodsMenu();
        });

        buttonRefresh.setOnAction(event ->
        {
            refreshView();
        });

        buttonLogOut.setOnAction(event ->
        {
            model.logOut();
        });
    }

    public void refreshView()
    {
        tableViewGoods.setItems(FXCollections.observableList(model.getListGoods()));

        tableViewGoods.getColumns().clear();
        for (Field field : Good.class.getDeclaredFields())
        {
            TableColumn tableColumn = new TableColumn(field.getName());
            tableColumn.setCellValueFactory(new PropertyValueFactory<>(field.getName()));
            tableViewGoods.getColumns().add(tableColumn);
        }
    }
}
