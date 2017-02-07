package start;

import controllers.ScreensController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Initial extends Application{

    public static final String AUTHORIZATION_SCREEN = "Authorization";
    public static final String AUTHORIZATION_SCREEN_FXML = "/view/authorization.fxml";
    public static final String ADMIN_SCREEN = "Admin";
    public static final String ADMIN_SCREEN_FXML = "/view/admin_menu.fxml";
//    public static final String EMPLOYEE_SCREEN = "Employee";
//    public static final String EMPLOYEE_SCREEN_FXML = "";

    @Override
    public void start(Stage primaryStage) throws Exception {
        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(Initial.AUTHORIZATION_SCREEN,
                Initial.AUTHORIZATION_SCREEN_FXML);
        mainContainer.loadScreen(Initial.ADMIN_SCREEN,
                Initial.ADMIN_SCREEN_FXML);

        mainContainer.setScreen(Initial.AUTHORIZATION_SCREEN);

        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.isIconified();
//        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }



//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("/view/authorization.fxml"));
//        Scene main = new Scene(root);
//
//        primaryStage.setTitle("Authorization");
//        primaryStage.setResizable(false);
//        primaryStage.setScene(main);
//        primaryStage.show();
//    }

}
