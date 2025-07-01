package com.cinemax.moduloboletos.Servicios.VentaDeBoletos;

import java.util.List;

import com.cinemax.moduloboletos.Modelos.VentaDeBoletos.CalculadorIVA;
import com.cinemax.moduloboletos.Modelos.VentaDeBoletos.CalculadorImpuesto;
import com.cinemax.moduloboletos.Modelos.VentaDeBoletos.Cliente;
import com.cinemax.moduloboletos.Modelos.VentaDeBoletos.Factura;
import com.cinemax.moduloboletos.Modelos.VentaDeBoletos.Producto;

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
