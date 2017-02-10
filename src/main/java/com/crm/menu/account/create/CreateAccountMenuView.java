package com.crm.menu.account.create;

import com.crm.menu.View;
import com.crm.menu.node.custom.UserInfo;
import com.crm.menu.node.factory.NodeFactory;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import static com.crm.menu.node.SizeConstants.INSETS;

/**
 * Created by Bohdan on 09.02.2017.
 */
public class CreateAccountMenuView implements View
{
    private GridPane gridPane = new GridPane();

    private UserInfo userInfo = new UserInfo(true);
    private Button buttonCreate = NodeFactory.getButton("Create", userInfo.getMaxWidth(), userInfo.getMaxHeight());
    private Button buttonCancel = NodeFactory.getButton("Cancel", userInfo.getMaxWidth(), userInfo.getMaxHeight());

    private CreateAccountMenuController controller;

    public UserInfo getUserInfo()
    {
        return userInfo;
    }

    public CreateAccountMenuView(CreateAccountMenuController controller)
    {
        this.controller = controller;
        init();
    }

    @Override
    public Parent getParent()
    {
        return gridPane;
    }

    @Override
    public void init()
    {
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(INSETS));

        gridPane.add(userInfo, 0, 0);
        gridPane.add(buttonCreate, 0, 1);
        gridPane.add(buttonCancel, 1, 1);

        buttonCreate.setOnAction(event ->
        {
            controller.createAccount();
        });

        buttonCancel.setOnAction(event ->
        {
            controller.cancel();
        });
    }
}
