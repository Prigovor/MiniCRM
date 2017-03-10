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

    public <T> void validateEntry(T objToValidate)
    {
        Validator validator = validatorFactory.getValidator();

        for (ConstraintViolation<T> tConstraintViolation : validator.validate(objToValidate))
        {
            throw new ValidationException(tConstraintViolation.getMessage());
        }

        T databaseObject = getEntry(objToValidate);

        Class clazz = objToValidate.getClass();

        while (clazz != null)
        {
            for (Field field : clazz.getDeclaredFields())
            {
                if (field.isAnnotationPresent(Unique.class))
                {
                    try
                    {
                        field.setAccessible(true);

                        GenericService service = FactoryService.getService(DatabaseManagerType.HIBERNATE, clazz);

                        Object obj = service.getEntryByField(field.getName(), field.get(objToValidate));

                        if (databaseObject != null)
                        {
                            if (!field.get(databaseObject).equals(objToValidate) && (obj != null && !obj.equals(databaseObject)))
                            {
                                throw new ValidationException(String.format("%s with such %s already exists", clazz.getSimpleName(), field.getName()));
                            }
                        }
                        else
                        {
                            if (obj != null)
                            {
                                throw new ValidationException(String.format("%s with such %s already exists", clazz.getSimpleName(), field.getName()));
                            }
                        }
                    }
                    catch (IllegalAccessException e)
                    {

                    }
                }
            }

            clazz = clazz.getSuperclass();
        }
    }

    private <T> T getEntry(T tObj)
    {
        Class clazz = tObj.getClass();

        while (clazz != null)
        {
            for (Field field : clazz.getDeclaredFields())
            {
                if (field.isAnnotationPresent(Id.class))
                {
                    GenericService service = FactoryService.getService(DatabaseManagerType.HIBERNATE, clazz);

                    field.setAccessible(true);
                    try
                    {
                        if (field.get(tObj) != null)
                        {
                            return (T) service.getEntry((Serializable) field.get(tObj));
                        }
                    }
                    catch (IllegalAccessException e)
                    {

                    }
                }
            }

            clazz = clazz.getSuperclass();
        }

        return null;
    }
}
