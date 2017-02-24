package com.crm.menu.manager.good.choose;

import com.crm.entity.good.Good;
import com.crm.entity.good.SelectedGood;
import com.crm.entity.order.Order;
import com.crm.main.Main;
import com.crm.menu.manager.OrderManagerMenuModel;
import com.crm.menu.manager.good.info.GoodInfoMenuModel;
import com.crm.service.good.GoodService;
import com.crm.service.good.GoodServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bohdan on 16.02.2017.
 */
public class ChooseGoodsMenuModel
{
    private GoodService goodService = new GoodServiceImpl();

    private Order order = OrderManagerMenuModel.getInstance().getOrder();

    private List<Good> listStoreGoods = new ArrayList<>();

    public List<Good> getListStoreGoods()
    {
        return listStoreGoods;
    }

    private List<SelectedGood> listChosenGoods = new ArrayList<>();

    public List<SelectedGood> getListChosenGoods()
    {
        return listChosenGoods;
    }

    private Double orderSum = 0.0;

    public Double getOrderSum()
    {
        return orderSum;
    }

    private static ChooseGoodsMenuModel instance;

    public static ChooseGoodsMenuModel getInstance()
    {
        if (instance == null)
        {
            instance = new ChooseGoodsMenuModel();
        }

        return instance;
    }

    private ChooseGoodsMenuModel()
    {
        listStoreGoods.addAll(goodService.findAll());
    }

    public void showGoodInfo(Good good)
    {
        try
        {
            GoodInfoMenuModel.getInstance().setGood(good);
            Main.getInstance().replaceSceneContent("/fxml-files/good-info-menu.fxml");
        }
        catch (IOException e)
        {
        }
    }

    public void addGood(Good good)
    {
        int indexStoreGood = listStoreGoods.indexOf(good);
        Good goodInStore = listStoreGoods.get(indexStoreGood);

        Integer amountOfGoodInStore = goodInStore.getAmount();
        if (amountOfGoodInStore > 0)
        {
            goodInStore.setAmount(amountOfGoodInStore - 1);

            int indexChosenGood = listChosenGoods.indexOf(good);
            if (indexChosenGood > -1)
            {
                Good goodInChosen = listChosenGoods.get(indexChosenGood);
                Integer amountOfGoodInChosen = goodInChosen.getAmount();
                goodInChosen.setAmount(amountOfGoodInChosen + 1);
            }
            else
            {
                SelectedGood goodToAdd = new SelectedGood(good.getNomination(), 1, good.getPrice(), order);
                goodToAdd.setDescription(good.getDescription());

                listChosenGoods.add(goodToAdd);
            }

            orderSum += goodInStore.getPrice();
        }
    }

    public void removeGood(Good good)
    {
        int indexChosenGood = listChosenGoods.indexOf(good);
        Good goodInChosen = listChosenGoods.get(indexChosenGood);

        Integer amountOfGoodInChosen = goodInChosen.getAmount();
        if (amountOfGoodInChosen > 0)
        {
            goodInChosen.setAmount(amountOfGoodInChosen - 1);

            int indexStoreGood = listStoreGoods.indexOf(good);
            Good goodInStore = listStoreGoods.get(indexStoreGood);

            Integer amountOfGoodInStore = goodInStore.getAmount();
            goodInStore.setAmount(amountOfGoodInStore + 1);

            orderSum -= goodInChosen.getPrice();
        }

        if (goodInChosen.getAmount() == 0)
        {
            listChosenGoods.remove(goodInChosen);
        }
    }

    public void confirm()
    {
        order.setGoods(listChosenGoods);
        order.setOrderPrice(orderSum);

        try
        {
            Main.getInstance().replaceSceneContent("/fxml-files/order-input-menu.fxml");
        }
        catch (IOException e)
        {
        }
    }

    public void cancel()
    {
        OrderManagerMenuModel.getInstance().clearData();
        try
        {
            Main.getInstance().replaceSceneContent("/fxml-files/order-manager-main-menu.fxml");
        }
        catch (IOException e)
        {
        }
    }

    public void back()
    {
        try
        {
            Main.getInstance().replaceSceneContent("/fxml-files/client-input-menu.fxml");
        }
        catch (IOException e)
        {
        }
    }
}
