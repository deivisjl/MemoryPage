/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author SAMSUNG
 */
public class Proceso {
    private String PID;
    private String nombre;
    private String estado;
    private int marcoPagina;

    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getMarcoPagina() {
        return marcoPagina;
    }

    public void setMarcoPagina(int marcoPagina) {
        this.marcoPagina = marcoPagina;
    }

}
