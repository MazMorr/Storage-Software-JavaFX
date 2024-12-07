
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
    
    //Hay q arreglar este método
    private void switchScene(ActionEvent event, String fxmlFile) throws IOException {
        // Load the new FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();

        // Get the current stage
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Create a new stage for the new scene
        Stage newStage = new Stage();
        Scene scene = new Scene(root);
        newStage.setScene(scene);
        newStage.setTitle("Almacen"); // Set a title for the new window
        newStage.setWidth(800); // Set desired width
        newStage.setHeight(640); // Set desired height
        newStage.centerOnScreen();

        // Show the new stage
        newStage.show();

        // Close the current stage
        currentStage.close();
    }
    
    private void setRoot(ActionEvent event, String fxmlFile) throws IOException {
        // Load the new FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();

        // Get the current scene and set the new root
        Scene currentScene = ((Node) event.getSource()).getScene();
        currentScene.setRoot(root);
    }
}
