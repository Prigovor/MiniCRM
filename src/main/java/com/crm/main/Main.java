package com.crm.main;

import com.crm.database.entity.account.Account;
import com.crm.database.entity.client.Client;
import com.crm.database.entity.good.Good;
import com.crm.database.service.FactoryService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.IOException;

import static com.crm.database.manager.DatabaseManagerType.HIBERNATE;

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

    public void replaceSceneContent(String filePath)
    {
        Scene scene = primaryStage.getScene();

        try
        {
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
        catch (IOException e)
        {

        }
    }

    public void exit()
    {
        primaryStage.close();
        System.exit(0);
    }

    public static void main(String[] args)
    {
        GenericXmlApplicationContext context = new GenericXmlApplicationContext("/spring-config/spring-config.xml");

        FactoryService.getAccountService(HIBERNATE).saveEntry(context.getBean("accountAdmin", Account.class));
        FactoryService.getAccountService(HIBERNATE).saveEntry(context.getBean("accountManagerAlan", Account.class));
        FactoryService.getAccountService(HIBERNATE).saveEntry(context.getBean("accountStorekeeperJake", Account.class));

        FactoryService.getGoodService(HIBERNATE).saveEntry(context.getBean("goodLaptopHP", Good.class));
        FactoryService.getGoodService(HIBERNATE).saveEntry(context.getBean("goodLaptopAcer", Good.class));
        FactoryService.getGoodService(HIBERNATE).saveEntry(context.getBean("goodLaptopAsus", Good.class));

        FactoryService.getClientService(HIBERNATE).saveEntry(context.getBean("clientMary", Client.class));
        FactoryService.getClientService(HIBERNATE).saveEntry(context.getBean("clientLara", Client.class));

        FactoryService.getAccountService(HIBERNATE).saveEntry(context.getBean("accountCourierJane", Account.class));

        launch(args);
    }
}
