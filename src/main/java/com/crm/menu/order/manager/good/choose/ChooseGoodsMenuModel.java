package com.crm.menu.order.manager.good.choose;

import com.crm.entity.good.Good;
import com.crm.entity.order.Order;
import com.crm.main.Main;
import com.crm.menu.order.manager.OrderManagerMenuModel;
import com.crm.menu.order.manager.good.info.GoodInfoMenuModel;
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

    private List<Good> listChosenGoods = new ArrayList<>();

    public List<Good> getListChosenGoods()
    {
        return listChosenGoods;
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
        for (int i = 0; i < 10; i++)
        {
            Good good = new Good((long) i, "Good" + i, 10, 890D, null);
            good.setDescription("DESC of " + good.getNomination());
            listStoreGoods.add(good);
        }
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
            e.printStackTrace();
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
                Good goodToAdd = new Good(good.getId(), good.getNomination(), 1, good.getPrice(), good.getOrder());
                goodToAdd.setDescription(good.getDescription());

                listChosenGoods.add(goodToAdd);
            }
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
        }

        if (goodInChosen.getAmount() == 0)
        {
            listChosenGoods.remove(goodInChosen);
        }
    }

    public void confirm()
    {
        listChosenGoods.forEach(good ->
        {
            order.getGoods().add(good);
        });

        try
        {
            Main.getInstance().replaceSceneContent("/fxml-files/order-input-menu.fxml");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void cancel()
    {

    }

    public void back()
    {

    }
}
