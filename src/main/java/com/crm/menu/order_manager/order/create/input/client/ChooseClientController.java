package com.crm.menu.order_manager.order.create.input.client;

import com.crm.database.entity.client.Client;
import com.crm.database.validation.ValidationException;
import com.crm.menu.order_manager.order.create.OrderCreationModel;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 * Created by Bohdan on 14.03.2017.
 */
public class ChooseClientController
{
    public ListView<Client> listViewClients;

    public Button buttonConfirm;
    public Button buttonBack;
    public Button buttonCancel;

    private ChooseClientModel model = new ChooseClientModel();

    @FXML
    public void initialize()
    {
        listViewClients.setItems(FXCollections.observableList(model.getListClients()));

        Client client = OrderCreationModel.getInstance().getOrder().getClient();

        if (client != null)
        {
            if (!listViewClients.getItems().contains(client))
            {
                listViewClients.getItems().add(client);
            }
            listViewClients.getSelectionModel().select(client);
        }

        buttonConfirm.setOnAction(event ->
        {
            Client selectedClient = listViewClients.getSelectionModel().getSelectedItem();

            if (selectedClient != null)
            {
                try
                {
                    model.setOrderToClient(selectedClient);
                    model.confirm();
                }
                catch (ValidationException e)
                {
                    showInformationMessage(e.getMessage());
                }
            }
            else
            {
                showInformationMessage("Choose client from the list");
            }
        });

        buttonBack.setOnAction(event ->
        {
            model.back();
        });

        buttonCancel.setOnAction(event ->
        {
            model.cancel();
        });
    }

    private void showInformationMessage(String text)
    {
        new Alert(Alert.AlertType.INFORMATION, text).showAndWait();
    }
}
