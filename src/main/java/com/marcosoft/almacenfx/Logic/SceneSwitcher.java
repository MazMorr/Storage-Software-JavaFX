
package com.marcosoft.almacenfx.Logic;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//Esta clase solo está para recordar los cambios entre ventanas.
public class SceneSwitcher {

    public SceneSwitcher() {
    }        
    
    public void setRoot(ActionEvent event, String fxmlFile) throws IOException {
        // Load the new FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();

        // Get the current scene and set the new root
        Scene currentScene = ((Node) event.getSource()).getScene();
        currentScene.setRoot(root);
    }
    
    
}
