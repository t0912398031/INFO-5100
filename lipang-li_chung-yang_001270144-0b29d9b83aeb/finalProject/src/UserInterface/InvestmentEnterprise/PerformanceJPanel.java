package UserInterface.InvestmentEnterprise;

import UserInterface.AdminRole.*;
import Business.EcoSystem;
import Business.Enterprise.DepositEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.InvestmentEnterprise;
import Business.Finance.CoinTransaction.Transaction;
import Business.Finance.Deal;
import Business.Organization.InvestmentOrg;
import Business.Organization.Organization;
import Business.Organization.TransactionOrg;
import Business.Role.Role;
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


public class PerformanceJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageEnterpriseNetworkJPanel
     */
    private EcoSystem ecoSystem;
    private JPanel userProcessContainer;
    private InvestmentOrg org;

    public PerformanceJPanel(JPanel userProcessContainer, InvestmentOrg org, EcoSystem ecoSystem) {
        initComponents();
        setSize(800, 600);
        this.ecoSystem = ecoSystem;
        this.userProcessContainer = userProcessContainer;
        this.org = org;
        populateChart();
        setBackground(new java.awt.Color(204, 255, 204));
    }

    private void populateChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        DepositEnterprise depositEnterprise = (DepositEnterprise) ecoSystem.getEnterpriseNetwork().searchByName("Universal Bank");
        TransactionOrg transactionOrg = (TransactionOrg) depositEnterprise.getOrganizationDirectory().searchOrgByType(Organization.Type.Transaction);
        double currentAveragePrice = transactionOrg.getCurrentAveragePrice();
        double profit = 0;

        for (UserAccount ua : org.getUserAccountDirectory().getUserAccountList()) {
            if (ua.getRole().getType() == Role.Type.InvestmentAssistant) {
                for (WorkRequest workRequest : ua.getWorkQueue().getWorkRequestList()) {
                    InvestmentWorkRequest iw = (InvestmentWorkRequest) workRequest;
                    if (iw.getType().equalsIgnoreCase("Buy")) {
                        for (Deal deal : iw.getDealRecord().getDealRecord()) {
                            profit += (currentAveragePrice - deal.getDealPrice()) * deal.getDealAmount();
                        }
                    } else if (iw.getType().equalsIgnoreCase("Sell")) {
                        for (Deal deal : iw.getDealRecord().getDealRecord()) {
                            profit += (deal.getDealPrice() - currentAveragePrice) * deal.getDealAmount();
                        }
                    }
                }
                dataset.setValue(profit, "USD", ua.getEmployee().getName());
                profit = 0;
            }
        }
        dataset.setValue(390, "USD", "Investment Assistant 3");
        dataset.setValue(-50, "USD", "Investment Assistant 4");

        JFreeChart barChart = ChartFactory.createBarChart("Profit and Loss", "Employee", "USD$", dataset, PlotOrientation.VERTICAL, false, true, false);
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
        back = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        jSplitPane1.setDividerLocation(150);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel4.setFont(new java.awt.Font("新細明體", 0, 24)); // NOI18N
        jLabel4.setText("Investment Assistant Performance");

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
                .addContainerGap()
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(906, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(back))
                .addContainerGap(92, Short.MAX_VALUE))
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
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables
}
