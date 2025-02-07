module com.marcosoft.almacenfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires java.sql;
    requires org.eclipse.persistence.jpa; // Módulo de EclipseLink
    requires jakarta.persistence; // Módulo de Jakarta Persistence
    requires org.xerial.sqlitejdbc; // Módulo de SQLite

    // Abre el paquete principal a javafx.fxml
    opens com.marcosoft.almacenfx to javafx.fxml;

    // Abre el paquete de lógica (donde están las entidades) a JPA
    opens com.marcosoft.almacenfx.Logic to org.eclipse.persistence.jpa, javafx.base;

    // Exporta el paquete principal
    exports com.marcosoft.almacenfx;

    // Exporta el paquete de lógica para que otras clases dentro del módulo puedan acceder
    exports com.marcosoft.almacenfx.Logic;
}