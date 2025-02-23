
package com.marcosoft.almacenfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MazMorr
 */
public class SellViewController implements Initializable {
    
    @FXML Label txtDebugForm;
    @FXML ProgressIndicator pindSellProduct;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    @FXML
    public void sellProduct(){
        if(pindSellProduct.isIndeterminate()){
            Alert alert= new Alert(AlertType.ERROR);
            alert.setTitle("Error al intentar la operación");
            alert.setResizable(false);
            alert.setContentText("Debe rellenar todos los campos");
            alert.showAndWait();
        } else {
            //eliminar producto de la existencia y poner el registro de la venta
        }
    }
    
    @FXML
    public void setTextChangedAmount(){
        txtDebugForm.setText("Introduzca la cantidad vendida");
    }
    
    @FXML
    public void setTextChangedPrize(){
        txtDebugForm.setText("Introduzca el precio Total de venta");
    }
    
    @FXML
    public void setTextChangedDate(){
        txtDebugForm.setText("Introduzca la fecha de transacción");
    }
    
    /*@FXML
    private void closeWindow(ActionEvent event){
        // Get the source of the event (the button that was clicked)
        Node source = (Node) event.getSource();
        
        // Get the stage from the source
        Stage stage = (Stage) source.getScene().getWindow();
        
        // Close the stage
        stage.close();
    }*/
    
}
