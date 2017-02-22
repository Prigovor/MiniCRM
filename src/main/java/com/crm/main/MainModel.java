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

    private Account currentAccount = new Account();

    public Account getCurrentAccount()
    {
        currentAccount.setId(1293012849L);
        return currentAccount;
    }

    public void setCurrentAccount(Account currentAccount)
    {
        this.currentAccount = currentAccount;
    }
}
