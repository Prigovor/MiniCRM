package com.crm.menu.client;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
//import org.controlsfx.glyphfont.Glyph;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Prigovor on 19.02.2017.
 */
public class ClientRegistrationContr implements Initializable {

    @FXML
    private GridPane gpMainPane;
    @FXML
    private TextField fldLogin;
    @FXML
    private PasswordField fldPassword;
    @FXML
    private Button btnAutorisation;
    @FXML
    private Button btnSignUp;
    @FXML
    private Button btnExit;

    private ClientMenuContr clientMenuContr;

    private Stage registrationStage;
    private Parent parent;
    private Stage clientMenuStage;
    private FXMLLoader fxmlLoader = new FXMLLoader();

//    @FXML
//    private Glyph glyphLogin;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private void initLoader() {
        fxmlLoader.setLocation(getClass().getResource("/fxml-files/client_menu.fxml"));
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        clientMenuContr = fxmlLoader.getController();
    }

    private void showClientMenu() {
        if (clientMenuStage == null) {
            clientMenuStage = new Stage();
            clientMenuStage.setMinWidth(800);
            clientMenuStage.setMinHeight(500);
            clientMenuStage.setScene(new Scene(parent));
        }
        registrationStage.hide();
        clientMenuStage.show();
    }

    public void setAppClientStage(Stage appClientStage) {
        this.registrationStage = appClientStage;
    }
}
