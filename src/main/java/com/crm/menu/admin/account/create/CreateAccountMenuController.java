package com.crm.menu.admin.account.create;

import com.crm.main.Main;
import com.crm.menu.Controller;
import com.crm.menu.View;
import com.crm.menu.admin.AdminMenuController;
import com.crm.service.UserValidationException;

import java.io.IOException;

/**
 * Created by Bohdan on 07.02.2017.
 */
public class CreateAccountMenuController implements Controller
{
    private CreateAccountMenuModel model = new CreateAccountMenuModel();
    private CreateAccountMenuView view = new CreateAccountMenuView(this);

    @Override
    public View getView()
    {
        return view;
    }

    public void createAccount()
    {
        try
        {
            model.getUser().setLogin(view.getUserInfo().getPairLogin().getInputText());
            model.getUser().setPassword(view.getUserInfo().getPairPassword().getInputText());
            model.getUser().setQuestion(view.getUserInfo().getPairQuestion().getInputText());
            model.getUser().setAnswer(view.getUserInfo().getPairAnswer().getInputText());

            model.getEmployee().setName(view.getUserInfo().getPairName().getInputText());
            model.getEmployee().setSurname(view.getUserInfo().getPairSurname().getInputText());
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

            model.createAccount();
        }
        catch (CreateAccountException | IOException | UserValidationException e)
        {
            view.showInformationMessage(e.getMessage());
        }
    }

    public void generatePassword()
    {
        view.getUserInfo().getPairPassword().getSecondNode().setText(model.generatePassword(6));
    }

    public void cancel()
    {
        Main.getInstance().replaceSceneContent(new AdminMenuController());
    }
}
