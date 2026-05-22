/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import BDatos.BDTurno;
import Clases.Cliente;
import Clases.Servicio;
import Clases.Turno;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author hansa
 */
public class LogTurno {

    BDTurno objBDTurno = new BDTurno();

    public void CrearTurno(Turno objTurno)
            //  sdsfsdfsdf
            throws ClassNotFoundException, SQLException {
        objBDTurno.InsertarTurno(objTurno);
    }

    public ArrayList<Turno> BuscarTurnosCliente(Cliente objCliente)
            throws SQLException, ClassNotFoundException {
        ResultSet rs = objBDTurno.BuscarTurnosCliente(objCliente);
        Servicio objServicio = new Servicio();
        LogServicio objLogServicio = new LogServicio();
        ArrayList<Turno> ArrayTurnos1 = new ArrayList<Turno>();
        Turno objTurno = new Turno();
        while (rs.next()) {
            // se setea el id al objeto cliente
            objTurno = new Turno();
            objServicio = new Servicio();
            objTurno.setIdTurn(rs.getInt(1));
            objTurno.setMes(rs.getInt(2));
            objTurno.setDia(rs.getInt(3));
            objTurno.setHora(rs.getInt(4));
            objTurno.setEstado(rs.getInt(5));
            objTurno.setCliente(objCliente);
            // setear Servicio
            objServicio.setIdSer(rs.getInt(7));
            objLogServicio.BuscarServicioxId(objServicio);
            objTurno.setServicio(objServicio);
            //objTurno.setMes(rs.getInt(2));
            ArrayTurnos1.add(objTurno);
        }
        rs.close();
        return ArrayTurnos1;
    }

    public int CerrarTurno(Turno objTurno)
            throws ClassNotFoundException, SQLException {
        return objBDTurno.CerrarTurno(objTurno);
    }

}
