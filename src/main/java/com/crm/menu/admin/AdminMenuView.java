package com.crm.menu.admin;

import com.crm.entity.user.User;
import com.crm.menu.View;
import com.crm.menu.node.factory.NodeFactory;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

import static com.crm.menu.node.SizeConstants.INSETS;
import static com.crm.menu.node.SizeConstants.SMALL_ELEMENT_HEIGHT;

/**
 * Created by Bohdan on 09.02.2017.
 */
public class AdminMenuView implements View
{
    private GridPane gridPane = new GridPane();

    private ListView<User> userListView = new ListView<>();

    private TableView tableView = new TableView();

    private Button buttonShowAllUsers = new Button();
    private Button buttonShowAllEmployers = new Button();

    private Button buttonAdd = new Button();
    private Button buttonGenerate = new Button();
    private Button buttonChange = new Button();
    private Button buttonDelete = new Button();

    private AdminMenuModel model;
    private AdminMenuController controller;

    public ListView<User> getUserListView()
    {
        return userListView;
    }

    public TableView getTableView()
    {
        return tableView;
    }

    public AdminMenuView(AdminMenuController controller)
    {
        this.controller = controller;
        this.model = controller.getModel();
        init();
    }

    @Override
    public Parent getParent()
    {
        return gridPane;
    }

    @Override
    public void init()
    {
        tableView.widthProperty().addListener((observable, oldValue, newValue) ->
        {
            buttonShowAllEmployers.setMinWidth(newValue.doubleValue() / 2 - INSETS / 2);
            buttonShowAllUsers.setMinWidth(newValue.doubleValue() / 2 - INSETS / 2);

            buttonAdd.setMinWidth(buttonShowAllEmployers.getMinWidth() / 2 - INSETS / 2);
            buttonChange.setMinWidth(buttonShowAllEmployers.getMinWidth() / 2 - INSETS / 2);
            buttonDelete.setMinWidth(buttonShowAllUsers.getMinWidth() / 2 - INSETS / 2);
            buttonGenerate.setMinWidth(buttonShowAllUsers.getMinWidth() / 2 - INSETS / 2);
        });

        buttonShowAllUsers = NodeFactory.getButton("Show all user accounts", tableView.getMaxWidth() / 2, SMALL_ELEMENT_HEIGHT * 1.5);
        buttonShowAllEmployers = NodeFactory.getButton("Show all employers", buttonShowAllUsers.getMaxWidth(), buttonShowAllUsers.getMaxHeight());

        GridPane gridPaneShowAllButtons = NodeFactory.getGridPane(1, 2);
        gridPaneShowAllButtons.add(buttonShowAllUsers, 0, 0);
        gridPaneShowAllButtons.add(buttonShowAllEmployers, 1, 0);
        gridPaneShowAllButtons.setMaxWidth(tableView.getMaxWidth());

        buttonAdd = NodeFactory.getButton("Add user", tableView.getMaxWidth() / 4, SMALL_ELEMENT_HEIGHT * 1.5);
        buttonChange = NodeFactory.getButton("Change user", tableView.getMaxWidth() / 4, SMALL_ELEMENT_HEIGHT * 1.5);
        buttonDelete = NodeFactory.getButton("Delete user", tableView.getMaxWidth() / 4, SMALL_ELEMENT_HEIGHT * 1.5);
        buttonGenerate = NodeFactory.getButton("Generate user", tableView.getMaxWidth() / 4, SMALL_ELEMENT_HEIGHT * 1.5);

        GridPane gridPaneDBControlButtons = NodeFactory.getGridPane(1, 4);
        gridPaneDBControlButtons.add(buttonAdd, 0, 0);
        gridPaneDBControlButtons.add(buttonChange, 1, 0);
        gridPaneDBControlButtons.add(buttonDelete, 2, 0);
        gridPaneDBControlButtons.add(buttonGenerate, 3, 0);
        gridPaneDBControlButtons.setMaxWidth(tableView.getMaxWidth());

        GridPane gridPaneRightSideControls = NodeFactory.getGridPane(3, 1);
        gridPaneRightSideControls.add(tableView, 0, 0);
        gridPaneRightSideControls.add(gridPaneShowAllButtons, 0, 1);
        gridPaneRightSideControls.add(gridPaneDBControlButtons, 0, 2);

        gridPaneRightSideControls.getRowConstraints().get(0).setPercentHeight(80);
        gridPaneRightSideControls.getRowConstraints().get(1).setPercentHeight(10);
        gridPaneRightSideControls.getRowConstraints().get(2).setPercentHeight(10);

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(INSETS);
        gridPane.setHgap(INSETS);

        gridPane.setPadding(new Insets(INSETS * 5));

        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPercentWidth(15);
        gridPane.getColumnConstraints().add(columnConstraints);

        gridPane.add(userListView, 0, 0);
        gridPane.add(gridPaneRightSideControls, 1, 0);

        buttonShowAllUsers.setOnAction(event ->
        {
            controller.showTableUsers();
        });

        buttonShowAllEmployers.setOnAction(event ->
        {
            controller.showTableEmployers();
        });
    }
}
