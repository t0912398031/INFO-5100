/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.InvestmentEnterprise;

import Business.EcoSystem;
import Business.Enterprise.DepositEnterprise;
import Business.Enterprise.Enterprise;
import Business.Finance.DailyTransactionPrice;
import Business.Finance.Pricehistory;
import Business.Organization.InvestmentOrg;
import Business.Organization.Organization;
import Business.Organization.TransactionOrg;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.InvestmentWorkRequest;
import Business.WorkQueue.WorkRequest;
import UserInterface.CommonUse.CheckProgress;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
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
import org.jfree.chart.plot.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Chung-Yang Li
 */
public class InvestmentAssistantWorkQueueJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdminWorkAreaJPanel
     */
    private JPanel upc;
    private InvestmentOrg investmentOrg;
    private UserAccount account;
    private Enterprise enterprise;
    private EcoSystem ecoSystem;
    public InvestmentAssistantWorkQueueJPanel(JPanel upc, UserAccount account, InvestmentOrg organization, Enterprise enterprise, EcoSystem ecoSystem) {
        initComponents();
        this.upc = upc;
        this.account = account;
        this.investmentOrg = organization;
        this.enterprise = enterprise;
        this.ecoSystem = ecoSystem;
        populateTable();
        populateTypeComboBox();
        chartJPanelShow.setVisible(true);
        populateChart();
        setBackground(new java.awt.Color(204, 255, 204));
    }
    
    private void populateTable(){
        DefaultTableModel model = (DefaultTableModel) investmentJTable.getModel();   
        model.setRowCount(0);
        
        for (WorkRequest request : account.getWorkQueue().getWorkRequestList()){
            InvestmentWorkRequest workRequest = (InvestmentWorkRequest)request;
            Object[] row = new Object[6];
            row[0] = workRequest;
            row[1] = workRequest.getType();
            row[2] = workRequest.getPrice();
            row[3] = workRequest.getAmount();
            row[4] = workRequest.getRequestDate();
            row[5] = workRequest.getStatus();
            
            model.addRow(row);
        }
    }
    
    private void populateTypeComboBox(){
        typeComboBox.removeAllItems(); 
        typeComboBox.addItem("Buy");
        typeComboBox.addItem("Sell");
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
//        CategoryAxis domainAxis2 = volumeChartPlot.getDomainAxis();
//        ValueAxis valueAxis2 = volumeChartPlot.getRangeAxis();
//        
//        CombinedDomainCategoryPlot plot = new CombinedDomainCategoryPlot(domainAxis2);
//        plot.add(priceChartPlot,1);
//        plot.add(volumeChartPlot,1);
//        plot.setOrientation(PlotOrientation.VERTICAL);
//        
//        JFreeChart cbChart = new JFreeChart(plot);
        
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
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        txtAmount = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        investmentJTable = new javax.swing.JTable();
        typeComboBox = new javax.swing.JComboBox();
        chartJPanelShow = new javax.swing.JPanel();
        checkBtn = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel4.setFont(new java.awt.Font("新細明體", 0, 24)); // NOI18N
        jLabel4.setText("Investment Assistant Work Queue");

        jLabel1.setFont(new java.awt.Font("新細明體", 0, 18)); // NOI18N
        jLabel1.setText("Price:");

        jLabel2.setFont(new java.awt.Font("新細明體", 0, 18)); // NOI18N
        jLabel2.setText("Amount:");

        investmentJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Work Number", "Type", "Price", "Amount", "Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(investmentJTable);
        if (investmentJTable.getColumnModel().getColumnCount() > 0) {
            investmentJTable.getColumnModel().getColumn(0).setResizable(false);
            investmentJTable.getColumnModel().getColumn(0).setPreferredWidth(20);
            investmentJTable.getColumnModel().getColumn(1).setResizable(false);
            investmentJTable.getColumnModel().getColumn(1).setPreferredWidth(20);
            investmentJTable.getColumnModel().getColumn(2).setResizable(false);
            investmentJTable.getColumnModel().getColumn(2).setPreferredWidth(20);
            investmentJTable.getColumnModel().getColumn(3).setResizable(false);
            investmentJTable.getColumnModel().getColumn(3).setPreferredWidth(20);
            investmentJTable.getColumnModel().getColumn(4).setResizable(false);
            investmentJTable.getColumnModel().getColumn(5).setResizable(false);
            investmentJTable.getColumnModel().getColumn(5).setPreferredWidth(20);
        }

        chartJPanelShow.setLayout(new java.awt.BorderLayout());

        checkBtn.setBackground(new java.awt.Color(255, 255, 255));
        checkBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        checkBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/BitCoinMall/picture/view.png"))); // NOI18N
        checkBtn.setText("Check Progess");
        checkBtn.setIconTextGap(10);
        checkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBtnActionPerformed(evt);
            }
        });

        back.setBackground(new java.awt.Color(255, 255, 255));
        back.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/BitCoinMall/picture/back.png"))); // NOI18N
        back.setText("Back");
        back.setIconTextGap(22);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/BitCoinMall/picture/OK - green.png"))); // NOI18N
        jButton2.setText("Confrim");
        jButton2.setIconTextGap(10);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(back)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(chartJPanelShow, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(checkBtn, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(244, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(back))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkBtn)
                .addGap(34, 34, 34)
                .addComponent(chartJPanelShow, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void checkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBtnActionPerformed
        int selectedRow = investmentJTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(upc, "Please select a workrequest!");
            return;
        }
        WorkRequest workRequest = (WorkRequest) investmentJTable.getValueAt(selectedRow, 0);
        CheckProgress checkProgress = new CheckProgress(workRequest);
        checkProgress.setVisible(true);
    }//GEN-LAST:event_checkBtnActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        upc.remove(this);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.previous(upc);
    }//GEN-LAST:event_backActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String price = txtPrice.getText();
        String amount = txtAmount.getText();
        if(price.equals("") || price.isEmpty() || amount.equals("") || amount.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter valid value");
            return;
        }
        if(!price.matches("[0-9]+(\\.){0,1}[0-9]*")){
        JOptionPane.showMessageDialog(null, "Please enter valid Price(ex. 7848.43)","Warning",JOptionPane.WARNING_MESSAGE);
        txtPrice.setText("");
        return;
        }
        if(!amount.matches("[0-9]+")){
        JOptionPane.showMessageDialog(null, "Please enter valid amount","Warning",JOptionPane.WARNING_MESSAGE);
        txtAmount.setText("");
        return;
        }
        
        else{
            InvestmentWorkRequest request = new InvestmentWorkRequest();
            request.setType(String.valueOf(typeComboBox.getSelectedItem()));
            request.setPrice(Double.parseDouble(price));
            request.setInitialAmount(Integer.parseInt(amount));
            request.setAmount(Integer.parseInt(amount));
            request.setSender(account);
            request.setStatus("Established");
            request.setInvestmentEnterprise(enterprise.getName());
            
            investmentOrg.getWorkQueue().addWorkRequest(request);
            account.getWorkQueue().addWorkRequest(request);

            JOptionPane.showMessageDialog(null, "Request create successfully");
            populateTable();
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JPanel chartJPanelShow;
    private javax.swing.JButton checkBtn;
    private javax.swing.JTable investmentJTable;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JComboBox typeComboBox;
    // End of variables declaration//GEN-END:variables
}
