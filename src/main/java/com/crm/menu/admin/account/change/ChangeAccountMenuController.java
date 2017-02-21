package com.crm.menu.admin.account.change;

import com.crm.entity.account.Account;
import com.crm.main.Main;
import com.crm.menu.Controller;
import com.crm.menu.admin.account.create.CreateAccountException;
import com.crm.menu.admin.AdminMenuController;
import com.crm.service.UserValidationException;

import java.io.IOException;

public class ChangeAccountMenuController implements Controller
{
    private ChangeAccountMenuModel model;
    private ChangeAccountMenuView view;

    public ChangeAccountMenuController(Account account)
    {
        model = new ChangeAccountMenuModel();
        model.setAccount(account);

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
        model.getAccount().setLogin(view.getAccountInfo().getPairLogin().getInputText());
        model.getAccount().setPassword(view.getAccountInfo().getPairPassword().getInputText());
        model.getAccount().setQuestion(view.getAccountInfo().getPairQuestion().getInputText());
        model.getAccount().setAnswer(view.getAccountInfo().getPairAnswer().getInputText());

        model.getEmployee().setName(view.getAccountInfo().getPairName().getInputText());
        model.getEmployee().setSurname(view.getAccountInfo().getPairSurname().getInputText());
        model.getEmployee().setAge(Integer.valueOf(view.getAccountInfo().getPairAge().getInputText()));
        model.getEmployee().setWorkEmail(view.getAccountInfo().getPairEmail().getInputText());

        try
        {
            model.getAccount().setRightType(view.getAccountInfo().getPairRights().getSecondNode().getValue());
            model.getAccount().setLockType(view.getAccountInfo().getPairLock().getSecondNode().getValue());
            model.getEmployee().setGender(view.getAccountInfo().getPairGender().getSecondNode().getValue());
            model.getEmployee().setPosition(view.getAccountInfo().getPairPosition().getSecondNode().getValue());

            model.getEmployee().setAge(Integer.valueOf(view.getAccountInfo().getPairAge().getInputText()));
        }
        catch (Exception e)
        {
        }

        try
        {
            if (!model.getAccount().getLogin().equals(view.getAccountInfo().getPairLogin().getInputText()) ||
                    !model.getAccount().getPassword().equals(view.getAccountInfo().getPairPassword().getInputText()))
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
        view.getAccountInfo().getPairPassword().getSecondNode().setText(model.generatePassword(6));
    }

    public void cancel()
    {
        Main.getInstance().replaceSceneContent(new AdminMenuController());
    }
}
