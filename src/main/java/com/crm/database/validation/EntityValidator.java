package com.crm.database.validation;

import com.crm.database.service.FactoryService;
import com.crm.database.service.GenericService;
import com.crm.database.validation.unique.Unique;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
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

        for (Field field : tObj.getClass().getDeclaredFields())
        {
            if (field.isAnnotationPresent(Unique.class))
            {
                Unique uniqueAnnotation = field.getAnnotation(Unique.class);
                field.setAccessible(true);

                GenericService service = FactoryService.getService(uniqueAnnotation.serviceType(), uniqueAnnotation.serviceClass());

                try
                {
                    if (service.getEntryByField(field.getName(), field.get(tObj)) != null)
                    {
                        throw new ValidationException("Entry with such field already exists");
                    }
                }
                catch (IllegalAccessException e)
                {

                }
            }
        }
    }
}
