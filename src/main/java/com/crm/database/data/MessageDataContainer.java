package com.crm.database.data;

/**
 * Created by Bohdan on 01.03.2017.
 */
public class MessageDataContainer
{
    public static final String LOGIN_INVALID = "Login is incorrect. It should contain only alphanumeric characters and dots without whitespaces";
    public static final String PASSWORD_INVALID = "Password is incorrect. It should contain at least 8 characters without whitespaces";
    public static final String EMAIL_INVALID = "EmailCustom is incorrect";
    public static final String PHONE_INVALID = "Phone is incorrect";

    public static final String LOGIN_EXISTS = "Entry with such login already exists";
    public static final String PASSWORD_EXISTS = "Entry with such password already exists";
    public static final String EMAIL_EXISTS = "Entry with such email already exists";
    public static final String PHONE_EXISTS = "Entry with such phone already exists";
}
