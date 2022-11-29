/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import Code.JpanelLoader;
import Code.db;
import com.mysql.cj.util.SearchMode;
import java.awt.HeadlessException;
import java.awt.TextArea;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Vector;
import javax.print.attribute.standard.Sides;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kavishika
 *
 */
public class inventory_add extends javax.swing.JPanel {

    /**
     * Creates new form inventory
     */
    JpanelLoader jpload = new JpanelLoader();

    public inventory_add() {
        initComponents();
        //txt_pid.setEnabled(false);
        tb_load();
        //i_hload();
        //disablefields();

    }

    public void tb_load() {
        //i_hload();
        stable=0;

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
        stable=0;

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
        stable=0;
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
        stable=1;
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
        
        stable=1;

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
    int warncorrectsup = 0;
    String tblselectedsname = "";
    int stable = 0;

    public void checkallwarnings() {
        if ((w_pname == 0) && (w_bcode == 0) && (w_cprice == 0) && (w_sprice == 0) && (w_quantity == 0) && (w_sname == 0)) {
            btn_add.setEnabled(true);
            warn_all.setText("");
            /*if ((warn_barcode.getText().equals(" ")) || (warn_cprice.getText().equals(" ")) || (warn_cprice.getText().equals(" ")) || (warn_pname.getText().equals(" "))
                || (warn_quantity.getText().equals(" "))||(warn_sname.getText().equals(" "))||(warn_sprice.getText().equals(" ")) ) {
            btn_save.setEnabled(true);*/
        } else {
            btn_add.setEnabled(false);
            warn_all.setText("Please fill every field without errors");
        }
    }

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
        String status = "1";

        try {
            Statement st = db.mycon().createStatement();
            st.executeUpdate("UPDATE inventory SET pname='" + pname + "',barcode='" + barcode + "'"
                    + ",cprice='" + cprice + "',sprice='" + sprice + "',quantity='" + quantity + "',sname='" + sname + "',status='" + status + "' WHERE pid='" + pid + "'");
            JOptionPane.showMessageDialog(null, "Product data updated");
        } catch (Exception e) {
        }
        tb_load();
    }*/
    public void addpro() {
        //Add Product
        //int pid = Integer.parseInt(txt_pid.getText());
        String pname = txt_pname.getText();
        String barcode = txt_bcode.getText();
        double cprice = Double.parseDouble(txt_cprice.getText());
        double sprice = Double.parseDouble(txt_sprice.getText());
        double quantity = Double.parseDouble(txt_quantity.getText());
        String sname = txt_sname.getText();
        String status = "1";

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
    }

