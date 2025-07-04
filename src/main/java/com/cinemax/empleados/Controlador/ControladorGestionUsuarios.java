package com.cinemax.empleados.Controlador;

import com.cinemax.empleados.Servicios.GestorSesionSingleton;
import com.cinemax.empleados.Modelo.Entidades.Usuario;
import com.cinemax.empleados.Modelo.Entidades.*;


import com.cinemax.empleados.Servicios.GestorUsuarios;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ForkJoinPool;

import javafx.fxml.FXML;

public class ControladorGestionUsuarios {

    public Button btnAgregarUsuario;
    public Button btnBack;
    public Label lblNombreUsuario;
    public Label lblRolUsuario;
    @FXML private TableView<Usuario> tableUsuarios;
    @FXML private TableColumn<Usuario, Long> colActivo;
    @FXML private TableColumn<Usuario, Long> colUsuario;
    @FXML private TableColumn<Usuario, String> colNombre;
    @FXML private TableColumn<Usuario, String> colEmail;
    @FXML private TableColumn<Usuario, String> colRol;
    @FXML private TableColumn<Usuario, Void> colEditar;
    private GestorUsuarios gestorUsuarios;

    @FXML
    public void initialize() {
        // Configurar columnas…
        gestorUsuarios = new GestorUsuarios();

        colActivo.setCellValueFactory(new PropertyValueFactory<>("activo"));
        colUsuario.setCellValueFactory(new PropertyValueFactory<>("nombreUsuario"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombreCompleto"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colRol.setCellValueFactory(new PropertyValueFactory<>("nombreRol"));


        // Columna de botones de edición
        colEditar.setCellFactory(tc -> new TableCell<>() {
            private final Button btn = new Button("✎");
            {
                btn.getStyleClass().add("icon-button");
                btn.setOnAction(e -> editarUsuario(getTableView().getItems().get(getIndex())));
            }
            @Override protected void updateItem(Void itm, boolean empty) {
                super.updateItem(itm, empty);
                setGraphic(empty ? null : btn);
            }
        });

        // Cargar datos…
        try {
            tableUsuarios.setItems(FXCollections.observableArrayList(gestorUsuarios.listarUsuarios()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void editarUsuario(Usuario u) {
        // abrir diálogo / escena de edición
    }

    public void onBackAction(ActionEvent actionEvent) {
    }

    public void onAgregarUsuario(ActionEvent actionEvent) {
    }

    @FXML
    private void onCerrarSesion(ActionEvent event) {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/PantallaLogin.fxml"));
        try {
            Parent root = loader.load();

            // Obtener el Stage actual desde el botón o cualquier nodo
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Portal del Administrador");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        // Ejemplo de cerrar ventana actual (si fuera necesario)
        // Stage stage = (Stage) txtBienvenida.getScene().getWindow();
        // stage.close();
    }
}
