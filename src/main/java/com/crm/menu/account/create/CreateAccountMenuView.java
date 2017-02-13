package com.crm.menu.account.create;

import com.crm.menu.View;
import com.crm.menu.node.custom.UserInfo;
import com.crm.menu.node.factory.NodeFactory;
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

    private Button buttonCreate;
    private Button buttonGeneratePassword = new Button();
    private Button buttonCancel;

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
        buttonCreate = NodeFactory.getButton("Create", userInfo.getPairPosition().getMaxWidth() / 2, userInfo.getPairPosition().getMaxHeight());
        buttonCancel = NodeFactory.getButton("Cancel", buttonCreate.getMaxWidth() / 2, buttonCreate.getMaxHeight());
        buttonGeneratePassword = NodeFactory.getButton("Generate password", userInfo.getPairPosition().getMaxWidth(), buttonCancel.getMaxHeight());

        GridPane gridPaneButtons = NodeFactory.getGridPane(2, 2);
        gridPaneButtons.setMaxWidth(userInfo.getMaxWidth());
        gridPaneButtons.add(buttonGeneratePassword, 0, 0, 2, 1);
        gridPaneButtons.add(buttonCreate, 0, 1);
        gridPaneButtons.add(buttonCancel, 1, 1);

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(INSETS);
        gridPane.setVgap(INSETS);

        gridPane.add(userInfo, 0, 0);
        gridPane.add(gridPaneButtons, 0, 1);

        buttonCreate.setOnAction(event ->
        {
            controller.createAccount();
        });

        buttonGeneratePassword.setOnAction(event ->
        {
            controller.generatePassword();
        });

        buttonCancel.setOnAction(event ->
        {
            controller.cancel();
        });
    }
}
