/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.Statement; 


/**
 *
 * @author JIHAN
 */
public class koneksi_mysql {
    Connection con; 
    public Connection getconConnection(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/pinjambuku", "root", "");
        }
        catch (Exception e) { 
            JOptionPane.showMessageDialog(null, "Koneksi gagal");
        }
        return con;
    }

    Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
