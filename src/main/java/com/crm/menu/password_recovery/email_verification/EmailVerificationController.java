package com.crm.menu.password_recovery.email_verification;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Created by Bohdan on 03.03.2017.
 */
public class EmailVerificationController
{
    public TextField textFieldEmail;
    public Button buttonConfirm;
    public Button buttonCancel;

    private EmailVerificationModel model = new EmailVerificationModel();

    @FXML
    public void initialize()
    {
        buttonConfirm.setOnAction(event ->
        {
            model.verifyEmail(textFieldEmail.getText());
        });

        buttonCancel.setOnAction(event ->
        {
            model.cancel();
        });
    }
}
