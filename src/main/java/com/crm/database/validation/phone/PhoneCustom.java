package com.crm.database.validation.phone;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static com.crm.database.data.MessageDataContainer.PHONE_INVALID;

/**
 * Created by Bohdan on 05.03.2017.
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneCustomValidator.class)
@Documented
public @interface PhoneCustom
{
    String message() default PHONE_INVALID;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
