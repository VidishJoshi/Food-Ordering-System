/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms_project;
import javax.swing.ButtonGroup;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Harsh Kakasaniya
 */
public class DM_SignIn extends javax.swing.JFrame {

    Connection conn = null;
    CallableStatement stmt = null;
    int delId = 0;
    
    public DM_SignIn() {
        initComponents();
        setSize(520,480);
        setTitle("Please verify your details !!!");
    }
    
    public DM_SignIn(Connection conn) {
        initComponents();
        setSize(520,480);
        setTitle("Please verify your details !!!");
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
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Email = new javax.swing.JTextField();
        BackToMain = new javax.swing.JButton();
        D_SignIn = new javax.swing.JButton();
        Password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Edwardian Script ITC", 3, 53)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 102));
        jLabel2.setText("SignIn as Deliveryman");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 10, 450, 70);

        jLabel5.setFont(new java.awt.Font("Elephant", 3, 40)); // NOI18N
        jLabel5.setText("Password");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(130, 210, 410, 60);

        jLabel7.setFont(new java.awt.Font("Elephant", 3, 40)); // NOI18N
        jLabel7.setText("Email");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(170, 90, 400, 60);

        Email.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jPanel1.add(Email);
        Email.setBounds(30, 150, 440, 40);

        BackToMain.setBackground(new java.awt.Color(255, 153, 102));
        BackToMain.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        BackToMain.setText("Back");
        BackToMain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackToMainActionPerformed(evt);
            }
        });
        jPanel1.add(BackToMain);
        BackToMain.setBounds(280, 340, 160, 70);

        D_SignIn.setBackground(new java.awt.Color(255, 153, 102));
        D_SignIn.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        D_SignIn.setText("Sign In");
        D_SignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                D_SignInActionPerformed(evt);
            }
        });
        jPanel1.add(D_SignIn);
        D_SignIn.setBounds(60, 340, 160, 70);

        Password.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jPanel1.add(Password);
        Password.setBounds(30, 270, 440, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackToMainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackToMainActionPerformed
        // TODO add your handling code here:
        Welcome mf = new Welcome();
        this.setVisible(false);
        this.dispose();
        mf.setVisible(true);
    }//GEN-LAST:event_BackToMainActionPerformed

    private void D_SignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_D_SignInActionPerformed
        try {
            // TODO add your handling code here:
            
            stmt = conn.prepareCall("{call signInDel(?, ?, ?)}");
            stmt.setString(1, Email.getText());
            stmt.setString(2, Password.getText());
            
            stmt.registerOutParameter(3, OracleTypes.INTEGER);
            stmt.execute();
            
            this.delId = stmt.getInt(3);
            
            if(this.delId != 0){
                showMessageDialog(null, "Signed IN Successfully! WELCOME :)");
                PendingDelivery mff = new PendingDelivery();
                this.setVisible(false);
                this.dispose();
                mff.setVisible(true);
            }
            else{
                showMessageDialog(null, "INVALID CREDENTIALS! Can't LOG-IN :(", "ERROR", ERROR_MESSAGE);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DM_SignIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_D_SignInActionPerformed

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
            java.util.logging.Logger.getLogger(DM_SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DM_SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DM_SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DM_SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DM_SignIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackToMain;
    private javax.swing.JButton D_SignIn;
    private javax.swing.JTextField Email;
    private javax.swing.JPasswordField Password;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}