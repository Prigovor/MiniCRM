package com.crm.menu.storekeeper.store;

import com.crm.database.entity.good.Good;
import com.crm.database.entity.good.selected_good.SelectedGood;
import com.crm.node.good.GoodInfo;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.lang.reflect.Field;

/**
 * Created by Bohdan on 13.03.2017.
 */
public class StoreManagementController
{
    @FXML
    private GoodInfo goodInfo;

    @FXML
    private ListView<Good> listViewGoods;

    @FXML
    private Button buttonShowGoodInfo;

    @FXML
    private Button buttonDeleteGood;

    @FXML
    private Button buttonChangeGood;

    @FXML
    private Button buttonAddGood;

    @FXML
    private Button buttonGenerateGood;

    @FXML
    private Button buttonShowAllGoods;

    @FXML
    private Button buttonShowAllSelectedGoods;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonRefresh;

    @FXML
    private TableView tableView;

    private StoreManagementModel model = new StoreManagementModel();

    @FXML
    public void initialize()
    {
        listViewGoods.setItems(FXCollections.observableList(model.getListGoods()));

        listViewGoods.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
        {
            model.setSelectedGood(newValue);
        });

        buttonShowGoodInfo.setOnAction(event ->
        {
            showGoodInfo();
        });

        buttonShowAllGoods.setOnAction(event ->
        {
            showAllGoods();
        });

        buttonShowAllSelectedGoods.setOnAction(event ->
        {
            showAllSelectedGoods();
        });

        buttonAddGood.setOnAction(event ->
        {
            addGood();
        });

        buttonChangeGood.setOnAction(event ->
        {
            changeGood();
        });

        buttonDeleteGood.setOnAction(event ->
        {
            deleteGood();
        });

        buttonGenerateGood.setOnAction(event ->
        {
            generateGood();
        });

        buttonRefresh.setOnAction(event ->
        {
            refresh();
        });

        buttonBack.setOnAction(event ->
        {
            back();
        });
    }

    private void showAllGoods()
    {
        goodInfo.setOpacity(0.0);
        tableView.setOpacity(1.0);
        tableView.setDisable(false);

        tableView.setItems(FXCollections.observableList(model.getListGoods()));

        tableView.getColumns().clear();
        for (Field field : Good.class.getDeclaredFields())
        {
            if (field.getName().equals("description"))
            {
                continue;
            }
            TableColumn tableColumn = new TableColumn(field.getName());
            tableColumn.setCellValueFactory(new PropertyValueFactory<>(field.getName()));
            tableView.getColumns().add(tableColumn);
        }
    }

    private void showAllSelectedGoods()
    {
        goodInfo.setOpacity(0.0);
        tableView.setOpacity(1.0);
        tableView.setDisable(false);

        tableView.setItems(FXCollections.observableList(model.getListSelectedGoods()));

        tableView.getColumns().clear();
        for (Field field : SelectedGood.class.getDeclaredFields())
        {
            TableColumn tableColumn = new TableColumn(field.getName());
            tableColumn.setCellValueFactory(new PropertyValueFactory<>(field.getName()));
            tableView.getColumns().add(tableColumn);
        }
    }

    private void showGoodInfo()
    {
        tableView.setOpacity(0.0);
        tableView.setDisable(true);
        goodInfo.setOpacity(1.0);

        if (model.getSelectedGood() != null)
        {
            goodInfo.setGood(model.getSelectedGood());
        }
        else
        {
            showInformationMessage("Select good in left-side list");
        }
    }

    private void addGood()
    {
        model.addGood();
    }

    private void changeGood()
    {
        if (model.getSelectedGood() != null)
        {
            model.changeGood();
        }
        else
        {
            showInformationMessage("Select good in left-side list");
        }
    }

    private void deleteGood()
    {
        if (model.getSelectedGood() != null)
        {
            model.deleteGood();
        }
        else
        {
            showInformationMessage("Select good in left-side list");
        }
    }

    private void generateGood()
    {
        model.generateGood();
    }

    private void refresh()
    {
        listViewGoods.setItems(FXCollections.observableList(model.getListGoods()));

        tableView.getItems().clear();
        goodInfo.clear();
    }

    private void back()
    {
        model.back();
    }

    private void showInformationMessage(String text)
    {
        new Alert(Alert.AlertType.INFORMATION, text).showAndWait();
    }
}
