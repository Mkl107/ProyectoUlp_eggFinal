/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoADatos;

import entidades.Habitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcos
 */
public class HabitacionData {
private final  Connection conexion;
private  PreparedStatement ps;
private  ResultSet resultado;

    public HabitacionData(Connection conexion) {
        this.conexion = conexion;
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
        return hbtcn;
    }
}
