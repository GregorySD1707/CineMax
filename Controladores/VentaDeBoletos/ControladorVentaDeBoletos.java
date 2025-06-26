package Controladores.VentaDeBoletos;

import Modelos.VentaDeBoletos.Cliente;
import Modelos.VentaDeBoletos.Factura;

public class ControladorVentaDeBoletos {

    public void gestionarVentaDeBoletos(){
        System.out.println("Módulo de Venta de Boletos iniciado.\n");
        
        ControladorBoleto controladorBoleto = new ControladorBoleto();
        
        //String funcion = "Función de Ejemplo"; // GRUPO A
        //List<String> butacas = List.of("A1", "A2", "B1", "B2"); // GRUPO B

        //List<Producto> boletos = controladorBoleto.generarBoleto(funcion, butacas);

        ControladorFacturacion controladorFacturacion = new ControladorFacturacion();
//
        //Cliente cliente = new Cliente("Juan","Pérez","12345678","juan.perez@example.com");
        //Factura factura = controladorFacturacion.generarFactura(boletos, cliente);

        //System.out.println("Factura generada:");
        //System.out.println(factura);
    }
}
