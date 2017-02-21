package com.crm.main;

import com.crm.entity.account.Account;

/**
 * Created by Bohdan on 05.02.2017.
 */
public class MainModel
{
    private static MainModel instance;

    public static MainModel getInstance()
    {
        if (instance == null)
        {
            instance = new MainModel();
        }

        return instance;
    }

    private MainModel()
    {

    }

    private Account currentAccount;

    public Account getCurrentAccount()
    {
        return currentAccount;
    }

    public void setCurrentAccount(Account currentAccount)
    {
        this.currentAccount = currentAccount;
    }
}