    public void snamecheck(String catchsname) {

        try {

            Statement st = db.mycon().createStatement();
            ResultSet rst = st.executeQuery(" SELECT * FROM supplier WHERE supplier_Name ='" + catchsname + "'  ");
            if (rst.next()) {
                warncorrectsup = 0;
                System.out.println(warncorrectsup);

            } else {
                warncorrectsup = 1;
                System.out.println(warncorrectsup);

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void clear() {
        txt_pname.setText("");
        //txt_pid.setText("");
        txt_bcode.setText("");
        txt_cprice.setText("");
        txt_sprice.setText("");
        txt_quantity.setText("");
        txt_sname.setText("");

        tb_load();
    }

    /*public void disablefields() {
        txt_bcode.setEnabled(false);
        txt_cprice.setEnabled(false);
        txt_sprice.setEnabled(false);
        txt_pname.setEnabled(false);
        txt_quantity.setEnabled(false);
        txt_sname.setEnabled(false);
        btn_add.setEnabled(false);
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbl_pname = new javax.swing.JLabel();
        lbl_barcode = new javax.swing.JLabel();
        lbl_cprice = new javax.swing.JLabel();
        lbl_quantity = new javax.swing.JLabel();
        lbl_sid = new javax.swing.JLabel();
        txt_bcode = new javax.swing.JTextField();
        txt_pname = new javax.swing.JTextField();
        txt_cprice = new javax.swing.JTextField();
        txt_quantity = new javax.swing.JTextField();
        txt_sname = new javax.swing.JTextField();
        lbl_sprice = new javax.swing.JLabel();
        txt_sprice = new javax.swing.JTextField();
        btn_clear = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        warn_barcode = new javax.swing.JLabel();
        warn_pname = new javax.swing.JLabel();
        warn_cprice = new javax.swing.JLabel();
        warn_sprice = new javax.swing.JLabel();
        warn_quantity = new javax.swing.JLabel();
        warn_sname = new javax.swing.JLabel();
        warn_all = new javax.swing.JLabel();
        btn_back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_inventory = new javax.swing.JTable();
        lbl_sname = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        lbl_sname1 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbl_pname.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbl_pname.setText("Product Name");

        lbl_barcode.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbl_barcode.setText("Bar Code");

        lbl_cprice.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbl_cprice.setText("Cost Price");

        lbl_quantity.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbl_quantity.setText("Stock Quantity");

        lbl_sid.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbl_sid.setText("Supplier's Name");

        txt_bcode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_bcodeFocusGained(evt);
            }
        });
        txt_bcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bcodeActionPerformed(evt);
            }
        });
        txt_bcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_bcodeKeyReleased(evt);
            }
        });

        txt_pname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_pnameFocusGained(evt);
            }
        });
        txt_pname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pnameActionPerformed(evt);
            }
        });
        txt_pname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pnameKeyReleased(evt);
            }
        });

        txt_cprice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_cpriceFocusGained(evt);
            }
        });
        txt_cprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cpriceActionPerformed(evt);
            }
        });
        txt_cprice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cpriceKeyReleased(evt);
            }
        });

        txt_quantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_quantityFocusGained(evt);
            }
        });
        txt_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_quantityActionPerformed(evt);
            }
        });
        txt_quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_quantityKeyReleased(evt);
            }
        });

        txt_sname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_snameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_snameFocusLost(evt);
            }
        });
        txt_sname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_snameActionPerformed(evt);
            }
        });
        txt_sname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_snameKeyReleased(evt);
            }
        });

        lbl_sprice.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbl_sprice.setText("Selling Price");

        txt_sprice.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_spriceFocusGained(evt);
            }
        });
        txt_sprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_spriceActionPerformed(evt);
            }
        });
        txt_sprice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_spriceKeyReleased(evt);
            }
        });

        btn_clear.setBackground(new java.awt.Color(51, 51, 51));
        btn_clear.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        btn_add.setBackground(new java.awt.Color(51, 51, 51));
        btn_add.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_add.setText("Add Product");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        warn_barcode.setForeground(new java.awt.Color(255, 38, 38));
        warn_barcode.setText(" ");

        warn_pname.setForeground(new java.awt.Color(255, 38, 38));
        warn_pname.setText(" ");

        warn_cprice.setForeground(new java.awt.Color(255, 38, 38));
        warn_cprice.setText(" ");

        warn_sprice.setForeground(new java.awt.Color(255, 38, 38));
        warn_sprice.setText(" ");

        warn_quantity.setForeground(new java.awt.Color(255, 38, 38));
        warn_quantity.setText(" ");

        warn_sname.setForeground(new java.awt.Color(255, 38, 38));
        warn_sname.setText(" ");

        warn_all.setForeground(new java.awt.Color(255, 38, 38));
        warn_all.setText(" ");

        btn_back.setText("Go back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_clear)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(warn_pname, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(175, 175, 175)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_quantity)
                                            .addComponent(txt_sname)
                                            .addComponent(warn_sname, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(warn_sprice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(txt_sprice, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGap(181, 181, 181)
                                        .addComponent(warn_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(warn_barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(warn_all, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(lbl_cprice)
                                                .addGap(35, 35, 35))
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lbl_pname)
                                                .addComponent(lbl_barcode)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addGap(6, 6, 6)
                                                    .addComponent(warn_cprice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txt_cprice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txt_pname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(txt_bcode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_quantity)
                                            .addComponent(lbl_sprice)
                                            .addComponent(lbl_sid))
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addGap(23, 23, 23))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_back)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_bcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_barcode))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(warn_barcode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_pname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_pname))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(warn_pname)
                        .addGap(4, 4, 4)
                        .addComponent(txt_cprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_cprice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(warn_cprice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_sprice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_sprice))
                .addGap(2, 2, 2)
                .addComponent(warn_sprice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_quantity))
                .addGap(2, 2, 2)
                .addComponent(warn_quantity)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_sname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_sid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(warn_sname)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_clear)
                .addGap(88, 88, 88)
                .addComponent(warn_all, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_back)
                .addGap(12, 12, 12))
        );

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

        lbl_sname.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbl_sname.setText("Product Name");

        txt_search.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_searchFocusGained(evt);
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

        lbl_sname1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_sname1.setText("Add New Product");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_sname1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_sname)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_search))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_sname)
                    .addComponent(lbl_sname1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
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
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

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

    private void txt_snameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_snameActionPerformed
        // TODO add your handling code here:
        s_hload();
    }//GEN-LAST:event_txt_snameActionPerformed

    private void txt_spriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_spriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_spriceActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        addpro();
        clear();

    }//GEN-LAST:event_btn_addActionPerformed

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchActionPerformed

    private void table_inventoryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table_inventoryKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_table_inventoryKeyPressed

    private void table_inventoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_inventoryMouseClicked
        // TODO add your handling code here:
        int r = table_inventory.getSelectedRow();
        System.out.println(table_inventory.getColumnName(1));
        if (stable==1) {

            tblselectedsname = table_inventory.getValueAt(r, 1).toString();
            snamecheck(tblselectedsname);
            int warn = warnempty(txt_sname.getText());
            txt_sname.setText(tblselectedsname);
            if ((warn == 1) && (warncorrectsup == 1)) {
                warn_sname.setText("Please select a correct supplier name");
                btn_add.setEnabled(false);
                w_sname = 1;
                checkallwarnings();
            } else {
                warn_sname.setText(" ");
                w_sname = 0;
                checkallwarnings();

            }
        }


    }//GEN-LAST:event_table_inventoryMouseClicked

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        // TODO add your handling code here:
        clear();

    }//GEN-LAST:event_btn_clearActionPerformed

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

    private void txt_snameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_snameKeyReleased
        // TODO add your handling code here:
        s_hload();
        try {

            DefaultTableModel dt = (DefaultTableModel) table_inventory.getModel();
            dt.setRowCount(0);
            String searchkey = txt_sname.getText();

            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM supplier WHERE supplier_Name LIKE '%" + searchkey + "%'");

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

        int warn = warnempty(txt_sname.getText());
        
       snamecheck(txt_sname.getText());

        if ((warn == 1) || (warncorrectsup == 1)) {
            warn_sname.setText("Please select a correct supplier name");
            btn_add.setEnabled(false);
            w_sname = 1;
            
            System.out.println("ggggg");
            checkallwarnings();
        } else {
            warn_sname.setText(" ");
            w_sname = 0;
            checkallwarnings();
            System.out.println("453453");

        }

    }//GEN-LAST:event_txt_snameKeyReleased

    private void txt_snameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_snameFocusLost
        // TODO add your handling code here:
        //i_hload();
        /*tb_load();
        checkallwarnings();*/
        
    }//GEN-LAST:event_txt_snameFocusLost

    private void txt_snameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_snameFocusGained
        // TODO add your handling code here:
        s_hload();
        stb_load();
        
    }//GEN-LAST:event_txt_snameFocusGained

    private void txt_cpriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cpriceKeyReleased
        // TODO add your handling code here:
        int warn = warnnumber(txt_cprice.getText());
        if (warn == 1) {
            warn_cprice.setText("Please use numbers only");
            btn_add.setEnabled(false);
            w_cprice = 1;
            checkallwarnings();
        } else {
            warn_cprice.setText(" ");
            w_cprice = 0;
            checkallwarnings();

        }
        
    }//GEN-LAST:event_txt_cpriceKeyReleased

