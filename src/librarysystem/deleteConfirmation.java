/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author agraw
 */
public class deleteConfirmation extends javax.swing.JFrame {

    /**
     * Creates new form deleteConfirmation
     */
         Connection con;
    ResultSet rs;
    PreparedStatement ps;
    PreparedStatement pd;
    
    
    protected static String e_id,del_id="",type="";
    public deleteConfirmation(String e_id,String del_id,String type) {
        super("Delete Confirmation");
        con= javaConnection.getConnection();
        initComponents();
        this.e_id=e_id;
        this.del_id=del_id;
        this.type=type;
       delId.setText(del_id);
       
       if(type=="cus"){
            jLabel5.setText("Customer Id :");
       }
       else
            jLabel5.setText("Media Id :");         
        
      
    }
    public void deleteMedia(){
        String mediaId="";
          String sql="SELECT BM.`MediaId` FROM `book media` BM INNER JOIN `media` AS M ON BM.MediaId=M.MediaId WHERE BM.`BookId`=?";
          try{
        ps=con.prepareStatement(sql);
         ps.setString(1,delId.getText());
        rs=ps.executeQuery();
         if(rs.next()){
            mediaId=rs.getString(1);
              
             rs.close();
             ps.close();
         }
    } catch (SQLException ex) {
        Logger.getLogger(SearchBook.class.getName()).log(Level.SEVERE, null, ex);
    }
    
        sql="DELETE FROM `media` WHERE `MediaId`=?";
        try {
            // System.out.println("i m here");
            ps=con.prepareStatement(sql);
          
           ps.setString(1,mediaId);
         

            ps.executeUpdate();
            
           // JOptionPane.showMessageDialog(null,"Book Deleted");

            ps.close();

        } catch (SQLException ex) {
            //Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Problem while deleting customer card");
        }
        sql="DELETE FROM `book media` WHERE `BookId`=?";
        try {
            // System.out.println("i m here");
            ps=con.prepareStatement(sql);
          
           ps.setString(1,del_id);
         

            ps.executeUpdate();
            
           // JOptionPane.showMessageDialog(null,"Book Deleted");

            ps.close();

        } catch (SQLException ex) {
            //Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Problem while deleting customer card");
        }
        
        sql="DELETE FROM `books` WHERE `BookId`=?";
        try {
            // System.out.println("i m here");
            ps=con.prepareStatement(sql);
          
           ps.setString(1,del_id);
         

            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Book Deleted");

            ps.close();

        } catch (SQLException ex) {
            //Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Problem while deleting customer card");
        }
    }

    public void deleteCus(){
    
            String sql="DELETE FROM `cards` WHERE `CustomerId`=?";
        try {
            // System.out.println("i m here");
            ps=con.prepareStatement(sql);
           // ps.setString(1,cus2.getText());
           ps.setString(1,del_id);
         

            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null," Customer Card Taken Back");

            ps.close();

        } catch (SQLException ex) {
            //Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Problem while deleting customer card");
        }

         sql="SELECT  `Customer Id`, `Name`, `Address`, `Date Of Birth`, `Phone No`, `Username`, `Password`, `Email` FROM `customers` WHERE `Customer Id`=?";
          try {
            // System.out.println("i m here");
            ps=con.prepareStatement(sql);
           
           
             ps.setString(1,del_id);
           
             rs=ps.executeQuery();
         if(rs.next()){
            String query="INSERT INTO `removed customers`(`Customer Id`, `Name`, `Address`, `Date Of Birth`, `Phone No`, `Username`, `Email`, `Date Time`) VALUES (?,?,?,?,?,?,?,?)";
        try {
             LocalDateTime now = LocalDateTime.now();
             DateTimeFormatter formate = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");  
        
        
        String DeletedOn = now.format(formate); 
            System.out.println("i m here");
            pd=con.prepareStatement(query);
            pd.setString(1,rs.getString(1));
            pd.setString(2,rs.getString(2));
            pd.setString(3,rs.getString(3));
            pd.setString(4,rs.getString(4));
            pd.setString(5,rs.getString(5));
            pd.setString(6,rs.getString(6));
            pd.setString(7,rs.getString(8));
            pd.setString(8,DeletedOn);
            
            pd.executeUpdate();
          

            pd.close();

        } catch (SQLException ex) {
            Logger.getLogger(newCustomer.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Problem while removing customer data at level 3");
        }
              
             rs.close();
             ps.close();
         }
    } catch (SQLException ex) {
        Logger.getLogger(SearchBook.class.getName()).log(Level.SEVERE, null, ex);
    }

        String query="DELETE FROM `customers` WHERE `Customer Id`=?";
        try {
            // System.out.println("i m here");
            ps=con.prepareStatement(query);
           // ps.setString(1,cus2.getText());
           
             ps.setString(1,del_id);
            ps.executeUpdate();
          
           // JOptionPane.showMessageDialog(null,"Customer data deleted");

            ps.close();

        } catch (SQLException ex) {
            //Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Problem while deleting customer data");
        }
         JOptionPane.showMessageDialog(null," customer data deleted");
    }
    
    
            
            

        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        delId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(28, 26, 33));

        jLabel1.setFont(new java.awt.Font("MV Boli", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("delete data of this customer?");

        jLabel2.setFont(new java.awt.Font("MV Boli", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Are you sure you want to permanently ");

        jLabel3.setFont(new java.awt.Font("Lucida Calligraphy", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Password :");

        jButton1.setFont(new java.awt.Font("Kristen ITC", 0, 13)); // NOI18N
        jButton1.setText("Yes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Kristen ITC", 0, 13)); // NOI18N
        jButton2.setText("No");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        delId.setText("jTextField1");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Customer Id:");

        pass.setText("jPasswordField1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton1)
                                    .addComponent(jLabel3))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(99, 99, 99)
                                        .addComponent(jButton2))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(delId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(139, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addComponent(jLabel2)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(54, 54, 54))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(jLabel2)
                    .addContainerGap(316, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        libCusView ob=new libCusView(e_id);
        ob.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
     String query="SELECT `EId` FROM `librarian` WHERE `Password`=SHA1(?) AND `EId`=?";
     try {//System.out.println("can i be here");
         ps=con.prepareStatement(query);
        // System.out.println("yes you can");
        
         ps.setString(1,pass.getText());
         ps.setString(2,e_id);
         rs= ps.executeQuery();
         //System.out.println("i m here again");
         if(rs.next()){
 //            s_id=5;
        JOptionPane.showMessageDialog(null,"deleting data");
        sleep(5000);
        
        if(type=="cus")
            deleteCus();
        else
            deleteMedia();
        
        setVisible(false);
        libCusView ob=new libCusView(e_id);
        ob.setVisible(true);
        
         }         
         else{
         JOptionPane.showMessageDialog(null,"Wrong UserName Or Password");}
     } catch (SQLException ex) {
     Logger.getLogger(deleteConfirmation.class.getName()).log(Level.SEVERE, null, ex);
     }       catch (InterruptedException ex) {
                 Logger.getLogger(deleteConfirmation.class.getName()).log(Level.SEVERE, null, ex);
             }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(deleteConfirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(deleteConfirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(deleteConfirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(deleteConfirmation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new deleteConfirmation(e_id,del_id,type).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField delId;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField pass;
    // End of variables declaration//GEN-END:variables
}
