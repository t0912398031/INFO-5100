/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.CustodianEnterprise;

import UserInterface.SystemMantenanceEnterprise.*;
import UserInterface.InvestmentEnterprise.*;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.InvestmentEnterprise;
import Business.Finance.Deal;
import Business.Organization.CustomerServiceOrg;
import Business.Organization.InvestmentOrg;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.InvestmentWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author lingfengzhou
 */
public class AnalysisJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageEnterpriseNetworkJPanel
     */
    private EcoSystem ecoSystem;
    private JPanel userProcessContainer;
    private CustomerServiceOrg organization;
    public AnalysisJPanel(JPanel userProcessContainer, CustomerServiceOrg organization, EcoSystem ecoSystem) {
        initComponents();
        setSize(800,600);
        this.ecoSystem = ecoSystem;
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        populateAnalysisComboBox();
    }
    
    public void populateAnalysisComboBox() {   
        analysisComboBox.addItem("Total Amount(Buy + Sell)");
        analysisComboBox.addItem("Best Companion(According to Investment Power)");
        populateChart("Total Amount(Buy + Sell)");        
    }
    private void populateChart(String s){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
        
        if(s.equalsIgnoreCase("Total Amount(Buy + Sell)")){
            int totalAmount = 0;       
                for(Enterprise e: ecoSystem.getEnterpriseNetwork().getEnterpriseList()){
                    if(e instanceof InvestmentEnterprise){
                        for(WorkRequest w: organization.getWorkQueue().getWorkRequestList()){
                            InvestmentWorkRequest iw = (InvestmentWorkRequest)w;                  
                            if(iw.getInvestmentEnterprise().equalsIgnoreCase(e.getName())){
                                totalAmount += iw.getAmount();
                            }
                        }
                    dataset.setValue(totalAmount, "Amount", e.getName());
                    totalAmount = 0;
                    }
                }         
                dataset.setValue(42, "Amount", "Goldman Sachs");
                dataset.setValue(18, "Amount", "Vanguard");
            }           
        if(s.equalsIgnoreCase("Best Companion(According to Investment Power)")){
            double serviceFeeBase = 0;
            for(Enterprise enterprise: ecoSystem.getEnterpriseNetwork().getEnterpriseList()){
                if(enterprise instanceof InvestmentEnterprise){
                    for(WorkRequest w: organization.getWorkQueue().getWorkRequestList()){
                        InvestmentWorkRequest iw = (InvestmentWorkRequest)w;                  
                        if(iw.getInvestmentEnterprise().equalsIgnoreCase(enterprise.getName())){
                            for(Deal deal: iw.getDealRecord().getDealRecord()){
                                serviceFeeBase += deal.getDealAmount() * deal.getDealPrice();
                            }
                        }
                    }              
                    dataset.setValue(serviceFeeBase, "USD", enterprise.getName());
                }
            }
            dataset.setValue(120000, "USD", "Goldman Sachs");
            dataset.setValue(35000, "USD", "Vanguard");
        }
        String a = "USD$";
        if(s.equalsIgnoreCase("Total Amount(Buy + Sell)")) a = "Amount";
        JFreeChart barChart = ChartFactory.createBarChart(s, "Investment Enterprise", a, dataset, PlotOrientation.VERTICAL,false, true, false);
        CategoryPlot barchrt = barChart.getCategoryPlot();
        barchrt.setRangeGridlinePaint(Color.YELLOW);
        barchrt.setBackgroundPaint(Color.BLACK);
//        barchrt.getRangeAxis().setRange(6000, 9000);
        
        ChartPanel barPanel = new ChartPanel(barChart);
        jPanel2.removeAll();
        jPanel2.add(barPanel, BorderLayout.CENTER);
        jPanel2.validate();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        analysisComboBox = new javax.swing.JComboBox();
        back = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        jSplitPane1.setDividerLocation(150);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        jLabel4.setFont(new java.awt.Font("新細明體", 0, 36)); // NOI18N
        jLabel4.setText("Analysis ");

        analysisComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analysisComboBoxActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(analysisComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(back))
                .addGap(138, 138, 138)
                .addComponent(jLabel4)
                .addContainerGap(265, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(back)
                        .addGap(18, 18, 18)
                        .addComponent(analysisComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());
        jSplitPane1.setRightComponent(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void analysisComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analysisComboBoxActionPerformed
        String s = (String) analysisComboBox.getSelectedItem();
        if (s != null){
            populateChart(s);
        }
    }//GEN-LAST:event_analysisComboBoxActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
         userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox analysisComboBox;
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables
}
