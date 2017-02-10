package com.crm.menu.account.change;

import com.crm.entity.user.User;
import com.crm.menu.Controller;

public class ChangeAccountMenuController implements Controller
{
    private ChangeAccountMenuModel model = new ChangeAccountMenuModel();
    private ChangeAccountMenuView view = new ChangeAccountMenuView();

    public ChangeAccountMenuController(User user)
    {
        model.setUser(user);
    }

    @Override
    public ChangeAccountMenuView getView()
    {
        return view;
    }
}
