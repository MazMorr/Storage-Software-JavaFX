
package com.marcosoft.almacenfx;

import com.marcosoft.almacenfx.Logic.Product;
import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ExistencyViewController  {
    
    @FXML Button btnFilter;
    @FXML TableView<Product> tblExistency;
    private ObservableList<Product> product;
    public boolean sellViewShowing;
    public boolean buyViewShowing;
    public boolean filterViewShowing;
    public boolean userConfigShowing;

    public void setSellViewShowing(boolean sellViewShowing) {
        this.sellViewShowing = sellViewShowing;
    }

    public ExistencyViewController(boolean sellViewShowing) {
        this.sellViewShowing = sellViewShowing;
    }

    public ExistencyViewController() {
    }
    
    
    
    @FXML
    private void switchToSupport(ActionEvent event) throws IOException {
        setRoot(event, "supportView.fxml");
    }
    

    
    @FXML
    private void switchToRegistry(ActionEvent event) throws IOException {
        setRoot(event, "registryView.fxml");
    }
    
    @FXML
    private void switchToConfiguration(ActionEvent event) throws IOException {
        setRoot(event, "configurationView.fxml");
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
    private void displaySellView(ActionEvent event) throws IOException { 
        String errorMessage= "Ya hay una ventana de Ventas abierta";
        String fxmlPath="sellView.fxml";
        int aux=2;
        
        try{
            
            displayAssistance(sellViewShowing, fxmlPath, errorMessage, aux);
            
        } catch(Exception e){
            System.out.println(e);
        }   
    }
    
    @FXML
    private void displayUserConfig(){
        String errorMessage= "Ya hay una ventana de Configuración de Usuario abierta";
        String fxmlPath="userConfigView.fxml";
        int aux=3;
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
                buyViewShowing=true;

                stage.setOnCloseRequest(eh ->{
                    buyViewShowing=false;
                });       
            } else if(auxView==2){
                sellViewShowing=true;

                stage.setOnCloseRequest(eh ->{
                    sellViewShowing=false;
                });       
            } else if(auxView==3){
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
    
    @FXML
    private void displayFilterView(ActionEvent event) throws IOException {
        String errorMessage= "Ya hay una ventana de filtros para existencias abierta";
        String fxmlPath="filterExistencyView.fxml";
        int aux=0;
        try{
            displayAssistance(filterViewShowing, fxmlPath, errorMessage, aux);
            
        } catch(Exception e){
            System.out.println(e);
        }   
    }
    
    @FXML
    private void displayBuyView(ActionEvent event) throws IOException {
        String errorMessage= "Ya hay una ventana de Compras  abierta";
        String fxmlPath="buyView.fxml";
        int aux=1;
        try{
            displayAssistance(buyViewShowing, fxmlPath, errorMessage, aux);

        } catch(Exception e){
            System.out.println(e);
        }   
        
    }
    
    @FXML
    public void initialize() {
        // TODO
    }    
    
}
