package Controladores.VentaDeBoletos;

import java.util.List;

import Modelos.VentaDeBoletos.Cliente;
import Modelos.VentaDeBoletos.Factura;
import Modelos.VentaDeBoletos.Producto;

public class ControladorVentaDeBoletos {

    ControladorAsignadorButacas controladorAsignadorButacas;
    ControladorAsignadorFuncion controladorAsignadorFuncion;
    ControladorBoleto controladorBoleto;
    ControladorFacturacion controladorFacturacion;

    public void gestionarVentaDeBoletos(String controladorCartelera, String controladorDeConsultaSalas){
        System.out.println("Módulo de Venta de Boletos iniciado.\n");

        controladorAsignadorButacas = new ControladorAsignadorButacas();
        controladorAsignadorFuncion = new ControladorAsignadorFuncion();
        controladorBoleto = new ControladorBoleto();

        //controladorCartelera = "Controlador de Cartelera"; // Simulación de controlador de cartelera, GRUPO A
        String funcion = controladorAsignadorFuncion.asignarFuncion(controladorCartelera); // GRUPO A

        //controladorDeConsultaSalas = "Controlador de Consulta de Salas"; // Simulación de controlador de consulta de salas, GRUPO B
        List<String> butacas = controladorAsignadorButacas.asignarButacas(controladorDeConsultaSalas, funcion); // GRUPO B

        List<Producto> boletos = controladorBoleto.generarBoleto(funcion, butacas);

        controladorFacturacion = new ControladorFacturacion();

        Cliente cliente = new Cliente("Juan","Pérez","12345678","juan.perez@example.com");
        Factura factura = controladorFacturacion.generarFactura(boletos, cliente);

        System.out.println("Factura generada:");
        System.out.println(factura);
    }
}
