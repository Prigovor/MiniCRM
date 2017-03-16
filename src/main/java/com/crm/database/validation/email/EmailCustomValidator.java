package com.crm.database.validation.email;

import com.crm.database.validation.DataValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Bohdan on 05.03.2017.
 */
public class EmailCustomValidator implements ConstraintValidator<EmailCustom, String>
{
    public void initialize(EmailCustom constraint)
    {
    }

    public boolean isValid(String email, ConstraintValidatorContext context)
    {
        return DataValidator.getInstance().isEmailValid(email);
    }
}
