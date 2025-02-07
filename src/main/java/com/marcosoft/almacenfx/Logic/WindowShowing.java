/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcosoft.almacenfx.Logic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author MazMorr
 */
public class WindowShowing {
    private static WindowShowing instance;
    //ExistencyView booleans
    private boolean sellViewShowing;
    private boolean buyViewShowing;
    private boolean filterViewShowing;
    private boolean configurationShowing;
    private boolean registryFilterViewShowing;
    private final List<Stage> openStages = new ArrayList();

    public WindowShowing() {
    }
    
    public WindowShowing(boolean sellViewShowing, boolean buyViewShowing, boolean filterViewShowing, boolean configurationShowing, boolean registryFilterViewShowing) {
        this.sellViewShowing = sellViewShowing;
        this.buyViewShowing = buyViewShowing;
        this.filterViewShowing = filterViewShowing;
        this.configurationShowing = configurationShowing;
        this.registryFilterViewShowing= registryFilterViewShowing;
    }
    public static WindowShowing getInstance() {
        if (instance == null) {
            instance = new WindowShowing();
        }
        return instance;
    }

    public boolean isSellViewShowing() {
        return sellViewShowing;
    }

    public void setSellViewShowing(boolean sellViewShowing) {
        this.sellViewShowing = sellViewShowing;
    }

    public boolean isBuyViewShowing() {
        return buyViewShowing;
    }

    public void setBuyViewShowing(boolean buyViewShowing) {
        this.buyViewShowing = buyViewShowing;
    }

    public boolean isFilterViewShowing() {
        return filterViewShowing;
    }

    public void setFilterViewShowing(boolean filterViewShowing) {
        this.filterViewShowing = filterViewShowing;
    }

    public boolean isConfigurationShowing() {
        return configurationShowing;
    }

    public void setConfigurationShowing(boolean configurationShowing) {
        this.configurationShowing = configurationShowing;
    }        

    public boolean isRegistryFilterViewShowing() {
        return registryFilterViewShowing;
    }

    public void setRegistryFilterViewShowing(boolean registryFilterViewShowing) {
        this.registryFilterViewShowing = registryFilterViewShowing;
    }
    
    public void displayAssistance(boolean viewShowing, String fxmlPath, String errorMessage, int auxView) throws IOException{
        try{
            if(!viewShowing){
                FXMLLoader fxml = new FXMLLoader(getClass().getResource(fxmlPath));
            
                Parent root = fxml.load();
            
                Scene scene= new Scene(root); 
                Stage stage = new Stage();
                stage.initStyle(StageStyle.DECORATED); //Configura el estilo de la ventana
                stage.setResizable(false);
                stage.setScene(scene);
                stage.getIcons().add(new Image("file:resources/images/RTS_logo.png"));
                openStages.add(stage);
                
                if(auxView==0){
                    setSellViewShowing(true);
                    stage.getIcons().add(new Image("file:resources/images/RTS_logo.png"));
                    stage.setTitle("Ventas");

                    stage.setOnCloseRequest(eh ->{
                        setSellViewShowing(false);
                    });
                } else if(auxView==1){
                    setBuyViewShowing(true);
                    stage.getIcons().add(new Image("file:resources/images/RTS_logo.png"));
                    stage.setTitle("Compras");
                
                    stage.setOnCloseRequest(eh ->{
                        setBuyViewShowing(false);
                    });       
                } else if(auxView==2){
                    setFilterViewShowing(true);
                    stage.getIcons().add(new Image("file:resources/images/RTS_logo.png"));
                    stage.setTitle("Filtro de Existencias");
                
                    stage.setOnCloseRequest(eh ->{
                        setFilterViewShowing(false);
                    });       
                } else if(auxView==3){
                    setConfigurationShowing(true);
                    stage.getIcons().add(new Image("file:resources/images/gears.png"));
                    stage.setTitle("Ajustes");
                        
                    stage.setOnCloseRequest(eh ->{
                        setConfigurationShowing(false);
                    });       
                } else if(auxView==4){
                    setRegistryFilterViewShowing(true);
                    stage.getIcons().add(new Image("file:resources/images/RTS_logo.png"));
                    stage.setTitle("Filtro de Registros");
                
                    stage.setOnCloseRequest(eh ->{
                        setRegistryFilterViewShowing(false);
                    });       
                }
            
                stage.showAndWait();                
            }else{
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Error al intentar abrir la ventana");
                alert.setContentText(errorMessage);
                alert.showAndWait();                
            }            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void closeAllWindows(){
        try{
            if(!openStages.isEmpty()){
                for (Stage stage : openStages) {
                    stage.close();
                }
                openStages.clear();
            } else{
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setContentText("openStages está vacía, hay un problema tanke");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
