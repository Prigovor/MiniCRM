package com.crm.menu.storekeeper.store;

import com.crm.database.entity.good.Good;
import com.crm.database.entity.good.selected_good.SelectedGood;
import com.crm.database.service.FactoryService;
import com.crm.main.Main;
import com.crm.menu.storekeeper.store.good.GoodCreationModel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by Bohdan on 13.03.2017.
 */
@Getter @Setter
public class StoreManagementModel
{
    private Good selectedGood;

    public void addGood()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/storekeeper/store/good/set-good-data-menu.fxml");
    }

    public void changeGood()
    {
        GoodCreationModel.getInstance().setGoodToCreate(selectedGood);
        Main.getInstance().replaceSceneContent("/com/crm/menu/storekeeper/store/good/set-good-data-menu.fxml");
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
        return FactoryService.getGoodService().getEntries();
    }

    public List<SelectedGood> getListSelectedGoods()
    {
        return FactoryService.getSelectedGoodService().getEntries();
    }

    public void back()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/storekeeper/storekeeper-menu.fxml");
    }
}
