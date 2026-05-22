/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author hansa
 */
public class Servicio {

    private int idSer;
    private String codigo;
    private String servicio;

    public Servicio() {
    }

    public Servicio(int idSer, String codigo, String servicio) {
        this.idSer = idSer;
        this.codigo = codigo;
        this.servicio = servicio;
    }

    public int getIdSer() {
        return idSer;
    }

    public void setIdSer(int idSer) {
        this.idSer = idSer;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    @Override
    public String toString() {
        return "Servicio{" + "idSer=" + idSer + ", codigo=" + codigo + ", servicio=" + servicio + '}';
    }

}
