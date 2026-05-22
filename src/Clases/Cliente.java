/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author hansa
 */
public class Cliente {

    int idclie;
    String cedula;
    String cliente;

    public Cliente() {
    }

    public Cliente(int idclie, String cedula, String cliente) {
        this.idclie = idclie;
        this.cedula = cedula;
        this.cliente = cliente;
    }

    public int getIdclie() {
        return idclie;
    }

    public String getCedula() {
        return cedula;
    }

    public String getCliente() {
        return cliente;
    }

    public void setIdclie(int idclie) {
        this.idclie = idclie;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "CLiente{" + "idclie=" + idclie + ", cedula=" + cedula + ", cliente=" + cliente + '}';
    }

}
