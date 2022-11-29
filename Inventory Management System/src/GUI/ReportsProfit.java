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
public class ReportsProfit extends javax.swing.JPanel {

    /**
     * Creates new form ReportsProfit
     */
    public ReportsProfit() {
        initComponents();
        table_load();
        setComboYear();
        setComboMonth();

    }

    public void table_load() {
        //load data from sales to table

        try {
            DefaultTableModel dt = (DefaultTableModel) tblSalesReports.getModel();
            dt.setRowCount(0);

            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery(" SELECT Date,saleid ,INID,Cid,Total_Cost,Total_Bill,Discount,Profit FROM sales ");

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

                dt.addRow(v);

            }
        } catch (SQLException e) {
            System.out.println("e");

        }

    }

    public void loadrows(String query) {
        // Load Rows of the table
        try {

            query = query;
            DefaultTableModel dt = (DefaultTableModel) tblSalesReports.getModel();
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

                dt.addRow(v);

            }

        } catch (SQLException e) {
            System.out.println(e);
        }
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

    public void setComboDay() {

        comboBoxDay.removeAllItems();
        String comboyear = (String) comboBoxYear.getSelectedItem();
        String combomonth = (String) comboBoxMonth.getSelectedItem();

        int intcyear = Integer.parseInt(comboyear);
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

        YearMonth yearMonthObject = YearMonth.of(intcyear, intmonth);
        Integer daysInMonth = yearMonthObject.lengthOfMonth();

        Integer cday = 1;
        comboBoxDay.addItem("Select");
        while (cday < daysInMonth) {

            comboBoxDay.addItem(cday.toString());
            cday = cday + 1;
        }

    }

    public void sortyear() {
//        String searchkey = txt_search.getText();
        String comboyear = (String) comboBoxYear.getSelectedItem();
        if (comboyear == "Select") {
            table_load();
            comboBoxMonth.setEnabled(false);
            comboBoxDay.setEnabled(false);
        } else {
            String yearquery = "SELECT Date,saleid ,INID,Cid,Total_Cost,Total_Bill,Discount,Profit "
                    + "FROM sales WHERE YEAR(Date) = '" + comboyear + "' ";
            loadrows(yearquery);
            comboBoxMonth.setEnabled(true);
            comboBoxDay.setEnabled(true);
        }

    }

    public void sortmonth() {
//        String searchkey = txt_search.getText();

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

        String yearquery = "SELECT Date,saleid ,INID,Cid,Total_Cost,Total_Bill,Discount,Profit"
                + " FROM sales WHERE YEAR(Date) = '" + comboyear + "' AND MONTH(Date)= '" + intmonth + "'";
        loadrows(yearquery);
//        }
    }

    public void sortday() {

        String comboyear = (String) comboBoxYear.getSelectedItem();
        String combomonth = (String) comboBoxMonth.getSelectedItem();
        String comboday = (String) comboBoxDay.getSelectedItem();

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

        if (comboday == "Select") {

            String yearquery = "SELECT Date,saleid ,INID,Cid,Total_Cost,Total_Bill,Discount,Profit"
                    + " FROM sales WHERE YEAR(Date) = '" + comboyear + "' AND MONTH(Date)= '" + intmonth + "'";
            loadrows(yearquery);

        } else {

            String yearquery = "SELECT Date,saleid ,INID,Cid,Total_Cost,Total_Bill,Discount,Profit "
                    + "FROM sales WHERE YEAR(Date) = '" + comboyear + "' AND  MONTH(Date) = '" + intmonth + "' AND  DAY(Date) = '" + comboday + "' ";
            loadrows(yearquery);

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboBoxYear = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        comboBoxMonth = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        comboBoxDay = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btn_customer2 = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSalesReports = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Sales Report");

        comboBoxYear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comboBoxYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        comboBoxYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxYearActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Year");

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

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Month");

        comboBoxDay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comboBoxDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        comboBoxDay.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxDayItemStateChanged(evt);
            }
        });
        comboBoxDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxDayActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Date");

        btn_customer2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_customer2.setText("Monthly Report");
        btn_customer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_customer2ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(489, 489, 489)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_customer2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(566, 566, 566)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboBoxYear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboBoxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxDay, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(jLabel6)))
                        .addGap(0, 95, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(32, 78, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBoxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(comboBoxDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(32, 32, 32)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(comboBoxYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btn_customer2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(14, 14, 14))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblSalesReports.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Date", "Sale ID", "Invoice ID", "Customer ID", "Total Cost", "Bill Total", "Discount", "Profit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblSalesReports);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                .addContainerGap())
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxYearActionPerformed
        // TODO add your handling code here:
        sortyear();

    }//GEN-LAST:event_comboBoxYearActionPerformed

    private void comboBoxMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxMonthItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxMonthItemStateChanged

    private void comboBoxMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxMonthActionPerformed
        // TODO add your handling code here:
        sortmonth();
        setComboDay();

    }//GEN-LAST:event_comboBoxMonthActionPerformed

    private void comboBoxDayItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxDayItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxDayItemStateChanged

    private void comboBoxDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxDayActionPerformed
        // TODO add your handling code here:
        sortday();
    }//GEN-LAST:event_comboBoxDayActionPerformed

    private void btn_customer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_customer2ActionPerformed
        // TODO add your handling code here:
        ReportMonthlyProfit monthlyreport = new ReportMonthlyProfit();

        monthlyreport.setVisible(true);
        monthlyreport.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }//GEN-LAST:event_btn_customer2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        GenerateProfitReport.main(new String[0]);

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn_customer2;
    private javax.swing.JComboBox<String> comboBoxDay;
    private javax.swing.JComboBox<String> comboBoxMonth;
    private javax.swing.JComboBox<String> comboBoxYear;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSalesReports;
    // End of variables declaration//GEN-END:variables
}
