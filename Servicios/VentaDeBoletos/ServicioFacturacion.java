package Servicios.VentaDeBoletos;

import java.util.List;

import Modelos.VentaDeBoletos.CalculadorIVA;
import Modelos.VentaDeBoletos.CalculadorImpuesto;
import Modelos.VentaDeBoletos.Cliente;
import Modelos.VentaDeBoletos.Factura;
import Modelos.VentaDeBoletos.Producto;

public class ServicioFacturacion {

    CalculadorImpuesto calculadorImpuesto;

    public ServicioFacturacion() {
        this.calculadorImpuesto = new CalculadorIVA();
    }



    public Factura generarFactura(List<Producto> productos, Cliente cliente) {
        Factura factura = new Factura("123","6-25-2025",cliente);
        factura.setProductos(productos);
        factura.calcularSubTotal();
        factura.calcularTotal(calculadorImpuesto);
        return factura;
    }
    
}
