package com.crm.main;

import com.crm.entity.employee.Employee;
import com.crm.entity.user.User;
import com.crm.managers.DatabaseManager;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Prigovor on 04.02.2017.
 */
public class Main extends Application
{
    private Stage primaryStage;

    private static Main instance;

    public static Main getInstance()
    {
        return instance;
    }

    public Main()
    {
        instance = this;
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        DatabaseManager.getInstance().configure("hibernate.cfg.xml", User.class, Employee.class);

        this.primaryStage = primaryStage;

        replaceSceneContent("/com/crm/menu/authorization/authorization.fxml");
        primaryStage.setFullScreen(true);
        primaryStage.setTitle("Title");
        primaryStage.show();
    }

    public void replaceSceneContent(String filePath) throws IOException
    {
        Scene scene = primaryStage.getScene();

        if (scene == null)
        {
            scene = new Scene(FXMLLoader.load(getClass().getResource(filePath)));
            primaryStage.setScene(scene);
        }
        else
        {
            primaryStage.getScene().setRoot(FXMLLoader.load(getClass().getResource(filePath)));
        }
    }

    @Override
    public void stop() throws Exception
    {
        Platform.exit();
        System.exit(0);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
