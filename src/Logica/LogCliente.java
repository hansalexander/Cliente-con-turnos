package Logica;

import BDatos.BDCliente;
import Clases.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hansa
 */
public class LogCliente {

    BDCliente objBDCliente = new BDCliente();

    public void CrearCliente(Cliente objCliente)
            throws ClassNotFoundException, SQLException {
        objBDCliente.InsertarCliente(objCliente);
    }

    public void BuscarCliente(Cliente objCliente)
            // llenar el objeto si se encuntran datos
            throws SQLException, ClassNotFoundException {
        ResultSet rs = objBDCliente.BuscarClientexCedula(objCliente);
        while (rs.next()) {
            // se setea el id al objeto cliente
            objCliente.setIdclie(rs.getInt(1));
            objCliente.setCliente(rs.getString(3));
        }
        rs.close();

    }

}
