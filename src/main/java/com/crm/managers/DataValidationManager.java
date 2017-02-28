package com.crm.managers;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * Created by Bohdan on 28.02.2017.
 */
public class DataValidationManager
{
    public static boolean isLoginValid(String login)
    {
        return login.matches("^\\w+$");
    }

    public static boolean isPasswordValid(String password)
    {
        return password.matches("^\\S{8,}$");
    }

    public static boolean isEmailValid(String email)
    {
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
