package com.crm.database.validation;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import static com.crm.database.data.MessageDataContainer.*;

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

    public void validateLogin(String login)
    {
        if (!isLoginValid(login))
        {
            throw new ValidationException(LOGIN_INVALID);
        }
    }

    public void validatePassword(String password)
    {
        if (!isPasswordValid(password))
        {
            throw new ValidationException(PASSWORD_INVALID);
        }
    }

    public void validatePhone(String phone)
    {
        if (!isPhoneValid(phone))
        {
            throw new ValidationException(PHONE_INVALID);
        }
    }

    public void validateEmail(String email)
    {
        if (!isEmailValid(email))
        {
            throw new ValidationException(EMAIL_INVALID);
        }
    }

    public void validateNotBlankField(String str, Integer minLength, String fieldName)
    {
        if (str == null || str.trim().isEmpty() || str.length() < minLength)
        {
            throw new ValidationException(String.format("%s should not be empty and has at least %d characters",
                    fieldName, minLength));
        }
    }
}
