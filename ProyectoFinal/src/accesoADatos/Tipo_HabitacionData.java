/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoADatos;

import entidades.Tipo_Habitacion;
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
public class Tipo_HabitacionData {
private final  Connection conexion;
private  PreparedStatement ps;
private  ResultSet resultado;

    public Tipo_HabitacionData(Connection conexion) {
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
        return thbtcn;
    }
}
