package com.crm.menu.node.custom;

import com.crm.menu.node.factory.NodeFactory;
import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.lang.reflect.Field;
import java.util.Arrays;

import static com.crm.menu.node.SizeConstants.INSETS;

/**
 * Created by Bohdan on 11.02.2017.
 */
public class ObjectInfoPane<I> extends GridPane
{
    private I innerObject;

    public I getInnerObject()
    {
        return innerObject;
    }

    public void setInnerObject(I innerObject)
    {
        this.innerObject = innerObject;
        try
        {
            init();
        }
        catch (IllegalAccessException e)
        {
        }
    }

    public ObjectInfoPane()
    {
    }

    public ObjectInfoPane(I innerObject)
    {
        setInnerObject(innerObject);
    }

    public void init() throws IllegalAccessException
    {
        setAlignment(Pos.CENTER);
        setVgap(INSETS);
        setHgap(INSETS);

        GridPane.setHalignment(this, HPos.CENTER);
        GridPane.setValignment(this, VPos.CENTER);

        for (Field field : innerObject.getClass().getDeclaredFields())
        {
            if (field.getType().isEnum())
            {
                PairNodePane<Label, ChoiceBox> pairNodePane = new PairNodePane<>();

                pairNodePane.setFirstNode(NodeFactory.getLabel("", Double.MAX_VALUE, Double.MAX_VALUE));
                pairNodePane.setSecondNode(NodeFactory.getChoiceBox(Double.MAX_VALUE, Double.MAX_VALUE));

                pairNodePane.getFirstNode()
                        .setText(field.getName().replaceFirst("\\w", field.getName().substring(0, 1).toUpperCase()));

                pairNodePane.getSecondNode()
                        .setItems(FXCollections.observableList(Arrays.asList(field.getType().getEnumConstants())));
                pairNodePane.getSecondNode()
                        .setValue(field.getType().getEnumConstants()[0]);
            }
            else
            {
                PairNodePane<Label, TextField> pairNodePane = new PairNodePane<>();

                pairNodePane.setFirstNode(NodeFactory.getLabel("", Double.MAX_VALUE, Double.MAX_VALUE));
                pairNodePane.setSecondNode(NodeFactory.getTextField(Double.MAX_VALUE, Double.MAX_VALUE));

                pairNodePane.getFirstNode()
                        .setText(field.getName().replaceFirst("\\w", field.getName().substring(0, 1).toUpperCase()));

                field.setAccessible(true);
                pairNodePane.getSecondNode()
                        .setText(field.get(innerObject).toString());
            }
        }
    }
}
