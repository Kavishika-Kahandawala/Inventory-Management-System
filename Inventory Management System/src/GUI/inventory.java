/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import GUI.inventory_full;
import Code.JpanelLoader;
import Code.db;
import Code.inv_editController;
import Code.inv_editModel;
import com.mysql.cj.util.SearchMode;
import java.awt.HeadlessException;
import java.awt.TextArea;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormatSymbols;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Vector;
import javax.print.attribute.standard.Sides;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
 *
 */
public class inventory extends javax.swing.JPanel {

    /**
     * Creates new form inventory
     */
    inv_editModel objeditmodel;
    inv_editController objeditcontroller;
    JpanelLoader jpload = new JpanelLoader();

    public inventory() {
        initComponents();
        objeditcontroller = new inv_editController();
        //txt_pid.setEnabled(false);
        tb_load();
        i_hload();
        panel_stock.setVisible(false);
        btn_addstock.setEnabled(false);
        btn_delete.setVisible(false);
        btn_edit.setEnabled(false);
        /*txt_newstk.setVisible(false);
        txt_newstk.revalidate();
        txt_newstk.repaint();*/
        //disablefields();

    }

    int tblselectedpid;
    double tblselectedqty;
    String tblselectedpname = "";
    String tblselectedstatus = "";

    public void tb_load() {
        i_hload();

        try {

            DefaultTableModel dt = (DefaultTableModel) table_inventory.getModel();
            dt.setRowCount(0);

            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery(" SELECT * FROM inventory");

            while (rs.next()) {

                Vector v = new Vector();

                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
                if (rs.getString(8).equals("1")) {
                    v.add("Active");
                } else {
                    v.add("Not Active");
                }

                dt.addRow(v);

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void tb_load_custom(String search) {

        try {

            DefaultTableModel dt = (DefaultTableModel) table_inventory.getModel();
            dt.setRowCount(0);
            search = search;

            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM inventory WHERE pname LIKE '%" + search + "%'");

            while (rs.next()) {

                Vector v = new Vector();

                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
                if (rs.getString(8).equals("1")) {
                    v.add("Active");
                } else {
                    v.add("Not Active");
                }

                dt.addRow(v);

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void i_hload() {
        table_inventory.getColumnModel().getColumn(0).setHeaderValue("PID");
        table_inventory.getColumnModel().getColumn(1).setHeaderValue("Product Name");
        table_inventory.getColumnModel().getColumn(2).setHeaderValue("Barcode");
        table_inventory.getColumnModel().getColumn(3).setHeaderValue("Cost Price");
        table_inventory.getColumnModel().getColumn(4).setHeaderValue("Selling Price");
        table_inventory.getColumnModel().getColumn(5).setHeaderValue("Quantity");
        table_inventory.getColumnModel().getColumn(6).setHeaderValue("Supplier Name");
        table_inventory.getColumnModel().getColumn(7).setHeaderValue("Status");
        table_inventory.getTableHeader().repaint();
        //System.out.println("i load");
    }

    public void s_hload() {
        table_inventory.getColumnModel().getColumn(0).setHeaderValue("SID");
        table_inventory.getColumnModel().getColumn(1).setHeaderValue("Supplier Name");
        table_inventory.getColumnModel().getColumn(2).setHeaderValue("tp_Number");
        table_inventory.getColumnModel().getColumn(3).setHeaderValue("Company");
        table_inventory.getColumnModel().getColumn(4).setHeaderValue("Supplier Email");
        table_inventory.getColumnModel().getColumn(5).setHeaderValue("");
        table_inventory.getColumnModel().getColumn(6).setHeaderValue("");
        table_inventory.getColumnModel().getColumn(7).setHeaderValue("");
        table_inventory.getTableHeader().repaint();
        //System.out.println("sssss load");
    }

    public void stb_load() {

        try {

            DefaultTableModel dt = (DefaultTableModel) table_inventory.getModel();
            dt.setRowCount(0);

            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery(" SELECT * FROM supplier");

            while (rs.next()) {

                Vector v = new Vector();

                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));

                dt.addRow(v);

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public int warnnumber(String num) {
        try {
            Double.parseDouble(num);
            System.out.println("is a number");
            return 0;
        } catch (NumberFormatException e) {
            return 1;
        }
    }

    public int warnempty(String text) {
        if (text.equals("")) {
            return 1;
        } else {
            return 0;
        }
    }

    int w_pname = 1;
    int w_bcode = 1;
    int w_cprice = 1;
    int w_sprice = 1;
    int w_quantity = 1;
    int w_sname = 1;

    /*public void checkallwarnings() {
        if ((w_pname == 0) && (w_bcode == 0) && (w_cprice == 0) && (w_sprice == 0) && (w_quantity == 0) && (w_sname == 0)) {
            btn_save.setEnabled(true);
            warn_all.setText("");
            /*if ((warn_barcode.getText().equals(" ")) || (warn_cprice.getText().equals(" ")) || (warn_cprice.getText().equals(" ")) || (warn_pname.getText().equals(" "))
                || (warn_quantity.getText().equals(" "))||(warn_sname.getText().equals(" "))||(warn_sprice.getText().equals(" ")) ) {
            btn_save.setEnabled(true);*/
 /*
        } else {
            btn_save.setEnabled(false);
            warn_all.setText("Please fill every field without errors");
        }
    } */

 /*public void editpro() {
        //Edit Product
        int pid = Integer.parseInt(txt_pid.getText());
        String pname = txt_pname.getText();
        String barcode = txt_bcode.getText();
        double cprice = Double.parseDouble(txt_cprice.getText());
        double sprice = Double.parseDouble(txt_sprice.getText());
        double quantity = Double.parseDouble(txt_quantity.getText());
        String sname = txt_sname.getText();
        //int sid = Integer.parseInt(txt_sname.getText());
        String status = "";
        if (chk_active.isSelected()) {
            status = "1";
        } else {
            status = "0";
        }

        try {
            Statement st = db.mycon().createStatement();
            st.executeUpdate("UPDATE inventory SET pname='" + pname + "',barcode='" + barcode + "'"
                    + ",cprice='" + cprice + "',sprice='" + sprice + "',quantity='" + quantity + "',sname='" + sname + "',status='" + status + "' WHERE pid='" + pid + "'");
            JOptionPane.showMessageDialog(null, "Product data updated");
        } catch (Exception e) {
        }
        tb_load();
    }*/

 /*public void addpro() {
        //Add Product
        //int pid = Integer.parseInt(txt_pid.getText());
        String pname = txt_pname.getText();
        String barcode = txt_bcode.getText();
        double cprice = Double.parseDouble(txt_cprice.getText());
        double sprice = Double.parseDouble(txt_sprice.getText());
        double quantity = Double.parseDouble(txt_quantity.getText());
        String sname = txt_sname.getText();
        String status = "";
        if (chk_active.isSelected()) {
            status = "1";
        } else {
            status = "0";
        }

        try {
            Statement insert_pd = db.mycon().createStatement();
            insert_pd.executeUpdate("INSERT INTO inventory(pname, barcode, cprice, sprice, quantity, sname, status) VALUES "
                    + "('" + pname + "','" + barcode + "','" + cprice + "','" + sprice + "','" + quantity + "','" + sname + "','" + status + "')");

            //insert_pd.executeUpdate( "INSERT INTO test(pname, barcode, cprice, sprice, quantity, sid, status ) VALUES "
            //+ "('"+pname+"','"+barcode+"','"+cprice+"','"+sprice+"','"+quantity+"','"+sid+"','"+status+"')");
            JOptionPane.showMessageDialog(null, "Product has been saved successfully");
        } catch (SQLException e) {
            System.out.println(e);
        }

        tb_load();
    }*/

 /* public void clear() {
        txt_pname.setText("");
        txt_pid.setText("");
        txt_bcode.setText("");
        txt_cprice.setText("");
        txt_sprice.setText("");
        txt_quantity.setText("");
        txt_sname.setText("");
        chk_active.setSelected(false);

        tb_load();
    }*/

 /* public void disablefields() {
        txt_bcode.setEnabled(false);
        txt_cprice.setEnabled(false);
        txt_sprice.setEnabled(false);
        txt_pname.setEnabled(false);
        txt_quantity.setEnabled(false);
        txt_sname.setEnabled(false);
        btn_save.setEnabled(false);
    }*/

 /*public void enablefields() {
        txt_bcode.setEnabled(true);
        txt_cprice.setEnabled(true);
        txt_sprice.setEnabled(true);
        txt_pname.setEnabled(true);
        txt_quantity.setEnabled(true);
        txt_sname.setEnabled(true);

    }*/

 /*public String getsid(String sname){
        try {
            
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT sid FROM supplier WHERE supplier_Name = '" + sname + "'");
            String sid=null;
            sid =rs.getString("sid");
            System.out.println(sid);
            
            return sid;
            
            }

         catch (SQLException e) {
            System.out.println(e);
            return "no";
            
        }
        
        
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

    public String gettime() {
        LocalTime time = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String timenow = time.format(formatter);

        return timenow;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup_stk = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btn_delete = new javax.swing.JButton();
        btn_new = new javax.swing.JButton();
        txt_search = new javax.swing.JTextField();
        lbl_sname = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_inventory = new javax.swing.JTable();
        btn_edit = new javax.swing.JButton();
        btn_addstock = new javax.swing.JButton();
        panel_stock = new javax.swing.JPanel();
        txt_newstk = new javax.swing.JTextField();
        radio_addstock = new javax.swing.JRadioButton();
        btn_stkok = new javax.swing.JButton();
        radio_newstk = new javax.swing.JRadioButton();
        btn_cancel = new javax.swing.JButton();
        warn_stock = new javax.swing.JLabel();
        btn_edit1 = new javax.swing.JButton();

        jPanel1.setMaximumSize(new java.awt.Dimension(1280, 720));

        btn_delete.setBackground(new java.awt.Color(225, 77, 42));
        btn_delete.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_delete.setText("Activate");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_new.setText("Add Product");
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });

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

        lbl_sname.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbl_sname.setText("Product Name");

        table_inventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "PID", "Product Name", "Barcode", "Cost Price", "Selling Price", "Quantity", "Supplier Name", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_inventory.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                table_inventoryFocusLost(evt);
            }
        });
        table_inventory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_inventoryMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                table_inventoryMouseEntered(evt);
            }
        });
        table_inventory.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                table_inventoryKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(table_inventory);

        btn_edit.setText("Edit");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_addstock.setText("Add Stock");
        btn_addstock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addstockActionPerformed(evt);
            }
        });

        txt_newstk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_newstkKeyReleased(evt);
            }
        });

        buttonGroup_stk.add(radio_addstock);
        radio_addstock.setText("Add to stock");
        radio_addstock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_addstockActionPerformed(evt);
            }
        });

        btn_stkok.setText("OK");
        btn_stkok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_stkokActionPerformed(evt);
            }
        });

        buttonGroup_stk.add(radio_newstk);
        radio_newstk.setText("New value");
        radio_newstk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_newstkActionPerformed(evt);
            }
        });

        btn_cancel.setText("Cancel");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        warn_stock.setForeground(new java.awt.Color(255, 38, 38));
        warn_stock.setText(" ");

        javax.swing.GroupLayout panel_stockLayout = new javax.swing.GroupLayout(panel_stock);
        panel_stock.setLayout(panel_stockLayout);
        panel_stockLayout.setHorizontalGroup(
            panel_stockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_stockLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_stockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(warn_stock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_newstk)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_stockLayout.createSequentialGroup()
                        .addComponent(radio_addstock)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(radio_newstk)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(panel_stockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_stkok))
                .addGap(16, 16, 16))
        );
        panel_stockLayout.setVerticalGroup(
            panel_stockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_stockLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_stockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radio_addstock)
                    .addComponent(radio_newstk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_newstk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(warn_stock)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_stockLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_stkok)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cancel)
                .addGap(16, 16, 16))
        );

        btn_edit1.setText("Export PDF");
        btn_edit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_sname)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_search))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_edit1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btn_new, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(700, 700, 700)
                        .addComponent(btn_addstock, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panel_stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_new, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_addstock, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(panel_stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_sname))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_edit1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:

        //delete product
        if (!(table_inventory.getSelectionModel().isSelectionEmpty())) {
            //panel_stock.setVisible(true);
            //radio_addstock.setSelected(true);

            int pid = tblselectedpid;
            if (tblselectedstatus.equals("Active")) {

                try {
                    Statement st = db.mycon().createStatement();
                    st.executeUpdate("UPDATE inventory SET status='" + 0 + "' WHERE pid='" + pid + "'");
                    //JOptionPane.showMessageDialog(null, "Product has been disabled from inventory");
                } catch (Exception error) {
                    System.out.println(error);
                }
            } else {
                if (tblselectedstatus.equals("Not Active")) {

                    try {
                        Statement st = db.mycon().createStatement();
                        st.executeUpdate("UPDATE inventory SET status='" + 1 + "' WHERE pid='" + pid + "'");
                        //JOptionPane.showMessageDialog(null, "Product has been enabled from inventory");
                    } catch (Exception error) {
                        System.out.println(error);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a product to continue");
        }

        tb_load();
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void table_inventoryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table_inventoryKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_table_inventoryKeyPressed

    private void table_inventoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_inventoryMouseClicked
        // TODO add your handling code here:
        btn_delete.setVisible(true);
        btn_edit.setEnabled(true);
        int r = table_inventory.getSelectedRow();

        tblselectedpid = Integer.parseInt(table_inventory.getValueAt(r, 0).toString());
        tblselectedqty = Double.parseDouble(table_inventory.getValueAt(r, 5).toString());
        tblselectedpname = table_inventory.getValueAt(r, 1).toString();
        btn_addstock.setEnabled(true);
        txt_newstk.setText("");
        tblselectedstatus = table_inventory.getValueAt(r, 7).toString();
        if (tblselectedstatus.equals("Active")) {
            btn_delete.setText("De-activate");

        } else {
            btn_delete.setText("Activate");
        }

    }//GEN-LAST:event_table_inventoryMouseClicked

    private void txt_searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchKeyPressed

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        // TODO add your handling code here:
        try {

            DefaultTableModel dt = (DefaultTableModel) table_inventory.getModel();
            dt.setRowCount(0);
            String searchkey = txt_search.getText();

            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM inventory WHERE pname LIKE '%" + searchkey + "%'");

            while (rs.next()) {

                Vector v = new Vector();

                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                v.add(rs.getString(7));
                if (rs.getString(8).equals("1")) {
                    v.add("Active");
                } else {
                    v.add("Not Active");
                }

                dt.addRow(v);

            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_txt_searchKeyReleased

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        // TODO add your handling code here:
        if (!(table_inventory.getSelectionModel().isSelectionEmpty())) {
            objeditmodel = objeditcontroller.transferpid(tblselectedpid);

            inventory_edit inv_edit = new inventory_edit();
            jpload.jPanelLoader(jPanel1, inv_edit);

        } else {
            JOptionPane.showMessageDialog(null, "Please select a product to continue");
        }

        /*if ((table_inventory.isRowSelected(row_num))) {
            enablefields();
            btn_save.setEnabled(true);
        }*/

 /* int row_num = table_inventory.getSelectedRow();

        String pid = table_inventory.getValueAt(row_num, 0).toString();
        String pname = table_inventory.getValueAt(row_num, 1).toString();
        String barcode = table_inventory.getValueAt(row_num, 2).toString();
        String cprice = table_inventory.getValueAt(row_num, 3).toString();
        String sprice = table_inventory.getValueAt(row_num, 4).toString();
        String quantity = table_inventory.getValueAt(row_num, 5).toString();
        String sid = table_inventory.getValueAt(row_num, 6).toString();
        String status = table_inventory.getValueAt(row_num, 7).toString();

        txt_pname.setText(pname);
        txt_pid.setText(pid);
        txt_bcode.setText(barcode);
        txt_cprice.setText(cprice);
        txt_sprice.setText(sprice);
        txt_quantity.setText(quantity);
        txt_sname.setText(sid);
        if (status.equals("Active")) {
            chk_active.setSelected(true);
        } else {
            chk_active.setSelected(false);
        }*/

    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        // TODO add your handling code here:
        inventory_add inv_load = new inventory_add();
        jpload.jPanelLoader(jPanel1, inv_load);


    }//GEN-LAST:event_btn_newActionPerformed

    private void btn_addstockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addstockActionPerformed
        // TODO add your handling code here:
        if (!(table_inventory.getSelectionModel().isSelectionEmpty())) {
            panel_stock.setVisible(true);
            radio_addstock.setSelected(true);

        } else {
            JOptionPane.showMessageDialog(null, "Please select a product to continue");
        }

        /*txt_newstk.setVisible(true);
        inventory.this.revalidate();
        inventory.this.repaint();*/

    }//GEN-LAST:event_btn_addstockActionPerformed

    private void btn_stkokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_stkokActionPerformed
        // TODO add your handling code here:
        if (txt_newstk.getText().equals("")) {
            panel_stock.setVisible(false);
        } else {
            int new_stock_qty = Integer.parseInt(txt_newstk.getText());
            double tobe_stock = new_stock_qty + tblselectedqty;
            System.out.println(tobe_stock);

            if (radio_addstock.isSelected()) {
                try {
                    Statement st = db.mycon().createStatement();
                    st.executeUpdate("UPDATE inventory SET quantity='" + tobe_stock + "' WHERE pid='" + tblselectedpid + "'");
                    String qrymonth = getmonth();
                    int qryyear = getyear();
                    int qryday = getday();
                    String qrytime = gettime();
                    st.executeUpdate("INSERT INTO stock_report (pid, pname, quantity, day, month, year, time, status) VALUES "
                            + "('" + tblselectedpid + "','" + tblselectedpname + "','" + tobe_stock + "','" + qryday + "','" + qrymonth + "','" + qryyear + "','" + qrytime + "','stock-in')");

                    //JOptionPane.showMessageDialog(null, "Product data updated");
                } catch (Exception e) {
                }

                tb_load();
                btn_addstock.setEnabled(false);
            } else {
                if (radio_newstk.isSelected()) {
                    try {
                        Statement st = db.mycon().createStatement();
                        st.executeUpdate("UPDATE inventory SET quantity='" + new_stock_qty + "' WHERE pid='" + tblselectedpid + "'");
                        //JOptionPane.showMessageDialog(null, "Product data updated");

                        String qrymonth = getmonth();
                        int qryyear = getyear();
                        int qryday = getday();
                        String qrytime = gettime();
                        st.executeUpdate("INSERT INTO stock_report (pid, pname, quantity, day, month, year, time, status) VALUES "
                                + "('" + tblselectedpid + "','" + tblselectedpname + "','" + tblselectedqty + "','" + qryday + "','" + qrymonth + "','" + qryyear + "','" + qrytime + "','stock-out')");
                        st.executeUpdate("INSERT INTO stock_report (pid, pname, quantity, day, month, year, time, status) VALUES "
                                + "('" + tblselectedpid + "','" + tblselectedpname + "','" + new_stock_qty + "','" + qryday + "','" + qrymonth + "','" + qryyear + "','" + qrytime + "','stock-in')");

                    } catch (Exception e) {
                    }
                    tb_load();
                    btn_addstock.setEnabled(false);

                }
            }
            panel_stock.setVisible(false);
        }


    }//GEN-LAST:event_btn_stkokActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        // TODO add your handling code here:
        panel_stock.setVisible(false);
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void radio_newstkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_newstkActionPerformed
        // TODO add your handling code here:
        txt_newstk.setText("");
    }//GEN-LAST:event_radio_newstkActionPerformed

    private void radio_addstockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_addstockActionPerformed
        // TODO add your handling code here:
        txt_newstk.setText("");
    }//GEN-LAST:event_radio_addstockActionPerformed

    private void table_inventoryFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_table_inventoryFocusLost
        // TODO add your handling code here:
        //btn_addstock.setEnabled(false);
    }//GEN-LAST:event_table_inventoryFocusLost

    private void txt_newstkKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_newstkKeyReleased
        // TODO add your handling code here:
        int warn = warnnumber(txt_newstk.getText());
        if (warn == 1) {
            warn_stock.setText("Please use numbers only");
            btn_stkok.setEnabled(false);
            w_cprice = 1;

        } else {
            warn_stock.setText("");
            w_cprice = 0;
            btn_stkok.setEnabled(true);

        }
    }//GEN-LAST:event_txt_newstkKeyReleased

