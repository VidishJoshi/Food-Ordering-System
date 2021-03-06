/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms_project;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.*;
import oracle.jdbc.OracleTypes;
        
/**
 *
 * @author Harsh Kakasaniya
 */
public class Cust_SignIn extends javax.swing.JFrame {

    Connection conn = null;
    CallableStatement stmt = null;
    ResultSet rs = null;
    int cusId = 0;
    
    public Cust_SignIn() {
        initComponents();
        setSize(530,500);
        setTitle("Let me confirm it's U !!!");
    }
    
    public Cust_SignIn(Connection conn) {
        initComponents();
        setSize(530,500);
        setTitle("Let me confirm it's U !!!");
        this.conn = conn;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        C_Email = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Cust_SignIn_Info_Page = new javax.swing.JButton();
        C_Password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("ITCEdwardianScriptW04-Reg", 3, 60)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 102));
        jLabel2.setText("Let me verify it's U");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 0, 460, 100);

        jLabel7.setFont(new java.awt.Font("Elephant", 3, 40)); // NOI18N
        jLabel7.setText("Enter Your Email");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(40, 100, 440, 60);

        C_Email.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jPanel1.add(C_Email);
        C_Email.setBounds(30, 160, 440, 40);

        jLabel5.setFont(new java.awt.Font("Elephant", 3, 40)); // NOI18N
        jLabel5.setText("Enter Password");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(60, 220, 410, 60);

        Cust_SignIn_Info_Page.setBackground(new java.awt.Color(255, 153, 102));
        Cust_SignIn_Info_Page.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        Cust_SignIn_Info_Page.setText("Sign In");
        Cust_SignIn_Info_Page.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cust_SignIn_Info_PageActionPerformed(evt);
            }
        });
        jPanel1.add(Cust_SignIn_Info_Page);
        Cust_SignIn_Info_Page.setBounds(160, 350, 170, 70);

        C_Password.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jPanel1.add(C_Password);
        C_Password.setBounds(30, 280, 440, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Cust_SignIn_Info_PageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cust_SignIn_Info_PageActionPerformed
        try {
            stmt = conn.prepareCall("{call signInCustomer(?, ?, ?)}");
            stmt.setString(1, C_Email.getText());
            stmt.setString(2, C_Password.getText());
            
            stmt.registerOutParameter(3, OracleTypes.INTEGER);
            stmt.execute();
            
            this.cusId = stmt.getInt(3);
            
            if(this.cusId != 0){
                showMessageDialog(null, "Signed IN Successfully! WELCOME :)");
                After_Cust_Sign_In_OR_Up mf1 = new After_Cust_Sign_In_OR_Up();
                this.setVisible(false);
                this.dispose();
                mf1.setVisible(true);
            }
            else{
                showMessageDialog(null, "INVALID CREDENTIALS! Can't LOG-IN :(", "ERROR", ERROR_MESSAGE);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Cust_SignIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Cust_SignIn_Info_PageActionPerformed

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
            java.util.logging.Logger.getLogger(Cust_SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cust_SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cust_SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cust_SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cust_SignIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField C_Email;
    private javax.swing.JPasswordField C_Password;
    private javax.swing.JButton Cust_SignIn_Info_Page;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
