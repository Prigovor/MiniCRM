package com.crm.menu.order_manager.order.create.input.client;

import com.crm.database.entity.client.Client;
import com.crm.database.service.FactoryService;
import com.crm.main.Main;
import com.crm.menu.order_manager.order.create.OrderCreationModel;

import java.util.List;

/**
 * Created by Bohdan on 14.03.2017.
 */
public class ChooseClientModel
{
    public List<Client> getListClients()
    {
        return FactoryService.getClientService().getEntries();
    }

    public void setOrderToClient(Client client)
    {
        OrderCreationModel.getInstance().getOrder().setClient(client);
    }

    public void confirm()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/order/create/input/good/good-choose-menu.fxml");
    }

    public void back()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/order_manager/order/order-management-menu.fxml");
    }

    public void cancel()
    {
        OrderCreationModel.getInstance().close();
    }
}
