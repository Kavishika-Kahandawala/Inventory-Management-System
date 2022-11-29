package GUI;

import Code.db;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class employee extends javax.swing.JPanel {

    

    public employee() {

        initComponents();
        table_load();
        //getMonthYear();
        e_id.setEnabled(false);
    }

    public void table_load() {

        try {

            DefaultTableModel dt = (DefaultTableModel) e_table.getModel();
            dt.setRowCount(0);

            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery(" SELECT * FROM employee ");

            while (rs.next()) {

                Vector v = new Vector();

                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getString(7));

                dt.addRow(v);

            }

        } catch (SQLException e) {
            System.out.println("e");

        }

    }

    /*public void getMonthYear() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date parse = sdf.parse(Dashboard.date.getText());
        Calendar c = Calendar.getInstance();
        c.setTime(parse);
        month = (c.get(Calendar.MONTH));
        year = (c.get(Calendar.YEAR));

    }*/
    public String getmonth() {
        String[] months = new DateFormatSymbols().getMonths();
        Calendar cal = Calendar.getInstance();
        String month = months[cal.get(Calendar.MONTH)];

        return month;
    }

    public int getday() {
        LocalDate currentdate = LocalDate.now();
        int currentDay = currentdate.getDayOfMonth();

        return currentDay;
    }

    public int getyear() {
        LocalDate currentdate = LocalDate.now();
        int currentYear = currentdate.getYear();

        return currentYear;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        sname = new javax.swing.JLabel();
        e_name = new javax.swing.JTextField();
        btncsave = new javax.swing.JButton();
        btncupdate = new javax.swing.JButton();
        btncdelete = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        e_tp = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnclear = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        e_email = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_pass = new javax.swing.JTextField();
        combo_role = new javax.swing.JComboBox<>();
        sname1 = new javax.swing.JLabel();
        e_id = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        e_table = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        sname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sname.setText("Name:");

        e_name.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        e_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_nameActionPerformed(evt);
            }
        });

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

        e_tp.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        e_tp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                e_tpKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Role:");

        btnclear.setBackground(new java.awt.Color(51, 51, 51));
        btnclear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnclear.setForeground(new java.awt.Color(255, 255, 255));
        btnclear.setText("Clear");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Email:");

        e_email.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        e_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                e_emailKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Username:");

        txt_username.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_usernameKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Password:");

        txt_pass.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_passKeyReleased(evt);
            }
        });

        combo_role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "cashier", "manger", "admin" }));

        sname1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sname1.setText("ID:");

        e_id.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        e_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                e_idActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btncupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btncdelete, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btncsave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(combo_role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(e_email, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(sname1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e_id, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(sname)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e_name, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(43, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e_tp, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btnclear, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(e_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sname1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(e_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sname))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(e_tp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(e_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(147, 147, 147)
                .addComponent(btnclear)
                .addGap(39, 39, 39)
                .addComponent(btncsave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncdelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btncupdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42))
        );

        e_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "T.P Number", "Email", "Username", "Password", "Role"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        e_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                e_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(e_table);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Employee Management");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(65, 65, 65))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 905, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
        // employee Data save

        //String id = e_id.getText();
        String name = e_name.getText();
        String tp = e_tp.getText();
        String email = e_email.getText();
        String username = txt_username.getText();
        String password = txt_pass.getText();
        String role = (String) combo_role.getSelectedItem();

        try {

            Statement s = db.mycon().createStatement();

            /*if (e_name.getText().equals("") || e_tp.getText().equals("") || e_role.getText().equals("") || e_email.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill Every Feild");
            } else {*/
            s.executeUpdate("INSERT INTO employee (Employee_name,Employee_tp,Employee_email,username,password,Employee_Role) "
                    + "VALUES ('" + name + "','" + tp + "','" + email + "','" + username + "','" + password + "','" + role + "' )");
            JOptionPane.showMessageDialog(null, "employee Data Saved");

            //}
        } catch (SQLException e) {
            System.out.println("e");

        }

        table_load();

    }//GEN-LAST:event_btncsaveActionPerformed

    private void btncupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncupdateActionPerformed
        // employee Update

        String id = e_id.getText();
        String name = e_name.getText();
        String tp = e_tp.getText();
        String email = e_email.getText();
        String username = txt_username.getText();
        String password = txt_pass.getText();
        String role = (String) combo_role.getSelectedItem();
        //String id = e_search.getText();

        try {

            Statement s = db.mycon().createStatement();
            /*if (e_name.getText().equals("") || e_tp.getText().equals("") || e_role.getText().equals("") || e_email.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill Every Feild");
            } else {*/
            s.executeUpdate("UPDATE employee SET Employee_name='" + name + "', Employee_tp = '" + tp + "',Employee_email = '" + email + "' "
                    + ",username = '" + username + "' ,password = '" + password + "', Employee_Role = '" + role + "' WHERE Employee_id = '" + id + "' ");
            JOptionPane.showMessageDialog(null, "employee Data Updated");
            //}

        } catch (SQLException e) {
            System.out.println();
        }

        table_load();
    }//GEN-LAST:event_btncupdateActionPerformed

    private void btncdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncdeleteActionPerformed
        // employee Delete

        String id = e_id.getText();

        try {

            Statement s = db.mycon().createStatement();

            /*if (e_search.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill Every Feild");
            } else {*/
            s.executeUpdate("DELETE  FROM employee WHERE Employee_id ='" + id + "'");
            JOptionPane.showMessageDialog(null, "employee Data Deleted");

            //}
        } catch (SQLException e) {
            System.out.println("e");
        }

        table_load();

    }//GEN-LAST:event_btncdeleteActionPerformed

    private void e_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_e_tableMouseClicked
        // Mouse click get data to textfeild

        int r = e_table.getSelectedRow();

        String id = e_table.getValueAt(r, 0).toString();
        String name = e_table.getValueAt(r, 1).toString();
        String tp = e_table.getValueAt(r, 2).toString();
        String email = e_table.getValueAt(r, 3).toString();
        String username = e_table.getValueAt(r, 4).toString();
        String password = e_table.getValueAt(r, 5).toString();
        String role = e_table.getValueAt(r, 6).toString();

        // s_search.setText(id);
        e_id.setText(id);
        e_name.setText(name);
        e_tp.setText(tp);
        e_email.setText(email);
        txt_username.setText(username);
        txt_pass.setText(password);
        combo_role.setSelectedItem(role);


    }//GEN-LAST:event_e_tableMouseClicked

    private void e_tpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_e_tpKeyReleased
        // Validate TP number


    }//GEN-LAST:event_e_tpKeyReleased

    private void e_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_nameActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        // Clear Text feilds:

        e_id.setText("");
        e_name.setText("");
        e_tp.setText("");
        e_email.setText("");
        txt_username.setText("");
        txt_pass.setText("");
        combo_role.setSelectedItem("cashier");

    }//GEN-LAST:event_btnclearActionPerformed

    private void e_emailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_e_emailKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_e_emailKeyReleased

    private void txt_usernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usernameKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameKeyReleased

    private void txt_passKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passKeyReleased

    private void e_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_e_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_e_idActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncdelete;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btncsave;
    private javax.swing.JButton btncupdate;
    private javax.swing.JComboBox<String> combo_role;
    private javax.swing.JTextField e_email;
    private javax.swing.JTextField e_id;
    private javax.swing.JTextField e_name;
    private javax.swing.JTable e_table;
    private javax.swing.JTextField e_tp;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel sname;
    private javax.swing.JLabel sname1;
    private javax.swing.JTextField txt_pass;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
