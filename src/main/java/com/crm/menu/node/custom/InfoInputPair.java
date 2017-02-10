package com.crm.menu.node.custom;

import com.crm.menu.node.factory.NodeFactory;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import static com.crm.menu.node.SizeConstants.INSETS;

/**
 * Created by Bohdan on 10.02.2017.
 */
public class InfoInputPair extends GridPane
{
    private Label labelInfo = new Label();
    private TextField textFieldInput = new TextField();

    public Label getLabelInfo()
    {
        return labelInfo;
    }

    public TextField getTextFieldInput()
    {
        return textFieldInput;
    }

    public String getInputText()
    {
        return textFieldInput.getText();
    }

    public InfoInputPair(String textInfo)
    {
        setAlignment(Pos.CENTER);
        setMaxWidth(Double.MAX_VALUE);

        NodeFactory.transformLabeled(labelInfo, textInfo);
        textFieldInput = NodeFactory.getTextField(Double.MAX_VALUE, Double.MAX_VALUE);

        init();
    }

    public InfoInputPair(String textInfo, String textInput)
    {
        this(textInfo);
        textFieldInput.setText(textInput);
    }

    private void init()
    {
        add(labelInfo, 0, 0);
        add(textFieldInput, 0, 1);

        setHgap(INSETS);
        setVgap(INSETS);
    }
}
