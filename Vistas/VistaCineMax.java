package Vistas;

import java.util.List;
import java.util.Scanner;

import Controladores.ControladorCineMax;

public class VistaCineMax {

    //ControladorCineMax controladorPaginaPrincipal;
    private Scanner scanner = new Scanner(System.in);

    //public VistaCineMax(ControladorCineMax controladorPaginaPrincipal){
    //    this.controladorPaginaPrincipal = controladorPaginaPrincipal;
    //}

    public VistaCineMax(){

    }

    public boolean mostrar(List<String> opciones) {
        System.out.println("Bienvenido a CineMax");
        System.out.println("Seleccione una opción:");
        for (String opcion : opciones) {
            System.out.println(opcion);
        }
        System.out.println("Ingrese el número de la opción deseada:");
        
        int seleccion = scanner.nextInt();

        switch (seleccion) {
            case 1:
                System.out.println("Aquí va la gestión de películas...");
                break;
            case 2:
                System.out.println("Aquí va la gestión de salas...");
                break;
            case 3:
                System.out.println("Aquí va la gestión de boletos...");
                break;
            case 4:
                System.out.println("Aquí va la gestión de empleados...");
                break;
            case 5:
                System.out.println("Aquí va la gestión de reportes...");
                break;
            case 6:
                System.out.println("Saliendo del sistema...");
                //controladorPaginaPrincipal.cerrarPaginaPrincipal();
                return true; // Indica que se debe cerrar la aplicación
            default:
                System.out.println("Opción no válida. Por favor, intente de nuevo.");
                break;
            
        }
        return false; // Indica que la aplicación no se cierra
    }

}
