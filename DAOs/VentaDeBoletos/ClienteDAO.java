package DAOs.VentaDeBoletos;

import DAOs.PostgreSQLDataHelper;
import Modelos.VentaDeBoletos.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends PostgreSQLDataHelper implements IDAO<Cliente> {
    @Override
    public boolean create(Cliente entity) throws Exception {
        String query = "INSERT INTO CLIENTE (CEDULACLIENTE, NOMBRE, APELLIDO, CORREOELECTRONICO) "
                + "VALUES (?, ?, ?, ?)";
        try {
            Connection conn = obtenerConexion();  // Usamos el método de conexión
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getCedula());
            pstmt.setString(2, entity.getNombre());
            pstmt.setString(3, entity.getApellido());
            pstmt.setString(4, entity.getCorreoElectronico());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al insertar el cliente: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Cliente> readAll() throws Exception {
        List<Cliente> lst = new ArrayList<>();
        String query = "SELECT CEDULACLIENTE, NOMBRE, APELLIDO, CORREOELECTRONICO FROM CLIENTE";
        try {
            Connection conn = obtenerConexion();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getString("CEDULACLIENTE"),
                        rs.getString("NOMBRE"),
                        rs.getString("APELLIDO"),
                        rs.getString("CORREOELECTRONICO")
                );
                lst.add(cliente);
            }
        } catch (SQLException e) {
            System.err.println("Error al leer los clientes: " + e.getMessage());
        }
        return lst;
    }

    @Override
    public Cliente readBy(String id) throws Exception {
        Cliente cliente = null;
        String query = "SELECT CEDULACLIENTE, NOMBRE, APELLIDO, CORREOELECTRONICO "
                + "FROM CLIENTE WHERE CEDULACLIENTE = ?";
        try {
            Connection conn = obtenerConexion();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id.toString());  // Usando la cédula como identificador
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                cliente = new Cliente(
                        rs.getString("CEDULACLIENTE"),
                        rs.getString("NOMBRE"),
                        rs.getString("APELLIDO"),
                        rs.getString("CORREOELECTRONICO")
                );
            }
        } catch (SQLException e) {
            System.err.println("Error al leer el cliente por ID: " + e.getMessage());
        }
        return cliente;
    }

    @Override
    public boolean update(Cliente entity) throws Exception {
        String query = "UPDATE CLIENTE SET CEDULACLIENTE = ?, NOMBRE = ?, APELLIDO = ?, CORREOELECTRONICO = ? "
                + "WHERE CEDULACLIENTE = ?";
        try {
            Connection conn = obtenerConexion();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getCedula());
            pstmt.setString(2, entity.getNombre());
            pstmt.setString(3, entity.getApellido());
            pstmt.setString(4, entity.getCorreoElectronico());
            pstmt.setString(5, entity.getCedula());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al actualizar el cliente: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean delete(String id) throws Exception {
        String query = "DELETE FROM CLIENTE WHERE CEDULACLIENTE = ?";
        try {
            Connection conn = obtenerConexion();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id.toString());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al eliminar el cliente: " + e.getMessage());
            return false;
        }
    }
}
