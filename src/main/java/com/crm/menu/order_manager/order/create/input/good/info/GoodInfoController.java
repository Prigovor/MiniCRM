package com.crm.menu.order_manager.order.create.input.good.info;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.IOException;

/**
 * Created by Bohdan on 17.02.2017.
 */
public class GoodInfoController
{
    public Button buttonOK;
    public TextArea textAreaDescription;

    private GoodInfoModel model = GoodInfoModel.getInstance();

    public GoodInfoController()
    {
    }

    @FXML
    public void initialize()
    {
        textAreaDescription.setText(model.getGood().getDescription());

        buttonOK.setOnAction(event ->
        {
            backToChooseGoodMenu();
        });
    }

    public void backToChooseGoodMenu()
    {
        try
        {
            model.backToGoodChoseMenu();
        }
        catch (IOException e)
        {

        }
    }
}
