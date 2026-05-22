/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author hansa
 */
public class Turno {

    private int idTurn;
    private int mes;
    private int dia;
    private int hora;
    private int estado;
    private Cliente cliente;
    private Servicio servicio;

    public Turno() {
    }

    public Turno(int idTurn, int mes, int dia, int hora, int estado, Cliente cliente, Servicio servicio) {
        this.idTurn = idTurn;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.estado = estado;
        this.cliente = cliente;
        this.servicio = servicio;
    }

    public int getIdTurn() {
        return idTurn;
    }

    public void setIdTurn(int idTurn) {
        this.idTurn = idTurn;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    @Override
    public String toString() {
        return "Turno{" + "idTurn=" + idTurn + ", mes=" + mes + ", dia=" + dia + ", hora=" + hora
                + ", estado=" + estado + ", cliente=" + cliente + ", servicio=" + servicio + '}';
    }

}
