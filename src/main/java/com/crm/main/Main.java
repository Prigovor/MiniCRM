package com.crm.main;

import com.crm.dao.FactoryDAO;
import com.crm.entity.employee.Employee;
import com.crm.entity.employee.courier.Courier;
import com.crm.entity.user.User;
import com.crm.managers.DatabaseManager;
import com.crm.menu.Controller;
import com.crm.menu.authorization.AuthorizationMenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.support.GenericXmlApplicationContext;

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
        this.primaryStage = primaryStage;

        replaceSceneContent(new AuthorizationMenuController());

        primaryStage.getScene().getStylesheets().addAll("/css-styles/mini-crm.css");

        primaryStage.setTitle("MiniCRM");
        primaryStage.setMaximized(true);

        primaryStage.setOnCloseRequest(event ->
        {
            exit();
        });

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

    /**
     * Replaces the application primary stage scene with view parent object taken from controller object
     */
    public void replaceSceneContent(Controller controller)
    {
        Scene scene = primaryStage.getScene();

        if (scene == null)
        {
            scene = new Scene(controller.getView().getParent());
            primaryStage.setScene(scene);
        }
        else
        {
            primaryStage.getScene().setRoot(controller.getView().getParent());
        }

        primaryStage.getScene().getRoot().setStyle("-fx-background-color: #393c3e;");
        controller.getView().getParent().requestFocus();
    }

    public void exit()
    {
        primaryStage.close();
        System.exit(0);
    }

    public static void main(String[] args)
    {
        Thread thread = new Thread(() ->
        {
            DatabaseManager.getInstance().configure("hibernate.cfg.xml", User.class, Employee.class);

            GenericXmlApplicationContext context = new GenericXmlApplicationContext("/spring-config/spring-config.xml");

            FactoryDAO.getUserDAO().createUser(context.getBean("userRoot", User.class));
            FactoryDAO.getEmployeeDAO().createEmployee(context.getBean("employeeAlan", Employee.class));
            FactoryDAO.getUserDAO().createUser(context.getBean("userManagerAlan", User.class));
            FactoryDAO.getCourierDAO().createCourier(context.getBean("courierJane", Courier.class));
        });
        thread.setDaemon(true);
        thread.start();

        launch(args);
    }
}
