package com.crm.menu.node.custom;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;

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
    }
}
