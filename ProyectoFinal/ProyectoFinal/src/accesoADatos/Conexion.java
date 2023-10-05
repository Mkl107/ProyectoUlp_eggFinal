
package accesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {

    private static Connection connection;
    
    //instancia generalizada de la conexion. (agregar DB_name)---------------------------------------------------------
    public static Connection getDefaultConnection(){
        
        try {
            if (connection == null || connection.isClosed()) {
                try{
                    Class.forName("org.mariadb.jdbc.Driver");
                    connection=DriverManager.getConnection("jdbc:mariadb://localhost/DB_name", "root", "");
                }catch(ClassNotFoundException ex){
                    javax.swing.JOptionPane.showMessageDialog(null, "Error en la carga de driver - "+ex.getMessage());
                }
                return connection;
            }else{
                return connection;
            }
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error en la conexion - "+ex.getMessage());
        }
        return connection;
    } 
    
    //instancia personalizada de la conexion. (agregar DB_name, MOD_usr y Password)-----------------------------------
    public static Connection getCustom_DB_Connection(String DB_name, String MOD_Usr, String Password){
        
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("org.mariadb.jdbc.Driver");
                connection=DriverManager.getConnection("jdbc:mariadb://localhost/"+DB_name, MOD_Usr, Password);
            }
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error en la conexion - "+ex.getMessage());
        }catch(ClassNotFoundException ex){
            javax.swing.JOptionPane.showMessageDialog(null, "Error en la carga de driver - "+ex.getMessage());
        }
        return connection;
    }
    
    //instancia personalizada de la conexion. (agregar URL, MOD_Usr y Password)---------------------------------------
    public static Connection getCustom_URL_Connection(String URL, String MOD_Usr, String Password){
        
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("org.mariadb.jdbc.Driver");
                connection=DriverManager.getConnection(URL, MOD_Usr, Password);
            }
        } catch (SQLException ex) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error en la conexion - "+ex.getMessage());
        }catch(ClassNotFoundException ex){
            javax.swing.JOptionPane.showMessageDialog(null, "Error en la carga de driver - "+ex.getMessage());
        }
        return connection;
    }
    
    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection aConnection) {
        connection = aConnection;
    }
}
