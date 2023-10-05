/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoADatos;

import entidades.Reserva_Huesped;
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
public class Reserva_HuespedData {
private final  Connection conexion;
private  PreparedStatement ps;
private  ResultSet resultado;

    public Reserva_HuespedData(Connection conexion) {
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
        return rhspd;
    }
}
