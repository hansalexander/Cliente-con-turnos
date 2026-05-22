/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BDatos;

import Clases.Servicio;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author hansa
 */
public class BDServicio {

    Conexiones BLcon = new Conexiones();

    // INSERTAR SERVICIO
    public int InsertarServicio(Servicio objServicio)
            throws ClassNotFoundException, SQLException {

        String Sentencia = "INSERT INTO servicios (codigo, servicio) VALUES (?, ?)";

        PreparedStatement ps = BLcon.getConnection().prepareStatement(Sentencia);

        ps.setString(1, objServicio.getCodigo());
        ps.setString(2, objServicio.getServicio());

        return ps.executeUpdate();
    }

    // BUSCAR SERVICIO POR CODIGO
    public ResultSet BuscarServicioxCodigo(Servicio objServicio)
            throws SQLException, ClassNotFoundException {

        String Sentencia = "SELECT * FROM servicios WHERE codigo = ?";

        PreparedStatement ps = BLcon.getConnection().prepareStatement(Sentencia);

        ps.setString(1, objServicio.getCodigo());

        return ps.executeQuery();
    }

    // BUSCAR SERVICIO POR ID
    public ResultSet BuscarServicioxId(Servicio objServicio)
            throws SQLException, ClassNotFoundException {

        String Sentencia = "SELECT * FROM servicios WHERE idSer = ?";

        PreparedStatement ps = BLcon.getConnection().prepareStatement(Sentencia);

        ps.setInt(1, objServicio.getIdSer());

        return ps.executeQuery();
    }
}
