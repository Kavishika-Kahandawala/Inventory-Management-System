/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import Code.db;
import java.security.interfaces.RSAKey;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormatSymbols;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**
 *
 * @author Kavishika
 */
public class stock_out extends javax.swing.JPanel {

    /**
     * Creates new form sales_in
     */
    public stock_out() {
        initComponents();

        tgl_monthload();
        tb_load_stockin();
        sort_tgl();
        tgl_yearload();
        
        
    }

    public void tb_load_stockin() {

        try {

            DefaultTableModel dt = (DefaultTableModel) tbl_stockin.getModel();
            dt.setRowCount(0);

            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery(" SELECT * FROM stock_report WHERE status='stock-out'");

            while (rs.next()) {

                Vector v = new Vector();

                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5) + "-" + rs.getString(6) + "-" + rs.getString(7));
                v.add(rs.getString(8));

                dt.addRow(v);

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void sort_tgl() {
        if (tgl_sort.isSelected()) {
            tgl_year.setEnabled(true);
            tgl_month.setEnabled(false);
            tgl_day.setEnabled(false);

        } else {
            tgl_day.setEnabled(false);
            tgl_month.setEnabled(false);
            tgl_year.setEnabled(false);
            combo_year.setEnabled(false);
            combo_month.setEnabled(false);
            combo_day.setEnabled(false);
            tgl_year.setSelected(false);
            tb_load_stockin();
        }

    }

    public void tgl_yearload() {

        try {

            Statement syear = db.mycon().createStatement();
            ResultSet rsyear = syear.executeQuery(" SELECT distinct(year) FROM stock_report ");

            while (rsyear.next()) {
                combo_year.addItem(rsyear.getString("year"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void tgl_monthload() {
        String[] months = new DateFormatSymbols().getMonths();
        combo_month.setModel(new DefaultComboBoxModel(months));
    }

    public void tgl_dayload() {
        combo_day.removeAllItems();
        String comboyear = (String) combo_year.getSelectedItem();
        String combomonth = (String) combo_month.getSelectedItem();
        //String test=combomonth.toUpperCase();
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

        //Format f = new SimpleDateFormat("M");
        //String strMonth = f.format(new Date());
        //System.out.println("Month Number = " + combomonth);

        /*try{
            Date date = new SimpleDateFormat("MMMM", Locale.ENGLISH).parse(test);//put your month name in english here
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int monthNumber = cal.get(Calendar.MONTH);
            System.out.println(monthNumber);
            }catch(Exception e){
                System.out.println(e);
            }*/
        //int intcmonth = Integer.parseInt(combomonth);
        //Date date = new SimpleDateFormat("MMMM", Locale.ENGLISH).parse(combomonth);
        //Calendar cal = Calendar.getInstance();
        //cal.setTime(date);
        //System.out.println(cal.get(Calendar.MONTH));
        YearMonth yearMonthObject = YearMonth.of(intcyear, intmonth);
        Integer daysInMonth = yearMonthObject.lengthOfMonth();
        //System.out.println(daysInMonth);
        Integer cday = 1;
        while (cday < daysInMonth + 1) {
            //combo_year.addItem(rsyear.getString("year"));
            combo_day.addItem(cday.toString());
            cday = cday + 1;
        }

    }

    public void loadrows(String query) {
        try {

            query = query;
            DefaultTableModel dt = (DefaultTableModel) tbl_stockin.getModel();
            dt.setRowCount(0);

            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery(query);

            while (rs.next()) {

                Vector v = new Vector();

                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5) + "-" + rs.getString(6) + "-" + rs.getString(7));
                v.add(rs.getString(8));

                dt.addRow(v);

            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void sortyear() {
        String searchkey = txt_search.getText();
        String comboyear = (String) combo_year.getSelectedItem();
        String yearquery = "SELECT * FROM stock_report WHERE year = '" + comboyear + "' AND status='stock-out' AND pname LIKE '%" + searchkey + "%'";
        loadrows(yearquery);

    }
    public void sortmonth() {
        String searchkey = txt_search.getText();
        String comboyear = (String) combo_year.getSelectedItem();
        String combomonth = (String) combo_month.getSelectedItem();
        //String upper_month = combomonth.toUpperCase();
        String yearquery = "SELECT * FROM stock_report WHERE year = '" + comboyear + "' AND month= '" +combomonth+ "' AND status='stock-out' AND pname LIKE '%" + searchkey + "%'";
        loadrows(yearquery);

    }
    public void sortday() {
        String searchkey = txt_search.getText();
        String comboyear = (String) combo_year.getSelectedItem();
        String combomonth = (String) combo_month.getSelectedItem();
        //String upper_month = combomonth.toUpperCase();
        String comboday = (String) combo_day.getSelectedItem();
        String yearquery = "SELECT * FROM stock_report WHERE year = '" + comboyear + "' AND month= '" +combomonth+ "' AND day='" +comboday+ "' AND status='stock-out' AND pname LIKE '%" + searchkey + "%'";
        loadrows(yearquery);

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
        jPanel3 = new javax.swing.JPanel();
        lbl_sname1 = new javax.swing.JLabel();
        tgl_sort = new javax.swing.JToggleButton();
        tgl_day = new javax.swing.JToggleButton();
        tgl_month = new javax.swing.JToggleButton();
        tgl_year = new javax.swing.JToggleButton();
        combo_day = new javax.swing.JComboBox<>();
        combo_month = new javax.swing.JComboBox<>();
        combo_year = new javax.swing.JComboBox<>();
        btn_edit1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_stockin = new javax.swing.JTable();
        txt_search = new javax.swing.JTextField();
        lbl_pname = new javax.swing.JLabel();

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setPreferredSize(new java.awt.Dimension(389, 404));

        lbl_sname1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbl_sname1.setText("Sort");

        tgl_sort.setText("Sort By");
        tgl_sort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tgl_sortActionPerformed(evt);
            }
        });

        tgl_day.setText("Day");
        tgl_day.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tgl_dayActionPerformed(evt);
            }
        });

        tgl_month.setText("Month");
        tgl_month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tgl_monthActionPerformed(evt);
            }
        });

        tgl_year.setText("Year");
        tgl_year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tgl_yearActionPerformed(evt);
            }
        });

        combo_day.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_dayItemStateChanged(evt);
            }
        });
        combo_day.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_dayActionPerformed(evt);
            }
        });

        combo_month.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_monthItemStateChanged(evt);
            }
        });
        combo_month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_monthActionPerformed(evt);
            }
        });

        combo_year.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_yearItemStateChanged(evt);
            }
        });
        combo_year.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                combo_yearMouseClicked(evt);
            }
        });
        combo_year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_yearActionPerformed(evt);
            }
        });

        btn_edit1.setText("Export PDF");
        btn_edit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tgl_year))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tgl_month)
                            .addComponent(combo_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(tgl_day)
                                .addGap(0, 949, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(combo_day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_edit1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_sname1)
                            .addComponent(tgl_sort))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_sname1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tgl_sort)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tgl_year)
                    .addComponent(tgl_month)
                    .addComponent(tgl_day))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_edit1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        tbl_stockin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STID", "PID", "Product Name", "Quantitiy", "Date", "Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_stockin);

        txt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchActionPerformed(evt);
            }
        });
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_searchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });

        lbl_pname.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbl_pname.setText("Product Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_pname)
                        .addGap(18, 18, 18)
                        .addComponent(txt_search))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1268, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1268, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_pname)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        // TODO add your handling code here:
        try {

            DefaultTableModel dt = (DefaultTableModel) tbl_stockin.getModel();
            dt.setRowCount(0);
            String searchkey = txt_search.getText();
            
            String searchquery = "";
            
                if (tgl_year.isSelected()&&(!tgl_month.isSelected())&&(!tgl_day.isSelected())) {
                    String selectedyear = (String) combo_year.getSelectedItem();
                    searchquery = "SELECT * FROM stock_report WHERE pname LIKE '%" + searchkey + "%' AND year='" + selectedyear + "' AND status='stock-out'";
            loadrows(searchquery);
                    
                }

                if ((tgl_month.isSelected()) && (tgl_year.isSelected())&&(!tgl_day.isSelected())) {
                    String selectedyear = (String) combo_year.getSelectedItem();
                    String selectedmonth = (String) combo_month.getSelectedItem();
                    searchquery = "SELECT * FROM stock_report WHERE pname LIKE '%" + searchkey + "%' AND year='" + selectedyear + "' AND month='" + selectedmonth + "' AND status='stock-out'";
            loadrows(searchquery);
                }

                if ((tgl_month.isSelected()) && (tgl_year.isSelected()) && (tgl_day.isSelected())) {
                    String selectedyear = (String) combo_year.getSelectedItem();
                    String selectedmonth = (String) combo_month.getSelectedItem();
                    String selectedday = (String) combo_day.getSelectedItem();
                    searchquery = "SELECT * FROM stock_report WHERE pname LIKE '%" + searchkey + "%' AND year='" + selectedyear + "' AND"
                            + " month='" + selectedmonth + "' AND day='" + selectedday + "' AND status='stock-out'";
            loadrows(searchquery);

                

            }
            if ((!tgl_month.isSelected()) && (!tgl_year.isSelected()) && (!tgl_day.isSelected())) {
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM stock_report WHERE pname LIKE '%" + searchkey + "%' AND status='stock-out'");

            
            
            while (rs.next()) {

                Vector v = new Vector();

                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5) + "-" + rs.getString(6) + "-" + rs.getString(7));
                v.add(rs.getString(8));

                dt.addRow(v);

            }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_txt_searchKeyReleased

    private void txt_searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchKeyPressed

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchActionPerformed

    private void tgl_yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tgl_yearActionPerformed
        // TODO add your handling code here:
        if (tgl_year.isSelected()) {
            combo_year.setEnabled(true);
            tgl_month.setEnabled(true);
            tgl_dayload();
            sortyear();
        } else {
            combo_year.setEnabled(false);
            combo_month.setEnabled(false);
            combo_day.setEnabled(false);
            tgl_month.setEnabled(false);
            tgl_day.setEnabled(false);
            tgl_day.setSelected(false);
            tgl_month.setSelected(false);
            tb_load_stockin();

        }
    }//GEN-LAST:event_tgl_yearActionPerformed

    private void tgl_monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tgl_monthActionPerformed
        // TODO add your handling code here:
        if (tgl_year.isSelected() && tgl_month.isSelected()) {
            combo_month.setEnabled(true);
            tgl_dayload();
            tgl_month.setEnabled(true);
            tgl_day.setEnabled(true);
            sortmonth();
        } else {
            combo_month.setEnabled(false);
            combo_day.setEnabled(false);
            tgl_day.setEnabled(false);
            tgl_day.setSelected(false);
            if (tgl_year.isEnabled()) {
                sortyear(); 
            }
        }
    }//GEN-LAST:event_tgl_monthActionPerformed

    private void tgl_dayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tgl_dayActionPerformed
        // TODO add your handling code here:
        if (tgl_year.isSelected() && tgl_month.isSelected() && tgl_day.isSelected()) {
            combo_day.setEnabled(true);
            sortday();
            tgl_month.setEnabled(true);
            tgl_day.setEnabled(true);

        } else {
            combo_day.setEnabled(false);
            if (tgl_month.isEnabled()){
                sortmonth();
            }else{
                tb_load_stockin();
            }
        }


    }//GEN-LAST:event_tgl_dayActionPerformed

    private void tgl_sortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tgl_sortActionPerformed
        // TODO add your handling code here:
        sort_tgl();
    }//GEN-LAST:event_tgl_sortActionPerformed

    private void combo_yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_yearActionPerformed
        // TODO add your handling code here:
        boolean checkyear = tgl_year.isEnabled();
        if (checkyear) {
            sortyear();
        } else {
            tb_load_stockin();
        }

    }//GEN-LAST:event_combo_yearActionPerformed

    private void combo_yearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_combo_yearMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_combo_yearMouseClicked

    private void combo_yearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_yearItemStateChanged
        // TODO add your handling code here:
        /*String comboyear = (String) combo_year.getSelectedItem();
        String yearquery = "SELECT * FROM stock_report WHERE year = '" + comboyear + "' AND status='stock-out'";
        tgl_dayload();*/
    }//GEN-LAST:event_combo_yearItemStateChanged

    private void combo_monthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_monthItemStateChanged
        // TODO add your handling code here:
        tgl_dayload();
    }//GEN-LAST:event_combo_monthItemStateChanged

    private void combo_dayItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_dayItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_combo_dayItemStateChanged

    private void combo_monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_monthActionPerformed
        // TODO add your handling code here:
        boolean checkmonth = tgl_month.isEnabled();
        if (checkmonth) {
            sortmonth();
        } else {
            tb_load_stockin();
        }
    }//GEN-LAST:event_combo_monthActionPerformed

    private void combo_dayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_dayActionPerformed
        // TODO add your handling code here:
        boolean checkday = tgl_day.isEnabled();
        if (checkday) {
            sortday();
        } else {
            tb_load_stockin();
        }
    }//GEN-LAST:event_combo_dayActionPerformed

    private void btn_edit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit1ActionPerformed
        // TODO add your handling code here:

        String path = "";
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = j.showSaveDialog(this);
        if (x == JFileChooser.APPROVE_OPTION) {
            path = j.getSelectedFile().getPath();

        }
        Document doc = new Document();
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + "Stock-out.pdf"));
            doc.open();
            PdfPTable tbl = new PdfPTable(6);
            tbl.addCell("STID");
            tbl.addCell("PID");
            tbl.addCell("Product Name");
            tbl.addCell("Quantity");
            tbl.addCell("Date");
            tbl.addCell("Time");

            for (int i = 0; i < tbl_stockin.getRowCount(); i++) {
                String d1 = tbl_stockin.getValueAt(i, 0).toString();
                String d2 = tbl_stockin.getValueAt(i, 1).toString();
                String d3 = tbl_stockin.getValueAt(i, 2).toString();
                String d4 = tbl_stockin.getValueAt(i, 3).toString();
                String d5 = tbl_stockin.getValueAt(i, 4).toString();
                String d6 = tbl_stockin.getValueAt(i, 5).toString();

                tbl.addCell(d1);
                tbl.addCell(d2);
                tbl.addCell(d3);
                tbl.addCell(d4);
                tbl.addCell(d5);
                tbl.addCell(d6);
            }
            doc.add(tbl);
            JOptionPane.showMessageDialog(null, "PDF Generated");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something went wrong");
        }
        doc.close();
    }//GEN-LAST:event_btn_edit1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_edit1;
    private javax.swing.JComboBox<String> combo_day;
    private javax.swing.JComboBox<String> combo_month;
    private javax.swing.JComboBox<String> combo_year;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_pname;
    private javax.swing.JLabel lbl_sname1;
    private javax.swing.JTable tbl_stockin;
    private javax.swing.JToggleButton tgl_day;
    private javax.swing.JToggleButton tgl_month;
    private javax.swing.JToggleButton tgl_sort;
    private javax.swing.JToggleButton tgl_year;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
