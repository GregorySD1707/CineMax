package Modelos;

import java.util.List;

public class PaginaPrincipal {

    List<String> opciones;
    private boolean cerrado;
    
    public PaginaPrincipal() {
        cerrado = false;
        // Inicializar las opciones de la página principal
        opciones = List.of("1. Gestionar películas","2. Gestionar Salas", "3. Gestionar boletos", "4. Gestionar Empleados","5. Gestionar Reportes","6. Salir");
    }

    public List<String> obtenerOpciones() {
        return opciones;
    }

    public void cerrar(){
        cerrado = true;
    }

    public boolean verificarSiEstaCerrado(){
        return cerrado;
    }

}
