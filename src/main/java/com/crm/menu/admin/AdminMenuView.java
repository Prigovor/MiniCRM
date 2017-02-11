package com.crm.menu.admin;

import com.crm.entity.user.User;
import com.crm.main.Main;
import com.crm.menu.View;
import com.crm.menu.authorization.AuthorizationMenuController;
import com.crm.menu.node.custom.UserInfo;
import com.crm.menu.node.factory.NodeFactory;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

import static com.crm.menu.node.SizeConstants.INSETS;
import static com.crm.menu.node.SizeConstants.SMALL_ELEMENT_HEIGHT;

/**
 * Created by Bohdan on 09.02.2017.
 */
public class AdminMenuView implements View {
    private GridPane gridPane = new GridPane();

    private ListView<User> userListView = new ListView<>();

    private TableView tableView = new TableView();
    private UserInfo userInfo = new UserInfo(false);

    private Button buttonShowUserInfo = new Button();

    private Button buttonShowAllUsers = new Button();
    private Button buttonShowAllEmployers = new Button();

    private Button buttonAdd = new Button();
    private Button buttonGenerate = new Button();
    private Button buttonChange = new Button();
    private Button buttonDelete = new Button();

    private Button buttonUnlogin = new Button();

    private AdminMenuModel model;
    private AdminMenuController controller;

    public ListView<User> getUserListView() {
        return userListView;
    }

