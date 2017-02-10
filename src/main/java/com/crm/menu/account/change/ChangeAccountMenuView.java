package com.crm.menu.account.change;

import com.crm.menu.View;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;

/**
 * Created by Bohdan on 09.02.2017.
 */
public class ChangeAccountMenuView implements View
{
    private GridPane gridPane = new GridPane();

    private ChangeAccountMenuController controller;

    public ChangeAccountMenuView(ChangeAccountMenuController controller)
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

    }
}
