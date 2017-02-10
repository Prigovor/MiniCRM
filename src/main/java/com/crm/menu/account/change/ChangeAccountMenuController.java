package com.crm.menu.account.change;

import com.crm.menu.Controller;

public class ChangeAccountMenuController implements Controller
{
    private ChangeAccountMenuModel model = new ChangeAccountMenuModel();
    private ChangeAccountMenuView view = new ChangeAccountMenuView();

    @Override
    public ChangeAccountMenuView getView()
    {
        return view;
    }
}
