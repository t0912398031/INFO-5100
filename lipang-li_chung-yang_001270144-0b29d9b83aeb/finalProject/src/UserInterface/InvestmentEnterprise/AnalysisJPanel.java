/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.InvestmentEnterprise;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.InvestmentEnterprise;
import Business.Finance.Deal;
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
    private Enterprise enterprise;
    public AnalysisJPanel(JPanel userProcessContainer, Enterprise enterprise, EcoSystem ecoSystem) {
        initComponents();
        setSize(800,600);
        this.enterprise = enterprise;
        this.ecoSystem = ecoSystem;
        this.userProcessContainer = userProcessContainer;
        populateAnalysisComboBox();
    }
    
    public void populateAnalysisComboBox() {       
        analysisComboBox.addItem("Revenues");
        analysisComboBox.addItem("Expenditures");
        analysisComboBox.addItem("TotalRevenues");
        analysisComboBox.addItem("TotalExpenditures");
        populateChart(enterprise);        
    }
    private void populateChart(Enterprise e){
        InvestmentEnterprise enterprise = (InvestmentEnterprise)e;
        String s = (String) analysisComboBox.getSelectedItem();
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();        
        if(s.equalsIgnoreCase("Revenues")){
            dataset.setValue(15000, "USD", enterprise.getEarnedRecords().getRevenueList().get(0).getDealDate().minusDays(2));
            dataset.setValue(28000, "USD", enterprise.getEarnedRecords().getRevenueList().get(0).getDealDate().minusDays(1));
            for(Deal deal: enterprise.getEarnedRecords().getRevenueList()){
                dataset.setValue(deal.getDealPrice(), "USD", deal.getDealDate());
            }      
        }
        else if(s.equalsIgnoreCase("Expenditures")){
            dataset.setValue(27000, "USD", enterprise.getSpentRecords().getRevenueList().get(0).getDealDate().minusDays(2));
            dataset.setValue(22000, "USD", enterprise.getSpentRecords().getRevenueList().get(0).getDealDate().minusDays(1));
            for(Deal deal: enterprise.getSpentRecords().getRevenueList()){
                dataset.setValue(deal.getDealPrice(), "USD", deal.getDealDate());
            }   
        }
        else if(s.equalsIgnoreCase("TotalRevenues")){
            dataset.setValue(15000, "USD", enterprise.getEarnedRecords().getRevenueList().get(0).getDealDate().minusDays(2));
            dataset.setValue(43000, "USD", enterprise.getEarnedRecords().getRevenueList().get(0).getDealDate().minusDays(1));
            double tempTotalEarned =49000;
            for(int i = 0; i< enterprise.getEarnedRecords().getRevenueList().size();i++){          
                tempTotalEarned += enterprise.getEarnedRecords().getRevenueList().get(i).getDealPrice();           
                dataset.setValue(tempTotalEarned, "USD", enterprise.getEarnedRecords().getRevenueList().get(i).getDealDate());
            }   
        }
        else if(s.equalsIgnoreCase("TotalExpenditures")){
            dataset.setValue(27000, "USD", enterprise.getSpentRecords().getRevenueList().get(0).getDealDate().minusDays(2));
            dataset.setValue(49000, "USD", enterprise.getSpentRecords().getRevenueList().get(0).getDealDate().minusDays(1));
            double tempTotalSpent =49000;
            for(int i = 0; i< enterprise.getSpentRecords().getRevenueList().size();i++){          
                tempTotalSpent += enterprise.getSpentRecords().getRevenueList().get(i).getDealPrice();           
                dataset.setValue(tempTotalSpent, "USD", enterprise.getSpentRecords().getRevenueList().get(i).getDealDate());
            }   
        }
        
        
        
        JFreeChart barChart = ChartFactory.createLineChart(s, "Timeline","USD$", dataset, PlotOrientation.VERTICAL,false, true, false);
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

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(analysisComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(181, 181, 181)
                .addComponent(jLabel4)
                .addContainerGap(273, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(back)
                        .addGap(31, 31, 31)
                        .addComponent(analysisComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
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
            populateChart(enterprise);
//            populateRoleComboBox(organization);
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
