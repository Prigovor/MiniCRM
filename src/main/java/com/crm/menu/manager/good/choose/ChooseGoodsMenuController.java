package com.crm.menu.manager.good.choose;

import com.crm.database.entity.good.Good;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

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

    public Label labelOrderSum;

    private ChooseGoodsMenuModel model = new ChooseGoodsMenuModel();

    public ChooseGoodsMenuModel getModel()
    {
        return model;
    }

    @FXML
    public void initialize()
    {
        listViewStore.setItems(FXCollections.observableList(model.getListStoreGoods()));
        listViewChosen.setItems(FXCollections.observableList(model.getListChosenGoods()));

        labelOrderSum.setText(String.valueOf(model.getOrderSum()));

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

        buttonConfirm.setOnAction(event ->
        {
            model.confirm();
        });

        buttonBack.setOnAction(event ->
        {
            model.back();
        });

        buttonCancel.setOnAction(event ->
        {
            model.cancel();
        });
    }

    private void refreshView()
    {
        listViewStore.setItems(FXCollections.emptyObservableList());
        listViewChosen.setItems(FXCollections.emptyObservableList());

        listViewStore.setItems(FXCollections.observableList(model.getListStoreGoods()));
        listViewChosen.setItems(FXCollections.observableList(model.getListChosenGoods()));

        labelOrderSum.setText(String.valueOf(model.getOrderSum()));
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
