package Modelos;

import Controladores.ControladorPaginaPrincipal;

public class CineMax {

    private ControladorPaginaPrincipal controladorPaginaPrincipal;
    private boolean cerrado;

    public CineMax() {
        this.controladorPaginaPrincipal = new ControladorPaginaPrincipal();
        this.cerrado = false;
    }

    public void iniciar() {
        do{
            cerrado = controladorPaginaPrincipal.mostrarPaginaPrincipal();
        }while(cerrado == false);
    }

}
