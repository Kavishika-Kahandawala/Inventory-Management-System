/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import Code.db;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormatSymbols;
import java.time.YearMonth;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PsYchO
 */
public class ReportsCustomer extends javax.swing.JPanel {

    /**
     * Creates new form ReportsCustomer
     */
    public ReportsCustomer() {
        initComponents();
        table_load();
        setComboMonth();
        setComboYear();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reportsCustomer = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        cusName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cusTP = new javax.swing.JTextField();
        comboBoxYear = new javax.swing.JComboBox<>();
        comboBoxMonth = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        reportsCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Customer ID", "Registered Date", "Registered By", "First Name", "Last Name", "TP Number", "Email", "Points", "Total Discounts"
            }
        ));
        jScrollPane1.setViewportView(reportsCustomer);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cusName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cusName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cusNameActionPerformed(evt);
            }
        });
        cusName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cusNameKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Customer Report");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Customer Name:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Customer TP:");

        cusTP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cusTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cusTPActionPerformed(evt);
            }
        });
        cusTP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cusTPKeyReleased(evt);
            }
        });

        comboBoxYear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comboBoxYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        comboBoxYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxYearActionPerformed(evt);
            }
        });

        comboBoxMonth.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comboBoxMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        comboBoxMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxMonthItemStateChanged(evt);
            }
        });
        comboBoxMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxMonthActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Year");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Month");

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(437, 437, 437)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cusTP, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cusName, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 600, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(comboBoxYear, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboBoxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cusName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboBoxYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBoxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(cusTP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cusNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cusNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cusNameActionPerformed

    private void cusTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cusTPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cusTPActionPerformed

    private void cusNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cusNameKeyReleased
        // Search data with Customer name:
        searchByName();
    }//GEN-LAST:event_cusNameKeyReleased

    private void cusTPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cusTPKeyReleased
        // Search data with Customer TP:
        searchByTP();
    }//GEN-LAST:event_cusTPKeyReleased

    private void comboBoxYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxYearActionPerformed
        // TODO add your handling code here:
        sortyear();

    }//GEN-LAST:event_comboBoxYearActionPerformed

    private void comboBoxMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxMonthActionPerformed
        // TODO add your handling code here:
        sortmonth();

    }//GEN-LAST:event_comboBoxMonthActionPerformed

    private void comboBoxMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxMonthItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_comboBoxMonthItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        GenerateCustomerReport.main(new String[0]);
        

        
    }//GEN-LAST:event_jButton1ActionPerformed

    public void table_load() {

        try {

            DefaultTableModel dt = (DefaultTableModel) reportsCustomer.getModel();
            dt.setRowCount(0);

            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery(" SELECT Cid ,Reg_Date,Reg_Employee,Customer_FirstName,Customer_LastName,Customer_TP,Customer_Email,Loyalty_Points,Total_Discounts FROM customer ");

            while (rs.next()) {

                Vector v = new Vector();

                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
                v.add(rs.getString(8));
                v.add(rs.getString(9));

                dt.addRow(v);

            }

        } catch (SQLException e) {
            System.out.println("e");

        }

    }

    public void searchByName() {
        String name = cusName.getText();

        try {

            DefaultTableModel dt = (DefaultTableModel) reportsCustomer.getModel();
            dt.setRowCount(0);
            Statement s = db.mycon().createStatement();

            ResultSet rs = s.executeQuery("SELECT Cid ,Reg_Date,Reg_Employee,Customer_FirstName,Customer_LastName,Customer_TP,Customer_Email,Loyalty_Points,Total_Discounts "
                    + "FROM customer WHERE Customer_FirstName LIKE '%" + name + "%'  OR Customer_LastName LIKE '%" + name + "%'");

            while (rs.next()) {

                Vector v = new Vector();

                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
                v.add(rs.getString(8));
                v.add(rs.getString(9));

                dt.addRow(v);

            }

        } catch (Exception e) {

            table_load();
        }
    }

    public void searchByTP() {
        String tp = cusTP.getText();

        try {

            DefaultTableModel dt = (DefaultTableModel) reportsCustomer.getModel();
            dt.setRowCount(0);
            Statement s = db.mycon().createStatement();

            ResultSet rs = s.executeQuery("SELECT Cid ,Reg_Date,Reg_Employee,Customer_FirstName,Customer_LastName,Customer_TP,Customer_Email,Loyalty_Points,Total_Discounts "
                    + "FROM customer WHERE Customer_TP LIKE '%" + tp + "%'");

            while (rs.next()) {

                Vector v = new Vector();

                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
                v.add(rs.getString(8));
                v.add(rs.getString(9));

                dt.addRow(v);

            }

        } catch (Exception e) {

            table_load();
        }
    }

    public void loadrows(String query) {
        try {

            query = query;
            DefaultTableModel dt = (DefaultTableModel) reportsCustomer.getModel();
            dt.setRowCount(0);

            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery(query);

            while (rs.next()) {

                Vector v = new Vector();

                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
                v.add(rs.getString(8));
                v.add(rs.getString(9));
                dt.addRow(v);

            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void setComboYear() {

        try {

            Statement syear = db.mycon().createStatement();
            ResultSet rsyear = syear.executeQuery(" SELECT distinct(Reg_year) FROM customer ");

            while (rsyear.next()) {
                comboBoxYear.addItem(rsyear.getString("Reg_year"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void setComboMonth() {
        String[] months = new DateFormatSymbols().getMonths();
        comboBoxMonth.setModel(new DefaultComboBoxModel(months));

    }

    public void sortyear() {
//        String searchkey = txt_search.getText();
        String comboyear = (String) comboBoxYear.getSelectedItem();
        if (comboyear == "Select") {
            table_load();
            comboBoxMonth.setEnabled(false);
        } else {
            String yearquery = "SELECT Cid ,Reg_Date,Reg_Employee,Customer_FirstName,Customer_LastName,Customer_TP,Customer_Email,Loyalty_Points,Total_Discounts "
                    + "FROM customer WHERE Reg_year = '" + comboyear + "' ";
            loadrows(yearquery);
            comboBoxMonth.setEnabled(true);
        }

    }

    public void sortmonth() {
//        String searchkey = txt_search.getText();

        String comboyear = (String) comboBoxYear.getSelectedItem();
        String combomonth = (String) comboBoxMonth.getSelectedItem();

//        if (comboyear == "Select") {
//            
//            comboBoxMonth.setEnabled(false);
//        } else {
        int intmonth = 0;
        if (combomonth.equals("January")) {
            intmonth = 0;
        }
        if (combomonth.equals("February")) {
            intmonth = 1;
        }
        if (combomonth.equals("March")) {
            intmonth = 2;
        }
        if (combomonth.equals("April")) {
            intmonth = 3;
        }
        if (combomonth.equals("May")) {
            intmonth = 4;
        }
        if (combomonth.equals("June")) {
            intmonth = 5;
        }
        if (combomonth.equals("July")) {
            intmonth = 6;
        }
        if (combomonth.equals("August")) {
            intmonth = 7;
        }
        if (combomonth.equals("September")) {
            intmonth = 8;
        }
        if (combomonth.equals("October")) {
            intmonth = 9;
        }
        if (combomonth.equals("November")) {
            intmonth = 10;
        }
        if (combomonth.equals("December")) {
            intmonth = 11;
        }

        String yearquery = "SELECT Cid ,Reg_Date,Reg_Employee,Customer_FirstName,Customer_LastName,Customer_TP,Customer_Email,Loyalty_Points,Total_Discounts"
                + " FROM customer WHERE Reg_year = '" + comboyear + "' AND Reg_Month= '" + intmonth + "'";
        loadrows(yearquery);
//        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBoxMonth;
    private javax.swing.JComboBox<String> comboBoxYear;
    private javax.swing.JTextField cusName;
    private javax.swing.JTextField cusTP;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable reportsCustomer;
    // End of variables declaration//GEN-END:variables
}
