package com.crm.database.validation;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * Created by Bohdan on 28.02.2017.
 */
public class DataValidator
{
    private static final DataValidator instance = new DataValidator();

    public static DataValidator getInstance()
    {
        return instance;
    }

    private DataValidator()
    {

    }

    public boolean isLoginValid(String login)
    {
        return login != null && login.matches("^[\\w\\.]+$");
    }

    public boolean isPasswordValid(String password)
    {
        return password != null && password.matches("^\\S{8,}$");
    }

    public boolean isEmailValid(String email)
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

    public boolean isPhoneValid(String phone)
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
