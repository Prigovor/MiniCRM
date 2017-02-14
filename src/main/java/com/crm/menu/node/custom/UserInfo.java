package com.crm.menu.node.custom;

import com.crm.entity.employee.Gender;
import com.crm.entity.employee.PositionType;
import com.crm.entity.user.User;
import com.crm.entity.user.UserType;
import com.crm.menu.node.factory.NodeFactory;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.Arrays;

import static com.crm.menu.node.SizeConstants.INSETS;
import static com.crm.menu.node.SizeConstants.SMALL_ELEMENT_WIDTH;

/**
 * Created by Bohdan on 10.02.2017.
 */
public class UserInfo extends GridPane
{
    private InfoInputPair pairLogin = new InfoInputPair("Login");
    private InfoInputPair pairPassword = new InfoInputPair("Password");

    private PairNodePane<Label, ChoiceBox<UserType>> pairUserType = new PairNodePane<>(
            NodeFactory.getLabel("User type", Double.MAX_VALUE, Double.MAX_VALUE),
            NodeFactory.getChoiceBox(Arrays.asList(UserType.values()), Double.MAX_VALUE, Double.MAX_VALUE)
    );

    private InfoInputPair pairQuestion = new InfoInputPair("Question");
    private InfoInputPair pairAnswer = new InfoInputPair("Answer");

    private InfoInputPair pairName = new InfoInputPair("Name");
    private InfoInputPair pairSurname = new InfoInputPair("Surname");
    private InfoInputPair pairAge = new InfoInputPair("Age");
    private InfoInputPair pairEmail = new InfoInputPair("Email");

    private PairNodePane<Label, ChoiceBox<Gender>> pairGender = new PairNodePane<>(
            NodeFactory.getLabel("Gender", Double.MAX_VALUE, Double.MAX_VALUE),
            NodeFactory.getChoiceBox(Arrays.asList(Gender.values()), Double.MAX_VALUE, Double.MAX_VALUE)
    );
    private PairNodePane<Label, ChoiceBox<PositionType>> pairPosition = new PairNodePane<>(
            NodeFactory.getLabel("Position", Double.MAX_VALUE, Double.MAX_VALUE),
            NodeFactory.getChoiceBox(Arrays.asList(PositionType.values()), Double.MAX_VALUE, Double.MAX_VALUE)
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

    public PairNodePane<Label, ChoiceBox<UserType>> getPairUserType()
    {
        return pairUserType;
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

    private User user;

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        cleanTextFields();

        pairLogin.getSecondNode().setText(user.getLogin());
        pairPassword.getSecondNode().setText(user.getPassword());
        pairQuestion.getSecondNode().setText(user.getQuestion());
        pairAnswer.getSecondNode().setText(user.getAnswer());
        pairEmail.getSecondNode().setText(user.getEmail());

        pairUserType.getSecondNode().setValue(UserType.EMPTY);

        if (user.getEmployee() != null)
        {
            pairName.getSecondNode().setText(user.getEmployee().getName());
            pairSurname.getSecondNode().setText(user.getEmployee().getSurname());
            pairAge.getSecondNode().setText(String.valueOf(user.getEmployee().getAge()));

            pairGender.getSecondNode().setValue(Gender.EMPTY);
            pairPosition.getSecondNode().setValue(PositionType.EMPTY);
        }

        this.user = user;
    }

    public UserInfo(boolean isEditable)
    {
        this.isEditable = isEditable;
        init();
        if (!isEditable)
        {
            setDisable(true);
        }
    }

    public UserInfo(User user, boolean isEditable)
    {
        pairLogin = new InfoInputPair("Login", user.getLogin());
        pairPassword = new InfoInputPair("Password", user.getPassword());

        pairUserType.getSecondNode().setValue(user.getUserType());

        pairQuestion = new InfoInputPair("Question", user.getQuestion());
        pairAnswer = new InfoInputPair("Answer", user.getAnswer());
        pairEmail.getSecondNode().setText(user.getEmail());

        if (user.getEmployee() != null)
        {
            pairName.getSecondNode().setText(user.getEmployee().getName());
            pairSurname.getSecondNode().setText(user.getEmployee().getSurname());
            pairAge.getSecondNode().setText(String.valueOf(user.getEmployee().getAge()));

            pairGender.getSecondNode().setValue(user.getEmployee().getGender());
            pairPosition.getSecondNode().setValue(user.getEmployee().getPosition());
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
        add(pairEmail, 2, 0);
        add(pairUserType, 3, 0);
        add(pairQuestion, 0, 1, 2, 1);
        add(pairAnswer, 2, 1, 2, 1);

        add(pairName, 0, 2);
        add(pairSurname, 1, 2);
        add(pairAge, 2, 2);
        add(pairGender, 0, 3, 2, 1);
        add(pairPosition, 2, 3, 2, 1);
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

        pairPosition.getSecondNode().setValue(PositionType.EMPTY);
        pairUserType.getSecondNode().setValue(UserType.EMPTY);
        pairGender.getSecondNode().setValue(Gender.EMPTY);

        if (!isEditable)
        {
            setDisable(true);
        }
    }
}
