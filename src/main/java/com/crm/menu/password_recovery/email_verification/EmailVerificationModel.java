package com.crm.menu.password_recovery.email_verification;

import com.crm.database.entity.account.LockType;
import com.crm.database.entity.employee.Employee;
import com.crm.database.manager.PasswordManager;
import com.crm.database.service.FactoryService;
import com.crm.main.Main;
import com.crm.managers.EmailManager;
import com.crm.menu.password_recovery.PasswordRecoveryModel;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * Created by Bohdan on 03.03.2017.
 */
public class EmailVerificationModel
{
    private int attempts = 0;

    public void verifyEmail(String email)
    {
        Employee employee = FactoryService.getEmployeeService().getEntryByField("email", email);

        if (employee != null && employee.getAccount().equals(PasswordRecoveryModel.getInstance().getAccountToRecover()))
        {
            if (employee.getAccount().getLockType() == LockType.LOCKED)
            {
                new Alert(Alert.AlertType.INFORMATION, "Account is locked").showAndWait();

                Main.getInstance().replaceSceneContent("/com/crm/menu/authorization/authorization-menu.fxml");
            }
            else
            {
                String emailCode = PasswordManager.getInstance().generatePassword(8);

                EmailManager.getInstance().sendMessage(employee.getAccount().getEmail(), "Verification code", emailCode);
                PasswordRecoveryModel.getInstance().setEmailCode(emailCode);

                Main.getInstance().replaceSceneContent("/com/crm/menu/password_recovery/email_code_verification/email-code-verification-menu.fxml");
            }
        }
        else
        {
            if (attempts < PasswordRecoveryModel.MAX_ATTEMPTS)
            {
                attempts++;
                new Alert(Alert.AlertType.INFORMATION, "Email is incorrect.\nAttempts left: "
                        + (PasswordRecoveryModel.MAX_ATTEMPTS - attempts), ButtonType.OK).showAndWait();
            }

            if (attempts >= PasswordRecoveryModel.MAX_ATTEMPTS)
            {
                FactoryService.getAccountService().lockAccount(
                        PasswordRecoveryModel.getInstance().getAccountToRecover()
                );
                Main.getInstance().replaceSceneContent("/com/crm/menu/authorization/authorization-menu.fxml");
            }
        }
    }

    public void cancel()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/authorization/authorization-menu.fxml");
    }
}
