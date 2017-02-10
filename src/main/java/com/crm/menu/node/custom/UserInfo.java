package com.crm.menu.node.custom;

import com.crm.entity.user.User;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import static com.crm.menu.node.SizeConstants.INSETS;

/**
 * Created by Bohdan on 10.02.2017.
 */
public class UserInfo extends GridPane
{
    private InfoInputPair pairLogin = new InfoInputPair("Login");
    private InfoInputPair pairPassword = new InfoInputPair("Password");
    private InfoInputPair pairUserType = new InfoInputPair("User type");
    private InfoInputPair pairQuestion = new InfoInputPair("Question");
    private InfoInputPair pairAnswer = new InfoInputPair("Answer");

    private InfoInputPair pairName = new InfoInputPair("Name");
    private InfoInputPair pairSurname = new InfoInputPair("Surname");
    private InfoInputPair pairAge = new InfoInputPair("Age");
    private InfoInputPair pairGender = new InfoInputPair("Gender");
    private InfoInputPair pairPosition = new InfoInputPair("Position");

    public InfoInputPair getPairLogin()
    {
        return pairLogin;
    }

    public InfoInputPair getPairPassword()
    {
        return pairPassword;
    }

    public InfoInputPair getPairUserType()
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

    public InfoInputPair getPairGender()
    {
        return pairGender;
    }

    public InfoInputPair getPairPosition()
    {
        return pairPosition;
    }

    public UserInfo(boolean isEditable)
    {
        init();
        if (!isEditable)
        {
            getChildren().forEach(node ->
            {
                InfoInputPair infoInputPair = (InfoInputPair) node;
                infoInputPair.getTextFieldInput().setEditable(false);
            });
        }
    }

    public UserInfo(User user, boolean isEditable)
    {
        pairLogin = new InfoInputPair("Login", user.getLogin());
        pairPassword = new InfoInputPair("Password", user.getPassword());
        pairUserType = new InfoInputPair("User type", user.getUserType().name());
        pairQuestion = new InfoInputPair("Question", user.getSecurityQuestion());
        pairAnswer = new InfoInputPair("Answer", user.getAnswerToSecurityQuestion());

        pairName = new InfoInputPair("Name", user.getEmployee().getName());
        pairSurname = new InfoInputPair("Surname", user.getEmployee().getSurname());
        pairAge = new InfoInputPair("Age", String.valueOf(user.getEmployee().getAge()));
        pairGender = new InfoInputPair("Gender", user.getEmployee().getGender().name());
        pairPosition = new InfoInputPair("Position", user.getEmployee().getPosition().name());

        init();
        if (!isEditable)
        {
            getChildren().forEach(node ->
            {
                InfoInputPair infoInputPair = (InfoInputPair) node;
                infoInputPair.getTextFieldInput().setEditable(false);
            });
        }
    }

    private void init()
    {
        setAlignment(Pos.CENTER);
        setHgap(INSETS);
        setVgap(INSETS);

        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setHgrow(Priority.ALWAYS);
        getColumnConstraints().add(columnConstraints);

        add(pairLogin, 0, 0);
        add(pairPassword, 1 , 0);
        add(pairUserType, 0 , 1, 2, 1);
        add(pairQuestion, 0, 2);
        add(pairAnswer, 1, 2);

        add(pairName, 0, 3);
        add(pairSurname, 1, 3);
        add(pairAge, 0, 4);
        add(pairGender, 1, 4);
        add(pairPosition, 0, 5, 2, 1);
    }
}
