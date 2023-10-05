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
public class Tipo_Habitacion {
    private int id_tipoDeHabitacion, cantSimple, cantQueen, cantKing, cantPersonas;
    private String descripcion;
    private double precioNoche;
    private boolean estado;

    public Tipo_Habitacion() {
    }

    public Tipo_Habitacion(int cant_simple, int cant_queen, int cant_king, int cant_pers, String descripcion, double precio_Noche, boolean estado) {
        this.cantSimple = cant_simple;
        this.cantQueen = cant_queen;
        this.cantKing = cant_king;
        this.cantPersonas = cant_pers;
        this.descripcion = descripcion;
        this.precioNoche = precio_Noche;
        this.estado = estado;
    }

    public Tipo_Habitacion(int id_TipoDeHabitacion, int cant_simple, int cant_queen, int cant_king, int cant_pers, String descripcion, double precio_Noche, boolean estado) {
        this.id_tipoDeHabitacion = id_TipoDeHabitacion;
        this.cantSimple = cant_simple;
        this.cantQueen = cant_queen;
        this.cantKing = cant_king;
        this.cantPersonas = cant_pers;
        this.descripcion = descripcion;
        this.precioNoche = precio_Noche;
        this.estado = estado;
    }

    public int getId_TipoDeHabitacion() {
        return id_tipoDeHabitacion;
    }

    public void setId_TipoDeHabitacion(int id_TipoDeHabitacion) {
        this.id_tipoDeHabitacion = id_TipoDeHabitacion;
    }

    public int getCant_simple() {
        return cantSimple;
    }

    public void setCant_simple(int cant_simple) {
        this.cantSimple = cant_simple;
    }

    public int getCant_queen() {
        return cantQueen;
    }

    public void setCant_queen(int cant_queen) {
        this.cantQueen = cant_queen;
    }

    public int getCant_king() {
        return cantKing;
    }

    public void setCant_king(int cant_king) {
        this.cantKing = cant_king;
    }

    public int getCant_pers() {
        return cantPersonas;
    }

    public void setCant_pers(int cant_pers) {
        this.cantPersonas = cant_pers;
    }

    public String getCategoria() {
        return descripcion;
    }

    public void setCategoria(String categoria) {
        this.descripcion = categoria;
    }

    public double getPrecio_Noche() {
        return precioNoche;
    }

    public void setPrecio_Noche(double precio_Noche) {
        this.precioNoche = precio_Noche;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
