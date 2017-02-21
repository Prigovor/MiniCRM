package com.crm.menu.node.custom;

import com.crm.entity.account.LockType;
import com.crm.entity.employee.Gender;
import com.crm.entity.employee.PositionType;
import com.crm.entity.account.Account;
import com.crm.entity.account.RightType;
import com.crm.menu.node.factory.NodeFactory;
import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static com.crm.menu.node.SizeConstants.INSETS;
import static com.crm.menu.node.SizeConstants.SMALL_ELEMENT_WIDTH;

/**
 * Created by Bohdan on 10.02.2017.
 */
public class AccountInfo extends GridPane
{
    private InfoInputPair pairLogin = new InfoInputPair("Login");
    private InfoInputPair pairPassword = new InfoInputPair("Password");

    private InfoInputPair pairQuestion = new InfoInputPair("Question");
    private InfoInputPair pairAnswer = new InfoInputPair("Answer");
    private InfoInputPair pairRegistrationDate = new InfoInputPair("Registration date");

    private InfoInputPair pairName = new InfoInputPair("Name");
    private InfoInputPair pairSurname = new InfoInputPair("Surname");
    private InfoInputPair pairAge = new InfoInputPair("Age");
    private InfoInputPair pairEmail = new InfoInputPair("Email");

    private PairNodePane<Label, ChoiceBox<RightType>> pairRights = new PairNodePane<>(
            NodeFactory.getLabel("Rights", Double.MAX_VALUE, Double.MAX_VALUE),
            NodeFactory.getChoiceBox(Arrays.asList(RightType.values()), Double.MAX_VALUE, Double.MAX_VALUE)
    );

    private PairNodePane<Label, ChoiceBox<Gender>> pairGender = new PairNodePane<>(
            NodeFactory.getLabel("Gender", Double.MAX_VALUE, Double.MAX_VALUE),
            NodeFactory.getChoiceBox(Arrays.asList(Gender.values()), Double.MAX_VALUE, Double.MAX_VALUE)
    );
    private PairNodePane<Label, ChoiceBox<PositionType>> pairPosition = new PairNodePane<>(
            NodeFactory.getLabel("Position", Double.MAX_VALUE, Double.MAX_VALUE),
            NodeFactory.getChoiceBox(Arrays.asList(PositionType.values()), Double.MAX_VALUE, Double.MAX_VALUE)
    );

    private PairNodePane<Label, ChoiceBox<LockType>> pairLock = new PairNodePane<>(
            NodeFactory.getLabel("Is locked", Double.MAX_VALUE, Double.MAX_VALUE),
            NodeFactory.getChoiceBox(Arrays.asList(LockType.values()), Double.MAX_VALUE, Double.MAX_VALUE)
    );

    private boolean isEditable;

    public InfoInputPair getPairLogin()
    {
        return pairLogin;
    }

    public InfoInputPair getPairPassword()
    {
        return pairPassword;
    }

    public PairNodePane<Label, ChoiceBox<RightType>> getPairRights()
    {
        return pairRights;
    }

    public InfoInputPair getPairQuestion()
    {
        return pairQuestion;
    }

    public InfoInputPair getPairAnswer()
    {
        return pairAnswer;
    }

    public InfoInputPair getPairName()
    {
        return pairName;
    }

    public InfoInputPair getPairSurname()
    {
        return pairSurname;
    }

    public InfoInputPair getPairAge()
    {
        return pairAge;
    }

    public InfoInputPair getPairEmail()
    {
        return pairEmail;
    }

    public PairNodePane<Label, ChoiceBox<Gender>> getPairGender()
    {
        return pairGender;
    }

    public PairNodePane<Label, ChoiceBox<PositionType>> getPairPosition()
    {
        return pairPosition;
    }

    public PairNodePane<Label, ChoiceBox<LockType>> getPairLock()
    {
        return pairLock;
    }

    private Account account;

    public Account getAccount()
    {
        return account;
    }

