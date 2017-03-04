package com.crm.database.validation.phone;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Bohdan on 05.03.2017.
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneCustomValidator.class)
@Documented
public @interface PhoneCustom
{
    String message() default "Phone is not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
