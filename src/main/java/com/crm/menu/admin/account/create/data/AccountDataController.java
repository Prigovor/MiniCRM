package com.crm.menu.admin.account.create.data;

import com.crm.database.entity.account.LockType;
import com.crm.database.entity.account.RightType;
import com.crm.menu.admin.account.create.AccountCreationModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

/**
 * Created by Bohdan on 04.03.2017.
 */
public class AccountDataController
{
    public TextField textFieldLogin;
    public ChoiceBox<RightType> choiceBoxRights;
    public ChoiceBox<LockType> choiceBoxLockType;

    public Button buttonNext;
    public Button buttonCancel;

    private AccountDataModel model = new AccountDataModel();

    @FXML
    public void initialize()
    {
        textFieldLogin.setText(AccountCreationModel.getInstance().getAccountToCreate().getLogin());
        choiceBoxRights.setValue(AccountCreationModel.getInstance().getAccountToCreate().getRightType());
        choiceBoxLockType.setValue(AccountCreationModel.getInstance().getAccountToCreate().getLockType());

        buttonNext.setOnAction(event ->
        {
            model.setAccountData(textFieldLogin.getText(), choiceBoxRights.getValue(), choiceBoxLockType.getValue());
            model.next();
        });

        buttonCancel.setOnAction(event ->
        {
            model.cancel();
        });
    }
}
