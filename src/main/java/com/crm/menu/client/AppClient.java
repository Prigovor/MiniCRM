package com.crm.menu.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Prigovor on 19.02.2017.
 */
public class AppClient extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/fxml-files/client_registration.fxml"));

        Parent parent = fxmlLoader.load();

        ClientRegistrationContr registrationContr = fxmlLoader.getController();
        registrationContr.setAppClientStage(primaryStage);

        primaryStage.setMaxWidth(505);
        primaryStage.setMaxHeight(330);
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }
}
