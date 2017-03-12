package com.crm.menu.password_recovery.phone_verification;

import com.crm.database.entity.account.LockType;
import com.crm.database.entity.employee.Employee;
import com.crm.database.manager.PasswordManager;
import com.crm.database.service.FactoryService;
import com.crm.main.Main;
import com.crm.menu.password_recovery.PasswordRecoveryModel;
import javafx.scene.control.Alert;

/**
 * Created by Bohdan on 03.03.2017.
 */
public class PhoneVerificationModel
{
    private int attempts = 0;

    public void verifyPhone(String phone)
    {
        Employee employee = FactoryService.getEmployeeService().getEntryByField("phone", phone);

        if (employee != null && employee.getAccount() != null)
        {
            if (employee.getAccount().getLockType() == LockType.LOCKED)
            {
                new Alert(Alert.AlertType.INFORMATION, "Account is locked").showAndWait();

                Main.getInstance().replaceSceneContent("/com/crm/menu/authorization/authorization-menu.fxml");
            }
            else
            {
                String smsCode = PasswordManager.getInstance().generatePassword(8);
                //SmsManager.getInstance().sendSms("380509442389", phone, smsCode);

                System.out.println(smsCode);

                PasswordRecoveryModel.getInstance().setAccountToRecover(employee.getAccount());
                PasswordRecoveryModel.getInstance().setSmsCode(smsCode);

                Main.getInstance().replaceSceneContent("/com/crm/menu/password_recovery/sms_code_verification/sms-code-verification-menu.fxml");
            }
        }
        else
        {
            if (attempts < PasswordRecoveryModel.MAX_ATTEMPTS)
            {
                attempts++;
                new Alert(Alert.AlertType.INFORMATION,
                        "Account with such phone is not registered.\nAttempts left: "
                                + (PasswordRecoveryModel.MAX_ATTEMPTS - attempts)).showAndWait();
            }

            if (attempts >= PasswordRecoveryModel.MAX_ATTEMPTS)
            {
                Main.getInstance().replaceSceneContent("/com/crm/menu/authorization/authorization-menu.fxml");
            }
        }
    }

    public void cancel()
    {
        Main.getInstance().replaceSceneContent("/com/crm/menu/authorization/authorization-menu.fxml");
    }
}
