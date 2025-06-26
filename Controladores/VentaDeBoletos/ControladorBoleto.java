package Controladores.VentaDeBoletos;

import java.util.List;

import Modelos.VentaDeBoletos.Producto;
import Servicios.VentaDeBoletos.ServicioGeneradorBoleto;

public class ControladorBoleto {

    private ServicioGeneradorBoleto servicioGeneradorBoleto;
    private ControladorAsignadorButacas controladorAsignadorButacas;
    private ControladorAsignadorFuncion controladorAsignadorFuncion;

    public ControladorBoleto() {
        this.servicioGeneradorBoleto = new ServicioGeneradorBoleto();
        this.controladorAsignadorButacas = new ControladorAsignadorButacas();
        this.controladorAsignadorFuncion = new ControladorAsignadorFuncion();
    }

    public List<Producto> generarBoleto(String funcion, List<String> butacas) {
        return servicioGeneradorBoleto.generarBoleto(funcion, butacas);
    }

    public void gestionarBoletos() {
        String funcion = controladorAsignadorFuncion.asignarFuncion("ControladorCartelera");
        List<String> butacas = controladorAsignadorButacas.asignarButacas("ControladorDeConsultaSalas", funcion);

        generarBoleto(funcion, butacas);    
    }
}
