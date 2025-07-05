package com.cinemax.modulopeliculas;

import com.cinemax.modulopeliculas.Controladores.ControladorCineMax;
import com.cinemax.modulopeliculas.Modelos.CineMax;
import com.cinemax.modulopeliculas.Vistas.VistaCineMax;


public class Main{
    public static void main(String[] args) {
        VistaCineMax vistaCineMax = new VistaCineMax();
        CineMax cineMax = new CineMax();
        ControladorCineMax controladorCineMax = new ControladorCineMax(cineMax, vistaCineMax);
        
        // Iniciar la aplicación con el menú principal de CineMax
        try {
            controladorCineMax.mostrarPaginaPrincipal();
        } catch (Exception e) {
            System.err.println("Error crítico en la aplicación: " + e.getMessage());
            e.printStackTrace();
        }
        
        System.out.println("\nGracias por usar CineMax!");
    }
}