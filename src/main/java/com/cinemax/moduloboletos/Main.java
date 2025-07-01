package com.cinemax.moduloboletos;

import com.cinemax.moduloboletos.Controladores.ControladorCineMax;
import com.cinemax.moduloboletos.Modelos.CineMax;
import com.cinemax.moduloboletos.Vistas.VistaCineMax;

public class Main{
    public static void main(String[] args) {
        VistaCineMax vistaCineMax = new VistaCineMax();

        CineMax cineMax = new CineMax();
        
        ControladorCineMax controladorCineMax = new ControladorCineMax(cineMax, vistaCineMax);
        
        controladorCineMax.mostrarPaginaPrincipal();
        //cineMax.iniciar();
    }
}