package com.crm.database.validation;

import com.crm.database.entity.account.Account;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 * Created by Bohdan on 05.03.2017.
 */
public class EntityValidator
{
    private static final EntityValidator instance = new EntityValidator();

    public static EntityValidator getInstance()
    {
        return instance;
    }

    private EntityValidator()
    {

    }

    public void validateAccount(Account account)
    {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        for (ConstraintViolation<Account> accountConstraintViolation : validator.validate(account))
        {
            throw new RuntimeException(accountConstraintViolation.getMessage());
        }
    }
}
