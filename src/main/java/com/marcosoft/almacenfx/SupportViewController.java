package com.marcosoft.almacenfx;

import com.marcosoft.almacenfx.Logic.SceneSwitcher;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SupportViewController {
    public boolean userConfigShowing;
    private AccountViewController accountController;
    
    public void setAccountController(AccountViewController accountController) {
        this.accountController = accountController;
    }
    
    @FXML private Label txtWelcome;

    @FXML
    private void switchToBuy(ActionEvent event) throws IOException {
        setRoot(event, "buyView.fxml");
    }
    
    @FXML
    private void switchToSell(ActionEvent event) throws IOException {
        setRoot(event, "sellView.fxml");
    }
    
    @FXML
    private void switchToRegistry(ActionEvent event) throws IOException {
        setRoot(event, "registryView.fxml");
    }
    
    @FXML
    private void switchToExistency(ActionEvent event) throws IOException {
        setRoot(event, "existencyView.fxml");
    }
    @FXML
    private void switchToConfiguration(ActionEvent event) throws IOException {
        setRoot(event, "configurationView.fxml");
    }
    
    @FXML
    private void licenseInformation(MouseEvent event){
        Alert alert= new Alert(AlertType.INFORMATION);
        alert.setTitle("Asistente de Ayuda");
        alert.setHeaderText("Información de la licencia");
        alert.setContentText("Pasado el tiempo disponible para renovar su licencia el programa se bloqueará instantaneamente y no podrá ser usado, muy posiblemente pierda los datos"
        + " de la base de datos, por lo que es recomendable llamar al +53 5550 5961 antes de que eso pase para que pueda revocar su licencia y continuar así con el consumo de este software.");
        alert.showAndWait();
    }
    
    @FXML
    private void displayUserConfig(MouseEvent event){
        String errorMessage= "Ya hay una ventana de Configuración de Usuario abierta";
        String fxmlPath="userConfigView.fxml";
        int aux=0;
        try{
            displayAssistance(userConfigShowing, fxmlPath, errorMessage, aux);
        }catch(Exception e){
            System.out.println(e);
        }
    }  
    
    public void displayAssistance(boolean viewShowing, String fxmlPath, String errorMessage, int auxView) throws IOException{
        if(viewShowing!=true){
            FXMLLoader fxml = new FXMLLoader(getClass().getResource(fxmlPath));
            
            Parent root = fxml.load();
            
            Scene scene= new Scene(root); 
            Stage stage = new Stage();
            stage.initStyle(StageStyle.DECORATED); //Configura el estilo de la ventana
            stage.setResizable(false);
            stage.setScene(scene);
            if(auxView==0){
                userConfigShowing=true;

                stage.setOnCloseRequest(eh ->{
                    userConfigShowing=false;
                });
            }
            
            stage.showAndWait();                
        }else{
            Alert alert=new Alert(AlertType.ERROR);
            alert.setHeaderText("Error al intentar abrir la ventana");
            alert.setContentText(errorMessage);
            alert.showAndWait();                
            }
    }
    
    private void setRoot(ActionEvent event, String fxmlFile) throws IOException {
        // Load the new FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();

        // Get the current scene and set the new root
        Scene currentScene = ((Node) event.getSource()).getScene();
        currentScene.setRoot(root);
    }
    
    
    @FXML
    private void initialize(){
        txtWelcome.setText("Este software le facilitará el control físico-financiero de su negocio "+
                "ya que tendrá a su disposición múltiples formas de manejar y almacenar todo tipo de productos, "+
                "permitiéndole tener un control total de las existencias en su almacen, sus costos y ganancias de venta.");
    }
}
