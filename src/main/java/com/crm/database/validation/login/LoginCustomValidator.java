package com.crm.database.validation.login;

import com.crm.database.validation.DataValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Bohdan on 05.03.2017.
 */
public class LoginCustomValidator implements ConstraintValidator<LoginCustom, String>
{
    public void initialize(LoginCustom constraint)
    {
    }

    public boolean isValid(String login, ConstraintValidatorContext context)
    {
        return DataValidator.getInstance().isLoginValid(login);
    }

}
