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
/**
 *
 * @author Harsh Kakasaniya
 */
public class After_Rest_Sign_In_OR_Up extends javax.swing.JFrame {
    
    String resId = "";
    Connection conn = null;
    CallableStatement stmt = null;
    ResultSet rs = null;

    public After_Rest_Sign_In_OR_Up() {
        initComponents();
        setSize(970,880);
        setTitle("Welcome !!!");
    }

    public After_Rest_Sign_In_OR_Up(Connection conn, String resId) {
        initComponents();
        setSize(970,880);
        setTitle("Welcome !!!");
        this.resId = resId;
        this.conn = conn;
        fillDetails();
    }
    
    void fillDetails(){
        try {
            stmt = conn.prepareCall("{call getResDetails(?, ?)}");
            stmt.setString(1, resId);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            
            rs = (ResultSet) stmt.getObject(2);
            while(rs.next()){
                R_Current_Name.setText(rs.getString("res_name"));
                R_Current_Address.setText(rs.getString("address_street") + ", " + rs.getString("address_city") + ", " + rs.getString("address_state") + ", " + rs.getString("address_zip"));
                R_Current_PhoneNo.setText(rs.getLong("phoneNo") + "");
                String OT = rs.getString("open_time");  COT.setText(OT.substring(OT.length() - 8, OT.length()));
                String CT = rs.getString("close_time"); CCT.setText(CT.substring(CT.length() - 8, CT.length()));
                if(rs.getInt("open_today") == 1){
                    Current_Status.setText("Open Today");
                }
                else Current_Status.setText("Close Today");
                if(rs.getInt("home_delivery")==1){
                    CHDS.setText("YES");
                }
                else CHDS.setText("NO");
                if(rs.getInt("dining")==1){
                    CDS.setText("YES");
                    NNN.setText(rs.getInt("tables_available") + "");
                }
                else{
                    CDS.setText("NO");
                    NNN.setText("NO Dining Available");
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(After_Rest_Sign_In_OR_Up.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        EditMenu = new javax.swing.JButton();
        EditDetails = new javax.swing.JButton();
        R_Current_Name = new javax.swing.JLabel();
        R_Current_PhoneNo = new javax.swing.JLabel();
        COT = new javax.swing.JLabel();
        CCT = new javax.swing.JLabel();
        Current_Status = new javax.swing.JLabel();
        CHDS = new javax.swing.JLabel();
        CDS = new javax.swing.JLabel();
        NNN = new javax.swing.JLabel();
        R_Current_Address = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        EditMenu1 = new javax.swing.JButton();
        EditDetails1 = new javax.swing.JButton();
        R_Current_Name1 = new javax.swing.JLabel();
        R_Current_PhoneNo1 = new javax.swing.JLabel();
        COT1 = new javax.swing.JLabel();
        CCT1 = new javax.swing.JLabel();
        Current_Status1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        NNN1 = new javax.swing.JLabel();
        R_Current_Address1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("ITCEdwardianScriptW04-Reg", 3, 60)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 102));
        jLabel2.setText("YourCurrent Details Visible To Customer");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 0, 910, 150);

        EditMenu.setBackground(new java.awt.Color(255, 153, 102));
        EditMenu.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        EditMenu.setText("Edit Menu");
        EditMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditMenuActionPerformed(evt);
            }
        });
        jPanel1.add(EditMenu);
        EditMenu.setBounds(710, 720, 220, 70);

        EditDetails.setBackground(new java.awt.Color(255, 153, 102));
        EditDetails.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        EditDetails.setText("Edit Details");
        EditDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditDetailsActionPerformed(evt);
            }
        });
        jPanel1.add(EditDetails);
        EditDetails.setBounds(420, 720, 220, 70);

        R_Current_Name.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        R_Current_Name.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        R_Current_Name.setText("Set Name Here - R_Current_Name");
        jPanel1.add(R_Current_Name);
        R_Current_Name.setBounds(320, 130, 610, 50);

        R_Current_PhoneNo.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        R_Current_PhoneNo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        R_Current_PhoneNo.setText("Set Contact Details Here - R_Current_PhoneNo");
        jPanel1.add(R_Current_PhoneNo);
        R_Current_PhoneNo.setBounds(270, 240, 660, 60);

        COT.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        COT.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        COT.setText("Set Current Opening Time Mentioned Here - COT ");
        jPanel1.add(COT);
        COT.setBounds(250, 300, 680, 60);

        CCT.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        CCT.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        CCT.setText("Set Current Closing Time Mentioned Here - CCT ");
        jPanel1.add(CCT);
        CCT.setBounds(240, 360, 690, 60);

        Current_Status.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        Current_Status.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Current_Status.setText("Set Current Status Here - Current_Status");
        jPanel1.add(Current_Status);
        Current_Status.setBounds(320, 420, 610, 60);

        CHDS.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        CHDS.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        CHDS.setText("Set Current Status Here - Yes/No - CHDS");
        jPanel1.add(CHDS);
        CHDS.setBounds(390, 480, 550, 50);

        CDS.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        CDS.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        CDS.setText("Set Current Status Here - Yes/No - CDS");
        jPanel1.add(CDS);
        CDS.setBounds(290, 540, 640, 50);

        NNN.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        NNN.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        NNN.setText("Tables - NNN");
        jPanel1.add(NNN);
        NNN.setBounds(410, 590, 510, 60);

        R_Current_Address.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        R_Current_Address.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        R_Current_Address.setText("Set Address Here - R_Current_Address");
        jPanel1.add(R_Current_Address);
        R_Current_Address.setBounds(190, 180, 740, 60);

        jLabel15.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        jLabel15.setText("Restaurant Name ::");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(20, 130, 260, 50);

        jLabel12.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        jLabel12.setText("Address ::");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(30, 180, 150, 60);

        jLabel10.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        jLabel10.setText("Contact Details ::");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(20, 240, 240, 60);

        jLabel17.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        jLabel17.setText("Opening Time :: ");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(20, 300, 220, 60);

        jLabel23.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        jLabel23.setText("Closing Time ::");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(20, 360, 210, 60);

        jLabel24.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        jLabel24.setText("Open Today Status ::");
        jPanel1.add(jLabel24);
        jLabel24.setBounds(20, 420, 300, 60);

        jLabel25.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        jLabel25.setText("Tables Available Currently :: ");
        jPanel1.add(jLabel25);
        jLabel25.setBounds(20, 590, 410, 60);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Edwardian Script ITC", 3, 100)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 153, 102));
        jLabel3.setText("YourCurrent Details");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(70, 10, 830, 150);

        EditMenu1.setBackground(new java.awt.Color(255, 153, 102));
        EditMenu1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        EditMenu1.setText("Edit Menu");
        EditMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditMenu1ActionPerformed(evt);
            }
        });
        jPanel2.add(EditMenu1);
        EditMenu1.setBounds(690, 640, 220, 70);

        EditDetails1.setBackground(new java.awt.Color(255, 153, 102));
        EditDetails1.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        EditDetails1.setText("Edit Details");
        EditDetails1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditDetails1ActionPerformed(evt);
            }
        });
        jPanel2.add(EditDetails1);
        EditDetails1.setBounds(690, 730, 220, 70);

        R_Current_Name1.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        R_Current_Name1.setText("Set Name Here - R_Current_Name");
        jPanel2.add(R_Current_Name1);
        R_Current_Name1.setBounds(320, 170, 610, 50);

        R_Current_PhoneNo1.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        R_Current_PhoneNo1.setText("Set Contact Details Here - R_Current_PhoneNo");
        jPanel2.add(R_Current_PhoneNo1);
        R_Current_PhoneNo1.setBounds(270, 280, 660, 60);

        COT1.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        COT1.setText("Set Current Opening Time Mentioned Here - COT ");
        jPanel2.add(COT1);
        COT1.setBounds(250, 340, 680, 60);

        CCT1.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        CCT1.setText("Set Current Closing Time Mentioned Here - CCT ");
        jPanel2.add(CCT1);
        CCT1.setBounds(240, 400, 690, 60);

        Current_Status1.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        Current_Status1.setText("Set Current Status Here - Current_Status");
        jPanel2.add(Current_Status1);
        Current_Status1.setBounds(320, 460, 610, 60);

        jLabel13.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        jLabel13.setText("Home Delivery Available ?");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(20, 520, 360, 50);

        jLabel22.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        jLabel22.setText("Dining Available ?");
        jPanel2.add(jLabel22);
        jLabel22.setBounds(20, 580, 250, 50);

        NNN1.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        NNN1.setText("Tables - NNN");
        jPanel2.add(NNN1);
        NNN1.setBounds(430, 630, 200, 60);

        R_Current_Address1.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        R_Current_Address1.setText("Set Address Here - R_Current_Address");
        jPanel2.add(R_Current_Address1);
        R_Current_Address1.setBounds(190, 220, 740, 60);

        jLabel16.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        jLabel16.setText("Restaurant Name ::");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(30, 170, 260, 50);

        jLabel14.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        jLabel14.setText("Address ::");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(30, 220, 150, 60);

        jLabel18.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        jLabel18.setText("Contact Details ::");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(20, 280, 240, 60);

        jLabel19.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        jLabel19.setText("Opening Time :: ");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(20, 340, 220, 60);

        jLabel26.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        jLabel26.setText("Closing Time ::");
        jPanel2.add(jLabel26);
        jLabel26.setBounds(20, 400, 210, 60);

        jLabel27.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        jLabel27.setText("Open Today Status ::");
        jPanel2.add(jLabel27);
        jLabel27.setBounds(20, 460, 300, 60);

        jLabel28.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        jLabel28.setText("Maximum Tables Available :: ");
        jPanel2.add(jLabel28);
        jLabel28.setBounds(20, 630, 410, 60);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 0, 0);

        jLabel20.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        jLabel20.setText("Home Delivery Available ?");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(20, 480, 360, 50);

        jLabel29.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        jLabel29.setText("Dining Available ?");
        jPanel1.add(jLabel29);
        jLabel29.setBounds(20, 540, 250, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 947, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EditMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditMenuActionPerformed
        // TODO add your handling code here:
        EditMenu mf = new EditMenu(resId, conn);
        this.setVisible(false);
        this.dispose();
        mf.setVisible(true);
    }//GEN-LAST:event_EditMenuActionPerformed

    private void EditDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditDetailsActionPerformed
        // TODO add your handling code here:
        EditDetails mf1 = new EditDetails(this.resId, conn);
        this.setVisible(false);
        this.dispose();
        mf1.setVisible(true);
    }//GEN-LAST:event_EditDetailsActionPerformed

    private void EditMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditMenu1ActionPerformed

    private void EditDetails1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditDetails1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EditDetails1ActionPerformed

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
            java.util.logging.Logger.getLogger(After_Rest_Sign_In_OR_Up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(After_Rest_Sign_In_OR_Up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(After_Rest_Sign_In_OR_Up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(After_Rest_Sign_In_OR_Up.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new After_Rest_Sign_In_OR_Up().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CCT;
    private javax.swing.JLabel CCT1;
    private javax.swing.JLabel CDS;
    private javax.swing.JLabel CHDS;
    private javax.swing.JLabel COT;
    private javax.swing.JLabel COT1;
    private javax.swing.JLabel Current_Status;
    private javax.swing.JLabel Current_Status1;
    private javax.swing.JButton EditDetails;
    private javax.swing.JButton EditDetails1;
    private javax.swing.JButton EditMenu;
    private javax.swing.JButton EditMenu1;
    private javax.swing.JLabel NNN;
    private javax.swing.JLabel NNN1;
    private javax.swing.JLabel R_Current_Address;
    private javax.swing.JLabel R_Current_Address1;
    private javax.swing.JLabel R_Current_Name;
    private javax.swing.JLabel R_Current_Name1;
    private javax.swing.JLabel R_Current_PhoneNo;
    private javax.swing.JLabel R_Current_PhoneNo1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
