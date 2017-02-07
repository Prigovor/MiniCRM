import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Initial extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/authorization.fxml"));
        Scene main = new Scene(root);

        primaryStage.setTitle("Authorization");
        primaryStage.setResizable(false);
        primaryStage.setScene(main);
        primaryStage.show();
    }

}
