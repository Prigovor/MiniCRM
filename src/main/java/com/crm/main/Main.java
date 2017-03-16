package com.crm.main;

import com.crm.database.manager.ContextManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;

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

        replaceSceneContent("/com/crm/menu/authorization/authorization-menu.fxml");

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
        ApplicationContext context = ContextManager.getInstance().getContext();

//        Account accountAdmin = context.getBean("accountAdmin", Account.class);
//        Employee employeeAdmin = context.getBean("employeeAdmin", Employee.class);
//
//        FactoryService.getEmployeeService().saveOrUpdate(employeeAdmin);
//        FactoryService.getAccountService().saveOrUpdate(accountAdmin);
//
//        Account accountOrderManager = context.getBean("accountManagerPeter", Account.class);
//        OrderManager orderManager = context.getBean("orderManagerPeter", OrderManager.class);
//
//        FactoryService.getOrderManagerService().saveOrUpdate(orderManager);
//        FactoryService.getAccountService().saveOrUpdate(accountOrderManager);
//
//        Account accountStorekeeper = context.getBean("accountStorekeeperDane", Account.class);
//        Storekeeper storekeeper = context.getBean("storekeeperDane", Storekeeper.class);
//
//        FactoryService.getStorekeeperService().saveOrUpdate(storekeeper);
//        FactoryService.getAccountService().saveOrUpdate(accountStorekeeper);
//
//        Account accountCourier = context.getBean("accountCourierGaverel", Account.class);
//        Courier courier = context.getBean("courierGaverel", Courier.class);
//
//        FactoryService.getCourierService().saveOrUpdate(courier);
//        FactoryService.getAccountService().saveOrUpdate(accountCourier);

        launch(args);
    }
}
