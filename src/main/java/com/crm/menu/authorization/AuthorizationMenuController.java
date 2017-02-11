package com.crm.menu.authorization;

import com.crm.main.Main;
import com.crm.main.MainModel;
import com.crm.menu.Controller;
import com.crm.menu.admin.AdminMenuController;
import com.crm.menu.employee.EmployeeMenuController;

import java.io.IOException;

/**
 * Created by Жека on 2/5/2017.
 */
public class AuthorizationMenuController implements Controller {
    private AuthorizationMenuModel model = new AuthorizationMenuModel();
    private AuthorizationMenuView view = new AuthorizationMenuView(this);

    @Override
    public AuthorizationMenuView getView() {
        return view;
    }

    public void logIn() {
        try {
            if (model.authorize(view.getTextFieldLogin().getText(), view.getPasswordField().getText())) {
                switch (MainModel.getInstance().getCurrentUser().getUserType()) {
                    case ADMINISTRATOR: {
                        Main.getInstance().replaceSceneContent(new AdminMenuController());
                        break;
                    }
                    case EMPLOYEE: {
                        Main.getInstance().replaceSceneContent(new EmployeeMenuController());
                        break;
                    }
                }
            } else {
                view.showInformationMessage("Incorrect login or password");
            }
        } catch (IOException e) {
            e.printStackTrace();
            view.showInformationMessage(e.getMessage());
        }
    }

    public void exit() {
        Main.getInstance().exit();
    }
}