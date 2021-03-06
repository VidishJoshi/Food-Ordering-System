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
import oracle.jdbc.OracleTypes;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;

/**
 *
 * @author Harsh Kakasaniya
 */
public class Rest_SignUp extends javax.swing.JFrame {
    
    Connection conn;
    CallableStatement stmt;
    ResultSet rs = null;
    
    int dine = 0, homeDel = 0, opTod = 0;
    String resId = "";

    public Rest_SignUp() {
        initComponents();
        setSize(520,1100);
        setTitle("Let's serve FRESH FAST FOOD together !!!");
        
        
        fillTimeBoxes();
        //fillStates();
        
        ButtonGroup D = new ButtonGroup();
        D.add(D_No);
        D.add(D_Yes);
        D_No.setSelected(true);
        
        ButtonGroup HD = new ButtonGroup();
        HD.add(HD_No);
        HD.add(HD_Yes);
        HD_No.setSelected(true);
        
        ButtonGroup OpTod = new ButtonGroup();
        OpTod.add(OpTodYes);
        OpTod.add(OpTodNo);
        OpTodNo.setSelected(true);
    }

    public Rest_SignUp(Connection conn) {
        initComponents();
        setSize(520,1100);
        setTitle("Let's serve FRESH FAST FOOD together !!!");
        this.conn = conn;
        
        fillTimeBoxes();
        fillStates();
        
        ButtonGroup D = new ButtonGroup();
        D.add(D_No);
        D.add(D_Yes);
        D_No.setSelected(true);
        
        ButtonGroup HD = new ButtonGroup();
        HD.add(HD_No);
        HD.add(HD_Yes);
        HD_No.setSelected(true);
        
        ButtonGroup OpTod = new ButtonGroup();
        OpTod.add(OpTodYes);
        OpTod.add(OpTodNo);
        OpTodNo.setSelected(true);
   
    }   
    
    void fillTimeBoxes(){
        String[] s = new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        for(int i=0; i<12; i++){
            OT_Hr.addItem(s[i]);
            CT_Hr.addItem(s[i]);
        }
        
        String[] s1 = new String[]{"00", "15", "30", "45"};
        for(int i=0; i<4; i++){
            OT_Min.addItem(s1[i]);
            CT_Min.addItem(s1[i]);
        }
        
        OT_AM_PM.addItem("AM");
        OT_AM_PM.addItem("PM");
        CT_AM_PM.addItem("AM");
        CT_AM_PM.addItem("PM");
        
    }
    
