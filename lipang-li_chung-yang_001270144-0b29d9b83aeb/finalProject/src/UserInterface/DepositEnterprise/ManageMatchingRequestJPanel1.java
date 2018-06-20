/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DepositEnterprise;

import Business.ConfigureEcoSystem;
import Business.EcoSystem;
import Business.Enterprise.CustodyEnterprise;
import Business.Enterprise.DepositEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.InvestmentEnterprise;
import Business.Organization.InvestmentOrg;
import Business.Organization.CustomerServiceOrg;
import Business.Organization.Organization;
import Business.Organization.TransactionOrg;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.InvestmentWorkRequest;
import Business.WorkQueue.WorkRequest;
import UserInterface.CommonUse.CheckProgress;
import static com.sun.javafx.runtime.SystemProperties.getCodebase;
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import javax.rmi.CORBA.Util;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Chung-Yang Li
 */
public class ManageMatchingRequestJPanel1 extends javax.swing.JPanel {

    /**
     * Creates new form AccountingAssistantWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private TransactionOrg matchingOrg;
    private DepositEnterprise enterprise;
    private EcoSystem ecoSystem;
    private Boolean alreadyMatched;
    private Image background;
    private JLabel JbackGroundImage;
    public ManageMatchingRequestJPanel1(JPanel userProcessContainer, UserAccount account, TransactionOrg matchingOrg, Enterprise enterprise, EcoSystem ecoSystem) {
        initComponents();
        setSize(1480,1050);
        this.account = account;
        this.userProcessContainer =userProcessContainer;
        this.matchingOrg = matchingOrg;
        this.enterprise = (DepositEnterprise)enterprise;
        this.ecoSystem = ecoSystem;
        populateBuyTable();
        populateSellTable();
        populateAveragePrice();
        this.alreadyMatched = false;
        setUpBackground();
    }
    private void populateBuyTable(){
    DefaultTableModel model = (DefaultTableModel) marketBuyJTable.getModel();   
    model.setRowCount(0);

    for (WorkRequest request : matchingOrg.getWorkQueue().getWorkRequestList()){
        InvestmentWorkRequest workRequest = (InvestmentWorkRequest)request;
        if(workRequest.getType().equalsIgnoreCase("Buy")){
            Object[] row = new Object[7];
            row[0] = workRequest;
            row[1] = workRequest.getType();
            row[2] = workRequest.getPrice();
            row[3] = workRequest.getInitialAmount();
            row[4] = workRequest.getAmount();
            row[5] = workRequest.getRequestDate();
            row[6] = workRequest.getStatus();           
            model.addRow(row);
        }
    }
    }
        
    private void populateSellTable(){
    DefaultTableModel model = (DefaultTableModel) marketSellJTable.getModel();   
    model.setRowCount(0);

        for (WorkRequest request : matchingOrg.getWorkQueue().getWorkRequestList()){
            InvestmentWorkRequest workRequest = (InvestmentWorkRequest)request;
            if(workRequest.getType().equalsIgnoreCase("Sell")){
                Object[] row = new Object[7];
                row[0] = workRequest;
                row[1] = workRequest.getType();
                row[2] = workRequest.getPrice();
                row[3] = workRequest.getInitialAmount();
                row[4] = workRequest.getAmount();
                row[5] = workRequest.getRequestDate();
                row[6] = workRequest.getStatus();         
                model.addRow(row);
            }
        }
    }  
    
    private void populateAveragePrice(){
        double dailyAveragePrice = 0.0;

        if(matchingOrg.getPricehistory().getDailyTransactionPriceList().size() == 0) {
            txtMarketDailyPrice.setText("0.00"); return;
        }
        if(Double.isNaN(matchingOrg.getAverageHistoryPrice())) {
            txtMarketPrice.setText("Undefined"); return;
        }
        else {
            if(!matchingOrg.getPricehistory().getDailyTransactionPriceList().isEmpty())               
                
                dailyAveragePrice = matchingOrg.getPricehistory().getDailyTransactionPriceList().get(matchingOrg.getPricehistory().getDailyTransactionPriceList().size()-1).getDealPrice();
                DecimalFormat df=new DecimalFormat("#.##");
                String dap=df.format(dailyAveragePrice);  
                String ap=df.format(matchingOrg.getAverageHistoryPrice());
                txtMarketDailyPrice.setText(dap);
                txtMarketPrice.setText(ap);
        }
    }
    private void setUpBackground(){   
        ImageIcon myImage = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("bitcoins.jpg")));
        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(1480, 1050, Image.SCALE_SMOOTH);
        
        jLabel6.setSize(1480, 1050);
        ImageIcon image = new ImageIcon(newImg);
        jLabel6.setIcon(image);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMarketDailyPrice = new javax.swing.JTextField();
        txtMarketPrice = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        marketBuyJTable = new javax.swing.JTable();
        btnMatch1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        marketSellJTable = new javax.swing.JTable();
        btnMatch2 = new javax.swing.JButton();
        btnMatch3 = new javax.swing.JButton();
        btnMatch = new javax.swing.JButton();
        checkBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1680, 1050));
        setLayout(null);

        backBtn.setBackground(new java.awt.Color(255, 255, 255));
        backBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/BitCoinMall/picture/back.png"))); // NOI18N
        backBtn.setText(" Back");
        backBtn.setIconTextGap(10);
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        add(backBtn);
        backBtn.setBounds(20, 20, 120, 45);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 28)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Manage Matching Request");
        add(jLabel4);
        jLabel4.setBounds(170, 20, 390, 50);

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Daily Average Price:");
        add(jLabel5);
        jLabel5.setBounds(560, 40, 210, 22);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Market Average Price:");
        add(jLabel3);
        jLabel3.setBounds(560, 80, 220, 22);

        txtMarketDailyPrice.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtMarketDailyPrice.setText("Undefined");
        txtMarketDailyPrice.setEnabled(false);
        add(txtMarketDailyPrice);
        txtMarketDailyPrice.setBounds(760, 40, 120, 32);

        txtMarketPrice.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        txtMarketPrice.setText("Undefined");
        txtMarketPrice.setEnabled(false);
        txtMarketPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarketPriceActionPerformed(evt);
            }
        });
        add(txtMarketPrice);
        txtMarketPrice.setBounds(760, 80, 120, 32);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Buy:");
        add(jLabel2);
        jLabel2.setBounds(20, 90, 100, 28);

        marketBuyJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Work Number", "Type", "Price", "Initial Amount", "Amount", "Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(marketBuyJTable);

        add(jScrollPane1);
        jScrollPane1.setBounds(20, 130, 800, 150);

        btnMatch1.setBackground(new java.awt.Color(255, 255, 255));
        btnMatch1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnMatch1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/BitCoinMall/picture/OK.png"))); // NOI18N
        btnMatch1.setText("Suspend/Unsuspend");
        btnMatch1.setIconTextGap(10);
        btnMatch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatch1ActionPerformed(evt);
            }
        });
        add(btnMatch1);
        btnMatch1.setBounds(620, 290, 200, 40);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sell:");
        add(jLabel1);
        jLabel1.setBounds(20, 290, 100, 28);

        marketSellJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Work Number", "Type", "Price", "Initial Amount", "Amount", "Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(marketSellJTable);

        add(jScrollPane2);
        jScrollPane2.setBounds(20, 340, 800, 160);

        btnMatch2.setBackground(new java.awt.Color(255, 255, 255));
        btnMatch2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnMatch2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/BitCoinMall/picture/OK - green.png"))); // NOI18N
        btnMatch2.setText("Suspend/Unsuspend");
        btnMatch2.setIconTextGap(10);
        btnMatch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatch2ActionPerformed(evt);
            }
        });
        add(btnMatch2);
        btnMatch2.setBounds(630, 510, 190, 42);

        btnMatch3.setBackground(new java.awt.Color(255, 255, 255));
        btnMatch3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnMatch3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/BitCoinMall/picture/update.png"))); // NOI18N
        btnMatch3.setText("Update");
        btnMatch3.setIconTextGap(10);
        btnMatch3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatch3ActionPerformed(evt);
            }
        });
        add(btnMatch3);
        btnMatch3.setBounds(20, 510, 160, 50);

        btnMatch.setBackground(new java.awt.Color(255, 255, 255));
        btnMatch.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnMatch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/BitCoinMall/picture/match.png"))); // NOI18N
        btnMatch.setText("Match");
        btnMatch.setIconTextGap(10);
        btnMatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatchActionPerformed(evt);
            }
        });
        add(btnMatch);
        btnMatch.setBounds(680, 560, 140, 50);

        checkBtn.setBackground(new java.awt.Color(255, 255, 255));
        checkBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        checkBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/BitCoinMall/picture/confrim.png"))); // NOI18N
        checkBtn.setText("Check");
        checkBtn.setIconTextGap(10);
        checkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBtnActionPerformed(evt);
            }
        });
        add(checkBtn);
        checkBtn.setBounds(680, 620, 140, 50);

        jLabel6.setBounds(new java.awt.Rectangle(0, 0, 1480, 1050));
        add(jLabel6);
        jLabel6.setBounds(-4, 0, 1160, 710);
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed

    private void txtMarketPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarketPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarketPriceActionPerformed

    private void btnMatch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatch1ActionPerformed
        int selectedrow = marketBuyJTable.getSelectedRow();
        if(selectedrow < 0){
            JOptionPane.showMessageDialog(null, "Please select any row");}
        else{
            InvestmentWorkRequest workRequest = (InvestmentWorkRequest) marketBuyJTable.getValueAt(selectedrow, 0);
            if(workRequest.getStatus().equalsIgnoreCase("Ready to trade")){
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "Suspend selected workrequest?", "Warning", dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION){
                    workRequest.setStatus("Suspended");
                    populateBuyTable();
                    populateSellTable();
                }
            }
            else if(workRequest.getStatus().equalsIgnoreCase("Suspended")){
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "Unsuspend selected workrequest?", "Warning", dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION){
                    workRequest.setStatus("Ready to trade");
                    populateBuyTable();
                    populateSellTable();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Unable to suspend selected workrequest", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMatch1ActionPerformed

    private void btnMatch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatch2ActionPerformed
        int selectedrow = marketSellJTable.getSelectedRow();
        if(selectedrow < 0){
            JOptionPane.showMessageDialog(null, "Please select any row");}
        else{
            InvestmentWorkRequest workRequest = (InvestmentWorkRequest) marketSellJTable.getValueAt(selectedrow, 0);
            if(workRequest.getStatus().equalsIgnoreCase("Ready to trade")){
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "Suspend selected workrequest?", "Warning", dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION){
                    workRequest.setStatus("Suspended");
                    populateBuyTable();
                    populateSellTable();
                }
            }
            else if(workRequest.getStatus().equalsIgnoreCase("Suspended")){
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "Unsuspend selected workrequest?", "Warning", dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION){
                    workRequest.setStatus("Ready to trade");
                    populateBuyTable();
                    populateSellTable();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Unable to suspend selected workrequest", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }   // TODO add your handling code here:
    }//GEN-LAST:event_btnMatch2ActionPerformed

    private void btnMatch3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatch3ActionPerformed
        Organization io = null;
        for(Enterprise enterprise: ecoSystem.getEnterpriseNetwork().getEnterpriseList()){
            if(enterprise instanceof CustodyEnterprise && enterprise.getName().equalsIgnoreCase("custodyEnterprise 1")){
                for(Organization investOrg: enterprise.getOrganizationDirectory().getOrganizationList()){
                    if(investOrg instanceof CustomerServiceOrg) {
                        io = investOrg;
                    }
                }
            }
        }
        for(Enterprise enterprise: ecoSystem.getEnterpriseNetwork().getEnterpriseList()){
            if(enterprise instanceof InvestmentEnterprise && enterprise.getName().equalsIgnoreCase("Mogan")){
                for(Organization investOrg: enterprise.getOrganizationDirectory().getOrganizationList()){
                    if(investOrg instanceof InvestmentOrg) {
                        ConfigureEcoSystem.uploadExistedOrder2(matchingOrg, investOrg, io);
                        JOptionPane.showMessageDialog(null, "Update successfully", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        }
        populateBuyTable();
        populateSellTable();
    }//GEN-LAST:event_btnMatch3ActionPerformed

    private void btnMatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatchActionPerformed
        for(int i = 0; i<marketBuyJTable.getRowCount(); i++){
            InvestmentWorkRequest buyRequest = (InvestmentWorkRequest) marketBuyJTable.getValueAt(i, 0);
            if(buyRequest.getStatus().matches("Ready to trade|Trading")){
                for(int j = 0; j<marketSellJTable.getRowCount(); j++){
                    InvestmentWorkRequest sellRequest = (InvestmentWorkRequest) marketSellJTable.getValueAt(j, 0);
                    if(sellRequest.getStatus().matches("Ready to trade|Trading"))
                    enterprise.matchTradingRequest(buyRequest, sellRequest, ecoSystem);
                    populateBuyTable();
                    populateSellTable();
                }
            }
        }
        /** calculateAverageTransactionPrice **/
        matchingOrg.calculateAveragePrice();
        for(Enterprise enterprise: ecoSystem.getEnterpriseNetwork().getEnterpriseList()){
            if (enterprise instanceof InvestmentEnterprise) {
                /** calculateTotalDealPrice **/
                matchingOrg.getWorkQueue().calculateTotalBuyDealPrice((InvestmentEnterprise)enterprise);
                /** calculateSpentAndEarnEachMatch **/
                InvestmentEnterprise ie = (InvestmentEnterprise)enterprise;
                ie.calculateSpentAndEarnEachMatch();
            }
        }
        populateBuyTable();
        populateSellTable();
        populateAveragePrice();
        alreadyMatched = true;
        JOptionPane.showMessageDialog(null, "Matched successfully");
    }//GEN-LAST:event_btnMatchActionPerformed

    private void checkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBtnActionPerformed
        int selectedRow = marketBuyJTable.getSelectedRow();
        WorkRequest workRequest = (WorkRequest) marketBuyJTable.getValueAt(selectedRow, 0);
        CheckProgress checkProgress = new CheckProgress(workRequest);
        checkProgress.setVisible(true);
    }//GEN-LAST:event_checkBtnActionPerformed
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton btnMatch;
    private javax.swing.JButton btnMatch1;
    private javax.swing.JButton btnMatch2;
    private javax.swing.JButton btnMatch3;
    private javax.swing.JButton checkBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable marketBuyJTable;
    private javax.swing.JTable marketSellJTable;
    private javax.swing.JTextField txtMarketDailyPrice;
    private javax.swing.JTextField txtMarketPrice;
    // End of variables declaration//GEN-END:variables
}