    public TableView getTableView() {
        return tableView;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public AdminMenuView(AdminMenuController controller) {
        this.controller = controller;
        this.model = controller.getModel();
        init();
        playInitAnimation();
    }

    @Override
    public Parent getParent() {
        return gridPane;
    }

    @Override
    public void init() {
        tableView.widthProperty().addListener((observable, oldValue, newValue) ->
        {
            buttonShowAllEmployers.setMinWidth(newValue.doubleValue() / 2 - INSETS / 2);
            buttonShowAllUsers.setMinWidth(newValue.doubleValue() / 2 - INSETS / 2);

            buttonAdd.setMinWidth(buttonShowAllEmployers.getMinWidth() / 2 - INSETS / 2);
            buttonChange.setMinWidth(buttonShowAllEmployers.getMinWidth() / 2 - INSETS / 2);
            buttonDelete.setMinWidth(buttonShowAllUsers.getMinWidth() / 2 - INSETS / 2);
            buttonGenerate.setMinWidth(buttonShowAllUsers.getMinWidth() / 2 - INSETS / 2);
        });

        userListView.widthProperty().addListener((observable, oldValue, newValue) ->
        {
            buttonShowUserInfo.setMinWidth(newValue.doubleValue());
        });

        buttonShowAllUsers = NodeFactory.getButton("Show all user accounts", tableView.getMaxWidth() / 2, SMALL_ELEMENT_HEIGHT * 1.5);
        buttonShowAllEmployers = NodeFactory.getButton("Show all employers", buttonShowAllUsers.getMaxWidth(), buttonShowAllUsers.getMaxHeight());

        buttonShowUserInfo = NodeFactory.getButton("Show user info", userListView.getMaxWidth(), buttonShowAllUsers.getMaxHeight() * 3 + INSETS);

        GridPane gridPaneShowAllButtons = NodeFactory.getGridPane(1, 2);
        gridPaneShowAllButtons.add(buttonShowAllUsers, 0, 0);
        gridPaneShowAllButtons.add(buttonShowAllEmployers, 1, 0);
        gridPaneShowAllButtons.setMaxWidth(tableView.getMaxWidth());

        buttonAdd = NodeFactory.getButton("Add user", tableView.getMaxWidth() / 4, SMALL_ELEMENT_HEIGHT * 1.5);
        buttonChange = NodeFactory.getButton("Change user", tableView.getMaxWidth() / 4, SMALL_ELEMENT_HEIGHT * 1.5);
        buttonDelete = NodeFactory.getButton("Delete user", tableView.getMaxWidth() / 4, SMALL_ELEMENT_HEIGHT * 1.5);
        buttonGenerate = NodeFactory.getButton("Generate user", tableView.getMaxWidth() / 4, SMALL_ELEMENT_HEIGHT * 1.5);
        buttonUnlogin = NodeFactory.getButton("Unlogin", tableView.getMaxWidth(), buttonAdd.getMaxHeight());

        GridPane gridPaneDBControlButtons = NodeFactory.getGridPane(1, 4);
        gridPaneDBControlButtons.add(buttonAdd, 0, 0);
        gridPaneDBControlButtons.add(buttonChange, 1, 0);
        gridPaneDBControlButtons.add(buttonDelete, 2, 0);
        gridPaneDBControlButtons.add(buttonGenerate, 3, 0);
        gridPaneDBControlButtons.setMaxWidth(tableView.getMaxWidth());

        tableView.setDisable(true);
        tableView.setOpacity(0.0);

        GridPane gridPaneRightSideControls = NodeFactory.getGridPane(4, 2);
        gridPaneRightSideControls.add(tableView, 1, 0);
        gridPaneRightSideControls.add(userInfo, 1, 0);
        gridPaneRightSideControls.add(gridPaneShowAllButtons, 1, 1);
        gridPaneRightSideControls.add(gridPaneDBControlButtons, 1, 2);
        gridPaneRightSideControls.add(userListView, 0, 0);
        gridPaneRightSideControls.add(buttonShowUserInfo, 0, 1, 1, 2);
        gridPaneRightSideControls.add(buttonUnlogin, 0, 3, 2, 1);

        buttonUnlogin.setMaxWidth(Double.MAX_VALUE);
        gridPaneRightSideControls.getRowConstraints().get(0).setPercentHeight(70);
        gridPaneRightSideControls.getRowConstraints().get(1).setPercentHeight(10);
        gridPaneRightSideControls.getRowConstraints().get(2).setPercentHeight(10);
        gridPaneRightSideControls.getRowConstraints().get(3).setPercentHeight(10);

        gridPaneRightSideControls.getColumnConstraints().get(0).setPercentWidth(15);

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(INSETS);
        gridPane.setHgap(INSETS);

        gridPane.setPadding(new Insets(INSETS * 5));

        gridPane.add(gridPaneRightSideControls, 0, 0);

        tableView.setMaxWidth(userInfo.getMaxWidth());

        buttonShowUserInfo.setOnAction(event ->
        {
            userInfo.setOpacity(1.0);
            userInfo.setDisable(false);
            tableView.setOpacity(0.0);
            tableView.setDisable(true);
            controller.showUserInfo();
        });

        buttonShowAllUsers.setOnAction(event ->
        {
            userInfo.setOpacity(0.0);
            userInfo.setDisable(true);
            tableView.setOpacity(1.0);
            tableView.setDisable(false);
            controller.showTableUsers();
        });

        buttonShowAllEmployers.setOnAction(event ->
        {
            userInfo.setOpacity(0.0);
            userInfo.setDisable(true);
            tableView.setOpacity(1.0);
            tableView.setDisable(false);
            controller.showTableEmployers();
        });

        buttonAdd.setOnAction(event ->
        {
            controller.addUser();
        });

        buttonChange.setOnAction(event ->
        {
            model.setSelectedUser(userListView.getSelectionModel().getSelectedItem());
            controller.changeUser();
        });

        buttonDelete.setOnAction(event ->
        {
            model.setSelectedUser(userListView.getSelectionModel().getSelectedItem());
            controller.deleteUser();
        });

        buttonGenerate.setOnAction(event ->
        {
            controller.generateUser();
        });

        buttonUnlogin.setOnAction(event ->
        {
            // TODO: 11.02.2017 COSTYIL!!!
            Main.getInstance().replaceSceneContent(new AuthorizationMenuController());
        });
    }
}