    void fillStates(){
        try {
            stmt = conn.prepareCall("{call statesList(?)}");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            
            rs = (ResultSet) stmt.getObject(1);
            while(rs.next()){
                R_State.addItem(rs.getString("s_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Rest_SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        R_PhoneNo = new javax.swing.JTextField();
        Rest_SignUp_Info_Page = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        R_Name = new javax.swing.JTextField();
        R_Street = new javax.swing.JTextField();
        R_ZipCode = new javax.swing.JTextField();
        Max_Tables = new javax.swing.JTextField();
        HD_No = new javax.swing.JRadioButton();
        HD_Yes = new javax.swing.JRadioButton();
        D_Yes = new javax.swing.JRadioButton();
        D_No = new javax.swing.JRadioButton();
        CT_AM_PM = new javax.swing.JComboBox<>();
        CT_Hr = new javax.swing.JComboBox<>();
        CT_Min = new javax.swing.JComboBox<>();
        OT_Hr = new javax.swing.JComboBox<>();
        OT_Min = new javax.swing.JComboBox<>();
        OT_AM_PM = new javax.swing.JComboBox<>();
        OpTodNo = new javax.swing.JRadioButton();
        OpTodYes = new javax.swing.JRadioButton();
        jLabel21 = new javax.swing.JLabel();
        R_Email = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        R_Password = new javax.swing.JPasswordField();
        R_State = new javax.swing.JComboBox<>();
        R_City = new javax.swing.JComboBox<>();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("ITCEdwardianScriptW04-Reg", 3, 53)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 102));
        jLabel2.setText("SignUp as Restaurant");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 20, 440, 70);

        R_PhoneNo.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jPanel1.add(R_PhoneNo);
        R_PhoneNo.setBounds(160, 390, 320, 40);

        Rest_SignUp_Info_Page.setBackground(new java.awt.Color(255, 153, 102));
        Rest_SignUp_Info_Page.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        Rest_SignUp_Info_Page.setText("Sign Up");
        Rest_SignUp_Info_Page.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rest_SignUp_Info_PageActionPerformed(evt);
            }
        });
        jPanel1.add(Rest_SignUp_Info_Page);
        Rest_SignUp_Info_Page.setBounds(340, 940, 160, 70);

        jLabel8.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        jLabel8.setText("Name");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(20, 110, 100, 60);

        jLabel9.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        jLabel9.setText("Street");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(20, 160, 150, 60);

        jLabel11.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        jLabel11.setText("Home Delivery Available ?");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(10, 690, 360, 50);

        jLabel12.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        jLabel12.setText("City");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(20, 260, 100, 60);

        jLabel13.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        jLabel13.setText("State");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(20, 210, 100, 60);

        jLabel14.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        jLabel14.setText("Maximum Tables Available");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(10, 790, 380, 60);

        jLabel15.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        jLabel15.setText("Opening Time");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(10, 430, 200, 60);

        jLabel16.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        jLabel16.setText("Dining Available ?");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(10, 740, 250, 50);

        jLabel17.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        jLabel17.setText("Phone");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(20, 390, 100, 40);

        jLabel18.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        jLabel18.setText("Zip Code");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(20, 320, 140, 60);

        jLabel19.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        jLabel19.setText("Closing Time");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(10, 480, 180, 60);

        jLabel20.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        jLabel20.setText("Email ID");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(10, 570, 130, 50);

        R_Name.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jPanel1.add(R_Name);
        R_Name.setBounds(160, 120, 320, 40);

        R_Street.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jPanel1.add(R_Street);
        R_Street.setBounds(160, 170, 320, 40);

        R_ZipCode.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jPanel1.add(R_ZipCode);
        R_ZipCode.setBounds(160, 330, 320, 40);

        Max_Tables.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jPanel1.add(Max_Tables);
        Max_Tables.setBounds(390, 800, 100, 40);

        HD_No.setBackground(new java.awt.Color(255, 153, 102));
        HD_No.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        HD_No.setText("N");
        HD_No.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HD_NoActionPerformed(evt);
            }
        });
        jPanel1.add(HD_No);
        HD_No.setBounds(450, 700, 40, 30);

        HD_Yes.setBackground(new java.awt.Color(255, 153, 102));
        HD_Yes.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        HD_Yes.setText("Y");
        HD_Yes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HD_YesActionPerformed(evt);
            }
        });
        jPanel1.add(HD_Yes);
        HD_Yes.setBounds(390, 700, 40, 30);

        D_Yes.setBackground(new java.awt.Color(255, 153, 102));
        D_Yes.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        D_Yes.setText("Y");
        D_Yes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                D_YesActionPerformed(evt);
            }
        });
        jPanel1.add(D_Yes);
        D_Yes.setBounds(390, 750, 40, 30);

        D_No.setBackground(new java.awt.Color(255, 153, 102));
        D_No.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        D_No.setText("N");
        D_No.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                D_NoActionPerformed(evt);
            }
        });
        jPanel1.add(D_No);
        D_No.setBounds(450, 750, 40, 30);

        jPanel1.add(CT_AM_PM);
        CT_AM_PM.setBounds(400, 490, 80, 40);

        jPanel1.add(CT_Hr);
        CT_Hr.setBounds(220, 490, 80, 40);

        jPanel1.add(CT_Min);
        CT_Min.setBounds(310, 490, 80, 40);

        jPanel1.add(OT_Hr);
        OT_Hr.setBounds(220, 440, 80, 40);

        jPanel1.add(OT_Min);
        OT_Min.setBounds(310, 440, 80, 40);

        jPanel1.add(OT_AM_PM);
        OT_AM_PM.setBounds(400, 440, 80, 40);

        OpTodNo.setBackground(new java.awt.Color(255, 153, 102));
        OpTodNo.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        OpTodNo.setText("N");
        OpTodNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpTodNoActionPerformed(evt);
            }
        });
        jPanel1.add(OpTodNo);
        OpTodNo.setBounds(450, 650, 40, 25);

        OpTodYes.setBackground(new java.awt.Color(255, 153, 102));
        OpTodYes.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        OpTodYes.setText("Y");
        OpTodYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpTodYesActionPerformed(evt);
            }
        });
        jPanel1.add(OpTodYes);
        OpTodYes.setBounds(390, 650, 35, 25);

        jLabel21.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        jLabel21.setText("Password");
        jPanel1.add(jLabel21);
        jLabel21.setBounds(10, 850, 180, 50);

        R_Email.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jPanel1.add(R_Email);
        R_Email.setBounds(150, 570, 330, 40);

        jLabel22.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        jLabel22.setText("Open Today");
        jPanel1.add(jLabel22);
        jLabel22.setBounds(10, 640, 180, 50);
        jPanel1.add(R_Password);
        R_Password.setBounds(200, 860, 280, 40);

        R_State.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        R_State.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                R_StateMouseClicked(evt);
            }
        });
        jPanel1.add(R_State);
        R_State.setBounds(160, 230, 320, 30);

        R_City.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        R_City.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R_CityActionPerformed(evt);
            }
        });
        jPanel1.add(R_City);
        R_City.setBounds(160, 270, 320, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1031, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void D_YesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_D_YesActionPerformed
        // TODO add your handling code here:
        this.dine = 1;
    }//GEN-LAST:event_D_YesActionPerformed

    private void D_NoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_D_NoActionPerformed
        // TODO add your handling code here:
        this.dine = 0;
    }//GEN-LAST:event_D_NoActionPerformed

    private void HD_NoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HD_NoActionPerformed
        // TODO add your handling code here:
        this.homeDel = 0;
    }//GEN-LAST:event_HD_NoActionPerformed

    private void HD_YesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HD_YesActionPerformed
        // TODO add your handling code here:
        this.homeDel = 1;
    }//GEN-LAST:event_HD_YesActionPerformed

    private void Rest_SignUp_Info_PageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rest_SignUp_Info_PageActionPerformed
        try {
            // TODO add your handling code here:
            
            stmt = conn.prepareCall("{call signUpRestaurant(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            stmt.setString(1, R_Name.getText());
            stmt.setString(2, R_Street.getText());
            stmt.setString(3, R_City.getSelectedItem().toString());
            stmt.setString(4, R_State.getSelectedItem().toString());            
            stmt.setInt(5, Integer.parseInt(R_ZipCode.getText()));
            stmt.setString(6, "01-JAN-20 " + OT_Hr.getSelectedItem().toString() + "." + OT_Min.getSelectedItem().toString() + ".00.000000 " + OT_AM_PM.getSelectedItem().toString());
            stmt.setString(7, "01-JAN-20 " + CT_Hr.getSelectedItem().toString() + "." + CT_Min.getSelectedItem().toString() + ".00.000000 " + CT_AM_PM.getSelectedItem().toString());
            stmt.setInt(8, this.opTod);
            stmt.setInt(9, this.homeDel);
            stmt.setInt(10, this.dine);
            stmt.setLong(11, Long.parseLong(R_PhoneNo.getText()));
            stmt.setString(12, R_Email.getText());
            stmt.setInt(13, Integer.parseInt(Max_Tables.getText()));
            stmt.setString(14, R_Password.getText());
            //01-JAN-20 09.00.00.000000 AM
            System.out.println("01-JAN-20 " + CT_Hr.getSelectedItem().toString() + "." + CT_Min.getSelectedItem().toString() + ".00.000000 " + CT_AM_PM.getSelectedItem().toString());
            
            stmt.registerOutParameter(15, OracleTypes.CHAR);
            
            stmt.execute();
            
            resId = stmt.getString(15);
            
            
            After_Rest_Sign_In_OR_Up mf = new After_Rest_Sign_In_OR_Up(conn, resId);
            this.setVisible(false);
            this.dispose();
            mf.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Rest_SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Rest_SignUp_Info_PageActionPerformed

    private void OpTodNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpTodNoActionPerformed
        // TODO add your handling code here:
        this.opTod = 0;
    }//GEN-LAST:event_OpTodNoActionPerformed

    private void OpTodYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpTodYesActionPerformed
        // TODO add your handling code here:
        this.opTod = 1;
    }//GEN-LAST:event_OpTodYesActionPerformed

    private void R_CityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R_CityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_R_CityActionPerformed

    private void R_StateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_R_StateMouseClicked
        // TODO add your handling code here:
        R_City.removeAllItems();
        try {
            stmt = conn.prepareCall("{call cityList(?, ?)}");
            stmt.setString(1, R_State.getSelectedItem().toString());
            //System.out.println(R_State.getSelectedItem().toString());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            
            rs = (ResultSet) stmt.getObject(2);
            while(rs.next()){
                R_City.addItem(rs.getString("c_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Rest_SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_R_StateMouseClicked

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
            java.util.logging.Logger.getLogger(Rest_SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rest_SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rest_SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rest_SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rest_SignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CT_AM_PM;
    private javax.swing.JComboBox<String> CT_Hr;
    private javax.swing.JComboBox<String> CT_Min;
    private javax.swing.JRadioButton D_No;
    private javax.swing.JRadioButton D_Yes;
    private javax.swing.JRadioButton HD_No;
    private javax.swing.JRadioButton HD_Yes;
    private javax.swing.JTextField Max_Tables;
    private javax.swing.JComboBox<String> OT_AM_PM;
    private javax.swing.JComboBox<String> OT_Hr;
    private javax.swing.JComboBox<String> OT_Min;
    private javax.swing.JRadioButton OpTodNo;
    private javax.swing.JRadioButton OpTodYes;
    private javax.swing.JComboBox<String> R_City;
    private javax.swing.JTextField R_Email;
    private javax.swing.JTextField R_Name;
    private javax.swing.JPasswordField R_Password;
    private javax.swing.JTextField R_PhoneNo;
    private javax.swing.JComboBox<String> R_State;
    private javax.swing.JTextField R_Street;
    private javax.swing.JTextField R_ZipCode;
    private javax.swing.JButton Rest_SignUp_Info_Page;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
