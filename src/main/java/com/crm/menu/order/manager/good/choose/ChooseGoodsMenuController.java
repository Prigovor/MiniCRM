package com.crm.menu.order.manager.good.choose;

import com.crm.menu.Controller;
import com.crm.menu.View;

/**
 * Created by Bohdan on 16.02.2017.
 */
public class ChooseGoodsMenuController implements Controller
{
    private ChooseGoodsMenuView view = new ChooseGoodsMenuView(this);

    @Override
    public View getView()
    {
        return view;
    }

    private ChooseGoodsMenuModel model = new ChooseGoodsMenuModel();

    public ChooseGoodsMenuModel getModel()
    {
        return model;
    }

    public ChooseGoodsMenuController()
    {
        view.refreshView();
    }

    public void addGood()
    {
        model.addGood(view.getListViewStoreGoods().getSelectionModel().getSelectedItem());
        view.refreshView();
    }

    public void removeGood()
    {
        model.removeGood(view.getListViewChosenGoods().getSelectionModel().getSelectedItem());
        view.refreshView();
    }
}
