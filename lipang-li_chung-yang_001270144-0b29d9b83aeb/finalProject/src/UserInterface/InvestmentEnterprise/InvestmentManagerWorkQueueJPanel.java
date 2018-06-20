/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.InvestmentEnterprise;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.AccountingOrg;
import Business.Organization.InvestmentOrg;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.InvestmentWorkRequest;
import Business.WorkQueue.WorkRequest;
import UserInterface.CommonUse.CheckProgress;
import UserInterface.CommonUse.MarketInfo;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Chung-Yang Li
 */
public class InvestmentManagerWorkQueueJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdminWorkAreaJPanel
     */
    private JPanel upc;
    private InvestmentOrg investmentOrg;
    private UserAccount account;
    private Enterprise enterprise;
    private EcoSystem ecoSystem;
    public InvestmentManagerWorkQueueJPanel(JPanel upc, UserAccount account, InvestmentOrg organization, Enterprise enterprise, EcoSystem ecoSystem) {
        initComponents();
        this.upc = upc;
        this.account = account;
        this.investmentOrg = organization;
        this.enterprise = enterprise;
        this.ecoSystem =ecoSystem;
        populateTable();
        populateMyTable();
        setBackground(new java.awt.Color(204, 255, 204));
    }

    private void populateTable(){
        DefaultTableModel model = (DefaultTableModel) investmentJTable.getModel();   
        model.setRowCount(0);
        
        for (WorkRequest request : investmentOrg.getWorkQueue().getWorkRequestList()){
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
    
    private void populateMyTable(){
        DefaultTableModel model = (DefaultTableModel) myJTable.getModel();   
        model.setRowCount(0);
        
        for (WorkRequest request : investmentOrg.getWorkQueue().getWorkRequestList()){
            if(request.getStatus().equalsIgnoreCase("Established")){
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
        btnConfirm = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        investmentJTable = new javax.swing.JTable();
        back = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        myJTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        checkBtn = new javax.swing.JButton();
        btnAssign1 = new javax.swing.JButton();

        jLabel4.setFont(new java.awt.Font("新細明體", 0, 18)); // NOI18N
        jLabel4.setText("All workrequest:");

        btnConfirm.setBackground(new java.awt.Color(255, 255, 255));
        btnConfirm.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnConfirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/BitCoinMall/picture/next.png"))); // NOI18N
        btnConfirm.setText("Send to Accounting");
        btnConfirm.setIconTextGap(10);
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/BitCoinMall/picture/delete - red.png"))); // NOI18N
        btnDelete.setText("Cancel WorkRequest");
        btnDelete.setIconTextGap(10);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

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

        myJTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(myJTable);

        jLabel5.setFont(new java.awt.Font("新細明體", 0, 24)); // NOI18N
        jLabel5.setText("Investment Work");

        jLabel6.setFont(new java.awt.Font("新細明體", 0, 18)); // NOI18N
        jLabel6.setText("New workrequest:");

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

        btnAssign1.setBackground(new java.awt.Color(255, 255, 255));
        btnAssign1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnAssign1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/BitCoinMall/picture/OK.png"))); // NOI18N
        btnAssign1.setText("Market Info");
        btnAssign1.setIconTextGap(10);
        btnAssign1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssign1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(back))
                        .addGap(87, 87, 87)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnAssign1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelete)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(checkBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(337, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(back)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel4))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAssign1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        int selectedrow = myJTable.getSelectedRow();
        if(selectedrow >=0){
            InvestmentWorkRequest workRequest = (InvestmentWorkRequest) myJTable.getValueAt(selectedrow, 0);
            if(workRequest.getStatus().equalsIgnoreCase("Established")){
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(null, "Send selected workrequest?", "Warning", dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION){            
                    workRequest.setStatus("Pending");
                    Organization org = null;
                    for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
                        if (organization instanceof AccountingOrg){
                            org = organization;
                            break;
                        }
                    }
                    if (org!=null){
                        org.getWorkQueue().addWorkRequest(workRequest);                        
                    }
                    JOptionPane.showMessageDialog(null, "Sent successfully", "Warning", JOptionPane.WARNING_MESSAGE);
                    populateTable();
                    populateMyTable();
                }           
            }
            else{
                JOptionPane.showMessageDialog(null, "Unable to send selected workrequest", "Warning", JOptionPane.WARNING_MESSAGE);
                }
        }
        else{
            JOptionPane.showMessageDialog(null, "Please select any row", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int selectedrow = myJTable.getSelectedRow();
        if(selectedrow >=0){
            InvestmentWorkRequest workRequest = (InvestmentWorkRequest) myJTable.getValueAt(selectedrow, 0);
            if(workRequest.getStatus().equalsIgnoreCase("Established")){
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Cancel selected workrequest?", "Warning", dialogButton);
                if(dialogResult == JOptionPane.YES_OPTION){
                    workRequest.setStatus("Cancelled");
                    JOptionPane.showMessageDialog(null, "Cancelled successfully");  
                    populateTable();
                    populateMyTable();
                }         
            }
            else{
                JOptionPane.showMessageDialog(null, "Unable to cancel selected workrequest", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Please select any row", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        upc.remove(this);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.previous(upc);
    }//GEN-LAST:event_backActionPerformed

    private void checkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBtnActionPerformed
        int selectedRow = investmentJTable.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(upc, "Please select a workrequest from upper TAB!");
            return;
        }
        WorkRequest workRequest = (WorkRequest) investmentJTable.getValueAt(selectedRow, 0);
        CheckProgress checkProgress = new CheckProgress(workRequest);
        checkProgress.setVisible(true);
    }//GEN-LAST:event_checkBtnActionPerformed

    private void btnAssign1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssign1ActionPerformed
        MarketInfo marketInfo = new MarketInfo(ecoSystem);
        marketInfo.setVisible(true);
        
    }//GEN-LAST:event_btnAssign1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton btnAssign1;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton checkBtn;
    private javax.swing.JTable investmentJTable;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable myJTable;
    // End of variables declaration//GEN-END:variables
}
