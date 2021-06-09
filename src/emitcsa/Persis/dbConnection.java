/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emitcsa.Persis;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Eliezer
 */
public class dbConnection {
    
    public static Connection con(){
        
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/transpo","root","");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return con;
        
        
        
    }
    
    
}
