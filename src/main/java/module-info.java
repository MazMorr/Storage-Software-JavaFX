module com.marcosoft.almacenfx {
    // Exportar los paquetes que contienen clases usadas por JavaFX o desde otros módulos.
    exports com.marcosoft.almacenfx;
    exports com.marcosoft.almacenfx.Logic;
    exports com.marcosoft.almacenfx.Persistence;
    exports com.marcosoft.almacenfx.Persistence.exceptions;

    // Leer los módulos que necesitas
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires eclipselink;

    // Abrir paquetes para acceso reflexivo (necesario para FXML)
    opens com.marcosoft.almacenfx to javafx.fxml;
    opens com.marcosoft.almacenfx.Logic to javafx.base, jakarta.persistence;
    opens com.marcosoft.almacenfx.Persistence to jakarta.persistence;
}
