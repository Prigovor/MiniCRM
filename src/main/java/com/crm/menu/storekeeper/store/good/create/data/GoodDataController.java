package com.crm.menu.storekeeper.store.good.create.data;

import com.crm.database.entity.good.Good;
import com.crm.database.validation.ValidationException;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * Created by Bohdan on 14.03.2017.
 */
public class GoodDataController
{
    public TextField textFieldNomination;
    public TextArea textAreaDescription;
    public TextField textFieldAmount;
    public TextField textFieldPrice;

    public Button buttonConfirm;
    public Button buttonCancel;

    private GoodDataModel model = new GoodDataModel();

    @FXML
    public void initialize()
    {
        Good good = GoodCreationModel.getInstance().getGoodToCreate();

        textFieldNomination.setText(good.getNomination());
        textAreaDescription.setText(good.getDescription());

        if (good.getAmount() != null)
        {
            textFieldAmount.setText(String.valueOf(good.getAmount()));
        }

        if (good.getPrice() != null)
        {
            textFieldPrice.setText(String.valueOf(good.getPrice()));
        }

        buttonConfirm.setOnAction(event ->
        {
            try
            {
                model.setGoodData(textFieldNomination.getText(), textAreaDescription.getText(),
                        Integer.valueOf(textFieldAmount.getText()), Double.valueOf(textFieldPrice.getText()));
                model.confirm();
            }
            catch (ValidationException e)
            {
                showInformationMessage(e.getMessage());
            }
            catch (NumberFormatException e)
            {
                showInformationMessage("Enter valid numbers for amount and price");
            }
        });

        buttonCancel.setOnAction(event ->
        {
            model.cancel();
        });
    }

    public void showInformationMessage(String message)
    {
        new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK).show();
    }
}
