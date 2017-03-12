package com.crm.database.confirmation;

import com.crm.database.manager.PasswordManager;
import com.crm.managers.EmailManager;
import com.crm.managers.SmsManager;

/**
 * Created by Bohdan on 10.03.2017.
 */
public class ConfirmationManager
{
    public static void doActionWithEmailConfirmation(String email, String inputConfirmationCode, Action actionConfirmed, Action actionDeclined)
    {
        String confirmationCode = PasswordManager.getInstance().generatePassword(4);

        EmailManager.getInstance().sendMessage(email, "Confirmation", "Use this code to confirm action: " + confirmationCode);

        if (inputConfirmationCode.equals(confirmationCode))
        {
            actionConfirmed.doAction();
        }
        else
        {
            actionDeclined.doAction();
        }
    }

    public static void doActionWithPhoneConfirmation(String phone, String inputConfirmationCode, Action actionConfirmed, Action actionDeclined)
    {
        String confirmationCode = PasswordManager.getInstance().generatePassword(4);

        SmsManager.getInstance().sendSms(phone, "Use this code to confirm action");

        if (inputConfirmationCode.equals(confirmationCode))
        {
            actionConfirmed.doAction();
        }
        else
        {
            actionDeclined.doAction();
        }
    }

    public static void doActionWithPasswordConfirmation(String encryptedPassword, String inputPassword, Action actionConfirmed, Action actionDeclined)
    {
        if (PasswordManager.getInstance().isPasswordCorrect(inputPassword, encryptedPassword))
        {
            actionConfirmed.doAction();
        }
        else
        {
            actionDeclined.doAction();
        }
    }
}
