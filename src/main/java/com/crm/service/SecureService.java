package com.crm.service;

import com.crm.main.MainModel;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

/**
 * Created by Bohdan on 08.02.2017.
 */
public interface SecureService {
    default void validateUser() throws UserValidationException {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Security checking");
        dialog.setContentText(MainModel.getInstance().getCurrentUser().getQuestion());

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            if ((MainModel.getInstance().getCurrentUser().getAnswer().equals(result.get()))) {
                return;
            } else {
                throw new UserValidationException("Access denied");
            }
        }

        throw new UserValidationException("Access denied");
    }
}