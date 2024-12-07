module com.marcosoft.almacenfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.marcosoft.almacenfx to javafx.fxml;
    opens com.marcosoft.almacenfx.Logic to javafx.base;
    exports com.marcosoft.almacenfx;
}
