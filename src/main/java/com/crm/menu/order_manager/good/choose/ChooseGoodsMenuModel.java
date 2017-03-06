package com.crm.menu.order_manager.good.choose;

import com.crm.database.entity.good.Good;
import com.crm.database.entity.good.selected_good.SelectedGood;
import com.crm.database.entity.order.Order;
import com.crm.main.Main;
import com.crm.menu.order_manager.OrderManagerMenuModel;
import com.crm.menu.order_manager.good.info.GoodInfoMenuModel;

import java.util.List;

/**
 * Created by Bohdan on 16.02.2017.
 */
public class ChooseGoodsMenuModel
{
    private Order order = OrderManagerMenuModel.getInstance().getOrder();

    private List<Good> listStoreGoods = OrderManagerMenuModel.getInstance().getListStoreGoods();

    public List<Good> getListStoreGoods()
    {
        return listStoreGoods;
    }

    private List<SelectedGood> listChosenGoods = OrderManagerMenuModel.getInstance().getListChosenGoods();

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
        GoodInfoMenuModel.getInstance().setGood(good);
        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/good/good-info-menu.fxml");
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

        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/order/order-input-menu.fxml");
    }

    public void cancel()
    {
        OrderManagerMenuModel.getInstance().clearData();
        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/main/order-manager-main-menu.fxml");
    }

    public void back()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/client_input/client-input-menu.fxml");
    }
}
