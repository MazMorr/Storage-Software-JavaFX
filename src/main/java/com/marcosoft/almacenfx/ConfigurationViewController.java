package com.marcosoft.almacenfx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author MazMorr
 */
public class ConfigurationViewController implements Initializable {
    
    @FXML private Button btnAdjustAdjust;
    @FXML private Button btnExistencyAdjust;
    @FXML private Button btnRegistryAdjust;
    @FXML private Button btnSupportAdjust;
    @FXML private MenuButton mbAppTheme;
    @FXML private MenuButton mbUsers;
    @FXML private MenuItem miChangeUser;
    @FXML private MenuButton mbLanguage;
    @FXML private MenuButton mbResolution;
    @FXML private RadioMenuItem rdmiDarkTheme;
    @FXML private RadioMenuItem rdmiLightTheme;
    @FXML private Label txtTitleAdjust;
    

    @FXML
    private void switchToRegistry(ActionEvent event) throws IOException {
        setRoot(event, "registryView.fxml");
    }
    
    @FXML
    private void switchToSupport(ActionEvent event) throws IOException {
        setRoot(event, "supportView.fxml");
    }
    
    @FXML
    private void switchToExistency(ActionEvent event) throws IOException {
        setRoot(event, "existencyView.fxml");
    }
    
    @FXML
    void switchLanguageToEnglish(ActionEvent event) {
        btnAdjustAdjust.setText("Config");
        btnExistencyAdjust.setText("Existency");
        btnRegistryAdjust.setText("Registry");
        btnSupportAdjust.setText("Support");
        mbAppTheme.setText("Application Theme");
        mbUsers.setText("Account");
        miChangeUser.setText("Change User");
        mbLanguage.setText("Language");
        rdmiDarkTheme.setText("Dark Theme");
        rdmiLightTheme.setText("Light Theme");
        txtTitleAdjust.setText("Configuration");
        mbResolution.setText("Resolution");
    }

    @FXML
    void switchLanguageToSpanish(ActionEvent event) {
        btnAdjustAdjust.setText("Ajustes");
        btnExistencyAdjust.setText("Existencias");
        btnRegistryAdjust.setText("Registros");
        btnSupportAdjust.setText("Soporte");
        mbAppTheme.setText("Tema de Aplicación");
        mbUsers.setText("Cuentas");
        miChangeUser.setText("Cuentas");
        mbLanguage.setText("Idioma");
        rdmiDarkTheme.setText("Modo Oscuro");
        rdmiLightTheme.setText("Modo Claro");
        txtTitleAdjust.setText("Ajustes");
        mbResolution.setText("Resolución");
    }
    
    private void setRoot(ActionEvent event, String fxmlFile) throws IOException {
        // Load the new FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();

        // Get the current scene and set the new root
        Scene currentScene = ((Node) event.getSource()).getScene();
        currentScene.setRoot(root);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
