package com.crm.menu.node.factory;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import static com.crm.menu.node.SizeConstants.*;

/**
 * Created by Bohdan on 09.02.2017.
 */
public class NodeFactory
{
    public static GridPane getGridPane(int rowAmount, int columnAmount)
    {
        GridPane gridPane = new GridPane();

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(INSETS);
        gridPane.setHgap(INSETS);

        GridPane.setValignment(gridPane, VPos.CENTER);
        GridPane.setHalignment(gridPane, HPos.CENTER);

        for (int i = 0; i < rowAmount; i++)
        {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100 / rowAmount);
            gridPane.getRowConstraints().add(row);
        }

        for (int i = 0; i < columnAmount; i++)
        {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(100 / columnAmount);
            gridPane.getColumnConstraints().add(column);
        }

        return gridPane;
    }

    public static void transformGridPane(GridPane gridPane, int rowAmount, int columnAmount)
    {
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(INSETS);
        gridPane.setHgap(INSETS);

        GridPane.setValignment(gridPane, VPos.CENTER);
        GridPane.setHalignment(gridPane, HPos.CENTER);

        for (int i = 0; i < rowAmount; i++)
        {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100 / rowAmount);
            gridPane.getRowConstraints().add(row);
        }

        for (int i = 0; i < columnAmount; i++)
        {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(100 / columnAmount);
            gridPane.getColumnConstraints().add(column);
        }
    }

    public static Label getLabel(String text, Double maxWidth, Double maxHeight)
    {
        Label label = new Label(text);
        label.setAlignment(Pos.CENTER);
        label.setMinSize(SMALL_ELEMENT_WIDTH, SMALL_ELEMENT_HEIGHT);
        label.setMaxSize(maxWidth, maxHeight);
        label.setStyle("-fx-background-color: #1d1d1d;");

        GridPane.setValignment(label, VPos.CENTER);
        GridPane.setHalignment(label, HPos.CENTER);

        return label;
    }

    public static TextField getTextField(Double maxWidth, Double maxHeight)
    {
        TextField textField = new TextField();
        textField.setAlignment(Pos.CENTER);
        textField.setMinSize(SMALL_ELEMENT_WIDTH, SMALL_ELEMENT_HEIGHT);
        textField.setMaxSize(maxWidth, maxHeight);

        GridPane.setValignment(textField, VPos.CENTER);
        GridPane.setHalignment(textField, HPos.CENTER);

        return textField;
    }

    public static PasswordField getPasswordField(Double maxWidth, Double maxHeight)
    {
        PasswordField passwordField = new PasswordField();
        passwordField.setAlignment(Pos.CENTER);
        passwordField.setMinSize(SMALL_ELEMENT_WIDTH, SMALL_ELEMENT_HEIGHT);
        passwordField.setMaxSize(maxWidth, maxHeight);

        GridPane.setValignment(passwordField, VPos.CENTER);
        GridPane.setHalignment(passwordField, HPos.CENTER);

        return passwordField;
    }

    public static Button getButton(String text, Double maxWidth, Double maxHeight)
    {
        Button button = new Button(text);
        button.setAlignment(Pos.CENTER);
        button.setMinSize(SMALL_ELEMENT_WIDTH, SMALL_ELEMENT_HEIGHT);
        button.setMaxSize(maxWidth, maxHeight);

        GridPane.setValignment(button, VPos.CENTER);
        GridPane.setHalignment(button, HPos.CENTER);

        return button;
    }

    public static <T extends Labeled> void transformLabeled(T labeled, String text)
    {
        labeled.setText(text);
        labeled.setAlignment(Pos.CENTER);
        labeled.setMinSize(SMALL_ELEMENT_WIDTH, SMALL_ELEMENT_HEIGHT);
        labeled.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        GridPane.setValignment(labeled, VPos.CENTER);
        GridPane.setHalignment(labeled, HPos.CENTER);
    }
}