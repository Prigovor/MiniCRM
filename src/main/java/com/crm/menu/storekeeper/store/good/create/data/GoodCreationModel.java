package com.crm.menu.storekeeper.store.good.create.data;

import com.crm.database.entity.good.Good;
import com.crm.database.service.FactoryService;
import com.crm.main.Main;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Bohdan on 13.03.2017.
 */
@Getter @Setter
public class GoodCreationModel
{
    private static final GoodCreationModel instance = new GoodCreationModel();

    public static GoodCreationModel getInstance()
    {
        return instance;
    }

    private GoodCreationModel()
    {

    }

    private Good goodToCreate = new Good();

    public void saveGood()
    {
        FactoryService.getGoodService().saveOrUpdate(goodToCreate);
    }

    public void close()
    {
        goodToCreate = new Good();
        Main.getInstance().replaceSceneContent("/com/crm/menu/storekeeper/store/store-management-menu.fxml");
    }
}
