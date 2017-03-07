package com.crm.database.validation;

import com.crm.database.manager.DatabaseManagerType;
import com.crm.database.service.FactoryService;
import com.crm.database.service.GenericService;
import com.crm.database.validation.unique.Unique;

import javax.persistence.Id;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.Serializable;
import java.lang.reflect.Field;

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

    private ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

    public <T> void validateEntry(T tObj)
    {
        Validator validator = validatorFactory.getValidator();

        for (ConstraintViolation<T> tConstraintViolation : validator.validate(tObj))
        {
            throw new ValidationException(tConstraintViolation.getMessage());
        }

        T tObjInDb = getEntry(tObj);

        for (Field field : tObj.getClass().getDeclaredFields())
        {
            if (field.isAnnotationPresent(Unique.class))
            {
                Unique uniqueAnnotation = field.getAnnotation(Unique.class);
                field.setAccessible(true);

                GenericService service = FactoryService.getService(uniqueAnnotation.serviceType(), tObj.getClass());

                try
                {
                    if (!field.get(tObj).equals(field.get(tObjInDb)) && service.getEntryByField(field.getName(), field.get(tObj)) != null)
                    {
                        throw new ValidationException(String.format("%s with such %s already exists", tObj.getClass().getSimpleName(), field.getName()));
                    }
                }
                catch (IllegalAccessException e)
                {

                }
            }
        }
    }

    private <T> T getEntry(T tObj)
    {
        for (Field field : tObj.getClass().getDeclaredFields())
        {
            if (field.isAnnotationPresent(Id.class))
            {
                GenericService service = FactoryService.getService(DatabaseManagerType.HIBERNATE, tObj.getClass());

                field.setAccessible(true);
                try
                {
                    return (T) service.getEntry((Serializable) field.get(tObj));
                }
                catch (IllegalAccessException e)
                {

                }
            }
        }

        return null;
    }
}
