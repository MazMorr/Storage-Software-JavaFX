package com.marcosoft.almacenfx;

import com.marcosoft.almacenfx.Logic.SceneSwitcher;
import com.marcosoft.almacenfx.Logic.WindowShowing;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class SupportViewController {
    public boolean configurationShowing;
    private AccountViewController accountController;
    private final WindowShowing windowShowing;
    private final SceneSwitcher sceneSwitcher;
    
    public void setAccountController(AccountViewController accountController) {
        this.accountController = accountController;
    }
    
    public SupportViewController(){
        windowShowing= new WindowShowing();
        sceneSwitcher= new SceneSwitcher();
    }
    
    @FXML private Label txtWelcome;
    
    @FXML
    private void switchToRegistry(ActionEvent event) throws IOException {
        sceneSwitcher.setRoot(event, "/com/marcosoft/almacenfx/registryView.fxml");
        windowShowing.closeAllWindows();
    }
    
    @FXML
    private void switchToExistency(ActionEvent event) throws IOException {
        sceneSwitcher.setRoot(event, "/com/marcosoft/almacenfx/existencyView.fxml");
        windowShowing.closeAllWindows();
    }
    
    @FXML
    private void displayConfigurationView(ActionEvent event) throws IOException {
        String errorMessage= "Ya hay una ventana de Configuración abierta";
        String fxmlPath="/com/marcosoft/almacenfx/configurationView.fxml";
        int aux=3;
        windowShowing.displayAssistance(windowShowing.isConfigurationShowing(), fxmlPath, errorMessage, aux);
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
    private void initialize(){
        txtWelcome.setText("Este software le facilitará el control físico-financiero de su negocio "+
                "ya que tendrá a su disposición múltiples formas de manejar y almacenar todo tipo de productos, "+
                "permitiéndole tener un control total de las existencias en su almacen, sus costos y ganancias de venta.");
    }
}
