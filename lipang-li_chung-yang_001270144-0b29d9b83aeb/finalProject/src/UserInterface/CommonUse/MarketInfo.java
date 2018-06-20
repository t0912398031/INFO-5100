/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.CommonUse;

import Business.EcoSystem;
import Business.Enterprise.DepositEnterprise;
import Business.Finance.DailyTransactionPrice;
import Business.Finance.Pricehistory;
import Business.Organization.Organization;
import Business.Organization.TransactionOrg;
import Business.WorkQueue.InvestmentWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.BorderLayout;
import java.awt.Color;
import java.time.LocalDate;
import java.util.Locale;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author lingfengzhou
 */
public class MarketInfo extends javax.swing.JFrame {

    /**
     * Creates new form MarketInfo
     */
    
    private EcoSystem ecoSystem;
    
    
    public MarketInfo(EcoSystem ecoSystem) {
        initComponents();
        this.ecoSystem =ecoSystem;
        setSize(800, 1000);
        populateChart();
        
    }
    
    
    private void populateChart(){
        DepositEnterprise de = (DepositEnterprise) ecoSystem.getEnterpriseNetwork().searchByName("Universal bank");
        TransactionOrg transactionOrg = (TransactionOrg) de.getOrganizationDirectory().searchOrgByType(Organization.Type.Transaction);
        Pricehistory pricehistory = transactionOrg.getPricehistory();
        //price data
        DefaultCategoryDataset priceLineDataset = new DefaultCategoryDataset();
        priceLineDataset.addValue(7000.0, "Price", LocalDate.of(2016, 12, 1));
        priceLineDataset.addValue(7100.0, "Price", LocalDate.of(2017, 12, 1));
        //volume data
        DefaultCategoryDataset volumeBarDataset = new DefaultCategoryDataset();
        volumeBarDataset.addValue(10, "Volume", LocalDate.of(2016, 12, 1));
        volumeBarDataset.addValue(10, "Volume", LocalDate.of(2017, 12, 1));
        //Pie chart
        DefaultPieDataset pieChartDataset = new DefaultPieDataset();
        
        Double totalBuy=0.0;
        Double totalSell= 0.0;
        for(WorkRequest inRequest:de.getOrganizationDirectory().searchOrgByType(Organization.Type.Transaction).getWorkQueue().getWorkRequestList()){
            InvestmentWorkRequest inr = (InvestmentWorkRequest) inRequest;
            if(inr.getType().equalsIgnoreCase("Buy")) totalBuy+=inr.getInitialAmount();
            if(inr.getType().equalsIgnoreCase("Sell")) totalSell+=inr.getInitialAmount();
        }
        pieChartDataset.setValue("BuyVolume", totalBuy/(totalSell+totalBuy));
        pieChartDataset.setValue("SellVolume", totalSell/(totalSell+totalBuy));
        
        
        
        for(DailyTransactionPrice p:transactionOrg.getPricehistory().getDailyTransactionPriceList()) {
            priceLineDataset.addValue(p.getDealPrice(), "Price", p.getDealDate());
            volumeBarDataset.addValue(p.getDealAmount(), "Volume", p.getDealDate());
        }
        
        //line chart
        JFreeChart lineChart = ChartFactory.createLineChart("Transaction history", "Date","Price/USD", priceLineDataset, PlotOrientation.VERTICAL,true, true, false);
        CategoryPlot priceChartPlot = lineChart.getCategoryPlot();
        priceChartPlot.setRangeGridlinePaint(Color.YELLOW);
        priceChartPlot.setBackgroundPaint(Color.BLACK);
        priceChartPlot.getRangeAxis().setRange(6000, 9000);
        //Bar chart
        JFreeChart barChart = ChartFactory.createBarChart("Transaction history", "Date", "Volume", volumeBarDataset, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot volumeChartPlot = barChart.getCategoryPlot();
        volumeChartPlot.setRangeGridlinePaint(Color.YELLOW);
        volumeChartPlot.setBackgroundPaint(Color.BLACK);
        //Pie
        JFreeChart pieChart = ChartFactory.createPieChart("Buy and sell ratio", pieChartDataset, true, true, false);
        
        //two in one
        volumeChartPlot.setDomainAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);
        volumeChartPlot.setDataset(1, priceLineDataset);
        volumeChartPlot.mapDatasetToRangeAxis(1, 1);
        BarRenderer br = (BarRenderer) volumeChartPlot.getRenderer();
        br.setMaximumBarWidth(.05);
        CategoryAxis domainAxis = volumeChartPlot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.STANDARD);
        domainAxis.setVisible(true);
        ValueAxis axis1 = volumeChartPlot.getRangeAxis(0);
        axis1.setRange(0, 200);
        final ValueAxis axis2 = new NumberAxis("Price/USD");
        axis2.setRange(4500, 9000);
        volumeChartPlot.setRangeAxis(1, axis2);
        final LineAndShapeRenderer renderer2 = new LineAndShapeRenderer();
        renderer2.setToolTipGenerator(new StandardCategoryToolTipGenerator());
        volumeChartPlot.setRenderer(1, renderer2);
        volumeChartPlot.setDatasetRenderingOrder(DatasetRenderingOrder.REVERSE);
       
        
       
            
        
//        ChartPanel chartPanel = new ChartPanel(cbChart);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartJPanelShow.removeAll();
        chartJPanelShow.add(chartPanel, BorderLayout.CENTER);
        chartJPanelShow.validate();
        
        ChartPanel chartPanel1 = new ChartPanel(pieChart);
        piePanel.removeAll();
        piePanel.add(chartPanel1, BorderLayout.CENTER);
        piePanel.validate();
        
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
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        chartJPanelShow = new javax.swing.JPanel();
        piePanel = new javax.swing.JPanel();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Market inforamtion");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/BitCoinMall/picture/delete - red.png"))); // NOI18N
        jButton1.setText("Close");
        jButton1.setIconTextGap(20);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        chartJPanelShow.setLayout(new java.awt.BorderLayout());

        piePanel.setLayout(new java.awt.BorderLayout());

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/BitCoinMall/picture/update.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setIconTextGap(25);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(piePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chartJPanelShow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 321, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chartJPanelShow, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(piePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
            populateChart();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MarketInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MarketInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MarketInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MarketInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MarketInfo().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel chartJPanelShow;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel piePanel;
    // End of variables declaration//GEN-END:variables
}
