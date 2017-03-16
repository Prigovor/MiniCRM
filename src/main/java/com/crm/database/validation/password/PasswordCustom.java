package com.crm.database.validation.password;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static com.crm.database.data.MessageDataContainer.PASSWORD_INVALID;

/**
 * Created by Bohdan on 05.03.2017.
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordCustomValidator.class)
@Documented
public @interface PasswordCustom
{
    String message() default PASSWORD_INVALID;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
