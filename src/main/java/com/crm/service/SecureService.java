package com.crm.service;

import javafx.scene.control.TextInputDialog;

import java.util.Optional;

/**
 * Created by Bohdan on 08.02.2017.
 */
public interface SecureService
{
    default void checkPassword()
    {
        TextInputDialog textInputDialog = new TextInputDialog();
        textInputDialog.setTitle("Password check");
        textInputDialog.setContentText("Enter your password");

        Optional<String> result = textInputDialog.showAndWait();

        if (result.isPresent())
        {

        }
    }
}
