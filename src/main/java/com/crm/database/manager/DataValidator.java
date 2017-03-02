package com.crm.database.manager;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * Created by Bohdan on 28.02.2017.
 */
public class DataValidator
{
    public static boolean isLoginValid(String login)
    {
        return login != null && login.matches("^[\\w\\.]+$");
    }

    public static boolean isPasswordValid(String password)
    {
        return password != null && password.matches("^\\S{8,}$");
    }

    public static boolean isEmailValid(String email)
    {
        if (email == null)
        {
            return false;
        }

        try
        {
            new InternetAddress(email).validate();
        }
        catch (AddressException e)
        {
            return false;
        }

        return true;
    }

    public static boolean isPhoneValid(String phone)
    {
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        try
        {
            return phoneNumberUtil.isValidNumber(phoneNumberUtil.parse(phone, ""));
        }
        catch (NumberParseException e)
        {
            return false;
        }
    }
}
