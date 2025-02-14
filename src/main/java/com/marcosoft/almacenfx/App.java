package com.marcosoft.almacenfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

import java.io.IOException;
import javafx.scene.image.Image;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("accountView"));
        stage.setScene(scene);
        stage.getIcons().add(new Image("file:resources/images/RTS_logo.png"));
        stage.setResizable(false);
        stage.setTitle("Sistema de cuentas");
        stage.centerOnScreen();
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        //connect();
        launch();
    }

}
