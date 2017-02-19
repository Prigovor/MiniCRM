package com.crm.menu.admin;

import com.crm.entity.employee.Employee;
import com.crm.entity.user.User;
import com.crm.main.Main;
import com.crm.managers.JsonFileManager;
import com.crm.menu.Controller;
import com.crm.menu.account.change.ChangeAccountMenuController;
import com.crm.menu.account.create.CreateAccountMenuController;
import com.crm.service.UserValidationException;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 * Created by Жека on 2/5/2017.
 */
public class AdminMenuController implements Controller
{
    private AdminMenuModel model = new AdminMenuModel();
    private AdminMenuView view = new AdminMenuView(this);

    @Override
    public AdminMenuView getView()
    {
        return view;
    }

    public AdminMenuModel getModel()
    {
        return model;
    }

    public AdminMenuController()
    {
        showListUsers();
    }

    public void showListUsers()
    {
        view.getUserListView().setItems(FXCollections.observableList(model.getListUsers()));
    }

    public void showUserInfo()
    {
        if (view.getUserListView().getSelectionModel().getSelectedItem() != null)
        {
            try
            {
                model.validateUser();
                view.getUserInfo().setUser(view.getUserListView().getSelectionModel().getSelectedItem());
            }
            catch (UserValidationException e)
            {
                view.getUserInfo().setDisable(true);
                view.getUserInfo().cleanTextFields();

                view.showInformationMessage(e.getMessage());
            }
        }
        else
        {
            view.getUserInfo().setDisable(true);
            view.getUserInfo().cleanTextFields();

            view.showInformationMessage("Select user in left-side list");
        }
    }

    public void showTableUsers()
    {
        try
        {
            view.getTableView().setItems(FXCollections.observableList(model.secureGetListUsers()));

            view.getTableView().getColumns().clear();

            for (Field field : User.class.getDeclaredFields())
            {
                TableColumn tableColumn = new TableColumn(field.getName());
                view.getTableView().getColumns().add(tableColumn);
                tableColumn.setCellValueFactory(new PropertyValueFactory(field.getName()));
            }
        }
        catch (UserValidationException e)
        {
            view.showInformationMessage(e.getMessage());
        }
    }

    public void showTableEmployers()
    {
        try
        {
            view.getTableView().setItems(FXCollections.observableList(model.secureGetListEmployers()));

            view.getTableView().getColumns().clear();

            for (Field field : Employee.class.getDeclaredFields())
            {
                TableColumn tableColumn = new TableColumn(field.getName());
                view.getTableView().getColumns().add(tableColumn);
                tableColumn.setCellValueFactory(new PropertyValueFactory(field.getName()));
            }
        }
        catch (UserValidationException e)
        {
            view.showInformationMessage(e.getMessage());
        }
    }

    public void addUser()
    {
        try
        {
            model.validateUser();
            Main.getInstance().replaceSceneContent(new CreateAccountMenuController());
        }
        catch (UserValidationException e)
        {
            view.showInformationMessage(e.getMessage());
        }
    }

    public void changeUser()
    {
        if (model.getSelectedUser() != null)
        {
            try
            {
                model.validateUser();
                Main.getInstance().replaceSceneContent(new ChangeAccountMenuController(model.getSelectedUser()));
            }
            catch (UserValidationException e)
            {
                view.showInformationMessage(e.getMessage());
            }
        }
        else
        {
            view.showInformationMessage("Select user in left-side list");
        }
    }

    public void deleteUser()
    {
        if (model.getSelectedUser() != null)
        {
            try
            {
                model.deleteUser(model.getSelectedUser());
                showListUsers();
            }
            catch (UserValidationException e)
            {
                view.showInformationMessage(e.getMessage());
            }
        }
        else
        {
            view.showInformationMessage("Select user in left-side list");
        }
    }

    public void generateUser()
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open resource File");

        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Json files", "*.json");

        fileChooser.getExtensionFilters().add(filter);
        fileChooser.setSelectedExtensionFilter(filter);

        File file = fileChooser.showOpenDialog(view.getParent().getScene().getWindow());

        if (file != null)
        {
            try
            {
                model.generateUser(JsonFileManager.deserializeFromJsonFile(Employee.class, file.getAbsolutePath()));
                showListUsers();
            }
            catch (IOException | UserValidationException | MessagingException e)
            {
                view.showInformationMessage(e.getMessage());
            }
        }
    }
}
