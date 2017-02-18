package com.crm.menu.order.manager.good.choose;

import com.crm.entity.good.Good;
import com.crm.main.Main;
import com.crm.menu.Controller;
import com.crm.menu.View;
import com.crm.menu.order.manager.good.info.GoodInfoMenuModel;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.io.IOException;

/**
 * Created by Bohdan on 16.02.2017.
 */
public class ChooseGoodsMenuController
{
    public Button buttonBack;
    public Button buttonConfirm;
    public Button buttonCancel;

    public ListView listViewStore;
    public ListView listViewChosen;

    private ChooseGoodsMenuModel model = ChooseGoodsMenuModel.getInstance();

    public ChooseGoodsMenuModel getModel()
    {
        return model;
    }

    @FXML
    public void initialize()
    {
        listViewStore.setItems(FXCollections.observableList(model.getListStoreGoods()));
        listViewChosen.setItems(FXCollections.observableList(model.getListChosenGoods()));

        listViewStore.setOnMouseClicked(event ->
        {
            switch (event.getButton())
            {
                case PRIMARY:
                {
                    addGood();
                    break;
                }
                case SECONDARY:
                {
                    Good selectedGood = (Good) listViewStore.getSelectionModel().getSelectedItem();
                    if (selectedGood != null)
                    {
                        model.showGoodInfo(selectedGood);
                    }
                    break;
                }
            }
        });

        listViewChosen.setOnMouseClicked(event ->
        {
            switch (event.getButton())
            {
                case PRIMARY:
                {
                    removeGood();
                    break;
                }
                case SECONDARY:
                {
                    Good selectedGood = (Good) listViewChosen.getSelectionModel().getSelectedItem();
                    if (selectedGood != null)
                    {
                        model.showGoodInfo(selectedGood);
                    }
                    break;
                }
            }
        });
    }

    private void refreshView()
    {
        listViewStore.setItems(FXCollections.emptyObservableList());
        listViewChosen.setItems(FXCollections.emptyObservableList());

        listViewStore.setItems(FXCollections.observableList(model.getListStoreGoods()));
        listViewChosen.setItems(FXCollections.observableList(model.getListChosenGoods()));
    }

    public void addGood()
    {
        Good selectedGood = (Good) listViewStore.getSelectionModel().getSelectedItem();

        if (selectedGood != null)
        {
            model.addGood(selectedGood);
            refreshView();
        }
    }

    public void removeGood()
    {
        Good selectedGood = (Good) listViewChosen.getSelectionModel().getSelectedItem();

        if (selectedGood != null)
        {
            model.removeGood(selectedGood);
            refreshView();
        }
    }
}
