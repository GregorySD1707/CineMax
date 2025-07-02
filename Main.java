import DAOs.VentaDeBoletos.ClienteDAO;
import Modelos.CineMax;
import Controladores.ControladorCineMax;
import Modelos.VentaDeBoletos.Cliente;
import Vistas.VistaCineMax;

public class Main{
    public static void main(String[] args) throws Exception{
        //VistaCineMax vistaCineMax = new VistaCineMax();

        //CineMax cineMax = new CineMax();
        
        //ControladorCineMax controladorCineMax = new ControladorCineMax(cineMax, vistaCineMax);
        
        //controladorCineMax.mostrarPaginaPrincipal();
        //cineMax.iniciar();

        ClienteDAO clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente("1234567890", "Juan", "Pérez", "juan.perez@epn.edu.ec");

        clienteDAO.create(cliente);

        Cliente cliente2 = clienteDAO.readBy("1234567890");

        System.out.println(cliente2.toString());
    }
}