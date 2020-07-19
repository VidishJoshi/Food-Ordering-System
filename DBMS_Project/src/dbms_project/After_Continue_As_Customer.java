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
public class After_Continue_As_Customer extends javax.swing.JFrame {

    Connection conn = null;
    CallableStatement stmt = null;
    ResultSet rs = null;
    ArrayList<String> arrL = new ArrayList<String>();
    
    public After_Continue_As_Customer() {
        initComponents();
        setSize(520,870);
        setTitle("Get details !!!");
    }
    
    public After_Continue_As_Customer(Connection conn) {
        initComponents();
        setSize(520,870);
        setTitle("Get details !!!");
        this.conn = conn;
        fillStates();
    }
    
    void fillStates(){
        try {
            stmt = conn.prepareCall("{call statesList(?)}");
            stmt.registerOutParameter(1, OracleTypes.CURSOR);
            stmt.execute();
            
            rs = (ResultSet) stmt.getObject(1);
            while(rs.next()){
                State_Dropdown.addItem(rs.getString("s_name"));
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        State_Dropdown = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        City_Dropdown = new javax.swing.JComboBox();
        Rest_Dropdown = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Menu_Items = new javax.swing.JComboBox();
        OrderNow = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("ITCEdwardianScriptW04-Reg", 3, 100)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 102));
        jLabel2.setText("Get Details");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 0, 430, 150);

        State_Dropdown.setBackground(new java.awt.Color(255, 153, 102));
        State_Dropdown.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        State_Dropdown.setToolTipText("--selected state--");
        State_Dropdown.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                State_DropdownMouseClicked(evt);
            }
        });
        jPanel1.add(State_Dropdown);
        State_Dropdown.setBounds(50, 210, 380, 40);

        jLabel11.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        jLabel11.setText("Select your state");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(130, 160, 220, 50);

        jLabel12.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        jLabel12.setText("Select your city");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(130, 260, 220, 50);

        City_Dropdown.setBackground(new java.awt.Color(255, 153, 102));
        City_Dropdown.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        City_Dropdown.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                City_DropdownMouseClicked(evt);
            }
        });
        City_Dropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                City_DropdownActionPerformed(evt);
            }
        });
        jPanel1.add(City_Dropdown);
        City_Dropdown.setBounds(50, 310, 380, 40);

        Rest_Dropdown.setBackground(new java.awt.Color(255, 153, 102));
        Rest_Dropdown.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        Rest_Dropdown.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Rest_DropdownMouseClicked(evt);
            }
        });
        Rest_Dropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rest_DropdownActionPerformed(evt);
            }
        });
        jPanel1.add(Rest_Dropdown);
        Rest_Dropdown.setBounds(50, 420, 380, 40);

        jLabel13.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        jLabel13.setText("Select restaurant");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(120, 370, 260, 50);

        jLabel14.setFont(new java.awt.Font("Elephant", 3, 24)); // NOI18N
        jLabel14.setText("Menu");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(20, 490, 80, 60);

        Menu_Items.setBackground(new java.awt.Color(255, 153, 102));
        Menu_Items.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        Menu_Items.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_ItemsActionPerformed(evt);
            }
        });
        jPanel1.add(Menu_Items);
        Menu_Items.setBounds(110, 500, 370, 40);

        OrderNow.setBackground(new java.awt.Color(255, 153, 102));
        OrderNow.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        OrderNow.setText("Order Now");
        OrderNow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderNowActionPerformed(evt);
            }
        });
        jPanel1.add(OrderNow);
        OrderNow.setBounds(290, 730, 190, 70);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void City_DropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_City_DropdownActionPerformed
        // TODO add your handling code here:
        // ADD ITEMS BASED ON STATE
    }//GEN-LAST:event_City_DropdownActionPerformed

    private void Rest_DropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rest_DropdownActionPerformed
        // TODO add your handling code here:
        // ADD ITEMS BASED ON CITY
    }//GEN-LAST:event_Rest_DropdownActionPerformed

    private void Menu_ItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_ItemsActionPerformed
        // TODO add your handling code here:
        // ADD ITEMS BASED ON RESTAURANT SELECTED
    }//GEN-LAST:event_Menu_ItemsActionPerformed

    private void OrderNowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderNowActionPerformed
        // TODO add your handling code here:
        Cust_SignUp mf = new Cust_SignUp(conn);
        this.setVisible(false);
        this.dispose();
        mf.setVisible(true);
    }//GEN-LAST:event_OrderNowActionPerformed

    private void State_DropdownMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_State_DropdownMouseClicked
        // TODO add your handling code here:
        City_Dropdown.removeAllItems();
        try {
            stmt = conn.prepareCall("{call cityList(?, ?)}");
            stmt.setString(1, State_Dropdown.getSelectedItem().toString());
            //System.out.println(R_State.getSelectedItem().toString());
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            
            rs = (ResultSet) stmt.getObject(2);
            while(rs.next()){
                City_Dropdown.addItem(rs.getString("c_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Rest_SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_State_DropdownMouseClicked

    private void City_DropdownMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_City_DropdownMouseClicked
        // TODO add your handling code here:
        Rest_Dropdown.removeAllItems();
        arrL.clear();
        try {
            stmt = conn.prepareCall("{call viewSpcificRestaurantList(?, ?, ?)}");
            stmt.setString(1, State_Dropdown.getSelectedItem().toString());
            stmt.setString(2, City_Dropdown.getSelectedItem().toString());
            System.out.println(City_Dropdown.getSelectedIndex());
            
            stmt.registerOutParameter(3, OracleTypes.CURSOR);
            stmt.execute();
            
            rs = (ResultSet) stmt.getObject(3);
            while(rs.next()){
                Rest_Dropdown.addItem(rs.getString("res_name"));
                arrL.add(rs.getString("res_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Rest_SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_City_DropdownMouseClicked

    private void Rest_DropdownMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Rest_DropdownMouseClicked
        // TODO add your handling code here:
        Menu_Items.removeAllItems();
        ArrayList<String> ar1 = new ArrayList<String>();
        try {
            int ind = Rest_Dropdown.getSelectedIndex();
            
            stmt = conn.prepareCall("{call getRestaurantMenu(?, ?)}");
            stmt.setString(1, arrL.get(ind));
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            
            rs = (ResultSet) stmt.getObject(2);
            while(rs.next()){
                ar1.add(rs.getString("item_id"));
            }
            
            stmt = conn.prepareCall("{call getItemName(?, ?)}");
            for(int i=0; i<ar1.size(); i++){
                stmt.setString(1, ar1.get(i));
                
                stmt.registerOutParameter(2, OracleTypes.VARCHAR);
                stmt.execute();
                
                String getName = stmt.getString(2);
                Menu_Items.addItem(getName);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Rest_SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Rest_DropdownMouseClicked

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
            java.util.logging.Logger.getLogger(After_Continue_As_Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(After_Continue_As_Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(After_Continue_As_Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(After_Continue_As_Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new After_Continue_As_Customer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox City_Dropdown;
    private javax.swing.JComboBox Menu_Items;
    private javax.swing.JButton OrderNow;
    private javax.swing.JComboBox Rest_Dropdown;
    private javax.swing.JComboBox State_Dropdown;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}