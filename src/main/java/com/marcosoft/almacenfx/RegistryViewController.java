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
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RegistryViewController implements Initializable {
    boolean filterViewShowing;
    boolean userConfigShowing;
    

    @FXML 
    private void switchToSupport(ActionEvent event) throws IOException {
        setRoot(event, "supportView.fxml");
    }
    
    @FXML
    private void switchToBuy(ActionEvent event) throws IOException {
        setRoot(event, "buyView.fxml");
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
    private void displayRegistryfilterView(ActionEvent event) throws IOException{
        String errorMessage= "Ya hay una ventana de filtros para registros abierta";
        String fxmlPath="registryFilterView.fxml";
        int aux=0;
        try{
            displayAssistance(filterViewShowing, fxmlPath, errorMessage, aux);
            
        } catch(Exception e){
            System.out.println(e);
        }   
    }
    
    @FXML
    private void displayUserConfig(){
        String errorMessage= "Ya hay una ventana de Configuración de Usuario abierta";
        String fxmlPath="userConfigView.fxml";
        int aux=1;
        try{
            displayAssistance(userConfigShowing, fxmlPath, errorMessage, aux);
        }catch(Exception e){
            System.out.println(e);
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
    
    public void displayAssistance(boolean viewShowing, String fxmlPath, String errorMessage, int auxView) throws IOException{
        if(viewShowing!=true){
            FXMLLoader fxml = new FXMLLoader(getClass().getResource(fxmlPath));
            
            Parent root = fxml.load();
            
            //BuyViewController controller= fxml.getController();
            
            //controller.initAtributtes(product);
            
            Scene scene= new Scene(root); 
            Stage stage = new Stage();
            stage.initStyle(StageStyle.DECORATED); //Configura el estilo de la ventana
            stage.setResizable(false);
            stage.setScene(scene);
            if(auxView==0){
                filterViewShowing=true;

                stage.setOnCloseRequest(eh ->{
                    filterViewShowing=false;
                });
            } else if(auxView==1){
                userConfigShowing=true;

                stage.setOnCloseRequest(eh ->{
                    userConfigShowing=false;
                });       
            }/* else if(auxView==2){
                sellViewShowing=true;

                stage.setOnCloseRequest(eh ->{
                    sellViewShowing=false;
                });       
            } */
            
            stage.showAndWait();                
        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error al intentar abrir la ventana");
            alert.setContentText(errorMessage);
            alert.showAndWait();                
            }
    }
    
    @FXML
    private void selected(MouseEvent event){
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
