package com.crm.menu.order_manager.order.create.input.good;

import com.crm.database.entity.good.Good;
import com.crm.database.entity.good.selected_good.SelectedGood;
import com.crm.database.entity.order.Order;
import com.crm.main.Main;
import com.crm.menu.order_manager.order.create.OrderCreationModel;
import com.crm.menu.order_manager.order.create.input.good.info.GoodInfoModel;

import java.util.List;

/**
 * Created by Bohdan on 16.02.2017.
 */
public class ChooseGoodsModel
{
    private Order order = OrderCreationModel.getInstance().getOrder();

    private List<Good> listStoreGoods = OrderCreationModel.getInstance().getListStoreGoods();

    private List<SelectedGood> listChosenGoods = OrderCreationModel.getInstance().getListChosenGoods();

    public List<Good> getListStoreGoods()
    {
        return listStoreGoods;
    }

    public List<SelectedGood> getListChosenGoods()
    {
        return listChosenGoods;
    }

    private Double orderSum;

    public Double getOrderSum()
    {
        orderSum = 0.0;
        for (SelectedGood selectedGood : listChosenGoods)
        {
            orderSum += selectedGood.getPrice() * selectedGood.getAmount();
        }
        return orderSum;
    }

    public void showGoodInfo(Good good)
    {
        GoodInfoModel.getInstance().setGood(good);
        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/order/creation/input/good/good-info-menu.fxml");
    }

    public void addGood(Good good)
    {
        int indexStoreGood = listStoreGoods.indexOf(good);
        Good goodInStore = listStoreGoods.get(indexStoreGood);

        Integer amountOfGoodInStore = goodInStore.getAmount();
        if (amountOfGoodInStore > 0)
        {
            int indexChosenGood = listChosenGoods.indexOf(good);
            if (indexChosenGood > -1)
            {
                listChosenGoods.get(indexChosenGood).incAmount();
            }
            else
            {
                SelectedGood goodToAdd = new SelectedGood(good, order);
                goodToAdd.incAmount();

                listChosenGoods.add(goodToAdd);
            }

            orderSum += goodInStore.getPrice();
        }
    }

    public void removeGood(Good good)
    {
        int indexChosenGood = listChosenGoods.indexOf(good);
        SelectedGood goodInChosen = listChosenGoods.get(indexChosenGood);

        Integer amountOfGoodInChosen = goodInChosen.getAmount();
        if (amountOfGoodInChosen > 0)
        {
            goodInChosen.decAmount();

            orderSum -= goodInChosen.getPrice();
        }
    }

    public void confirm()
    {
        order.setGoods(listChosenGoods);
        order.setOrderPrice(orderSum);

        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/order/create/input/order/order-input-menu.fxml");
    }

    public void cancel()
    {
        OrderCreationModel.getInstance().close();
    }

    public void back()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/order/create/input/client/client-choose-menu.fxml");
    }
}
