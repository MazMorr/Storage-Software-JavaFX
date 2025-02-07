# Storage-Software-JavaFX
# **AlmacenMipyme**
## **1. Project Description**
The **AlmacenMipyme** project is a product management system designed for small and medium-sized enterprises (SMEs). It utilizes **JavaFX** for the graphical user interface and **JPA** (Jakarta Persistence API) for the persistence layer. The system enables the management of products, categories, and their relationships while providing an attractive and functional user experience.
### **Objectives**
- Create a practical and simple system to manage inventories for SMEs.
- Use modern technologies like JavaFX and JPA for the implementation.
- Allow future extensions such as reports, data exports, and remote database connections.

## **2. Technologies Used**
### **Backend**
- **Jakarta Persistence API (JPA)**: Used for handling data persistence and managing relationships between products and categories in an SQLite database.

### **Frontend**
- **JavaFX 23.0.1**: Provides an interactive graphical interface for users to manage data manually.

### **Database**
- **SQLite**: A lightweight and embedded database suitable for local projects or small applications.

### **IDE**
- **IntelliJ IDEA**: For project development.

## **3. Setup Instructions**
### **3.1 Prerequisites**
- **JDK 22** or later.
- Maven configured in your system.
- IntelliJ IDEA or any other Java-compatible IDE.
- SQLite as the local database.
- Required libraries, including:
    - `javafx-controls`
    - `javafx-fxml`
    - `jakarta.persistence`
    - `sqlite-jdbc`
    - `org.eclipse.persistence`

### **3.2 Project Structure**
The project follows the standard Maven structure:
``` 
src/
├── main/
│   ├── java/                          <- Source code
│   │   └── com.marcosoft.almacenfx/
│   │       ├── Logic/                 <- Business logic (Classes like Producto and Categoria)
│   │       ├── UI/                    <- Controllers and view connections
│   │       └── almacenfx/             <- Main class, initializes the application
│   ├── resources/                     <- Resources: FXML, images, etc.
│       ├── images/                    <- Images used in the application
│       └── views/                     <- FXML files for the interface
└── pom.xml                            <- Dependency and build configuration
```
### **3.3 Installation**
1. Clone the project repository:
``` bash
   git clone <repository_url>
   cd AlmacenMipyme
```
1. Set up dependencies:
    - Ensure that the dependencies in `pom.xml` are properly configured:
``` xml
     <dependencies>
         <!-- JavaFX -->
         <dependency>
             <groupId>org.openjfx</groupId>
             <artifactId>javafx-controls</artifactId>
             <version>23.0.1</version>
         </dependency>
         <dependency>
             <groupId>org.openjfx</groupId>
             <artifactId>javafx-fxml</artifactId>
             <version>23.0.1</version>
         </dependency>

         <!-- JPA -->
         <dependency>
             <groupId>jakarta.persistence</groupId>
             <artifactId>jakarta.persistence-api</artifactId>
             <version>3.2.0</version>
         </dependency>

         <!-- SQLite -->
         <dependency>
             <groupId>org.xerial</groupId>
             <artifactId>sqlite-jdbc</artifactId>
             <version>3.47.1.0</version>
         </dependency>
     </dependencies>
```
1. Launch the application from IntelliJ:
    - Configure the run options to include `JavaFX` modules.

## **4. Code Explanation**
### **4.1 Business Logic**
#### Class `Producto`:
- Represents the products managed in the system.
- Attributes include:
    - `idProducto`: Unique identifier for the product.
    - `nameProduct`: Product name.
    - `categoria`: Relationship with the `Categoria` class.

Code:
``` java
@Entity
@Table(name = "Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;

    @Column(nullable = false, length = 20)
    private String nameProduct;

    @ManyToOne
    @JoinColumn(name = "categoria", nullable = false)
    private Categoria categoria;

    // Constructors, Getters, and Setters
}
```
#### Class `Categoria`:
- Defines the categories to which the products belong. It could include attributes such as `idCategoria` and `nombre`.

### **4.2 Graphical Interface**
- **FXML Files**:
    - The files are located in `src/main/resources/views`.
    - Each file is linked to a controller in the `UI` folder.

Example of loading a view:
``` java
FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/main.fxml"));
Parent root = loader.load();
Scene scene = new Scene(root);
stage.setScene(scene);
```
- **Loading Images**:
  Images must be located in `src/main/resources/images`, and they can be loaded relatively:
``` java
  Image image = new Image(getClass().getResource("/images/product.png").toString());
```
## **5. Possible Extensions**
1. **Export to Excel/CSV**:
    - Add functionality to export stored data to an Excel or CSV file for reporting purposes.

2. **Real-Time Reports**:
    - Use libraries like `JFreeChart` or JavaFX charts to display inventory statistics.

3. **Remote Connection**:
    - Replace the local SQLite setup with a remote database such as MySQL or PostgreSQL for distributed environments.

4. **Security and Authentication**:
    - Implement a user system with privileges (admin, manager, normal user).

## **6. Common Error Messages**
### **Error: `Invalid URL or resource not found`**
- **Cause**: Missing resources or misconfigured paths.
- **Solution**:
    - Confirm that images or FXML files are located in the correct folders and accessible from the classpath.

## **7. Credits**
- **Author:** MazMorr
- **Purpose:** Inventory management for small and medium-sized enterprises (SMEs).
