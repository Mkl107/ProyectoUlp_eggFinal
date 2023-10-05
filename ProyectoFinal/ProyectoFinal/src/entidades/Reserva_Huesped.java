/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.time.LocalDate;

/**
 *
 * @author Marcos
 */
public class Reserva_Huesped {
    private int idReserva, id_habitacion, id_huesped, cant_personas;
    private double precio;
    private boolean estado;
    private LocalDate f_ingreso, f_salida;

    public Reserva_Huesped() {
    }

    public Reserva_Huesped(int id_Habitacion, int id_Huesped, int cant_personas, double precio, boolean estado, LocalDate f_ingreso, LocalDate f_salida) {
        this.id_habitacion = id_Habitacion;
        this.id_huesped = id_Huesped;
        this.cant_personas = cant_personas;
        this.precio = precio;
        this.estado = estado;
        this.f_ingreso = f_ingreso;
        this.f_salida = f_salida;
    }

    public Reserva_Huesped(int idReserva, int id_Habitacion, int id_Huesped, int cant_personas, double precio, boolean estado, LocalDate f_ingreso, LocalDate f_salida) {
        this.idReserva = idReserva;
        this.id_habitacion = id_Habitacion;
        this.id_huesped = id_Huesped;
        this.cant_personas = cant_personas;
        this.precio = precio;
        this.estado = estado;
        this.f_ingreso = f_ingreso;
        this.f_salida = f_salida;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getId_Habitacion() {
        return id_habitacion;
    }

    public void setId_Habitacion(int id_Habitacion) {
        this.id_habitacion = id_Habitacion;
    }

    public int getId_Huesped() {
        return id_huesped;
    }

    public void setId_Huesped(int id_Huesped) {
        this.id_huesped = id_Huesped;
    }

    public int getCant_personas() {
        return cant_personas;
    }

    public void setCant_personas(int cant_personas) {
        this.cant_personas = cant_personas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public LocalDate getF_ingreso() {
        return f_ingreso;
    }

    public void setF_ingreso(LocalDate f_ingreso) {
        this.f_ingreso = f_ingreso;
    }

    public LocalDate getF_salida() {
        return f_salida;
    }

    public void setF_salida(LocalDate f_salida) {
        this.f_salida = f_salida;
    }
}