    private void table_inventoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_inventoryMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_table_inventoryMouseEntered

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
            PdfWriter.getInstance(doc, new FileOutputStream(path + "inventory.pdf"));
            doc.open();
            PdfPTable tbl = new PdfPTable(8);
            tbl.addCell("PID");
            tbl.addCell("Product Name");
            tbl.addCell("Barcode");
            tbl.addCell("Cost Price");
            tbl.addCell("Selling Price");
            tbl.addCell("Quantity");
            tbl.addCell("Supplier Name");
            tbl.addCell("Status");

            for (int i = 0; i < table_inventory.getRowCount(); i++) {
                String d1 = table_inventory.getValueAt(i, 0).toString();
                String d2 = table_inventory.getValueAt(i, 1).toString();
                String d3 = table_inventory.getValueAt(i, 2).toString();
                String d4 = table_inventory.getValueAt(i, 3).toString();
                String d5 = table_inventory.getValueAt(i, 4).toString();
                String d6 = table_inventory.getValueAt(i, 5).toString();
                String d7 = table_inventory.getValueAt(i, 6).toString();
                String d8 = table_inventory.getValueAt(i, 7).toString();

                tbl.addCell(d1);
                tbl.addCell(d2);
                tbl.addCell(d3);
                tbl.addCell(d4);
                tbl.addCell(d5);
                tbl.addCell(d6);
                tbl.addCell(d7);
                tbl.addCell(d8);
            }
            doc.add(tbl);
            JOptionPane.showMessageDialog(null, "PDF Generated");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something went wrong");
        }
        doc.close();

    }//GEN-LAST:event_btn_edit1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addstock;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_edit1;
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_stkok;
    private javax.swing.ButtonGroup buttonGroup_stk;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_sname;
    private javax.swing.JPanel panel_stock;
    private javax.swing.JRadioButton radio_addstock;
    private javax.swing.JRadioButton radio_newstk;
    private javax.swing.JTable table_inventory;
    private javax.swing.JTextField txt_newstk;
    private javax.swing.JTextField txt_search;
    private javax.swing.JLabel warn_stock;
    // End of variables declaration//GEN-END:variables
}
