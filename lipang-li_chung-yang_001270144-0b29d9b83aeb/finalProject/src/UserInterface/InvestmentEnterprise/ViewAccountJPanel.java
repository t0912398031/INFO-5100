/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.InvestmentEnterprise;

import Business.EcoSystem;
import Business.Enterprise.DepositEnterprise;
import Business.Enterprise.Enterprise;
import UserInterface.CommonUse.*;
import Business.Enterprise.InvestmentEnterprise;
import Business.Finance.Deal;
import Business.Finance.Property.Coin;
import Business.WorkQueue.InvestmentWorkRequest;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Chung-Yang Li
 */
public class ViewAccountJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private DepositEnterprise depositEnterprise;
    private EcoSystem ecoSystem;
    private double balance;
    public ViewAccountJPanel(JPanel userProcessContainer, Enterprise enterprise, EcoSystem ecoSystem) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.ecoSystem = ecoSystem;
        
        depositEnterprise = (DepositEnterprise)ecoSystem.getEnterpriseNetwork().searchByName("Universal Bank");
        popBitcoin();
        popBalance();
        setBackground(new java.awt.Color(204, 255, 204));
        
    }
    
    private void popBitcoin(){
        DefaultTableModel model = (DefaultTableModel) dealTable.getModel();   
        model.setRowCount(0); 
        for(Coin coin: depositEnterprise.getAccountInfo(enterprise.getName()).getCoinCollection().getCoinList()){
            Object[] row = new Object[3];
            row[0] = coin.getCoinKey();
            row[1] = coin.getPrevOwnership();
            row[2] = coin.getCurOwnership();         
            model.addRow(row);          
        }
        txtBitcoin.setText(String.valueOf(depositEnterprise.getAccountInfo(enterprise.getName()).getCoinCollection().getCoinList().size()));
    }
    
      public void popBalance(){
//        DepositEnterprise depositEnterprise = (DepositEnterprise)ecoSystem.getEnterpriseNetwork().searchByName("Universal Bank");
//        
//        for(FinancialAccount financialAccount: depositEnterprise.getFinancialAccountDirectory().getFinancialAccountList()){
//            if(financialAccount.getName().equalsIgnoreCase(enterprise.getName())) balance = financialAccount.getDollorAccount();
//        }
        balance = depositEnterprise.getAccountInfo(enterprise.getName()).getDollorAccount();   
        txtBalance.setText("$"+String.valueOf(balance));      
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        dealTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtBalance = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtBitcoin = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        back = new javax.swing.JButton();

        dealTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Key Number", "Previous Owner", "Currnet Owner"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(dealTable);

        jLabel4.setFont(new java.awt.Font("新細明體", 0, 24)); // NOI18N
        jLabel4.setText("View Account");

        txtBalance.setFont(new java.awt.Font("新細明體", 0, 18)); // NOI18N
        txtBalance.setEnabled(false);
        txtBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBalanceActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("新細明體", 0, 18)); // NOI18N
        jLabel1.setText("Balance:");

        txtBitcoin.setFont(new java.awt.Font("新細明體", 0, 18)); // NOI18N
        txtBitcoin.setEnabled(false);
        txtBitcoin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBitcoinActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("新細明體", 0, 18)); // NOI18N
        jLabel2.setText("Bitcoin:");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtBitcoin, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(back)
                        .addGap(119, 119, 119)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(257, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(back))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtBitcoin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(177, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBalanceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBalanceActionPerformed

    private void txtBitcoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBitcoinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBitcoinActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
         userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JTable dealTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JTextField txtBitcoin;
    // End of variables declaration//GEN-END:variables
}
