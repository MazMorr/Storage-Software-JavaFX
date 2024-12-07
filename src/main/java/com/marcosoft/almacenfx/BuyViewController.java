package com.marcosoft.almacenfx;

import com.marcosoft.almacenfx.Logic.Product;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BuyViewController implements Initializable{

    @FXML private Label txtDebugForm;
    @FXML private MenuItem miPersonal, miClean, miMilk, miCereal, miMeat, miDrink;
    @FXML private TextField txtFieldSubCategory, txtFieldPrize, txtFieldAmount, txtFieldName;
    @FXML private DatePicker txtFieldDate;
    @FXML private RadioMenuItem rmiCUP, rmiUSD, rmiEUR, rmiMLC;
    private ObservableList<Product> products;
    
    private Product product;
       
    @FXML
    private void setTextChangedName(){
        txtDebugForm.setText("Nombre de su producto.");
    }
    @FXML
    private void setTextChangedSubCategory(){
        txtDebugForm.setText("Categoría del producto. ");
    }
    @FXML
    private void setTextChangedPrize() {
        txtDebugForm.setText("Recuerde seleccionar el tipo de moneda en el botón: Moneda.");
    }
    @FXML
    private void setTextChangedDate(){
        txtDebugForm.setText("Seleccione la fecha en el botón de la derecha.");
    }
    @FXML
    private void setTextChangedAmount(){
        txtDebugForm.setText("Cantidad de ese mismo producto.");
    }
    
    @FXML
    private void addProduct() {
        try {
            // Retrieve and trim input values from text fields
            String subCategory = txtFieldSubCategory.getText().trim();
            String prize = txtFieldPrize.getText().trim();
            String amount = txtFieldAmount.getText().trim();
            String name = txtFieldName.getText().trim();
            
            if(txtFieldDate.getValue() == null){
                txtDebugForm.setText("Por favor seleccione la fecha.");
                return;
            }
        
            // Validate that all fields are filled
            if (areFieldsEmpty(subCategory, prize, amount, name)) {
                txtDebugForm.setText("Por favor rellene todos los campos");
                return; // Exit the method if any fields are empty
            }
        
            // Validate that a currency type is selected
            if (!isCurrencySelected()) {
                txtDebugForm.setText("Por favor seleccione el tipo de Moneda en el botón correspondiente");
                return; // Exit if no currency is selected
            }
            
            if(txtFieldDate.getValue() == null){
                txtDebugForm.setText("Por favor seleccione la fecha.");
                return;
            }
        
            // If all validations pass, confirm successful addition
            txtDebugForm.setText("Su producto ha sido añadido exitosamente");
        
        } catch (Exception e) {
            // Log the exception message for debugging
            e.printStackTrace(); // Print stack trace to console for debugging
            txtDebugForm.setText("Ocurrió un error: " + e.getMessage());
        }
    }

    // Helper method to check if any fields are empty
    private boolean areFieldsEmpty(String... fields) {
        for (String field : fields) {
            if (field.isEmpty()) {
                return true; // Return true if any field is empty
            }
        }
        return false; // Return false if all fields are filled
    }

    // Helper method to check if a currency type is selected
    private boolean isCurrencySelected() {
        return rmiCUP.isSelected() || rmiUSD.isSelected() || rmiEUR.isSelected() || rmiMLC.isSelected();
    }
    
    @FXML
    private void hideProvisions(){
        if(miMilk.isVisible() && miCereal.isVisible() && miMeat.isVisible() && miDrink.isVisible()){
            miMilk.setVisible(false);
            miCereal.setVisible(false);
            miMeat.setVisible(false);
            miDrink.setVisible(false);
            miPersonal.setVisible(true);
            miClean.setVisible(true);
        }      
    }
    
    @FXML
    private void hideCleanStuff(){
        if(miPersonal.isVisible() && miClean.isVisible()){
            miPersonal.setVisible(false);
            miClean.setVisible(false);
            miMilk.setVisible(true);
            miCereal.setVisible(true);
            miMeat.setVisible(true);
            miDrink.setVisible(true);            
        }
    }
    
    @FXML private void setDrinkText(){
        txtFieldSubCategory.setText("Bebida");
    }           
    @FXML private void setMilkText(){
        txtFieldSubCategory.setText("Lácteo");
    }   
    @FXML private void setPersonalText(){
        txtFieldSubCategory.setText("Aseo Personal");
    }  
    @FXML private void setCleanText(){
        txtFieldSubCategory.setText("Limpieza");
    }   
    @FXML private void setCerealText(){
        txtFieldSubCategory.setText("Cereal");
    }
    @FXML private void setMeatText(){
        txtFieldSubCategory.setText("Cárnico");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb){

    }
    
    public Product getProduct() {
        return product;
    }
    
    public void initAtributtes(ObservableList<Product> products){
        this.products=products;
    }
    
    @FXML
    private void closeWindow(ActionEvent event){
        // Get the source of the event (the button that was clicked)
        Node source = (Node) event.getSource();
        
        // Get the stage from the source
        Stage stage = (Stage) source.getScene().getWindow();
        
        // Close the stage
        stage.close();
    }
    
}
