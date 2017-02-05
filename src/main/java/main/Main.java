package main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.MainModel;

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

        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("view/authorization.fxml")));
        primaryStage.setScene(scene);
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
