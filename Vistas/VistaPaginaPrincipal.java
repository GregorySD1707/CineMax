package Vistas;

import java.util.List;
import java.util.Scanner;

import Controladores.ControladorPaginaPrincipal;

public class VistaPaginaPrincipal {

    ControladorPaginaPrincipal controladorPaginaPrincipal;
    private Scanner scanner = new Scanner(System.in);

    public VistaPaginaPrincipal(ControladorPaginaPrincipal controladorPaginaPrincipal){
        this.controladorPaginaPrincipal = controladorPaginaPrincipal;
    }

    public void mostrar(List<String> opciones) {
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
                controladorPaginaPrincipal.cerrarPaginaPrincipal();
                break;
            default:
                System.out.println("Opción no válida. Por favor, intente de nuevo.");
                break;
        }
    }

}
