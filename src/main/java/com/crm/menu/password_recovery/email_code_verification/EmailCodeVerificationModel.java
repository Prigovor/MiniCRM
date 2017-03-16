package com.crm.menu.password_recovery.email_code_verification;

import com.crm.database.entity.account.Account;
import com.crm.database.manager.PasswordManager;
import com.crm.database.service.FactoryService;
import com.crm.main.Main;
import com.crm.managers.EmailManager;
import com.crm.menu.password_recovery.PasswordRecoveryModel;
import javafx.scene.control.Alert;

/**
 * Created by Bohdan on 03.03.2017.
 */
public class EmailCodeVerificationModel
{
    private int attempts = 0;

    public void verifyEmailCode(String emailCode)
    {
        if (emailCode.equals(PasswordRecoveryModel.getInstance().getEmailCode()))
        {
            Account account = PasswordRecoveryModel.getInstance().getAccountToRecover();

            String generatedPassword = PasswordManager.getInstance().generatePassword(8);
            account.setPassword(generatedPassword);

            FactoryService.getAccountService().updateEntry(account);

            EmailManager.getInstance().sendAccountData(account, generatedPassword);

            Main.getInstance().replaceSceneContent("/com/crm/menu/authorization/authorization-menu.fxml");
        }
        else
        {
            if (attempts < PasswordRecoveryModel.MAX_ATTEMPTS)
            {
                attempts++;
                new Alert(Alert.AlertType.INFORMATION, "Code is incorrect.\nAttempts left: "
                        + (PasswordRecoveryModel.MAX_ATTEMPTS - attempts)).showAndWait();
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
