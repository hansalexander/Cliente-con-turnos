package BDatos;

import Clases.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hansa
 */
public class BDCliente {

    Conexiones BLcon = new Conexiones ();

    public int InsertarCliente(Cliente objCliente)
            throws ClassNotFoundException, SQLException {
        String Sentencia = "insert into clientes (cedula, cliente)"
                + "values (?,?)";
        PreparedStatement ps = BLcon.getConnection().prepareStatement(Sentencia);
        ps.setString(1, objCliente.getCedula());
        ps.setString(2, objCliente.getCliente());
        return ps.executeUpdate();
    }

    public ResultSet BuscarClientexCedula(Cliente objCliente)
            throws SQLException, ClassNotFoundException {
        String Sentencia = "SELECT * FROM Clientes where cedula = ?";
        PreparedStatement ps = BLcon.getConnection().prepareStatement(Sentencia);
        ps.setString(1, objCliente.getCedula());
        return ps.executeQuery();
    }

}
