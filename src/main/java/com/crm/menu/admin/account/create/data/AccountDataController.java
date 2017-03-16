package com.crm.menu.admin.account.create.data;

import com.crm.database.entity.account.LockType;
import com.crm.database.entity.account.RightType;
import com.crm.database.validation.ValidationException;
import com.crm.menu.admin.account.create.AccountCreationModel;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Arrays;

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
        choiceBoxRights.setItems(FXCollections.observableList(Arrays.asList(RightType.values())));
        choiceBoxLockType.setItems(FXCollections.observableList(Arrays.asList(LockType.values())));

        textFieldLogin.setText(AccountCreationModel.getInstance().getAccountToCreate().getLogin());
        choiceBoxRights.setValue(AccountCreationModel.getInstance().getAccountToCreate().getRightType());
        choiceBoxLockType.setValue(AccountCreationModel.getInstance().getAccountToCreate().getLockType());

        buttonNext.setOnAction(event ->
        {
            try
            {
                model.setAccountData(textFieldLogin.getText(), choiceBoxRights.getValue(), choiceBoxLockType.getValue());
                model.next();
            }
            catch (ValidationException e)
            {
                showInformationMessage(e.getMessage());
            }
        });

        buttonCancel.setOnAction(event ->
        {
            model.cancel();
        });
    }

    public void showInformationMessage(String message)
    {
        new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK).show();
    }
}
