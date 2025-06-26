package Modelos.VentaDeBoletos;

public class Cliente {
    private String nombre;
    private String apellido;
    private String cedula;
    private String correoElectronico;

    public Cliente(String nombre, String apellido, String cedula, String correoElectronico) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.correoElectronico = correoElectronico;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cedula='" + cedula + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                '}';
    }
}
