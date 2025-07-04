package com.cinemax.empleados;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {


    @Override
    public void start(Stage stage) throws IOException {

                try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("✅ Driver JDBC SQL Server cargado correctamente.");
        } catch (ClassNotFoundException e) {
            System.out.println("❌ No se encontró el driver JDBC.");
            e.printStackTrace();
        }

        
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/Vista/PantallaLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);


        stage.setTitle("CineMax - Empleados");
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        // You can add any pre-launch logic here if needed
        launch();
    }
}
