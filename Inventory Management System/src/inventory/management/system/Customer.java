package inventory.management.system;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Customer extends javax.swing.JPanel {

    
    public Customer() {
        
        initComponents();
        table_load();
        
    }

    public void table_load(){
    
    try{
    
        DefaultTableModel dt = (DefaultTableModel) c_table.getModel();
        dt.setRowCount(0);
        
        Statement s = db.mycon().createStatement();
        ResultSet rs = s.executeQuery(" SELECT * FROM customer ");
        
        while (rs.next()){
        
            Vector v = new Vector();
            
            v.add(rs.getString(1));
            v.add(rs.getString(2));
            v.add(rs.getString(3));
            
            dt.addRow(v);
            
            
        }
        
    
    }catch(SQLException e){
        System.out.println("e");
    
    }
    
    
    
    }
            
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        c_name = new javax.swing.JTextField();
        c_tp = new javax.swing.JTextField();
        btncsave = new javax.swing.JButton();
        btncsearch = new javax.swing.JButton();
        btncupdate = new javax.swing.JButton();
        btncdelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        c_table = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        c_search = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        c_search_table = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Name :");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("T.P.Number :");

        c_name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        c_name.setText("0");

        c_tp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        c_tp.setText("0");

        btncsave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btncsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/package_icons/save.png"))); // NOI18N
        btncsave.setText("Save");
        btncsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncsaveActionPerformed(evt);
            }
        });

        btncsearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btncsearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/package_icons/search.png"))); // NOI18N
        btncsearch.setText("Search");
        btncsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncsearchActionPerformed(evt);
            }
        });

        btncupdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btncupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/package_icons/update.png"))); // NOI18N
        btncupdate.setText("Update");
        btncupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncupdateActionPerformed(evt);
            }
        });

        btncdelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btncdelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/package_icons/delete.png"))); // NOI18N
        btncdelete.setText("Delete");
        btncdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncdeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btncsave)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(c_tp, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_name, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btncsearch)
                        .addGap(18, 18, 18)
                        .addComponent(btncupdate)
                        .addGap(18, 18, 18)
                        .addComponent(btncdelete)))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(c_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(c_tp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btncupdate)
                        .addComponent(btncdelete))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btncsave)
                        .addComponent(btncsearch)))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        c_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Customer Name", "T.P. Number"
            }
        ));
        c_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(c_table);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Customers Info :");

        c_search.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        c_search.setText("0");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Search ID :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(c_search, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)))
                .addContainerGap(313, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(19, 19, 19))
        );

        c_search_table.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        c_search_table.setText("0");
        c_search_table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                c_search_tableKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Search :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(c_search_table, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(c_search_table, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btncsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncsaveActionPerformed
        // TODO add your handling code here:
        
        String name = c_name.getText();
        String tp = c_tp.getText();
        
        try {
        
            Statement s = db.mycon().createStatement();
            s.executeUpdate("INSERT INTO customer (Customer_name,Tp_Number) VALUES ('"+name+"','"+tp+"')");
                JOptionPane.showMessageDialog(null, "Customer Data Saved");
            
            
        } catch (SQLException e) {
            System.out.println("e");
            
   
        }
        
        table_load();
        
    }//GEN-LAST:event_btncsaveActionPerformed

    private void btncsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncsearchActionPerformed
        // Search Customers
       
        String search = c_search.getText();
        try {
        
            Statement s = db.mycon().createStatement();
            
            ResultSet rs = s.executeQuery("SELECT * FROM customer WHERE Cid = '"+search+"'");
            
            if (rs.next()){
            
                c_name.setText(rs.getString("Customer_name"));
                c_tp.setText(rs.getString("Tp_Number"));
                
            }
        } catch(SQLException e){
                System.out.println("e");
        }
        
        table_load();
        
    }//GEN-LAST:event_btncsearchActionPerformed

    private void btncupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncupdateActionPerformed
        // Customer Update
        
        String name = c_name.getText();
        String tp = c_tp.getText();
        String id = c_search.getText();
        
        try{
        
            Statement s = db.mycon().createStatement();
            s.executeUpdate("UPDATE customer SET Customer_name='"+name+"', Tp_Number = '"+tp+"' WHERE cid = '"+id+"'");
                JOptionPane.showMessageDialog(null, "Customer Data Updated");
        
        }catch (SQLException e){
                System.out.println("e");
        }
        
        table_load();
    }//GEN-LAST:event_btncupdateActionPerformed

    private void btncdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncdeleteActionPerformed
        // Customer Delete
        
        String id = c_search.getText();
        
        
        try{
        
            Statement s = db.mycon().createStatement();
            s.executeUpdate("DELETE  FROM customer WHERE Cid ='"+id+"'");
                JOptionPane.showMessageDialog(null, "Customer Data Deleted");
        
        }catch (SQLException e){
                System.out.println("e");
        }
        
        table_load();
        
    }//GEN-LAST:event_btncdeleteActionPerformed

    private void c_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_tableMouseClicked
        // Mouse click get data to textfeild
        
        int r = c_table.getSelectedRow();
        
        String id = c_table.getValueAt(r, 0).toString();
        String name = c_table.getValueAt(r,1).toString(); 
        String tp = c_table.getValueAt(r,2).toString(); 
        
        c_search.setText(id);
        c_name.setText(name);
        c_tp.setText(tp);
        
        
    }//GEN-LAST:event_c_tableMouseClicked

    private void c_search_tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c_search_tableKeyReleased
        // Search customer table with customer name
        
        String name = c_search_table.getText();
        
        try{
        
               DefaultTableModel dt = (DefaultTableModel) c_table.getModel();
               dt.setRowCount(0);
               Statement s = db.mycon().createStatement();
               
               ResultSet rs = s.executeQuery("SELECT * FROM customer WHERE Customer_name LIKE '%"+name+"%' ");
               
               while (rs.next()){
               
                   Vector v = new Vector();
                   
                   v.add(rs.getString(1));
                   v.add(rs.getString(2));
                   v.add(rs.getString(3));
                   
                   dt.addRow(v);
                   
                   
               }
        
        }catch (Exception e){
            
            table_load();
        }
    }//GEN-LAST:event_c_search_tableKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncdelete;
    private javax.swing.JButton btncsave;
    private javax.swing.JButton btncsearch;
    private javax.swing.JButton btncupdate;
    private javax.swing.JTextField c_name;
    private javax.swing.JTextField c_search;
    private javax.swing.JTextField c_search_table;
    private javax.swing.JTable c_table;
    private javax.swing.JTextField c_tp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
