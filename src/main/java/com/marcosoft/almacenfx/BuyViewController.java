package com.marcosoft.almacenfx;

import com.marcosoft.almacenfx.Logic.*;

import java.math.BigDecimal;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import java.time.LocalDate;

import com.marcosoft.almacenfx.Persistence.PersistenceController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class BuyViewController implements Initializable{

    //FXMl declarations that are actually in use
    @FXML private Label txtDebugForm;
    @FXML private MenuItem miPersonal, miClean, miMilk, miCereal, miMeat, miDrink;
    @FXML private TextField txtFieldSubCategory, txtFieldPrize, txtFieldAmount, txtFieldName;
    @FXML private DatePicker txtFieldDate;
    @FXML private RadioMenuItem rmiCUP, rmiUSD, rmiEUR, rmiMLC;
    @FXML private ProgressIndicator percentageBar;

    //Some variables that are important for the user interface
    double percentageDate=0,percentageName=0,percentageSubCategory=0,percentagePrize=0,percentageAmount=0;
    boolean dateIsSetted= false, nameIsSetted= false, subCategoryIsSetted=false, prizeIsSetted=false, amountIsSetted= false;

    //The method that are controlling while are you typing in TexFieldName
    @FXML
    private void setTextChangedName(){
        txtDebugForm.setText("Nombre de su producto.");

        if(txtFieldName.getLength()!= 0 && !nameIsSetted) {
            percentageName += 0.2;
            percentageBar.setProgress(percentageName+percentageDate+percentageSubCategory+percentageAmount+percentagePrize);
            nameIsSetted=true;
        }else if(txtFieldName.getLength()==0 && percentageName == 0.2){
            percentageName -= 0.2;
            percentageBar.setProgress(percentageName+percentageDate+percentageSubCategory+percentageAmount+percentagePrize);
            nameIsSetted=false;
        }
    }

    //The method that are controlling while are you typing in TexFielSubCategory
    @FXML
    private void setTextChangedSubCategory(){
        txtDebugForm.setText("Categoría del producto. ");
        if(txtFieldSubCategory.getLength()!= 0 && !subCategoryIsSetted) {
            percentageSubCategory += 0.2;
            percentageBar.setProgress(percentageName+percentageDate+percentageSubCategory+percentageAmount+percentagePrize);
            subCategoryIsSetted=true;
        }else if(txtFieldSubCategory.getLength()==0 && percentageSubCategory == 0.2){
            percentageSubCategory -= 0.2;
            percentageBar.setProgress(percentageName+percentageDate+percentageSubCategory+percentageAmount+percentagePrize);
            subCategoryIsSetted=false;
        }
    }

    //The method that are controlling while are you typing in TexFieldPrice
    @FXML
    private void setTextChangedPrice() {
        txtDebugForm.setText("Recuerde seleccionar el tipo de moneda en el botón: Moneda.");
        if (!txtFieldPrize.getText().matches("\\d*(\\.\\d*)?")) {
            txtDebugForm.setText("Solo se permiten números decimales.");
            // Eliminar caracteres no numéricos excepto el punto decimal
            txtFieldPrize.setText(txtFieldPrize.getText().replaceAll("[^\\d.]", ""));
        } else if (txtFieldPrize.getLength() != 0 && !prizeIsSetted) {
            percentagePrize += 0.2;
            percentageBar.setProgress(percentageName + percentageDate + percentageSubCategory + percentageAmount + percentagePrize);
            prizeIsSetted = true;
        } else if (txtFieldPrize.getLength() == 0 && percentagePrize == 0.2) {
            percentagePrize -= 0.2;
            percentageBar.setProgress(percentageName + percentageDate + percentageSubCategory + percentageAmount + percentagePrize);
            prizeIsSetted = false;
        }
    }

    //The method that are controlling while are you typing in TexFieldAmount or Quantity
    @FXML
    private void setTextChangedAmount(){
        txtDebugForm.setText("Cantidad de ese mismo producto.");
        // Verificar si el texto contiene solo dígitos
        if(!txtFieldAmount.getText().matches("\\d*")) {
            txtDebugForm.setText("Solo se permiten números enteros.");
            // Eliminar caracteres no numéricos
            txtFieldAmount.setText(txtFieldAmount.getText().replaceAll("[^\\d]", ""));
        } else if(txtFieldAmount.getLength() != 0 && !amountIsSetted) {
            percentageAmount += 0.2;
            percentageBar.setProgress(percentageName + percentageDate + percentageSubCategory + percentageAmount + percentagePrize);
            amountIsSetted = true;
        } else if(txtFieldAmount.getLength() == 0 && percentageAmount == 0.2) {
            percentageAmount -= 0.2;
            percentageBar.setProgress(percentageName + percentageDate + percentageSubCategory + percentageAmount + percentagePrize);
            amountIsSetted = false;
        }
    }

    //The method that are controlling while are you typing in DatePicker
    @FXML
    private void setTextClickedDate(){
        txtDebugForm.setText("Seleccione la fecha en el botón de la derecha.");
        if(txtFieldDate.getValue()!=null && !dateIsSetted) {
            percentageDate += 0.2;
            percentageBar.setProgress(percentageName+percentageDate+percentageSubCategory+percentageAmount+percentagePrize);
            dateIsSetted=true;
        } else if (txtFieldDate.getValue()==null&& percentageDate ==0.2){
            percentageDate -= 0.2;
            percentageBar.setProgress(percentageName+percentageDate+percentageSubCategory+percentageAmount+percentagePrize);
            dateIsSetted=false;
        }
    }

    //Methods that are listening when you touch their respective TextField (not implemented yet)
    @FXML
    private void setTextClickedAmount(){}
    @FXML
    private void setTextClickedPrice(){}
    @FXML
    private void setTextClickedSubCategory(){}
    @FXML
    private void setTextClickedName(){}

    //This makes all at the begginig without close the window
    @FXML
    private void clean(){
        txtDebugForm.setText("");
        txtFieldSubCategory.setText("");
        txtFieldPrize.setText("");
        txtFieldAmount.setText("");
        txtFieldName.setText("");
        txtFieldDate.setValue(LocalDate.now());
        percentageName=0;
        percentageSubCategory=0;
        percentagePrize=0;
        percentageAmount=0;
        nameIsSetted= false;
        subCategoryIsSetted=false;
        prizeIsSetted=false;
        amountIsSetted= false;
        percentageBar.setProgress(percentageName + percentageDate + percentageSubCategory + percentageAmount + percentagePrize);
    }

    @FXML
    private void addProduct() {
        try {
            // Validar campos obligatorios
            if (areFieldsEmpty(txtFieldSubCategory.getText(), txtFieldPrize.getText(),
                    txtFieldAmount.getText(), txtFieldName.getText()) && percentageBar.getProgress() !=1.0 ) {
                txtDebugForm.setText("Por favor rellene todos los campos");
                return;
            }

            if (!isCurrencySelected()) {
                txtDebugForm.setText("Por favor seleccione el tipo de Moneda");
                return;
            }

            if (txtFieldDate.getValue() == null) {
                txtDebugForm.setText("Por favor seleccione la fecha.");
                return;
            }

            // Obtener valores de los campos
            String productName = txtFieldName.getText();
            String categoryName = txtFieldSubCategory.getText();
            BigDecimal price = new BigDecimal(txtFieldPrize.getText());
            int quantity = Integer.parseInt(txtFieldAmount.getText());
            LocalDate date = txtFieldDate.getValue();

            // Obtener o crear la categoría
            Categoria category = findOrCreateCategory(categoryName);

            // Crear el producto
            Producto product = new Producto(productName, category);

            // Crear la transacción
            Transaccion transaction = createTransaction(product, price, quantity, date);

            // Persistir los datos
            PersistenceController pc = new PersistenceController();
            pc.addCategory(category);
            pc.addProduct(product);
            pc.addTransaction(transaction);

            // Limpiar campos y mostrar mensaje de éxito
            clean();
            txtDebugForm.setText("Producto añadido exitosamente");

        } catch (NumberFormatException e) {
            txtDebugForm.setText("Error en el formato de números");
        } catch (Exception e) {
            e.printStackTrace();
            txtDebugForm.setText("Error: " + e.getMessage());
        }
    }

    private Categoria findOrCreateCategory(String categoryName) {
        // Buscar si la categoría ya existe
        PersistenceController pc = new PersistenceController();
        Categoria existingCategory = pc.findCategoryByName(categoryName);

        if (existingCategory != null) {
            return existingCategory;
        }

        // Crear y persistir nueva categoría si no existe
        Categoria newCategory = new Categoria(categoryName);
        pc.addCategory(newCategory);
        return newCategory;
    }

    private Transaccion createTransaction(Producto product, BigDecimal price, int quantity, LocalDate date) {
        // Obtener la moneda seleccionada
        Moneda currency = getSelectedCurrency();

        // Crear la transacción
        Transaccion transaction = new Transaccion();
        transaction.setProduct(product);
        transaction.setPrecio(price);
        transaction.setCantidad(quantity);
        transaction.setFecha(date);
        transaction.setCoin(currency);

        // Establecer el tipo de transacción (ejemplo: "Compra")
        TipoTransaccion transactionType = new TipoTransaccion();
        transactionType.setNombreTransaccion("Compra");
        transaction.setTransactionType(transactionType);

        // Establecer la cuenta (ejemplo: cuenta predeterminada)
        Cuenta account = new Cuenta();
        account.setName("Cuenta Predeterminada");
        account.setContrasena("password"); // Asegúrate de usar una contraseña segura
        transaction.setAccount(account);

        return transaction;
    }

    private Moneda getSelectedCurrency() {
        if (rmiCUP.isSelected()) {
            return new Moneda("CUP", "Peso Cubano");
        } else if (rmiUSD.isSelected()) {
            return new Moneda("USD", "Dólar Estadounidense");
        } else if (rmiEUR.isSelected()) {
            return new Moneda("EUR", "Euro");
        } else if (rmiMLC.isSelected()) {
            return new Moneda("MLC", "Moneda Libremente Convertible");
        }
        throw new IllegalStateException("No se seleccionó ninguna moneda");
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


    //Logic for set the texts predefined in subcategory textField
    public void setSubcategory(String x){
        txtFieldSubCategory.setText(x);
        if(!subCategoryIsSetted){
            subCategoryIsSetted=true;
            percentageSubCategory+=0.2;
            percentageBar.setProgress(percentageName+percentageDate+percentageSubCategory+percentageAmount+percentagePrize);
        }
    }

    @FXML private void setDrinkText(){
        setSubcategory("Bebida");

    }           
    @FXML private void setMilkText(){
        setSubcategory("Lácteo");
    }   
    @FXML private void setPersonalText(){
        setSubcategory("Aseo Personal");
    }  
    @FXML private void setCleanText(){
        setSubcategory("Limpieza");
    }   
    @FXML private void setCerealText(){
        setSubcategory("Cereal");
    }
    @FXML private void setMeatText(){
        setSubcategory("Cárnico");
    }

    //Initialize method
    @Override
    public void initialize(URL url, ResourceBundle rb){
        txtFieldDate.setValue(LocalDate.now());
        percentageDate += 0.2;
        percentageBar.setProgress(percentageName+percentageDate+percentageSubCategory+percentageAmount+percentagePrize);
        dateIsSetted=true;
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
