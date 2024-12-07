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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class FilterExistencyViewController implements Initializable {

        
    @FXML
    private void closeWindow(ActionEvent event){
        // Get the source of the event (the button that was clicked)
        Node source = (Node) event.getSource();
        
        // Get the stage from the source
        Stage stage = (Stage) source.getScene().getWindow();
        
        // Close the stage
        stage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
