package com.crm.menu.order.manager.good.choose;

import com.crm.entity.good.Good;
import com.crm.menu.View;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

/**
 * Created by Bohdan on 16.02.2017.
 */
public class ChooseGoodsMenuView implements View
{
    private GridPane gridPane = new GridPane();

    private ListView<Good> listViewStoreGoods = new ListView<>();
    private ListView<Good> listViewChosenGoods = new ListView<>();

    private Button buttonAddGood = new Button("Add good");
    private Button buttonRemoveGood = new Button("Remove good");

    private ChooseGoodsMenuController controller;

    public ListView<Good> getListViewStoreGoods()
    {
        return listViewStoreGoods;
    }

    public ListView<Good> getListViewChosenGoods()
    {
        return listViewChosenGoods;
    }

    @Override
    public Parent getParent()
    {
        return gridPane;
    }

    public ChooseGoodsMenuView(ChooseGoodsMenuController controller)
    {
        this.controller = controller;
        init();
    }

    @Override
    public void init()
    {
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        gridPane.add(listViewStoreGoods, 0, 0);
        gridPane.add(listViewChosenGoods, 1, 0);
        gridPane.add(buttonAddGood, 0, 1);
        gridPane.add(buttonRemoveGood, 1, 1);

        buttonAddGood.setOnAction(event ->
        {
            controller.addGood();
        });

        buttonRemoveGood.setOnAction(event ->
        {
            controller.removeGood();
        });
    }

    public void refreshView()
    {
        listViewStoreGoods.getItems().clear();
        controller.getModel().getListStoreGoods().forEach(good ->
        {
            listViewStoreGoods.getItems().add(good);
        });

        listViewChosenGoods.getItems().clear();
        controller.getModel().getListChosenGoods().forEach(good ->
        {
            listViewChosenGoods.getItems().add(good);
        });
    }
}
