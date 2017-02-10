package com.crm.menu;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * Created by Bohdan on 09.02.2017.
 */
public interface View
{
    Parent getParent();
    void init();

    default void showInformationMessage(String message)
    {
        new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK).showAndWait();
    }
}
