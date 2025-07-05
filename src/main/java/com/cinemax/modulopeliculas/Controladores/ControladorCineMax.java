package com.cinemax.modulopeliculas.Controladores;

import com.cinemax.modulopeliculas.Modelos.CineMax;
import com.cinemax.modulopeliculas.Servicios.ServicioCineMax;
import com.cinemax.modulopeliculas.Vistas.VistaCineMax;

public class ControladorCineMax {

    private VistaCineMax vistaPaginaPrincipal;
    private CineMax cineMax;
    private ServicioCineMax servicioCineMax;

    public ControladorCineMax(CineMax cineMax, VistaCineMax vistaCineMax) {
        vistaPaginaPrincipal = vistaCineMax;
        this.cineMax = cineMax;
        this.servicioCineMax = new ServicioCineMax();
    }

    public void mostrarPaginaPrincipal() {
        servicioCineMax.manejarInicio(cineMax, vistaPaginaPrincipal);
    }

    public void cerrarPaginaPrincipal() {
        cineMax.cerrar();
    }
}