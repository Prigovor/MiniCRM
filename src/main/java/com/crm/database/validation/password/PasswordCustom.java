package com.crm.database.validation.password;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Bohdan on 05.03.2017.
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordCustomValidator.class)
@Documented
public @interface PasswordCustom
{
    String message() default "Password is not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
