package com.cinemax.empleados.Controlador;

import com.cinemax.empleados.Servicios.GestorSesionSingleton;
import com.cinemax.empleados.Modelo.Entidades.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ForkJoinPool;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ControladorPortalPrincipal {


        @FXML
        private Button btnGestionUsuarios;

        @FXML
        private Button btnVerReportes;

        @FXML
        private Button btnConfiguracion;

         @FXML
         private Button btnVentaBoleto;

        @FXML 
        private Label lblNombreUsuario;
        @FXML 
        private Label lblRolUsuario;


    @FXML private HBox headerBar;

        private GestorSesionSingleton gestorSesion;

        /**
         * Método para inicializar el controlador con el usuario activo.
         * Debe llamarse después de cargar la vista.
         */
        @FXML
        public void initialize() {
            gestorSesion = GestorSesionSingleton.getInstancia();
            cargarDatos();
         Usuario u = gestorSesion.getUsuarioActivo();
         lblNombreUsuario.setText(u.getNombreCompleto());
         lblRolUsuario.setText(u.getDescripcionRol());

            System.out.println(gestorSesion.getUsuarioActivo().toString());
                        System.out.println(gestorSesion.getUsuarioActivo().getRol().toString());
            for (Permiso i : gestorSesion.getUsuarioActivo().getRol().getPermisos()) {
                System.out.println(i);
                
            }
//            // Controlar visibilidad de botones según permisos
//            btnGestionUsuarios.setVisible(gestorSesion.tienePermiso(Permiso.GESTIONAR_USUARIO));
//            btnVerReportes.setVisible(gestorSesion.tienePermiso(Permiso.GESTIONAR_REPORTES));
//            btnConfiguracion.setVisible(gestorSesion.tienePermiso(Permiso.GESTIONAR_SALA) || gestorSesion.tienePermiso(Permiso.GESTIONAR_FUNCION));
//            btnVentaBoleto.setVisible(gestorSesion.tienePermiso(Permiso.VENDER_BOLETO));
//        }

    ocultarSiNo(btnGestionUsuarios,   Permiso.GESTIONAR_USUARIO);
    ocultarSiNo(btnVerReportes,   Permiso.GESTIONAR_REPORTES);
    ocultarSiNo(btnConfiguracion,     Permiso.GESTIONAR_SALA);
    ocultarSiNo(btnVentaBoleto,     Permiso.VENDER_BOLETO);
}

    // // --- Control dinámico de permisos ---


//         // Selecciona la vista por defecto
//         btnCartelera.setSelected(true);
//     }

    /* Simplifica: si no tiene alguno de los permisos, oculta (sin dejar hueco) */
    private void ocultarSiNo(Node nodo, Permiso permiso) {
        boolean visible = gestorSesion.tienePermiso(permiso);
        nodo.setVisible(visible);
        nodo.setManaged(visible);           // evita huecos
    }

        @FXML
        private void onGestionUsuarios(ActionEvent event) {
            System.out.println("Navegar a Gestión de Usuarios");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/PantallaGestionDeUsuarios.fxml"));
            try {
                Parent root = loader.load();

                // Obtener el Stage actual desde el botón o cualquier nodo
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setTitle("Portal del Administrador");
                stage.setScene(new Scene(root));
                stage.show();

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }        }

        @FXML
        private void onVerReportes() {
            System.out.println("Navegar a Ver Reportes");
            // TODO: Implementar navegación a la pantalla de reportes
        }

        @FXML
        private void onConfiguracion() {
            System.out.println("Navegar a Configuración");
            // TODO: Implementar navegación a la pantalla de configuración
        }

        @FXML
        private void onVenderBoleto() {
            System.out.println("Navegar a Vender Boleto");
            // TODO: Implementar navegación a la pantalla de venta de boletos
        }

        @FXML
        private void onCerrarSesion(ActionEvent event) {
            System.out.println("Cerrar sesión y volver al login");
            // TODO: Implementar cerrar sesión y volver a la pantalla de login
            URL url = getClass().getResource("/Vista/PantallaPortalPrincipal.fxml");
            System.out.println(url); // Si imprime null, el archivo no se encuentra

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


        public void cargarDatos() {
            Usuario usuarioActivo = gestorSesion.getUsuarioActivo();
            String mensaje = "¡Bienvenido, " + usuarioActivo.getNombreCompleto() + "! Rol: " + usuarioActivo.getDescripcionRol();
        }

    public void onMiPerfil() {
        System.out.println("Navegar a Mi Perfil");
        // TODO: Implementar navegación a la pantalla de mi perfil, para gestion de datos
    }
}




//     public class ControladorPortalPrincipal {

//     // === FXML ===


//     @FXML private ToggleButton btnCartelera, btnVentas, btnClientes,
//                                 btnReportes, btnPersonal, btnConfig;

//     @FXML private GridPane panelCentral;

//     private final GestorSesionSingleton gestor = GestorSesionSingleton.getInstancia();

//     @FXML
//     public void initialize() {
//         // Mostrar datos de la sesión
//         Usuario u = gestor.getUsuarioActivo();
//         lblNombreUsuario.setText(u.getNombreCompleto());
//         lblRolUsuario.setText(u.getDescripcionRol());

//         // // --- Control dinámico de permisos ---
//         // ocultarSiNo(btnClientes,   Permiso.GESTIONAR_CLIENTE);
//         // ocultarSiNo(btnPersonal,   Permiso.GESTIONAR_PERSONAL);
//         // ocultarSiNo(btnReportes,   Permiso.GESTIONAR_REPORTES);
//         // ocultarSiNo(btnConfig,     Permiso.GESTIONAR_SALA, Permiso.GESTIONAR_FUNCION);

//         // Selecciona la vista por defecto
//         btnCartelera.setSelected(true);
//     }

//     /* Simplifica: si no tiene alguno de los permisos, oculta (sin dejar hueco) */
//     private void ocultarSiNo(Node nodo, Permiso permiso) {
//         boolean visible = gestor.tienePermiso(permiso);
//         nodo.setVisible(visible);
//         nodo.setManaged(visible);           // evita huecos
//     }

//     // ==== handlers (ejemplos) ====
//     @FXML private void irCartelera()    { /* cargar vista de cartelera en panelCentral */ }
//     @FXML private void irVentas()       { /* … */ }
//     @FXML private void irClientes()     { /* … */ }
//     @FXML private void irReportes()     { /* … */ }
//     @FXML private void irPersonal()     { /* … */ }
//     @FXML private void irConfiguracion(){ /* … */ }

//     @FXML
//     private void onCerrarSesion(ActionEvent e) throws IOException {
//         gestor.cerrarSesion();
//         Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
//         Parent root = FXMLLoader.load(getClass().getResource("/Vista/PantallaLogin.fxml"));
//         stage.setScene(new Scene(root));
//     }

//     @FXML private void onPerfil() {
//         // abrir diálogo para cambiar contraseña, datos, etc.
//     }
// }
