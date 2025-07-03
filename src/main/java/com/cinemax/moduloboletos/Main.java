package com.cinemax.moduloboletos;

import java.io.IOException;

import com.cinemax.moduloboletos.Controladores.ControladorCineMax;
import com.cinemax.moduloboletos.Controladores.UI.VentaDeBoletos.ControllerBoleto;
import com.cinemax.moduloboletos.Modelos.CineMax;
import com.cinemax.moduloboletos.Util.ThemeManager;
import com.cinemax.moduloboletos.Vistas.VistaCineMax;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    // --- Campos estáticos para guardar los datos iniciales ---
    private static String initialPelicula;
    private static String initialFuncion;

    // --- PARTE DE JAVAFX ---
    @Override
    public void start(Stage stage) throws IOException {
        stage.initStyle(StageStyle.UNDECORATED);

        // CORRECCIÓN: La ruta debe ser absoluta desde la raíz de los recursos.
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/com/cinemax/moduloboletos/Vistas/VentaDeBoletos/boleto-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        // Pasar los datos guardados al primer controlador de la GUI
        ControllerBoleto controller = fxmlLoader.getController();
        controller.initData(initialPelicula, initialFuncion);

        ThemeManager.getInstance().applyTheme(scene);

        stage.setTitle("CINE MAX - Venta de Boletos");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

    /**
     * Este es el nuevo método que llamará el ControladorCineMax.
     * Guarda los datos y luego lanza la aplicación.
     */
    public static void launchWithData(String pelicula, String funcion) {
        initialPelicula = pelicula;
        initialFuncion = funcion;
        // Llama al método launch() de Application, que eventualmente llamará a start()
        launch(); 
    }

    // --- PARTE DE LA CONSOLA ---
    // Este es el punto de entrada principal de TODA la aplicación.
    public static void main(String[] args) {
        // Inicia la lógica de la aplicación de consola.
        VistaCineMax vistaCineMax = new VistaCineMax();
        CineMax cineMax = new CineMax();
        ControladorCineMax controladorCineMax = new ControladorCineMax(cineMax, vistaCineMax);
        
        controladorCineMax.mostrarPaginaPrincipal();
    }
}
