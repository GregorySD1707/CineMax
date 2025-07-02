package Modelos.VentaDeBoletos;

public class Cliente {
    private String cedula;
    private String nombre;
    private String apellido;
    private String correoElectronico;

    public Cliente(String cedula, String nombre, String apellido, String correoElectronico) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.correoElectronico = correoElectronico;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
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
