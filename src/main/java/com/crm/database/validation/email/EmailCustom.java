package com.crm.database.validation.email;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static com.crm.database.data.MessageDataContainer.EMAIL_INVALID;

/**
 * Created by Bohdan on 04.03.2017.
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailCustomValidator.class)
@Documented
public @interface EmailCustom
{
    String message() default EMAIL_INVALID;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
