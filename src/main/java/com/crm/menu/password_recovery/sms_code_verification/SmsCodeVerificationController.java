package com.crm.menu.password_recovery.sms_code_verification;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Created by Bohdan on 03.03.2017.
 */
public class SmsCodeVerificationController
{
    public TextField textFieldSmsCode;
    public Button buttonConfirm;
    public Button buttonCancel;

    private SmsCodeVerificationModel model = new SmsCodeVerificationModel();

    @FXML
    public void initialize()
    {
        buttonConfirm.setOnAction(event ->
        {
            model.verifySmsCode(textFieldSmsCode.getText());
        });

        buttonCancel.setOnAction(event ->
        {
            model.cancel();
        });
    }
}
