
package com.marcosoft.almacenfx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class CreateAccountViewController {
    
    @FXML private PasswordField passFieldPasswordConfirmed;
    
    @FXML
    private void createAccount() throws IOException{
        System.out.println(passFieldPasswordConfirmed.getText());
        App.setRoot("accountView");
    }

    @FXML
    public void initialize() {
        // TODO
    }    
    
}
