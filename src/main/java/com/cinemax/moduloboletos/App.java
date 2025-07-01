package com.cinemax.moduloboletos;

import com.cinemax.moduloboletos.Controladores.UI.VentaDeBoletos.BoletoController;
import com.cinemax.moduloboletos.Util.ThemeManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class App extends Application {

    private static String initialPelicula;
    private static String initialSala;

    @Override
    public void start(Stage stage) throws IOException {
        stage.initStyle(StageStyle.UNDECORATED);

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/com/cinemax/moduloboletos/Vistas/VentaDeBoletos/boleto-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        BoletoController controller = fxmlLoader.getController();
        controller.initData(initialPelicula, initialSala);


        // Usar el ThemeManager para aplicar el tema inicial
        ThemeManager.getInstance().applyTheme(scene);

        stage.setTitle("CINE MAX - Venta de Boletos");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

    public static void launchWithData(String pelicula, String sala) {
        initialPelicula = pelicula;
        initialSala = sala;
        launch();
    }

    public static void main(String[] args) {
//        launch(args);
        launchWithData("Pelicula Prueba", "Sala7");
    }
}
