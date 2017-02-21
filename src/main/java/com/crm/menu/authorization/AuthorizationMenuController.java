package com.crm.menu.authorization;

import com.crm.main.Main;
import com.crm.main.MainModel;
import com.crm.menu.Controller;
import com.crm.menu.admin.AdminMenuController;
import com.crm.menu.employee.EmployeeMenuController;
import com.crm.service.UserValidationException;

import javax.mail.MessagingException;
import java.io.IOException;

/**
 * Created by Жека on 2/5/2017.
 */
public class AuthorizationMenuController implements Controller
{
    private AuthorizationMenuModel model = new AuthorizationMenuModel();
    private AuthorizationMenuView view = new AuthorizationMenuView(this);

    @Override
    public AuthorizationMenuView getView()
    {
        return view;
    }

    public void logIn()
    {
        try
        {
            switch (model.authorize(view.getTextFieldLogin().getText(), view.getPasswordField().getText()))
            {
                case SUCCESSFUL:
                {
                    switch (MainModel.getInstance().getCurrentAccount().getRightType())
                    {
                        case ADMIN:
                        {
                            Main.getInstance().replaceSceneContent(new AdminMenuController());
                            break;
                        }
                        case USER:
                        {
                            switch (MainModel.getInstance().getCurrentAccount().getEmployee().getPosition())
                            {
                                case MANAGER:
                                {
                                    Main.getInstance().replaceSceneContent("/fxml-files/order-manager-main-menu.fxml");
                                    break;
                                }
                                default:
                                {
                                    Main.getInstance().replaceSceneContent(new EmployeeMenuController());
                                    break;
                                }
                            }
                            break;
                        }
                    }

                    break;
                }
                case LOCKED:
                {
                    view.showInformationMessage("Your account is locked");
                    break;
                }
                case INCORRECT_LOGIN_PASSWORD:
                {
                    view.showInformationMessage("Incorrect login or password");
                    break;
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
            view.showInformationMessage(e.getMessage());
        }
    }

    public void remindPassword()
    {
        try
        {
            model.remindPassword();
        }
        catch (MessagingException | UserValidationException e)
        {
            view.showInformationMessage(e.getMessage());
        }
    }

    public void exit()
    {
        Main.getInstance().exit();
    }
}