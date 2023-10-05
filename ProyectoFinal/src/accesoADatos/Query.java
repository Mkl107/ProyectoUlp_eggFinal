/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoADatos;

import entidades.Habitacion;
import entidades.Huesped;
import entidades.Reserva_Huesped;
import entidades.Tipo_Habitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Karim
 */
public class Query {
    
private final  Connection conexion;
private  PreparedStatement ps;
private  ResultSet resultado;

    public Query(Connection conexion) {
        this.conexion=conexion;
    }

    //ordenes generales (Modificacion y Carga) + captura de las llaves auto generadas-----------------------
    public int comandoGeneral_generatedKey(String sql){
         try {
                ps=conexion.prepareStatement(sql);
                ps.executeUpdate();
                resultado = ps.getGeneratedKeys();
                int id=0;
                if(resultado.isFirst()){
                    id=resultado.getInt(1);
                }
                return id;
        } catch (SQLException ex) {
                javax.swing.JOptionPane.showMessageDialog(null, "Error \"SQL\" - "+ex.getMessage());
        }finally{
            try {
                ps.close();
            } catch (SQLException ex) {
                javax.swing.JOptionPane.showMessageDialog(null, "Error al finalizar conexion - "+ex.getMessage());
            }
        }
        return 0;
    }
    
    //ordenes generales (Modificacion y Carga)--------------------------------------------------------------
    public int comandoGeneral(String sql){
        try {
                ps=conexion.prepareStatement(sql);
                ps.executeUpdate();
        } catch (SQLException ex) {
                javax.swing.JOptionPane.showMessageDialog(null, "Error \"SQL\" - "+ex.getMessage());
        }finally{
            try {
                ps.close();
            } catch (SQLException ex) {
                javax.swing.JOptionPane.showMessageDialog(null, "Error al finalizar conexion - "+ex.getMessage());
            }
        }
        return 0;
    }
    
    //volcar una DB_list a Object ArrayList -> (Habitacion)-------------------------------------------------------------
    public List<Habitacion> listarHabitaciones(String sql){
        
        List<Habitacion> hbtcn = new ArrayList<>();
        
        try {
            ps=conexion.prepareStatement(sql);
            resultado=ps.executeQuery();
             while (resultado.next()){
                
                Habitacion h = new Habitacion(
                        resultado.getInt("id_habitacion"), 
                        resultado.getInt("id_tipoDeHabitacion"), 
                        resultado.getInt("piso"), 
                        resultado.getInt("nroHabitacion"), 
                        resultado.getString("descripcion"), 
                        resultado.getBoolean("estado"));
                hbtcn.add(h);
            }
            return hbtcn;
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error \"SQL\" - "+ex.getMessage());
        }finally{
            try {
                ps.close();
            } catch (SQLException ex) {
                javax.swing.JOptionPane.showMessageDialog(null, "Error al finalizar conexion - "+ex.getMessage());
            }
        }
        return null;
    }
    
    //volcar una DB_list a Object ArrayList -> (Huesped)----------------------------------------------------------------
    public List<Huesped> listarHuespedes(String sql){
        
        List<Huesped> hspd = new ArrayList<>();
        
        try {
            ps=conexion.prepareStatement(sql);
            resultado=ps.executeQuery();
             while (resultado.next()){
                 
                Huesped mat=new Huesped(
                        resultado.getString("nombre"), 
                        resultado.getString("apellido"), 
                        resultado.getString("domicilio"), 
                        resultado.getString("correo"), 
                        resultado.getString("celular"), 
                        resultado.getString("dni"), 
                        resultado.getInt("id_huesped"), 
                        resultado.getBoolean("estado"));
                hspd.add(mat);
            }
            return hspd;
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error \"SQL\" - "+ex.getMessage());
        }finally{
            try {
                ps.close();
            } catch (SQLException ex) {
                javax.swing.JOptionPane.showMessageDialog(null, "Error al finalizar conexion - "+ex.getMessage());
            }
        }
        return null;
    }
    
    //volcar una DB_list a Object ArrayList -> (Reserva_Huesped)--------------------------------------------------------
    public List<Reserva_Huesped> listarReservas(String sql){
        
        List<Reserva_Huesped> rhspd = new ArrayList<>();
        
        try {
            ps=conexion.prepareStatement(sql);
            resultado=ps.executeQuery();
             while (resultado.next()){
                 
                Reserva_Huesped insc=new Reserva_Huesped(
                        resultado.getInt("idReserva"), 
                        resultado.getInt("id_habitacion"), 
                        resultado.getInt("id_huesped"), 
                        resultado.getInt("cant_personas"), 
                        resultado.getDouble("precio"), 
                        resultado.getBoolean("estado"), 
                        resultado.getDate("fechaIngreso").toLocalDate(), 
                        resultado.getDate("fechaSalida").toLocalDate());
                rhspd.add(insc);
            }
            return rhspd;
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error \"SQL\" - "+ex.getMessage());
        }finally{
            try {
                ps.close();
            } catch (SQLException ex) {
                javax.swing.JOptionPane.showMessageDialog(null, "Error al finalizar conexion - "+ex.getMessage());
            }
        }
        return null;
    }
    
    //volcar una DB_list a Object ArrayList -> (Tipo_Habitacion)---------------------------------------------------------
    public List<Tipo_Habitacion> listarTipo_Habitacion(String sql){
        
        List<Tipo_Habitacion> thbtcn = new ArrayList<>();
        
        try {
            ps=conexion.prepareStatement(sql);
            resultado=ps.executeQuery();
             while (resultado.next()){
                 
                Tipo_Habitacion insc=new Tipo_Habitacion(
                        resultado.getInt("id_tipoDeHabitacion"), 
                        resultado.getInt("cantSimple"), 
                        resultado.getInt("cantQueen"), 
                        resultado.getInt("cantKing"), 
                        resultado.getInt("cantPersonas"), 
                        resultado.getString("descripcion"), 
                        resultado.getDouble("precioNoche"), 
                        resultado.getBoolean("estado"));
                thbtcn.add(insc);
            }
            return thbtcn;
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error \"SQL\" - "+ex.getMessage());
        }finally{
            try {
                ps.close();
            } catch (SQLException ex) {
                javax.swing.JOptionPane.showMessageDialog(null, "Error al finalizar conexion - "+ex.getMessage());
            }
        }
        return null;
    }
}
