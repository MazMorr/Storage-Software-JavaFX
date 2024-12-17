
package com.marcosoft.almacenfx;

import com.marcosoft.almacenfx.Logic.Product;
import com.marcosoft.almacenfx.Logic.SceneSwitcher;
import com.marcosoft.almacenfx.Logic.WindowShowing;
import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class ExistencyViewController  {
    
    @FXML Button btnFilter;
    @FXML TableView<Product> tblExistency;
    private ObservableList<Product> product;
    
    private WindowShowing windowShowing;
    private SceneSwitcher sceneSwitcher;

    public ExistencyViewController() {
        windowShowing= new WindowShowing();
        sceneSwitcher= new SceneSwitcher();
    }
    
    @FXML
    private void switchToSupport(ActionEvent event) throws IOException {
        sceneSwitcher.setRoot(event, "/com/marcosoft/almacenfx/supportView.fxml");
        windowShowing.closeAllWindows();
    }
    
    @FXML
    private void switchToRegistry(ActionEvent event) throws IOException {
        sceneSwitcher.setRoot(event, "/com/marcosoft/almacenfx/registryView.fxml");
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
    private void displaySellView(ActionEvent event) throws IOException { 
        String errorMessage= "Ya hay una ventana de Ventas abierta";
        String fxmlPath="/com/marcosoft/almacenfx/sellView.fxml";
        int aux=0;
        windowShowing.displayAssistance(windowShowing.isSellViewShowing(), fxmlPath, errorMessage, aux);
    }
    
    @FXML
    private void displayFilterView(ActionEvent event) throws IOException {
        String errorMessage= "Ya hay una ventana de filtros para existencias abierta";
        String fxmlPath="/com/marcosoft/almacenfx/filterExistencyView.fxml";
        int aux=2;
        windowShowing.displayAssistance(windowShowing.isFilterViewShowing(), fxmlPath, errorMessage, aux);
    }  

    @FXML
    private void displayBuyView(ActionEvent event) throws IOException {
        String errorMessage= "Ya hay una ventana de Compras  abierta";
        String fxmlPath="/com/marcosoft/almacenfx/buyView.fxml";
        int aux=1;
        windowShowing.displayAssistance(windowShowing.isBuyViewShowing(), fxmlPath, errorMessage, aux);
    }
    
    @FXML
    public void initialize() {
        // TODO
    }    
    
}
