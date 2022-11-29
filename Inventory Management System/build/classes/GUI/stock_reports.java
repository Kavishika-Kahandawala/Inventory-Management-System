/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import Code.JpanelLoader;

/**
 *
 * @author Horizon
 */
public class stock_reports extends javax.swing.JPanel {

    /**
     * Creates new form inventory_full
     */
    
    JpanelLoader jpload = new JpanelLoader();
    
    public stock_reports() {
        initComponents();
        
        stock_in st_in = new stock_in();
        jpload.jPanelLoader(stock_in, st_in);
        
        stock_out st_out = new stock_out();
        jpload.jPanelLoader(stock_out, st_out);
        
        stock_log st_log = new stock_log();
        jpload.jPanelLoader(stock_log, st_log);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        stock_log = new javax.swing.JPanel();
        stock_in = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        stock_out = new javax.swing.JPanel();

        javax.swing.GroupLayout stock_logLayout = new javax.swing.GroupLayout(stock_log);
        stock_log.setLayout(stock_logLayout);
        stock_logLayout.setHorizontalGroup(
            stock_logLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
        );
        stock_logLayout.setVerticalGroup(
            stock_logLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 687, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Full Report", stock_log);

        javax.swing.GroupLayout stock_inLayout = new javax.swing.GroupLayout(stock_in);
        stock_in.setLayout(stock_inLayout);
        stock_inLayout.setHorizontalGroup(
            stock_inLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stock_inLayout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1180, Short.MAX_VALUE))
        );
        stock_inLayout.setVerticalGroup(
            stock_inLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stock_inLayout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 587, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Stock - in", stock_in);

        javax.swing.GroupLayout stock_outLayout = new javax.swing.GroupLayout(stock_out);
        stock_out.setLayout(stock_outLayout);
        stock_outLayout.setHorizontalGroup(
            stock_outLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
        );
        stock_outLayout.setVerticalGroup(
            stock_outLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 687, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Stock - out", stock_out);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JPanel stock_in;
    private javax.swing.JPanel stock_log;
    private javax.swing.JPanel stock_out;
    // End of variables declaration//GEN-END:variables
}
