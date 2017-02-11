package com.crm.menu.account.change;

import com.crm.entity.employee.Gender;
import com.crm.entity.employee.PositionType;
import com.crm.entity.user.User;
import com.crm.entity.user.UserType;
import com.crm.main.Main;
import com.crm.menu.Controller;
import com.crm.menu.account.create.CreateAccountException;
import com.crm.menu.admin.AdminMenuController;
import com.crm.service.UserValidationException;

import java.io.IOException;

public class ChangeAccountMenuController implements Controller
{
    private ChangeAccountMenuModel model;
    private ChangeAccountMenuView view;

    public ChangeAccountMenuController(User user)
    {
        model = new ChangeAccountMenuModel();
        model.setUser(user);

        view = new ChangeAccountMenuView(this);
    }

    public ChangeAccountMenuModel getModel()
    {
        return model;
    }

    @Override
    public ChangeAccountMenuView getView()
    {
        return view;
    }

    public void changeAccount()
    {
        model.getUser().setLogin(view.getUserInfo().getPairLogin().getInputText());
        model.getUser().setPassword(view.getUserInfo().getPairPassword().getInputText());
        model.getUser().setUserType(UserType.valueOf(view.getUserInfo().getPairUserType().getInputText()));
        model.getUser().setQuestion(view.getUserInfo().getPairQuestion().getInputText());
        model.getUser().setAnswer(view.getUserInfo().getPairAnswer().getInputText());

        model.getEmployee().setName(view.getUserInfo().getPairName().getInputText());
        model.getEmployee().setSurname(view.getUserInfo().getPairSurname().getInputText());
        model.getEmployee().setAge(Integer.valueOf(view.getUserInfo().getPairAge().getInputText()));
        model.getEmployee().setGender(Gender.valueOf(view.getUserInfo().getPairGender().getInputText()));
        model.getEmployee().setPosition(PositionType.valueOf(view.getUserInfo().getPairPosition().getInputText()));

        try
        {
            if (!model.getUser().getLogin().equals(view.getUserInfo().getPairLogin().getInputText()) ||
              !model.getUser().getPassword().equals(view.getUserInfo().getPairPassword().getInputText()))
            {
                model.checkAccountSameLoginPassword();
            }

            model.changeAccount();
        }
        catch (CreateAccountException | IOException | UserValidationException e)
        {
            view.showInformationMessage(e.getMessage());
        }
    }

    public void cancel()
    {
        Main.getInstance().replaceSceneContent(new AdminMenuController());
    }
}
