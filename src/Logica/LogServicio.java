/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import BDatos.BDServicio;
import Clases.Servicio;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author hansa
 */
public class LogServicio {

    BDServicio objBDServicio = new BDServicio();

    public void CrearServicio(Servicio objServicio)
            throws ClassNotFoundException, SQLException {
        objBDServicio.InsertarServicio(objServicio);
    }

    public void BuscarServicio(Servicio objServicio)
            throws SQLException, ClassNotFoundException {
        ResultSet rs = objBDServicio.BuscarServicioxCodigo(objServicio);
        while (rs.next()) {
            // se setea el id al objeto cliente
            objServicio.setIdSer(rs.getInt(1));
            objServicio.setServicio(rs.getString(3));
        }
        rs.close();
    }

    public void BuscarServicioxId(Servicio objServicio)
            throws SQLException, ClassNotFoundException {
        ResultSet rs = objBDServicio.BuscarServicioxId(objServicio);
        while (rs.next()) {
            // se setea el id al objeto cliente
            objServicio.setCodigo(rs.getString(2));
            objServicio.setServicio(rs.getString(3));
        }
        rs.close();
    }
}
