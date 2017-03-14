package com.crm.menu.storekeeper.store;

import com.crm.database.entity.good.Good;
import com.crm.database.service.FactoryService;
import com.crm.main.Main;
import com.crm.menu.storekeeper.store.good.create.data.GoodCreationModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Bohdan on 13.03.2017.
 */
@Getter @Setter
public class StoreManagementModel
{
    private Good selectedGood;

    public void addGood()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/storekeeper/store/good/data/set-good-data-menu.fxml");
    }

    public void changeGood()
    {
        GoodCreationModel.getInstance().setGoodToCreate(selectedGood);
        Main.getInstance().replaceSceneContent("/com/crm/menu/storekeeper/store/good/data/set-good-data-menu.fxml");
    }

    public void deleteGood()
    {
        FactoryService.getGoodService().deleteEntry(selectedGood.getId());
    }

    public void generateGood()
    {

    }

    public List<Good> getListGoods()
    {
        return FactoryService.getGoodService().getEntries().stream().filter(good ->
        {
            return good.getClass().equals(Good.class);
        }).collect(Collectors.toList());
    }

    public void back()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/storekeeper/storekeeper-menu.fxml");
    }
}
