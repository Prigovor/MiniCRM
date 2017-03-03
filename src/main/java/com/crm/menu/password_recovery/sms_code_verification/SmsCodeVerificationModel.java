package com.crm.menu.password_recovery.sms_code_verification;

import com.crm.database.manager.DatabaseManagerType;
import com.crm.database.service.FactoryService;
import com.crm.main.Main;
import com.crm.menu.password_recovery.PasswordRecoveryModel;
import javafx.scene.control.Alert;

/**
 * Created by Bohdan on 03.03.2017.
 */
public class SmsCodeVerificationModel
{
    private int attempts = 0;

    public void verifySmsCode(String smsCode)
    {
        if (smsCode.equals(PasswordRecoveryModel.getInstance().getSmsCode()))
        {
            Main.getInstance().replaceSceneContent("/fxml-files/password-recovery/email-verification-menu.fxml");
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
                FactoryService.getAccountService(DatabaseManagerType.HIBERNATE).lockAccount(
                        PasswordRecoveryModel.getInstance().getAccountToRecover()
                );
                Main.getInstance().replaceSceneContent("/fxml-files/authorization-menu.fxml");
            }
        }
    }

    public void cancel()
    {
        Main.getInstance().replaceSceneContent("/fxml-files/authorization-menu.fxml");
    }
}
