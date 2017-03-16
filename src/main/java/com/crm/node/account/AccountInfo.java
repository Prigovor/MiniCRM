package com.crm.node.account;

import com.crm.database.entity.account.Account;
import com.crm.database.entity.account.LockType;
import com.crm.database.entity.account.RightType;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Bohdan on 22.02.2017.
 */
public class AccountInfo extends AnchorPane
{
    public TextField textFieldLogin;
    public TextField textFieldPhone;
    public TextField textFieldEmail;

    public DatePicker datePickerRegistrationDate;

    public ChoiceBox<RightType> choiceBoxRights;
    public ChoiceBox<LockType> choiceBoxLockType;

    private Account account;

    public Account getAccount()
    {
        return account;
    }

    public void setAccount(Account account)
    {
        this.account = account;

        textFieldLogin.setText(account.getLogin());
        textFieldPhone.setText(account.getPhone());
        textFieldEmail.setText(account.getEmail());

        if (account.getRegistrationDate() != null)
        {
            datePickerRegistrationDate.setValue(new java.sql.Date(account.getRegistrationDate().getTime()).toLocalDate());
        }

        choiceBoxRights.setValue(account.getRightType());
        choiceBoxLockType.setValue(account.getLockType());
    }

    public AccountInfo()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml-files/custom-panes/account-info.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try
        {
            fxmlLoader.load();

            choiceBoxRights.setItems(FXCollections.observableList(Arrays.asList(RightType.values())));
            choiceBoxLockType.setItems(FXCollections.observableList(Arrays.asList(LockType.values())));
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void applyChangesToAccount()
    {
        account.setLogin(textFieldLogin.getText());

        account.setRegistrationDate(java.sql.Date.valueOf(datePickerRegistrationDate.getValue()));

        account.setLockType(choiceBoxLockType.getValue());
        account.setRightType(choiceBoxRights.getValue());
    }

    public void clear()
    {
        textFieldLogin.clear();
        textFieldPhone.clear();
        textFieldEmail.clear();

        datePickerRegistrationDate.setValue(null);

        choiceBoxLockType.setValue(null);
        choiceBoxRights.setValue(null);
    }
}
