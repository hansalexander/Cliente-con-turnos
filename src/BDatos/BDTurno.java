/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BDatos;

import Clases.Cliente;
import Clases.Turno;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author hansa
 */
public class BDTurno {

    Conexiones BLcon = new Conexiones();

    public int InsertarTurno(Turno objTurno)
            throws ClassNotFoundException, SQLException {

        String Sentencia = "INSERT INTO Turnos (mes, dia, hora, idClie, idSer) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement ps = BLcon.getConnection().prepareStatement(Sentencia);

        ps.setInt(1, objTurno.getMes());
        ps.setInt(2, objTurno.getDia());
        ps.setInt(3, objTurno.getHora());
        ps.setInt(4, objTurno.getCliente().getIdclie());
        ps.setInt(5, objTurno.getServicio().getIdSer());

        return ps.executeUpdate();
    }

    public ResultSet BuscarTurnosCliente(Cliente objCliente)
            throws SQLException, ClassNotFoundException {

        String Sentencia = "SELECT * FROM Turnos WHERE idClie = ?";

        PreparedStatement ps = BLcon.getConnection().prepareStatement(Sentencia);

        ps.setInt(1, objCliente.getIdclie());

        return ps.executeQuery();
    }

    public int CerrarTurno(Turno objTurno)
            throws ClassNotFoundException, SQLException {

        String sql = "UPDATE Turnos SET estado = 1 WHERE idTurn = ?";

        PreparedStatement ps = BLcon.getConnection().prepareStatement(sql);

        ps.setInt(1, objTurno.getIdTurn());

        return ps.executeUpdate();
    }
}
