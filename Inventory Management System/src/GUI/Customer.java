package GUI;

import Code.db;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
            v.add(rs.getString(4));
            v.add(rs.getString(5));
            
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
        c_fname = new javax.swing.JTextField();
        c_lname = new javax.swing.JTextField();
        btncsave = new javax.swing.JButton();
        btncupdate = new javax.swing.JButton();
        btncdelete = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        c_tp = new javax.swing.JTextField();
        c_email = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tperror = new javax.swing.JLabel();
        emailerror = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        c_table = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        c_search = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btncsearch = new javax.swing.JButton();
        c_search_table = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("First Name:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Last Name:");

        c_fname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        c_fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_fnameActionPerformed(evt);
            }
        });

        c_lname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        btncsave.setBackground(new java.awt.Color(51, 51, 51));
        btncsave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btncsave.setForeground(new java.awt.Color(255, 255, 255));
        btncsave.setText("Save");
        btncsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncsaveActionPerformed(evt);
            }
        });

        btncupdate.setBackground(new java.awt.Color(51, 51, 51));
        btncupdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btncupdate.setForeground(new java.awt.Color(255, 255, 255));
        btncupdate.setText("Update");
        btncupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncupdateActionPerformed(evt);
            }
        });

        btncdelete.setBackground(new java.awt.Color(225, 77, 42));
        btncdelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btncdelete.setForeground(new java.awt.Color(255, 255, 255));
        btncdelete.setText("Delete");
        btncdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncdeleteActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("T.P.Number:");

        c_tp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        c_tp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                c_tpKeyReleased(evt);
            }
        });

        c_email.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        c_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                c_emailKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Email:");

        tperror.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        tperror.setForeground(new java.awt.Color(255, 0, 0));

        emailerror.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        emailerror.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailerror, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tperror, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(c_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(c_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(c_tp, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(c_email, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(btncsave, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addComponent(btncdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btncupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)))))
                        .addGap(0, 25, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(c_lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(c_tp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tperror, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(c_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(emailerror, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btncsave, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(btncupdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addComponent(btncdelete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        c_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "First Name", "Last Name", "TP Number", "Email"
            }
        ));
        c_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(c_table);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Customers Info");

        c_search.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        c_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_searchActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Search ID :");

        btncsearch.setBackground(new java.awt.Color(51, 51, 51));
        btncsearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btncsearch.setForeground(new java.awt.Color(255, 255, 255));
        btncsearch.setText("Search");
        btncsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncsearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(c_search, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(jLabel3)))
                        .addGap(0, 26, Short.MAX_VALUE))
                    .addComponent(btncsearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(c_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btncsearch)
                .addContainerGap())
        );

        c_search_table.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        c_search_table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                c_search_tableKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Search First Name:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_search_table, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(254, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(c_search_table, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btncsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncsaveActionPerformed
        // TODO add your handling code here:
        
        String fname = c_fname.getText();
        String lname = c_lname.getText();
        String tp = c_tp.getText();
        String email = c_email.getText();
        
        try {
        
            Statement s = db.mycon().createStatement();
            
            if(c_fname.equals("") ||c_lname.equals("") || c_tp.equals("") || c_email.equals("") ){
                    JOptionPane.showMessageDialog(null, "Fill every feild");
                }
            else{
            s.executeUpdate("INSERT INTO customer (Customer_FirstName,Customer_LastName,Customer_TP,Customer_Email) VALUES ('"+fname+"','"+lname+"','"+tp+"','"+email+"')");
                JOptionPane.showMessageDialog(null, "Customer Data Saved");
            
            }
            
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
            
                c_fname.setText(rs.getString("Customer_FirstName"));
                c_lname.setText(rs.getString("Customer_LastName"));
                c_tp.setText(rs.getString("Customer_TP"));
                c_email.setText(rs.getString("Customer_Email"));
                
            }
        } catch(SQLException e){
                System.out.println("e");
        }
        
        table_load();
        
    }//GEN-LAST:event_btncsearchActionPerformed

    private void btncupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncupdateActionPerformed
        // Customer Update
        
        String fname = c_fname.getText();
        String lname = c_lname.getText();
        String tp = c_tp.getText();
        String email = c_email.getText();
        String id = c_search.getText();
        
        try{
        
            Statement s = db.mycon().createStatement();
            s.executeUpdate("UPDATE customer SET Customer_FirstName='"+fname+"', Customer_LastName = '"+lname+"',Customer_TP = '"+tp+"',Customer_Email = '"+email+"' WHERE cid = '"+id+"'");
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
        String fname = c_table.getValueAt(r,1).toString(); 
        String lname = c_table.getValueAt(r,2).toString(); 
        String tp = c_table.getValueAt(r,2).toString();
        String email = c_table.getValueAt(r,2).toString();
        
        c_search.setText(id);
        c_fname.setText(fname);
        c_lname.setText(lname);
        c_tp.setText(tp);
        c_email.setText(email);
        
        
    }//GEN-LAST:event_c_tableMouseClicked

    private void c_search_tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c_search_tableKeyReleased
        // Search customer table with customer name
        
        String name = c_search_table.getText();
        
        try{
        
               DefaultTableModel dt = (DefaultTableModel) c_table.getModel();
               dt.setRowCount(0);
               Statement s = db.mycon().createStatement();
               
               ResultSet rs = s.executeQuery("SELECT * FROM customer WHERE Customer_FirstName LIKE '%"+name+"%' ");
               
               while (rs.next()){
               
                   Vector v = new Vector();
                   
                   v.add(rs.getString(1));
                   v.add(rs.getString(2));
                   v.add(rs.getString(3));
                   v.add(rs.getString(4));
                   v.add(rs.getString(5));
                   
                   dt.addRow(v);
                   
                   
               }
        
        }catch (Exception e){
            
            table_load();
        }
    }//GEN-LAST:event_c_search_tableKeyReleased

    private void c_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_searchActionPerformed

    private void c_emailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c_emailKeyReleased
        // Validate Email address
        
        String PATTERN =  "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
        Pattern patt = Pattern.compile(PATTERN);
        Matcher match = patt.matcher(c_email.getText());
            if(!match.matches()){
                emailerror.setText("Invalid Email");
            }
            else{
                emailerror.setText(null);
            }
        
        
    }//GEN-LAST:event_c_emailKeyReleased

    private void c_tpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c_tpKeyReleased
        // Validate TP number
       
       
          
    }//GEN-LAST:event_c_tpKeyReleased

    private void c_fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_fnameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncdelete;
    private javax.swing.JButton btncsave;
    private javax.swing.JButton btncsearch;
    private javax.swing.JButton btncupdate;
    private javax.swing.JTextField c_email;
    private javax.swing.JTextField c_fname;
    private javax.swing.JTextField c_lname;
    private javax.swing.JTextField c_search;
    private javax.swing.JTextField c_search_table;
    private javax.swing.JTable c_table;
    private javax.swing.JTextField c_tp;
    private javax.swing.JLabel emailerror;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel tperror;
    // End of variables declaration//GEN-END:variables
}
