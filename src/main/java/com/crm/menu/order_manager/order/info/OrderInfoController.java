package com.crm.menu.order_manager.order.info;

import com.crm.node.order.OrderInfo;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created by Bohdan on 14.03.2017.
 */
public class OrderInfoController
{
    public OrderInfo orderInfo;

    public Button buttonBack;

    private OrderInfoModel model = OrderInfoModel.getInstance();

    @FXML
    public void initialize()
    {
        orderInfo.setOrder(model.getOrder());

        buttonBack.setOnAction(event ->
        {
            model.back();
        });
    }
}
