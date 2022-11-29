package GUI;

import Code.db;
import GUI.Sales;
import static GUI.Sales.b_total;
import static GUI.Sales.balance;
import static GUI.Sales.cus_id;
import static GUI.Sales.inid;
import static GUI.Sales.jTable1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Double.parseDouble;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PsYchO
 */
public class LoyaltyPoints extends javax.swing.JFrame {

    public float Old_Loyalty_points;
    public float Loyalty_points;
    public float Temp_Loyalty_points;
    public double Discount;
    public float bill_total;
    public double spendlp;
    double Available_Loyalty_Points;

    public LoyaltyPoints() {
        initComponents();
        displaybillTotal();
        Calculate_loyalty_point();
        setDate();
        setTime();
        sTime();

    }

    public void sTime() {

        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
                Time.setText(s.format(d));
            }
        }
        ).start();
    }

    public void setDate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        Date.setText(s.format(d));

    }

    public void setTime() {

        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
                Time.setText(s.format(d));
            }
        }
        ).start();
    }

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

    public void stockupdate() {
        String month = getmonth();
        int year = getyear();
        int day = getday();
        String time = gettime();

        ArrayList<String> pidarr = new ArrayList<String>();
        ArrayList<String> qtyarr = new ArrayList<String>();

        try {
            Statement st = db.mycon().createStatement();
            ResultSet rs = st.executeQuery("SELECT pid,qty FROM cart");

            while (rs.next()) {
                pidarr.add(rs.getString(1));
                qtyarr.add(rs.getString(2));
                System.out.println(rs.getString(1));

            }

            for (int counter = 0; counter < pidarr.size(); counter++) {
                int temppid = Integer.parseInt(pidarr.get(counter));
                String pname = "";
                Double invqty = 0.0;
                System.out.println(temppid);

                ResultSet currentqty = st.executeQuery("SELECT quantity,pname FROM inventory WHERE pid='" + temppid + "'");
                while (currentqty.next()) {
                    invqty = Double.parseDouble(currentqty.getString(1));
                    pname = currentqty.getString(2);
                }
                int cartqty = Integer.parseInt(qtyarr.get(counter));
                Double finalqty = invqty - cartqty;

                st.executeUpdate("UPDATE inventory SET quantity='" + finalqty + "' WHERE pid='" + temppid + "'");

                st.executeUpdate("INSERT INTO stock_report(pid, pname, quantity, day, month, year, time, status) "
                        + "VALUES('" + temppid + "','" + pname + "','" + cartqty + "','" + day + "','" + month + "','" + year + "','" + time + "','stock-out')");

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void displaybillTotal() {
        Sales obj = new Sales();
        double bill_total = obj.total;

        billTotal.setText(Double.toString(bill_total));

    }

    public void getCusData() {

        String x;
        String search = searchcustp.getText();
        try {

            Statement s = db.mycon().createStatement();

            ResultSet rs = s.executeQuery("SELECT * FROM customer WHERE Customer_TP = '" + search + "'");

            if (rs.next()) {

                cusName.setText(rs.getString("Customer_FirstName"));
                cusID.setText(rs.getString("Cid"));

                x = (rs.getString("Loyalty_Points"));
                float Old_Loyalty_points = Float.parseFloat(x);

                Available_Loyalty_Points = Temp_Loyalty_points + Old_Loyalty_points;

                availablepoints.setText(Double.toString(Available_Loyalty_Points));

            } else {
                JOptionPane.showMessageDialog(null, "No Results Found");
            }

        } catch (SQLException e) {
            System.out.println("e");
        }

    }

    public void setTempLoyalty_points(float Temp_Loyalty_points) {
        this.Temp_Loyalty_points = Temp_Loyalty_points;
    }

    public void setDiscount(float Discount) {
        this.Discount = Discount;
    }

    public void Calculate_loyalty_point() {

        Sales obj = new Sales();
        double bill_total = obj.total;

        int lp = 0;

        if (bill_total > 999) {
            lp = 5;
        }
        if (bill_total > 2999) {
            lp = 8;
        }
        if (bill_total > 4999) {
            lp = 10;
        }
        if (bill_total > 14999) {
            lp = 12;
        }
        if (bill_total > 19999) {
            lp = 15;
        }
        setTempLoyalty_points(lp);

    }

    public void Calculate_Discount() {

        Sales obj = new Sales();
        double bill_total = obj.total;

        String redeemPoints = jComboBox1.getSelectedItem().toString();
        spendlp = Double.parseDouble(redeemPoints);

        double discount = 0;
        double newtot = 0;

        String x = availablepoints.getText();
        double availblep = Double.parseDouble(x);

        if (availblep > spendlp) {

            if (spendlp == 50) {
                discount = (bill_total * 5) / 100;
            } else if (spendlp == 100) {
                discount = (bill_total * 8) / 100;
            } else if (spendlp == 150) {
                discount = (bill_total * 10) / 100;
            } else if (spendlp == 200) {
                discount = (bill_total * 12) / 100;
            } else if (spendlp == 250) {
                discount = (bill_total * 15) / 100;
            } else if (spendlp == 0) {
                discount = 0.00;
            } else {
                JOptionPane.showMessageDialog(null, "100, 150, 200, 250 Only");
            }

            setDiscount((float) discount);
            showDiscount.setText(Double.toString(discount));

            newtot = bill_total - discount;
            newtotal.setText(Double.toString(newtot));

        } else {
            JOptionPane.showMessageDialog(null, "Not Enough Points");

            newtot = bill_total;
            newtotal.setText(Double.toString(newtot));
        }
    }

    public void displaynewTotal() {

        double newtot = 0;

        newtot = bill_total - Discount;
        newtotal.setText(Double.toString(newtot));

    }

    public void tot() {

        Double paid = Double.valueOf(paidAmount.getText());
        Double newtot = Double.valueOf(newtotal.getText());
        Double bal;

        bal = paid - newtot; //calculate balance
        balance.setText(String.valueOf(bal));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        billTotal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        availablepoints = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        showDiscount = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        newtotal = new javax.swing.JLabel();
        btnpay = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        balance = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        paidAmount = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        searchcustp = new javax.swing.JTextField();
        btnCusSearch = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cusName = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cusID = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Time = new javax.swing.JLabel();
        Date = new javax.swing.JLabel();
        employeeName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Bill Total:");

        billTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        billTotal.setText("00.00");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Available Points :");

        availablepoints.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        availablepoints.setText("00.00");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Discount :");

        showDiscount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        showDiscount.setText("00.00");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("New Total :");

        newtotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        newtotal.setText("00.00");

        btnpay.setBackground(new java.awt.Color(51, 51, 51));
        btnpay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnpay.setForeground(new java.awt.Color(255, 255, 255));
        btnpay.setText("Pay");
        btnpay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpayActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Balance :");

        balance.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        balance.setText("00.00");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Paid Amount :");

        paidAmount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        paidAmount.setText("0");
        paidAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paidAmountActionPerformed(evt);
            }
        });
        paidAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                paidAmountKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Points to redeem :");

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "50", "100", "150", "200", "250" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(showDiscount)
                            .addComponent(newtotal)
                            .addComponent(billTotal)
                            .addComponent(availablepoints)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(balance, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(paidAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnpay, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(billTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(availablepoints)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(showDiscount))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(newtotal))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(paidAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(balance))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btnpay, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Customer TP :");

        searchcustp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchcustp.setText("0");
        searchcustp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchcustpActionPerformed(evt);
            }
        });
        searchcustp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchcustpKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchcustpKeyReleased(evt);
            }
        });

        btnCusSearch.setBackground(new java.awt.Color(51, 51, 51));
        btnCusSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCusSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnCusSearch.setText("Select");
        btnCusSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCusSearchActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Customer Name :");

        cusName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cusName.setText("Name");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Customer ID :");

        cusID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cusID.setText("ID");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnCusSearch)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(searchcustp, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cusID)
                                .addGap(24, 24, 24))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cusName)))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(searchcustp, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCusSearch)
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cusName))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cusID))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        Time.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Time.setText("Time");

        Date.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Date.setText("Date");

        employeeName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        employeeName.setText("cashier");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(employeeName)
                .addGap(26, 26, 26))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(Time, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(Time)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Date)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(employeeName)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCusSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCusSearchActionPerformed
        // TODO add your handling code here:
        getCusData();


    }//GEN-LAST:event_btnCusSearchActionPerformed

    private void searchcustpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchcustpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchcustpActionPerformed

    private void searchcustpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchcustpKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchcustpKeyPressed

    private void searchcustpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchcustpKeyReleased
        // Get Customer Points

    }//GEN-LAST:event_searchcustpKeyReleased

    private void paidAmountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paidAmountKeyReleased
        // TODO add your handling code here:
        tot();
    }//GEN-LAST:event_paidAmountKeyReleased

    private void btnpayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpayActionPerformed
        // TODO add your handling code here:

        try {

            double totprofit = 0;
            double totCost = 0;
            double totItems = 0;
            String inv_id = Sales.inid.getText();
            String cname = cusName.getText();
            String cid = cusID.getText();
            String tot_bil = billTotal.getText();
            String blnc = balance.getText();
            String date = Dashboard.date.getText();
            String time = Dashboard.tiME.getText();
            String Employee = employeeName.getText(); // get the correct name
            String Discount = showDiscount.getText();
            String pamount = paidAmount.getText();
            String redeemPoints = jComboBox1.getSelectedItem().toString();
            double dis = parseDouble(Discount);
            Statement ss = db.mycon().createStatement();

            ResultSet rs = ss.executeQuery("SELECT SUM(profit),SUM(Total_Cost),SUM(qty) FROM cart WHERE INID = '" + inv_id + "' ");
            if (rs.next()) {
                double profit = parseDouble(rs.getString("SUM(profit)"));
                totprofit = profit - dis;
                totCost = parseDouble(rs.getString("SUM(Total_Cost)"));
                totItems = parseDouble(rs.getString("SUM(qty)"));

            }
            ss.executeLargeUpdate("INSERT INTO sales(INID, Date, Time ,Cashier,Cid, Customer_Name,No_Items, Total_Bill,Total_Cost,Paid_Amount, Balance,Loyalty_Points,Discount,Profit) VALUES"
                    + "('" + inv_id + "','" + date + "','" + time + "','" + Employee + "','" + cid + "','" + cname + "','" + totItems + "','" + tot_bil + "','" + totCost + "','" + pamount + "',"
                    + "'" + blnc + "','" + redeemPoints + "','" + Discount + "','" + totprofit + "')");

        } catch (SQLException e) {
            System.out.println(e);
        }

        //Update Loyalty Points and Discounts of Customer
        try {

            String cid = cusID.getText();
            double todayDiscount = Double.parseDouble(showDiscount.getText());
            double newpoints;
            double previousDiscounts;

            newpoints = Available_Loyalty_Points - spendlp;

            String x = Double.toString(newpoints);
            Statement s = db.mycon().createStatement();

            ResultSet rs = s.executeQuery("SELECT * FROM customer WHERE cid = '" + cid + "'");

            if (rs.next()) {
                previousDiscounts = (rs.getDouble("Total_Discounts"));

                double newDiscounts = previousDiscounts + todayDiscount;

                s.executeUpdate("UPDATE customer SET Loyalty_Points =  '" + x + "', Total_Discounts = '" + newDiscounts + "' WHERE cid = '" + cid + "'");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        stockupdate();
        GenerateInvoiceRegister.main(new String[0]);
        
        
        // save last inid number
        try {
            String id = Sales.inid.getText();
            Statement s = db.mycon().createStatement();
            s.executeUpdate("UPDATE extra SET val='" + id + "' WHERE exid = 1");

        } catch (SQLException e) {
            System.out.println(e);
        }
        dispose();

        JOptionPane.showMessageDialog(null, "Invoice Printed");

    }//GEN-LAST:event_btnpayActionPerformed

    private void paidAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paidAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paidAmountActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        Calculate_Discount();

    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(LoyaltyPoints.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoyaltyPoints.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoyaltyPoints.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoyaltyPoints.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoyaltyPoints().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Date;
    private javax.swing.JLabel Time;
    private javax.swing.JLabel availablepoints;
    private javax.swing.JLabel balance;
    private javax.swing.JLabel billTotal;
    private javax.swing.JButton btnCusSearch;
    private javax.swing.JButton btnpay;
    private javax.swing.JLabel cusID;
    private javax.swing.JLabel cusName;
    private javax.swing.JLabel employeeName;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel newtotal;
    private javax.swing.JTextField paidAmount;
    private javax.swing.JTextField searchcustp;
    private javax.swing.JLabel showDiscount;
    // End of variables declaration//GEN-END:variables
}
