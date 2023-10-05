/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Marcos
 */
public class Habitacion {
    private int id_habitacion, id_tipoDeHabitacion, piso, nroHabitacion;
    private String descripcion;
    boolean estado;

    public Habitacion() {
    }

    public Habitacion(int idTipo_Habitacion, int piso, int nroHabitacion, String descripcion, boolean estado) {
        this.id_tipoDeHabitacion = idTipo_Habitacion;
        this.piso = piso;
        this.nroHabitacion = nroHabitacion;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Habitacion(int idHabitacion, int idTipo_Habitacion, int piso, int nroHabitacion, String descripcion, boolean estado) {
        this.id_habitacion = idHabitacion;
        this.id_tipoDeHabitacion = idTipo_Habitacion;
        this.piso = piso;
        this.nroHabitacion = nroHabitacion;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getIdHabitacion() {
        return id_habitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.id_habitacion = idHabitacion;
    }

    public int getIdTipo_Habitacion() {
        return id_tipoDeHabitacion;
    }

    public void setIdTipo_Habitacion(int idTipo_Habitacion) {
        this.id_tipoDeHabitacion = idTipo_Habitacion;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getNroHabitacion() {
        return nroHabitacion;
    }

    public void setNroHabitacion(int nroHabitacion) {
        this.nroHabitacion = nroHabitacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
