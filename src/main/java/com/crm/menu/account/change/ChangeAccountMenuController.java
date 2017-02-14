package com.crm.menu.account.change;

import com.crm.entity.user.User;
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
        model.getUser().setQuestion(view.getUserInfo().getPairQuestion().getInputText());
        model.getUser().setAnswer(view.getUserInfo().getPairAnswer().getInputText());

        model.getEmployee().setName(view.getUserInfo().getPairName().getInputText());
        model.getEmployee().setSurname(view.getUserInfo().getPairSurname().getInputText());
        model.getEmployee().setAge(Integer.valueOf(view.getUserInfo().getPairAge().getInputText()));
        model.getEmployee().setEmail(view.getUserInfo().getPairEmail().getInputText());

        try
        {
            model.getUser().setUserType(view.getUserInfo().getPairUserType().getSecondNode().getValue());
            model.getEmployee().setGender(view.getUserInfo().getPairGender().getSecondNode().getValue());
            model.getEmployee().setPosition(view.getUserInfo().getPairPosition().getSecondNode().getValue());

            model.getEmployee().setAge(Integer.valueOf(view.getUserInfo().getPairAge().getInputText()));
        }
        catch (Exception e)
        {
        }

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

    public void generatePassword()
    {
        view.getUserInfo().getPairPassword().getTextFieldInput().setText(model.generatePassword(6));
    }

    public void cancel()
    {
        Main.getInstance().replaceSceneContent(new AdminMenuController());
    }
}
