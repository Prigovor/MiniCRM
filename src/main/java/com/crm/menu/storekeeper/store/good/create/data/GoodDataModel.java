package com.crm.menu.storekeeper.store.good.create.data;

import com.crm.database.entity.good.Good;
import com.crm.database.validation.DataValidator;

/**
 * Created by Bohdan on 14.03.2017.
 */
public class GoodDataModel
{
    public void setGoodData(String nomination, String description, Integer amount, Double price)
    {
        Good good = GoodCreationModel.getInstance().getGoodToCreate();

        good.setNomination(nomination);
        good.setDescription(description);
        good.setAmount(amount);
        good.setPrice(price);

        DataValidator.getInstance().validateNotBlankField(nomination, 1, "nomination");
    }

    public void confirm()
    {
        GoodCreationModel.getInstance().saveGood();
        GoodCreationModel.getInstance().close();
    }

    public void cancel()
    {
        GoodCreationModel.getInstance().close();
    }
}