    private void txt_spriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_spriceKeyReleased
        // TODO add your handling code here:
        int warn = warnnumber(txt_sprice.getText());
        if (warn == 1) {
            warn_sprice.setText("Please use numbers only");
            btn_add.setEnabled(false);
            w_sprice = 1;
            checkallwarnings();
        } else {
            warn_sprice.setText(" ");
            w_sprice = 0;
            checkallwarnings();

        }
        
    }//GEN-LAST:event_txt_spriceKeyReleased

    private void txt_quantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_quantityKeyReleased
        // TODO add your handling code here:
        int warn = warnnumber(txt_quantity.getText());
        if (warn == 1) {
            warn_quantity.setText("Please use numbers only");
            btn_add.setEnabled(false);
            w_quantity = 1;
            checkallwarnings();
        } else {
            warn_quantity.setText(" ");
            w_quantity = 0;
            checkallwarnings();

        }
        
    }//GEN-LAST:event_txt_quantityKeyReleased

    private void txt_bcodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_bcodeKeyReleased
        // TODO add your handling code here:
        int warn = warnempty(txt_bcode.getText());
        if (warn == 1) {
            warn_barcode.setText("Please Fill this field");
            btn_add.setEnabled(false);
            w_bcode = 1;
            checkallwarnings();
        } else {
            warn_barcode.setText(" ");
            w_bcode = 0;
            checkallwarnings();

        }
    }//GEN-LAST:event_txt_bcodeKeyReleased

    private void txt_pnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pnameKeyReleased
        // TODO add your handling code here:
        int warn = warnempty(txt_pname.getText());
        if (warn == 1) {
            warn_pname.setText("Please Fill this field");
            btn_add.setEnabled(false);
            w_pname = 1;
            checkallwarnings();

        } else {
            warn_pname.setText(" ");
            w_pname = 0;
            checkallwarnings();

        }
    }//GEN-LAST:event_txt_pnameKeyReleased

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
        inventory inv_load = new inventory();
        jpload.jPanelLoader(jPanel1, inv_load);

        //inventory_add inv_load = new inventory_add();
        //jpload.jPanelLoader(jPanel1, inv_load);
    }//GEN-LAST:event_btn_backActionPerformed

    private void table_inventoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_inventoryMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_table_inventoryMouseEntered

    private void txt_bcodeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bcodeFocusGained
        // TODO add your handling code here:i_hload();
        tb_load_custom(txt_search.getText());
        
        i_hload();
        
        
    }//GEN-LAST:event_txt_bcodeFocusGained

    private void txt_pnameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_pnameFocusGained
        // TODO add your handling code here:
        tb_load_custom(txt_search.getText());
        i_hload();
    }//GEN-LAST:event_txt_pnameFocusGained

    private void txt_cpriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cpriceFocusGained
        // TODO add your handling code here:
        tb_load_custom(txt_search.getText());
        i_hload();
    }//GEN-LAST:event_txt_cpriceFocusGained

    private void txt_spriceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_spriceFocusGained
        // TODO add your handling code here:
        tb_load_custom(txt_search.getText());
        i_hload();
    }//GEN-LAST:event_txt_spriceFocusGained

    private void txt_quantityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_quantityFocusGained
        // TODO add your handling code here:
        tb_load_custom(txt_search.getText());
        i_hload();
    }//GEN-LAST:event_txt_quantityFocusGained

    private void txt_searchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_searchFocusGained
        // TODO add your handling code here:
        tb_load_custom(txt_search.getText());
        i_hload();
    }//GEN-LAST:event_txt_searchFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_clear;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_barcode;
    private javax.swing.JLabel lbl_cprice;
    private javax.swing.JLabel lbl_pname;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_sid;
    private javax.swing.JLabel lbl_sname;
    private javax.swing.JLabel lbl_sname1;
    private javax.swing.JLabel lbl_sprice;
    private javax.swing.JTable table_inventory;
    private javax.swing.JTextField txt_bcode;
    private javax.swing.JTextField txt_cprice;
    private javax.swing.JTextField txt_pname;
    private javax.swing.JTextField txt_quantity;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_sname;
    private javax.swing.JTextField txt_sprice;
    private javax.swing.JLabel warn_all;
    private javax.swing.JLabel warn_barcode;
    private javax.swing.JLabel warn_cprice;
    private javax.swing.JLabel warn_pname;
    private javax.swing.JLabel warn_quantity;
    private javax.swing.JLabel warn_sname;
    private javax.swing.JLabel warn_sprice;
    // End of variables declaration//GEN-END:variables
}
