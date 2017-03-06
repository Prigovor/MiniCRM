package com.crm.database.validation.unique;

import com.crm.database.manager.DatabaseManagerType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Bohdan on 05.03.2017.
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Unique
{
    DatabaseManagerType serviceType() default DatabaseManagerType.HIBERNATE;
}
