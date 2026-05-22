/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg2006_turnos_a;

/**
 *
 * @author hansa
 */
import Clases.Cliente;
import Clases.Servicio;
import Clases.Turno;
import Logica.LogCliente;
import Logica.LogServicio;
import Logica.LogTurno;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
            throws ClassNotFoundException, SQLException {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);
        int op = 1;
        while (op != 0) {
            System.out.println("Crear Cliente            <1>");
            System.out.println("Crear Servicio           <2>");
            System.out.println("Crear Turno              <3>");
            System.out.println("Listar Turnos Cliente    <4>");
            System.out.println("Cerrar un turno          <5>");
            System.out.println("Cerrar turno abiertos    <6>");
            System.out.println("Salir                    <0>");
            System.out.print("Ingrese opcion: ");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    CrearCliente();
                    break;
                case 2:
                    CrearServicio();
                    break;
                case 3:
                    CrearTurno();
                    break;
                case 4:
                    ListarTurnos();
                    break;
                default:
                    System.out.println("Saliendo");
                    break;
            }
        }
    }

    private static void CrearCliente()
            throws ClassNotFoundException, SQLException {
        Scanner sc1 = new Scanner(System.in);
        Cliente objCliente = new Cliente();
        LogCliente objLogCliente = new LogCliente();
        String aux;
        System.out.println("  CREACION DE NUEVO CLIENTE ");
        System.out.println("Ingrese Cedula del cliente: ");
        aux = sc1.next();
        objCliente.setCedula(aux);
        System.out.println("Ingrese Nombre del Cliente: ");
        aux = sc1.next();
        objCliente.setCliente(aux);
        objLogCliente.CrearCliente(objCliente);
    }

    private static void CrearServicio()
            throws ClassNotFoundException, SQLException {
        Scanner sc1 = new Scanner(System.in);
        Servicio objServicio = new Servicio();
        LogServicio objLogServicio = new LogServicio();
        String aux;
        System.out.println("  CREACION DE NUEVO SERVICIO ");
        System.out.println("Ingrese Codigo: ");
        aux = sc1.next();
        objServicio.setCodigo(aux);
        System.out.println("Ingrese Nombre del Servicio: ");
        aux = sc1.next();
        objServicio.setServicio(aux);
        objLogServicio.CrearServicio(objServicio);
    }

    private static void CrearTurno() throws SQLException, ClassNotFoundException {
//        1. pedir la cedula y llenar objeto cliente
        Scanner sc1 = new Scanner(System.in);
        Cliente objCliente = new Cliente();
        LogCliente objLogCliente = new LogCliente();
        Servicio objServicio = new Servicio();
        LogServicio objLogServicio = new LogServicio();
        Turno objTurno = new Turno();
        LogTurno objLogTurno = new LogTurno();
        String aux;
        System.out.println("  CREACION DE NUEVO TURNO ");
        System.out.println("Ingrese Cedula cliente: ");
        aux = sc1.next();
        objCliente.setCedula(aux);
        objLogCliente.BuscarCliente(objCliente);
        if (objCliente.getIdclie() == 0) {
            System.out.println("Cliente no encontrado");
        }
//        2. pedir el codigo y llenar objeto servicio
        System.out.println("Ingrese Codigo del cliente: ");
        aux = sc1.next();
        objServicio.setCodigo(aux);
        objLogServicio.BuscarServicio(objServicio);
//        3. ingresar datos del turno
        System.out.println("Ingrese mes: ");
        //aux = sc1.next();
        objTurno.setMes(sc1.nextInt());
        System.out.println("Ingrese dia: ");
        //aux = sc1.next();
        objTurno.setDia(sc1.nextInt());
        System.out.println("Ingrese hora: ");
        //aux = sc1.next();
        objTurno.setHora(sc1.nextInt());
//        4. setear el objeto turno
        objTurno.setCliente(objCliente);
        objTurno.setServicio(objServicio);
//        5. Crear TURNO
        objLogTurno.CrearTurno(objTurno);

    }

    private static void ListarTurnos() throws SQLException, ClassNotFoundException {
        Scanner sc1 = new Scanner(System.in);
        Cliente objCliente = new Cliente();
        LogCliente objLogCliente = new LogCliente();
        LogTurno objLogTurno = new LogTurno();
        String aux;
        ArrayList<Turno> ArrayTurnos = new ArrayList<Turno>();
        System.out.println("  LISTAR TURNO DE UN CLIENTE ");
//        1. ingresar cedula del cliente y objeto lleno
        System.out.println("Ingrese Cedula cliente: ");
        aux = sc1.next();
        objCliente.setCedula(aux);
        objLogCliente.BuscarCliente(objCliente);
//        2. traer todos los turnos del cliente (id)
        ArrayTurnos = objLogTurno.BuscarTurnosCliente(objCliente);

//        3. listar los turnos
        for (Turno objT : ArrayTurnos) {
            System.out.println(objT.toString());
        }
    }

    private static void CerrarTurno() throws ClassNotFoundException, SQLException {
        Scanner sc1 = new Scanner(System.in);
        Cliente objCliente = new Cliente();
        LogCliente objLogCliente = new LogCliente();
        Turno objTurno = new Turno();
        LogTurno objLogTurno = new LogTurno();
        ArrayList<Turno> ArrayTurno = new ArrayList<Turno>();
        System.out.println(" CERRAR TURNO ");
        System.out.print("Ingrese la cedula del cliente ");
        objCliente.setCedula(sc1.next());
        objLogCliente.BuscarCliente(objCliente);
        System.out.println(" TURNOS DEL CLIENTE ");
        ArrayTurno = objLogTurno.BuscarTurnosCliente(objCliente);
        for (Turno objT : ArrayTurno) {
            System.out.println(objT.toString());
        }
        System.out.print("Ingrese el ID del turno a cerrar: ");
        objTurno.setIdTurn(sc1.nextInt());
        int estado = objLogTurno.CerrarTurno(objTurno);
        if (estado != 0) {
            System.out.println("Turno cerrado ");
        } else {
            System.out.println("No se encontro el turno con ese ID ");
        }
    }

}
