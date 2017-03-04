package com.crm.database.validation.password;

import com.crm.database.validation.DataValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Bohdan on 05.03.2017.
 */
public class PasswordCustomValidator implements ConstraintValidator<PasswordCustom, String>
{
    public void initialize(PasswordCustom constraint)
    {
    }

    public boolean isValid(String password, ConstraintValidatorContext context)
    {
        return DataValidator.getInstance().isPasswordValid(password);
    }
}
