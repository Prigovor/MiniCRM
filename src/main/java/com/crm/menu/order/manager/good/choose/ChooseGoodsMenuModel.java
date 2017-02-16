package com.crm.menu.order.manager.good.choose;

import com.crm.entity.good.Good;
import com.crm.service.good.GoodService;
import com.crm.service.good.GoodServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bohdan on 16.02.2017.
 */
public class ChooseGoodsMenuModel
{
    private GoodService goodService = new GoodServiceImpl();

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

    public ChooseGoodsMenuModel()
    {
        for (int i = 0; i < 10; i++)
        {
            listStoreGoods.add(new Good((long) i, "Good" + i, 10, 890D, null));
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
                listChosenGoods.add(new Good(good.getId(), good.getNomination(), 1, good.getPrice(), good.getOrder()));
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

        if (amountOfGoodInChosen == 0)
        {
            listChosenGoods.remove(goodInChosen);
        }
    }

    public void confirm()
    {
        listChosenGoods.forEach(good ->
        {

        });
    }

    public void cancel()
    {

    }

    public void back()
    {

    }
}
