package Controladores;

import java.util.List;

import Modelos.PaginaPrincipal;
import Vistas.VistaPaginaPrincipal;

public class ControladorPaginaPrincipal {

    private PaginaPrincipal paginaPrincipal;
    private VistaPaginaPrincipal vistaPaginaPrincipal;

    public ControladorPaginaPrincipal() {
        paginaPrincipal = new PaginaPrincipal();
        vistaPaginaPrincipal = new VistaPaginaPrincipal(this);
    }

    public boolean mostrarPaginaPrincipal() {
        List<String> opciones = paginaPrincipal.obtenerOpciones();
        do{
            vistaPaginaPrincipal.mostrar(opciones);
        }while(paginaPrincipal.verificarSiEstaCerrado() == false);
        return true;
    }

    public void cerrarPaginaPrincipal() {
        paginaPrincipal.cerrar();
    }

}
