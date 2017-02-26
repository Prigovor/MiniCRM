package com.crm.main;

import com.crm.dao.FactoryDAO;
import com.crm.dao.account.AccountDAOImplSpring;
import com.crm.entity.account.Account;
import com.crm.entity.client.Client;
import com.crm.entity.courier.Courier;
import com.crm.entity.good.Good;
import com.crm.entity.order.Order;
import com.crm.entity.storekeeper.Storekeeper;
import com.crm.menu.Controller;
import com.sun.org.apache.xpath.internal.operations.Or;
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

        replaceSceneContent("/fxml-files/authorization-menu.fxml");

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
        GenericXmlApplicationContext context = new GenericXmlApplicationContext("/spring-config/spring-config.xml");

        FactoryDAO.getAccountDAO().createAccount(context.getBean("accountAdmin", Account.class));
        FactoryDAO.getAccountDAO().createAccount(context.getBean("accountManagerAlan", Account.class));
        FactoryDAO.getAccountDAO().createAccount(context.getBean("accountStorekeeperJake", Account.class));
        FactoryDAO.getAccountDAO().createAccount(context.getBean("accountCourierJane", Account.class));

        FactoryDAO.getGoodDAO().createGood(context.getBean("goodLaptopHP", Good.class));
        FactoryDAO.getGoodDAO().createGood(context.getBean("goodLaptopAcer", Good.class));
        FactoryDAO.getGoodDAO().createGood(context.getBean("goodLaptopAsus", Good.class));

        FactoryDAO.getClientDAO().createClient(context.getBean("clientMary", Client.class));
        FactoryDAO.getClientDAO().createClient(context.getBean("clientLara", Client.class));

        launch(args);
    }
}
