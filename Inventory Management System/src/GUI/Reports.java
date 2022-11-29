/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import Code.JpanelLoader;

/**
 *
 * @author PsYchO
 */
public class Reports extends javax.swing.JPanel {

    JpanelLoader jpload = new JpanelLoader();
    /**
     * Creates new form Reports
     */
    public Reports() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btn_customer = new javax.swing.JToggleButton();
        btn_customer1 = new javax.swing.JToggleButton();
        btn_customer3 = new javax.swing.JToggleButton();
        btn_users = new javax.swing.JToggleButton();
        btn_invoice = new javax.swing.JToggleButton();
        btn_invoice1 = new javax.swing.JToggleButton();
        panel_loader_reports = new javax.swing.JPanel();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonGroup1.add(btn_customer);
        btn_customer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_customer.setText("Employee");
        btn_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_customerActionPerformed(evt);
            }
        });

        buttonGroup1.add(btn_customer1);
        btn_customer1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_customer1.setText("Sales");
        btn_customer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_customer1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(btn_customer3);
        btn_customer3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_customer3.setText("Customer");
        btn_customer3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_customer3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(btn_users);
        btn_users.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_users.setText("Attendence");
        btn_users.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_usersActionPerformed(evt);
            }
        });

        buttonGroup1.add(btn_invoice);
        btn_invoice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_invoice.setText("Invoice");
        btn_invoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_invoiceActionPerformed(evt);
            }
        });

        buttonGroup1.add(btn_invoice1);
        btn_invoice1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_invoice1.setText("Last Transaction");
        btn_invoice1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_invoice1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_customer3, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(btn_customer, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btn_users, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btn_customer1, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_invoice, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_invoice1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addGap(214, 214, 214))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_customer3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_customer, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_customer1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_users, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_invoice, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_invoice1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        panel_loader_reports.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout panel_loader_reportsLayout = new javax.swing.GroupLayout(panel_loader_reports);
        panel_loader_reports.setLayout(panel_loader_reportsLayout);
        panel_loader_reportsLayout.setHorizontalGroup(
            panel_loader_reportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel_loader_reportsLayout.setVerticalGroup(
            panel_loader_reportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 625, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_loader_reports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_loader_reports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_customerActionPerformed
        // Navigate to Customer
        emp_salary_log empsal = new emp_salary_log();
        jpload.jPanelLoader(panel_loader_reports, empsal);
        
    }//GEN-LAST:event_btn_customerActionPerformed

    private void btn_customer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_customer1ActionPerformed
        // TODO add your handling code here:
        ReportsProfit profit = new ReportsProfit();
        jpload.jPanelLoader(panel_loader_reports, profit);
    }//GEN-LAST:event_btn_customer1ActionPerformed

    private void btn_customer3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_customer3ActionPerformed
        // TODO add your handling code here:
        ReportsCustomer repcus = new ReportsCustomer();
        jpload.jPanelLoader(panel_loader_reports, repcus);
    }//GEN-LAST:event_btn_customer3ActionPerformed

    private void btn_usersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_usersActionPerformed
        // TODO add your handling code here:
        attendance atd = new attendance();
        jpload.jPanelLoader(panel_loader_reports, atd);
    }//GEN-LAST:event_btn_usersActionPerformed

    private void btn_invoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_invoiceActionPerformed
        // TODO add your handling code here:
        
        Invoice inv = new Invoice();
        jpload.jPanelLoader(panel_loader_reports, inv);
    }//GEN-LAST:event_btn_invoiceActionPerformed

    private void btn_invoice1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_invoice1ActionPerformed
        // TODO add your handling code here:
        ReportLastCart lastcart = new ReportLastCart();
        jpload.jPanelLoader(panel_loader_reports, lastcart);
    }//GEN-LAST:event_btn_invoice1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn_customer;
    private javax.swing.JToggleButton btn_customer1;
    private javax.swing.JToggleButton btn_customer3;
    private javax.swing.JToggleButton btn_invoice;
    private javax.swing.JToggleButton btn_invoice1;
    private javax.swing.JToggleButton btn_users;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panel_loader_reports;
    // End of variables declaration//GEN-END:variables
}
