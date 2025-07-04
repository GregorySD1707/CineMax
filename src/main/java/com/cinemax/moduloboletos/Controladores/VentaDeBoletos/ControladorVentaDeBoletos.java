package com.cinemax.moduloboletos.Controladores.VentaDeBoletos;

import java.util.List;

import com.cinemax.moduloboletos.Modelos.VentaDeBoletos.Cliente;
import com.cinemax.moduloboletos.Modelos.VentaDeBoletos.Factura;
import com.cinemax.moduloboletos.Modelos.VentaDeBoletos.Producto;

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
        controladorFacturacion = new ControladorFacturacion();

        Cliente cliente = new Cliente("Juan","Pérez","12345678","juan.perez@example.com");
        Factura factura = controladorFacturacion.generarFactura(boletos, cliente);

        System.out.println("Factura generada:");
        System.out.println(factura);
    }
}