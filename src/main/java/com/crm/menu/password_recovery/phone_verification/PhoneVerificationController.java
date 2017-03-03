package com.crm.menu.password_recovery.phone_verification;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Created by Bohdan on 03.03.2017.
 */
public class PhoneVerificationController
{
    public TextField textFieldPhone;
    public Button buttonConfirm;
    public Button buttonCancel;

    private PhoneVerificationModel model = new PhoneVerificationModel();

    @FXML
    public void initialize()
    {
        buttonConfirm.setOnAction(event ->
        {
            model.verifyPhone(textFieldPhone.getText());
        });

        buttonCancel.setOnAction(event ->
        {
            model.cancel();
        });
    }
}
