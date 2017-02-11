package com.crm.menu.account.create;

import com.crm.entity.employee.Gender;
import com.crm.entity.employee.PositionType;
import com.crm.entity.user.UserType;
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

            try {
                model.getUser().setUserType(UserType.valueOf(view.getUserInfo().getPairUserType().getInputText()));
                model.getEmployee().setGender(Gender.valueOf(view.getUserInfo().getPairGender().getInputText()));
                model.getEmployee().setPosition(PositionType.valueOf(view.getUserInfo().getPairPosition().getInputText()));
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

    public void cancel()
    {
        Main.getInstance().replaceSceneContent(new AdminMenuController());
    }
}
