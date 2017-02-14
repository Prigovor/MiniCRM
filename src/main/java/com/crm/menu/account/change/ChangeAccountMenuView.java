package com.crm.menu.account.change;

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
public class ChangeAccountMenuView implements View
{
    private GridPane gridPane = new GridPane();

    private Button buttonChange = new Button();
    private Button buttonGeneratePassword = new Button();
    private Button buttonCancel = new Button();

    private UserInfo userInfo;

    private ChangeAccountMenuController controller;
    private ChangeAccountMenuModel model;

    public ChangeAccountMenuView(ChangeAccountMenuController controller)
    {
        this.controller = controller;
        model = controller.getModel();

        userInfo = new UserInfo(model.getUser(), true);

        init();
    }

    @Override
    public Parent getParent()
    {
        return gridPane;
    }

    public UserInfo getUserInfo()
    {
        return userInfo;
    }

    @Override
    public void init()
    {
        buttonChange = NodeFactory.getButton("Create", Double.MAX_VALUE, userInfo.getPairPosition().getMaxHeight());
        buttonCancel = NodeFactory.getButton("Cancel", Double.MAX_VALUE, buttonChange.getMaxHeight());
        buttonGeneratePassword = NodeFactory.getButton("Generate password", Double.MAX_VALUE, buttonCancel.getMaxHeight());

        GridPane gridPaneButtons = NodeFactory.getGridPane(2, 2);
        gridPaneButtons.setMaxWidth(userInfo.getMaxWidth());
        gridPaneButtons.add(buttonGeneratePassword, 0, 0, 2, 1);
        gridPaneButtons.add(buttonChange, 0, 1);
        gridPaneButtons.add(buttonCancel, 1, 1);

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(INSETS);
        gridPane.setVgap(INSETS);

        gridPane.add(userInfo, 0, 0);
        gridPane.add(gridPaneButtons, 0, 1);

        buttonGeneratePassword.setOnAction(event ->
        {
            controller.generatePassword();
        });

        buttonChange.setOnAction(event ->
        {
            controller.changeAccount();
        });

        buttonCancel.setOnAction(event ->
        {
            controller.cancel();
        });

    }
}
