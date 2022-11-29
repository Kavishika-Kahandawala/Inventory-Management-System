/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Code.db;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormatSymbols;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author PsYchO
 */
public class ReportMonthlyProfit extends javax.swing.JFrame {

    /**
     * Creates new form ReportMonthlyProfit
     */
    public ReportMonthlyProfit() {
        initComponents();
        setComboMonth();
        setComboYear();
    }
    
    
    public void setComboYear() {

        try {

            Statement syear = db.mycon().createStatement();
            ResultSet rsyear = syear.executeQuery(" SELECT DISTINCT YEAR(Date) FROM  sales ORDER BY YEAR(Date) ASC ");

            while (rsyear.next()) {
                comboBoxYear.addItem(rsyear.getString("YEAR(Date)"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void setComboMonth() {
        String[] months = new DateFormatSymbols().getMonths();
        comboBoxMonth.addItem("Select");
        comboBoxMonth.setModel(new DefaultComboBoxModel(months));

    }

    public void sortyear() {
//        String searchkey = txt_search.getText();
        String comboyear = (String) comboBoxYear.getSelectedItem();
        if (comboyear == "Select") {

            comboBoxMonth.setEnabled(false);

        } else {
            String yearquery = "SELECT Date,saleid ,INID,Cid,Total_Cost,Total_Bill,Discount,Profit "
                    + "FROM sales WHERE YEAR(Date) = '" + comboyear + "' ";

            comboBoxMonth.setEnabled(true);

        }

    }

    public void sortmonth() {
//        String searchkey = txt_search.getText();

        try {
            String comboyear = (String) comboBoxYear.getSelectedItem();
            String combomonth = (String) comboBoxMonth.getSelectedItem();

            int intmonth = 0;
            if (combomonth.equals("January")) {
                intmonth = 1;
            }
            if (combomonth.equals("February")) {
                intmonth = 2;
            }
            if (combomonth.equals("March")) {
                intmonth = 3;
            }
            if (combomonth.equals("April")) {
                intmonth = 4;
            }
            if (combomonth.equals("May")) {
                intmonth = 5;
            }
            if (combomonth.equals("June")) {
                intmonth = 6;
            }
            if (combomonth.equals("July")) {
                intmonth = 7;
            }
            if (combomonth.equals("August")) {
                intmonth = 8;
            }
            if (combomonth.equals("September")) {
                intmonth = 9;
            }
            if (combomonth.equals("October")) {
                intmonth = 10;
            }
            if (combomonth.equals("November")) {
                intmonth = 11;
            }
            if (combomonth.equals("December")) {
                intmonth = 12;
            }

            txtYear.setText(comboyear);
            txtMonth.setText(combomonth);
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery(" SELECT COUNT(saleid),SUM(No_Items),SUM(Total_Bill),SUM(Total_Cost),SUM(Discount),SUM(Profit) From sales WHERE  YEAR(Date)= '" + comboyear + "' AND MONTH(Date)= '" + intmonth + "'");

            if (rs.next()) {

                totSales.setText(rs.getString("COUNT(saleid)"));
                totItems.setText(rs.getString("SUM(No_Items)"));
                totIncome.setText(rs.getString("SUM(Total_Bill)"));
                totCost.setText(rs.getString("SUM(Total_Cost)"));
                totDiscounts.setText(rs.getString("SUM(Discount)"));
                totProfit.setText(rs.getString("SUM(Profit)"));

            }

        } catch (SQLException e) {
            System.out.println("e");
        }

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMonth = new javax.swing.JLabel();
        comboBoxYear = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        comboBoxMonth = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txtYear = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        totItems = new javax.swing.JTextField();
        totSales = new javax.swing.JTextField();
        totIncome = new javax.swing.JTextField();
        totCost = new javax.swing.JTextField();
        totProfit = new javax.swing.JTextField();
        totDiscounts = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Monthly Report");

        txtMonth.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtMonth.setText(" ");

        comboBoxYear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comboBoxYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        comboBoxYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxYearActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Year");

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

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Month");

        txtYear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtYear.setText(" ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(comboBoxYear, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboBoxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtYear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMonth)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMonth)
                    .addComponent(txtYear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Total Sales:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Total Items:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Total Cost:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Total Income:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Total Discounts:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Total Profit:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("Sales");

        totItems.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totItems.setText(" ");
        totItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totItemsActionPerformed(evt);
            }
        });

        totSales.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totSales.setText(" ");
        totSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totSalesActionPerformed(evt);
            }
        });

        totIncome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totIncome.setText(" ");
        totIncome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totIncomeActionPerformed(evt);
            }
        });

        totCost.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totCost.setText(" ");
        totCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totCostActionPerformed(evt);
            }
        });

        totProfit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totProfit.setText(" ");
        totProfit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totProfitActionPerformed(evt);
            }
        });

        totDiscounts.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totDiscounts.setText(" ");
        totDiscounts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totDiscountsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel16))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totSales, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totItems, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totCost, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totDiscounts, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totProfit, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(180, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(totSales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(totItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totIncome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8))
                    .addComponent(totDiscounts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totProfit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 478, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxYearActionPerformed
        // TODO add your handling code here:
        //        sortyear();
    }//GEN-LAST:event_comboBoxYearActionPerformed

    private void comboBoxMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxMonthItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxMonthItemStateChanged

    private void comboBoxMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxMonthActionPerformed
        // TODO add your handling code here:
        sortmonth();
    }//GEN-LAST:event_comboBoxMonthActionPerformed

    private void totItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totItemsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totItemsActionPerformed

    private void totSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totSalesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totSalesActionPerformed

    private void totIncomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totIncomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totIncomeActionPerformed

    private void totCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totCostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totCostActionPerformed

    private void totProfitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totProfitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totProfitActionPerformed

    private void totDiscountsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totDiscountsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totDiscountsActionPerformed

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
            java.util.logging.Logger.getLogger(ReportMonthlyProfit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportMonthlyProfit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportMonthlyProfit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportMonthlyProfit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportMonthlyProfit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBoxMonth;
    private javax.swing.JComboBox<String> comboBoxYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField totCost;
    private javax.swing.JTextField totDiscounts;
    private javax.swing.JTextField totIncome;
    private javax.swing.JTextField totItems;
    private javax.swing.JTextField totProfit;
    private javax.swing.JTextField totSales;
    private javax.swing.JLabel txtMonth;
    private javax.swing.JLabel txtYear;
    // End of variables declaration//GEN-END:variables
}
