package com.crm.menu.order_manager.client;

import com.crm.database.entity.client.Client;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.lang.reflect.Field;

/**
 * Created by Bohdan on 14.03.2017.
 */
public class ClientManagementController
{
    @FXML
    private ListView<Client> listViewClients;

    @FXML
    private Button buttonShowClientInfo;

    @FXML
    private Button buttonDeleteClient;

    @FXML
    private Button buttonChangeClient;

    @FXML
    private Button buttonAddClient;

    @FXML
    private Button buttonGenerateClient;

    @FXML
    private Button buttonShowAllClients;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonRefresh;

    @FXML
    private TableView tableView;

    @FXML
    private TextArea textAreaClientInfo;

    private ClientManagementModel model = new ClientManagementModel();

    @FXML
    public void initialize()
    {
        listViewClients.setItems(FXCollections.observableList(model.getListClients()));

        listViewClients.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
        {
            model.setSelectedClient(newValue);
        });

        buttonAddClient.setOnAction(event ->
        {
            addClient();
        });

        buttonChangeClient.setOnAction(event ->
        {
            changeClient();
        });

        buttonDeleteClient.setOnAction(event ->
        {
            deleteClient();
        });

        buttonGenerateClient.setOnAction(event ->
        {
            generateClient();
        });

        buttonShowClientInfo.setOnAction(event ->
        {
            showClientInfo();
        });

        buttonShowAllClients.setOnAction(event ->
        {
            showAllClients();
        });

        buttonBack.setOnAction(event ->
        {
            back();
        });

        buttonRefresh.setOnAction(event ->
        {
            refresh();
        });
    }

    private void generateClient()
    {
        model.generateClient();
    }

    private void showClientInfo()
    {
        if (model.getSelectedClient() != null)
        {
            tableView.setOpacity(0.0);
            tableView.setDisable(true);
            textAreaClientInfo.setOpacity(1.0);
            textAreaClientInfo.setDisable(false);

            textAreaClientInfo.setText(model.getClientInfo());
        }
        else
        {
            showInformationMessage("Select client from the list");
        }
    }

    private void showAllClients()
    {
        textAreaClientInfo.setOpacity(0.0);
        textAreaClientInfo.setDisable(true);
        tableView.setOpacity(1.0);
        tableView.setDisable(false);

        tableView.setItems(FXCollections.observableList(model.getListClients()));

        tableView.getColumns().clear();
        for (Field field : Client.class.getDeclaredFields())
        {
            if (field.getName().equals("orders") || field.getName().equals("password"))
            {
                continue;
            }
            TableColumn tableColumn = new TableColumn(field.getName());
            tableColumn.setCellValueFactory(new PropertyValueFactory<>(field.getName()));
            tableView.getColumns().add(tableColumn);
        }
    }

    private void changeClient()
    {
        if (model.getSelectedClient() != null)
        {
            model.changeClient();
        }
        else
        {
            showInformationMessage("Select client from the list");
        }
    }

    private void deleteClient()
    {
        if (model.getSelectedClient() != null)
        {
            model.deleteClient();
            refresh();
        }
        else
        {
            showInformationMessage("Select client from the list");
        }
    }

    private void addClient()
    {
        model.addClient();
    }

    private void refresh()
    {
        listViewClients.setItems(FXCollections.observableList(model.getListClients()));
        tableView.getItems().clear();
        textAreaClientInfo.clear();
    }

    private void back()
    {
        model.back();
    }

    private void showInformationMessage(String text)
    {
        new Alert(Alert.AlertType.INFORMATION, text).showAndWait();
    }
}
