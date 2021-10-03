/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author agraw
 */
public class javaConnection extends javax.swing.JFrame {
    public static Connection getConnection(){
        Connection con=null;
        try {
             con=DriverManager.getConnection("jdbc:mysql://localhost/Library?serverTimezone=EST5EDT", "root",null);
               
            //JOptionPane.showMessageDialog(null,"connected");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(javaConnection.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null," not connected");
            return null;
        }
    
        
    
}}
