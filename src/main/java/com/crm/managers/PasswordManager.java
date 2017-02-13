package com.crm.managers;

import java.security.SecureRandom;

/**
 * Created by Bohdan on 12.02.2017.
 */
public class PasswordManager
{
    private static PasswordManager instance;

    public static PasswordManager getInstance()
    {
        if (instance == null)
        {
            instance = new PasswordManager();
        }
        return instance;
    }

    private PasswordManager()
    {

    }

    private final String symbols = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private SecureRandom rnd = new SecureRandom();

    public String generatePassword(int length)
    {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
        {
            sb.append(symbols.charAt(rnd.nextInt(symbols.length())));
        }
        return sb.toString();
    }
}