    public void setAccount(Account account)
    {
        cleanTextFields();

        pairLogin.getSecondNode().setText(account.getLogin());
        pairPassword.getSecondNode().setText(account.getPassword());
        pairQuestion.getSecondNode().setText(account.getQuestion());
        pairAnswer.getSecondNode().setText(account.getAnswer());
        pairEmail.getSecondNode().setText(account.getEmail());
        pairRegistrationDate.getSecondNode().setText(account.getRegistrationDate().toString());

        pairRights.getSecondNode().setValue(account.getRightType());
        pairLock.getSecondNode().setValue(account.getLockType());

        if (account.getEmployee() != null)
        {
            pairName.getSecondNode().setText(account.getEmployee().getName());
            pairSurname.getSecondNode().setText(account.getEmployee().getSurname());
            pairAge.getSecondNode().setText(String.valueOf(account.getEmployee().getAge()));

            pairGender.getSecondNode().setValue(account.getEmployee().getGender());
            pairPosition.getSecondNode().setValue(account.getEmployee().getPosition());
        }

        this.account = account;

        if (!isEditable)
        {
            setDisable(true);
        }
    }

    public AccountInfo(boolean isEditable)
    {
        this.isEditable = isEditable;
        init();
        if (!isEditable)
        {
            setDisable(true);
        }
    }

    public AccountInfo(Account account, boolean isEditable)
    {
        pairLogin = new InfoInputPair("Login", account.getLogin());
        pairPassword = new InfoInputPair("Password", account.getPassword());

        pairRights.getSecondNode().setValue(account.getRightType());
        pairLock.getSecondNode().setValue(account.getLockType());

        pairQuestion = new InfoInputPair("Question", account.getQuestion());
        pairAnswer = new InfoInputPair("Answer", account.getAnswer());
        pairEmail.getSecondNode().setText(account.getEmail());
        pairRegistrationDate.getSecondNode().setText(account.getRegistrationDate().toString());

        if (account.getEmployee() != null)
        {
            pairName.getSecondNode().setText(account.getEmployee().getName());
            pairSurname.getSecondNode().setText(account.getEmployee().getSurname());
            pairAge.getSecondNode().setText(String.valueOf(account.getEmployee().getAge()));

            pairGender.getSecondNode().setValue(account.getEmployee().getGender());
            pairPosition.getSecondNode().setValue(account.getEmployee().getPosition());
        }

        init();
        if (!isEditable)
        {
            setDisable(true);
        }
    }

    private void init()
    {
        setAlignment(Pos.CENTER);
        setVgap(INSETS);
        setHgap(INSETS);

        setMaxWidth(SMALL_ELEMENT_WIDTH * 5.5);

        for (int i = 0; i < 4; i++)
        {
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setPercentWidth(25);
            getColumnConstraints().add(columnConstraints);
        }

        for (int i = 0; i < 4; i++)
        {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setPercentHeight(25);
            getRowConstraints().add(rowConstraints);
        }

        GridPane.setHalignment(this, HPos.CENTER);
        GridPane.setValignment(this, VPos.CENTER);

        add(pairLogin, 0, 0);
        add(pairPassword, 1, 0);
        add(pairEmail, 2, 0, 2, 1);
        add(pairQuestion, 0, 1, 1, 1);
        add(pairAnswer, 1, 1, 1, 1);
        add(pairRegistrationDate, 2, 1, 2, 1);

        add(pairName, 0, 2);
        add(pairSurname, 1, 2);
        add(pairAge, 2, 2, 2, 1);
        add(pairGender, 0, 3, 1, 1);
        add(pairPosition, 1, 3, 1, 1);
        add(pairRights, 2, 3, 1, 1);
        add(pairLock, 3, 3, 1, 1);
    }

    public void cleanTextFields()
    {
        getChildren().forEach(node ->
        {
            if (node.getClass().equals(InfoInputPair.class))
            {
                InfoInputPair infoInputPair = (InfoInputPair) node;
                infoInputPair.getSecondNode().setText("");
            }
        });

        pairPosition.getSecondNode().setItems(FXCollections.observableList(Arrays.asList(PositionType.values())));
        pairRights.getSecondNode().setItems(FXCollections.observableList(Arrays.asList(RightType.values())));
        pairGender.getSecondNode().setItems(FXCollections.observableList(Arrays.asList(Gender.values())));
        pairLock.getSecondNode().setItems(FXCollections.observableList(Arrays.asList(LockType.values())));
    }
}
