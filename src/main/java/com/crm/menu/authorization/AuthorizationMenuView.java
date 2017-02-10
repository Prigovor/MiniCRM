package com.crm.menu.authorization;

import com.crm.menu.View;
import com.crm.menu.node.factory.NodeFactory;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

import static com.crm.menu.node.SizeConstants.*;

/**
 * Created by Bohdan on 09.02.2017.
 */
public class AuthorizationMenuView implements View
{
    private GridPane gridPane = new GridPane();

    private Label labelLogin = new Label();
    private Label labelPassword = new Label();

    private TextField textFieldLogin = new TextField();
    private PasswordField passwordField = new PasswordField();

    private Button buttonLogIn = new Button();
    private Button buttonExit = new Button();

    public TextField getTextFieldLogin()
    {
        return textFieldLogin;
    }

    public PasswordField getPasswordField()
    {
        return passwordField;
    }

    private AuthorizationMenuController controller;

    @Override
    public Parent getParent()
    {
        return gridPane;
    }

    public AuthorizationMenuView(AuthorizationMenuController controller)
    {
        this.controller = controller;
        init();
    }

    @Override
    public void init()
    {
        labelLogin = NodeFactory.getLabel("Login", SMALL_ELEMENT_WIDTH * 3, SMALL_ELEMENT_HEIGHT * 1.25);
        labelPassword = NodeFactory.getLabel("Password", SMALL_ELEMENT_WIDTH * 3, SMALL_ELEMENT_HEIGHT * 1.25);

        textFieldLogin = NodeFactory.getTextField(SMALL_ELEMENT_WIDTH * 3, SMALL_ELEMENT_HEIGHT * 1.25);
        passwordField = NodeFactory.getPasswordField(SMALL_ELEMENT_WIDTH * 3, SMALL_ELEMENT_HEIGHT * 1.25);

        buttonLogIn = NodeFactory.getButton("Log in", labelLogin.getMaxWidth() / 2, SMALL_ELEMENT_HEIGHT * 1.25);
        buttonExit = NodeFactory.getButton("Exit", labelLogin.getMaxWidth() / 2, SMALL_ELEMENT_HEIGHT * 1.25);

        GridPane gridPaneButtons = NodeFactory.getGridPane(1, 2);
        gridPaneButtons.setMaxWidth(labelLogin.getMaxWidth());

        gridPaneButtons.add(buttonLogIn, 0, 0);
        gridPaneButtons.add(buttonExit, 1, 0);

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(INSETS);
        gridPane.setVgap(INSETS);

        gridPane.setPadding(new Insets(INSETS));

        for (int i = 0; i < 1; i++)
        {
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setPercentWidth(100);
            gridPane.getColumnConstraints().add(columnConstraints);
        }

        gridPane.add(labelLogin, 0, 0);
        gridPane.add(textFieldLogin, 0, 1);
        gridPane.add(labelPassword, 0, 2);
        gridPane.add(passwordField, 0, 3);
        gridPane.add(gridPaneButtons, 0, 4);

        buttonLogIn.setOnAction(event ->
        {
            controller.logIn();
        });

        buttonExit.setOnAction(event ->
        {
            controller.exit();
        });
    }
}
