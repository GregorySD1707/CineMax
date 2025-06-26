package Controladores.VentaDeBoletos;

import java.util.List;

import Modelos.VentaDeBoletos.Cliente;
import Modelos.VentaDeBoletos.Factura;
import Modelos.VentaDeBoletos.Producto;
import Servicios.VentaDeBoletos.ServicioFacturacion;

public class ControladorFacturacion {

    private ServicioFacturacion servicioFacturacion;

    public ControladorFacturacion() {
        this.servicioFacturacion = new ServicioFacturacion();
    }

    public Factura generarFactura(List<Producto> productos, Cliente cliente){
        return servicioFacturacion.generarFactura(productos, cliente);
    }    
}
