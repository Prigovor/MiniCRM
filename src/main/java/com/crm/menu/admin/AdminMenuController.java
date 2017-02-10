package com.crm.menu.admin;

import com.crm.entity.employee.Employee;
import com.crm.entity.user.User;
import com.crm.menu.Controller;
import com.crm.service.UserValidationException;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

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
}
