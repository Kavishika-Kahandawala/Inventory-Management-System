/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import Code.db;
import java.awt.HeadlessException;
import java.awt.TextArea;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Inventory extends javax.swing.JPanel {

    public Inventory() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lbl_pid = new javax.swing.JLabel();
        lbl_pname = new javax.swing.JLabel();
        lbl_barcode = new javax.swing.JLabel();
        lbl_cprice = new javax.swing.JLabel();
        lbl_quantity = new javax.swing.JLabel();
        txt_pid = new javax.swing.JTextField();
        txt_bcode = new javax.swing.JTextField();
        txt_pname = new javax.swing.JTextField();
        txt_cprice = new javax.swing.JTextField();
        txt_quantity = new javax.swing.JTextField();
        lbl_sprice = new javax.swing.JLabel();
        txt_sprice = new javax.swing.JTextField();
        chk_active = new javax.swing.JCheckBox();
        btn_edit = new javax.swing.JButton();
        btn_edit1 = new javax.swing.JButton();
        btn_edit2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btn_search = new javax.swing.JButton();
        lbl_sname = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        lbl_sname1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_inventory = new javax.swing.JTable();

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbl_pid.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbl_pid.setText("Product ID:");

        lbl_pname.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbl_pname.setText("Product Name:");

        lbl_barcode.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbl_barcode.setText("Supplier ID:");

        lbl_cprice.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbl_cprice.setText("Cost Price:");

        lbl_quantity.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbl_quantity.setText("Stock Quantity:");

        txt_pid.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_pid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pidActionPerformed(evt);
            }
        });

        txt_bcode.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_bcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bcodeActionPerformed(evt);
            }
        });

        txt_pname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_pname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pnameActionPerformed(evt);
            }
        });

        txt_cprice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_cprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cpriceActionPerformed(evt);
            }
        });

        txt_quantity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_quantityActionPerformed(evt);
            }
        });

        lbl_sprice.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbl_sprice.setText("Seliing Price:");

        txt_sprice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_sprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_spriceActionPerformed(evt);
            }
        });

        chk_active.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        chk_active.setText("Active");
        chk_active.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_activeActionPerformed(evt);
            }
        });

        btn_edit.setBackground(new java.awt.Color(51, 51, 51));
        btn_edit.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_edit.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit.setText("Edit");

        btn_edit1.setBackground(new java.awt.Color(51, 51, 51));
        btn_edit1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_edit1.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit1.setText("Add");

        btn_edit2.setBackground(new java.awt.Color(204, 0, 0));
        btn_edit2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_edit2.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit2.setText("Delete");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chk_active)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbl_barcode)
                                        .addComponent(lbl_pname)
                                        .addComponent(lbl_cprice)
                                        .addComponent(lbl_pid)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addGap(25, 25, 25)
                                    .addComponent(lbl_sprice)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbl_quantity)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_sprice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(txt_cprice, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_pname, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_bcode, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_pid, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_quantity))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(btn_edit2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_edit1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_pid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_pid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_barcode)
                    .addComponent(txt_bcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_pname)
                    .addComponent(txt_pname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_cprice)
                    .addComponent(txt_cprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_sprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_sprice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_quantity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chk_active)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btn_edit1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_edit2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_search.setBackground(new java.awt.Color(51, 51, 51));
        btn_search.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_search.setForeground(new java.awt.Color(255, 255, 255));
        btn_search.setText("Search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        lbl_sname.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_sname.setText("Inventory System");

        txt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchActionPerformed(evt);
            }
        });

        lbl_sname1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbl_sname1.setText("Product Name:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lbl_sname1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 29, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(lbl_sname)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbl_sname)
                .addGap(43, 43, 43)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_sname1)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(btn_search)
                .addContainerGap())
        );

        table_inventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "PID", "Supplier ID", "Product Name", "Cost Price", "Selling Price", "Qty"
            }
        ));
        jScrollPane1.setViewportView(table_inventory);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_pidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pidActionPerformed

    private void txt_bcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bcodeActionPerformed

    private void txt_pnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pnameActionPerformed

    private void txt_cpriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cpriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cpriceActionPerformed

    private void txt_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quantityActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:
        
        //Btn Search
        String search=txt_search.getText();
        
        try {
            Statement search_db=db.mycon().createStatement();
            ResultSet rs = search_db.executeQuery("SELECT * FROM inventory WHERE pname='"+search+"'");
            
            if (rs.next()){
                txt_pname.setText(rs.getString("pname"));
                txt_bcode.setText(rs.getString("barcode"));
                txt_cprice.setText(rs.getString("cprice"));
                txt_sprice.setText(rs.getString("sprice"));
                txt_quantity.setText(rs.getString("quantity") );
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }//GEN-LAST:event_btn_searchActionPerformed

    private void txt_spriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_spriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_spriceActionPerformed

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchActionPerformed

    private void chk_activeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_activeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chk_activeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_edit1;
    private javax.swing.JButton btn_edit2;
    private javax.swing.JButton btn_search;
    private javax.swing.JCheckBox chk_active;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_barcode;
    private javax.swing.JLabel lbl_cprice;
    private javax.swing.JLabel lbl_pid;
    private javax.swing.JLabel lbl_pname;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_sname;
    private javax.swing.JLabel lbl_sname1;
    private javax.swing.JLabel lbl_sprice;
    private javax.swing.JTable table_inventory;
    private javax.swing.JTextField txt_bcode;
    private javax.swing.JTextField txt_cprice;
    private javax.swing.JTextField txt_pid;
    private javax.swing.JTextField txt_pname;
    private javax.swing.JTextField txt_quantity;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_sprice;
    // End of variables declaration//GEN-END:variables
}
