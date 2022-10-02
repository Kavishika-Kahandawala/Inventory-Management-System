package GUI;

import Code.db;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Loyalty extends javax.swing.JPanel {

    public float Loyalty_points;
    public float Temp_Loyalty_points;
    public float Discount;
    public float Old_Loyalty_points;
    public float bill_total;

    public Loyalty() {
        initComponents();

    }

    public static void main() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        totalamount = new javax.swing.JTextField();
        availablepoints = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        showdiscount = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        pointstoredeem = new javax.swing.JTextField();
        btnpay = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cusid = new javax.swing.JTextField();
        btncal = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        totalamount.setText("0");
        totalamount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalamountActionPerformed(evt);
            }
        });

        availablepoints.setText("0");

        jLabel3.setText("Discount");

        showdiscount.setText("0");

        jLabel4.setText("Points to redeem");

        pointstoredeem.setText("0");
        pointstoredeem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pointstoredeemKeyReleased(evt);
            }
        });

        btnpay.setText("Pay");
        btnpay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpayActionPerformed(evt);
            }
        });

        jLabel2.setText("Available Points");

        jLabel1.setText("Total Amount");

        jLabel5.setText("Customer ID");

        cusid.setText("0");
        cusid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cusidKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cusidKeyReleased(evt);
            }
        });

        btncal.setText("Calculate");
        btncal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnpay)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(23, 23, 23)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(availablepoints, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                    .addComponent(totalamount, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cusid, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(jLabel3)
                                .addGap(49, 49, 49))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pointstoredeem)
                            .addComponent(showdiscount))))
                .addGap(40, 40, 40)
                .addComponent(btncal)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cusid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btncal))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(availablepoints, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(showdiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(pointstoredeem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addComponent(jLabel3)))
                .addGap(37, 37, 37)
                .addComponent(btnpay)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cusidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cusidKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cusidKeyPressed

    private void cusidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cusidKeyReleased
        // Get Customer Points
        String customer = cusid.getText();
        String x;

        try {

            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM customer WHERE Cid = '" + customer + "'");

            if (rs.next()) {

                x = (rs.getString("Loyalty_Points"));
                float Old_Loyalty_points = Float.parseFloat(x);
                
            }

        } catch (SQLException e) {
            System.out.println("e");
        }
    }//GEN-LAST:event_cusidKeyReleased

    private void btncalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalActionPerformed
        // TODO add your handling code here:
        Calculate_loyalty_point();
        DisplayAvailableLoyaltyPoints();

    }//GEN-LAST:event_btncalActionPerformed

    private void pointstoredeemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pointstoredeemKeyReleased
        // TODO add your handling code here:
        Calculate_Discount();
    }//GEN-LAST:event_pointstoredeemKeyReleased

    private void totalamountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalamountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalamountActionPerformed

    private void btnpayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpayActionPerformed
        // TODO add your handling code here:
         
        
    }//GEN-LAST:event_btnpayActionPerformed

    public void setTempLoyalty_points(float Temp_Loyalty_points) {
        this.Temp_Loyalty_points = Temp_Loyalty_points;
    }

    public void setDiscount(float Discount) {
        this.Discount = Discount;
    }

    //Calculate Temp Loyalty Points
    public void Calculate_loyalty_point() {

        String total_amount = totalamount.getText();
        float bill_total = Float.parseFloat(total_amount);

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

    //Calculate Discount
    public void Calculate_Discount() {

        String total_amount = totalamount.getText();
        float bill_total = Float.parseFloat(total_amount);

        String redeem_points = pointstoredeem.getText();
        float spendlp = Integer.parseInt(redeem_points);

        float discount = 1;

        if (spendlp == 50) {
            discount = (bill_total * 5) / 100;

        }
        if (spendlp == 100) {
            discount = (bill_total * 8) / 100;
        }
        if (spendlp == 150) {
            discount = (bill_total * 10) / 100;
        }
        if (spendlp == 200) {
            discount = (bill_total * 12) / 100;
        }
        if (spendlp == 250) {
            discount = (bill_total * 15) / 100;
        }

        setDiscount(discount);
        showdiscount.setText(Float.toString(discount));

    }

    public void DisplayAvailableLoyaltyPoints() {

        float Available_Loyalty_Points;

        String customer = cusid.getText();
        String x;

        try {

            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM customer WHERE Cid = '" + customer + "'");

            if (rs.next()) {

                x = (rs.getString("Loyalty_Points"));
                float Old_Loyalty_points = Float.parseFloat(x);
                
                Available_Loyalty_Points = Temp_Loyalty_points + Old_Loyalty_points;

                availablepoints.setText(Float.toString(Available_Loyalty_Points));
            }

        } catch (SQLException e) {
            System.out.println("e");
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField availablepoints;
    private javax.swing.JButton btncal;
    private javax.swing.JButton btnpay;
    private javax.swing.JTextField cusid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField pointstoredeem;
    private javax.swing.JTextField showdiscount;
    private javax.swing.JTextField totalamount;
    // End of variables declaration//GEN-END:variables

}
