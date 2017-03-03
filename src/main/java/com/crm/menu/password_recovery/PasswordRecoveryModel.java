package com.crm.menu.password_recovery;

import com.crm.database.entity.account.Account;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Bohdan on 03.03.2017.
 */
@Getter @Setter
public class PasswordRecoveryModel
{
    public static final int MAX_ATTEMPTS = 3;

    private static final PasswordRecoveryModel ourInstance = new PasswordRecoveryModel();

    public static PasswordRecoveryModel getInstance()
    {
        return ourInstance;
    }

    private PasswordRecoveryModel()
    {
    }

    private String smsCode;
    private String emailCode;

    private Account accountToRecover;
}
