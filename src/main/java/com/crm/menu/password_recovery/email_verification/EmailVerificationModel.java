package com.crm.menu.password_recovery.email_verification;

import com.crm.database.entity.account.Account;
import com.crm.database.service.FactoryService;
import com.crm.main.Main;
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
        Account account = FactoryService.getAccountService().getEntryByField("email", email);

        if (account.equals(PasswordRecoveryModel.getInstance().getAccountToRecover()))
        {
            Main.getInstance().replaceSceneContent("/com/crm/menu/password_recovery/email_code_verification/email-code-verification-menu.fxml");
        }
        else
        {
            if (attempts < PasswordRecoveryModel.MAX_ATTEMPTS)
            {
                attempts++;
                new Alert(Alert.AlertType.INFORMATION, "EmailCustom is incorrect.\nAttempts left: "
                        +(PasswordRecoveryModel.MAX_ATTEMPTS - attempts), ButtonType.OK).showAndWait();
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
