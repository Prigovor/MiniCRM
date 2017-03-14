package com.crm.node.good;

import com.crm.database.entity.good.Good;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Created by Bohdan on 14.03.2017.
 */
public class GoodInfo extends AnchorPane
{
    public TextField textFieldNomination;
    public TextArea textAreaDescription;
    public TextField textFieldAmount;
    public TextField textFieldPrice;

    private Good good;

    public Good getGood()
    {
        return good;
    }

    public void setGood(Good good)
    {
        this.good = good;

        textFieldNomination.setText(good.getNomination());
        textAreaDescription.setText(good.getDescription());
        textFieldAmount.setText(String.valueOf(good.getAmount()));
        textFieldPrice.setText(String.valueOf(good.getPrice()));
    }

    public GoodInfo()
    {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml-files/custom-panes/good-info.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try
        {
            fxmlLoader.load();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void clear()
    {
        textFieldNomination.clear();
        textAreaDescription.clear();
        textFieldAmount.clear();
        textFieldPrice.clear();
    }
}
