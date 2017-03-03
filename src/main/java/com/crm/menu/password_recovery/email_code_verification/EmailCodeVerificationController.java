package com.crm.menu.password_recovery.email_code_verification;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Created by Bohdan on 03.03.2017.
 */
public class EmailCodeVerificationController
{
    public TextField textFieldEmailCode;
    public Button buttonConfirm;
    public Button buttonCancel;

    private EmailCodeVerificationModel model = new EmailCodeVerificationModel();

    @FXML
    public void initialize()
    {
        buttonConfirm.setOnAction(event ->
        {
            model.verifyEmailCode(textFieldEmailCode.getText());
        });

        buttonCancel.setOnAction(event ->
        {
            model.cancel();
        });
    }
}
