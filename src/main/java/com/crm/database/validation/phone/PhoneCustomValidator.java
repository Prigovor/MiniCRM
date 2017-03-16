package com.crm.database.validation.phone;

import com.crm.database.validation.DataValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Bohdan on 05.03.2017.
 */
public class PhoneCustomValidator implements ConstraintValidator<PhoneCustom, String>
{
    public void initialize(PhoneCustom constraint)
    {
    }

    public boolean isValid(String phone, ConstraintValidatorContext context)
    {
        return DataValidator.getInstance().isPhoneValid(phone);
    }
}
