/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.InvestmentEnterprise;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.InvestmentEnterprise;
import Business.Organization.AccountingOrg;
import Business.UserAccount.UserAccount;
import UserInterface.ShortMessage.ShortMessageJPanel;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author lingfengzhou
 */
public class AccountingManagerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AccountingManagerWorkAreaJPanel
     */
    private JPanel upc;
    private AccountingOrg accountingOrg;
    private UserAccount account;
    private Enterprise enterprise;
    private EcoSystem ecoSystem;
    public AccountingManagerWorkAreaJPanel(JPanel upc, UserAccount account, AccountingOrg organization, Enterprise enterprise, EcoSystem ecoSystem) {
        initComponents();
        this.upc = upc;
        this.account = account;
        this.accountingOrg = organization;
        this.enterprise = enterprise;
        this.ecoSystem = ecoSystem;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        myBtn = new javax.swing.JButton();
        imBtn = new javax.swing.JButton();
        imBtn1 = new javax.swing.JButton();
        lbl_show_thephoto = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setText("Accounting Manager Work Area");

        myBtn.setText("My Work");
        myBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myBtnActionPerformed(evt);
            }
        });

        imBtn.setText("InMail");
        imBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imBtnActionPerformed(evt);
            }
        });

        imBtn1.setText("View Account");
        imBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imBtn1ActionPerformed(evt);
            }
        });

        lbl_show_thephoto.setBackground(new java.awt.Color(255, 255, 204));
        lbl_show_thephoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/manager.png"))); // NOI18N
        lbl_show_thephoto.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(myBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(imBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(imBtn1, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_show_thephoto)
                        .addGap(160, 160, 160))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(myBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(imBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(imBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_show_thephoto, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(276, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void myBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myBtnActionPerformed
        AccountingManagerWorkQueueJPanel amwqjp = new AccountingManagerWorkQueueJPanel(upc, account, accountingOrg, enterprise, ecoSystem);
        upc.add("amwqjp", amwqjp);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.next(upc);
    }//GEN-LAST:event_myBtnActionPerformed

    private void imBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imBtnActionPerformed
        ShortMessageJPanel smjp = new ShortMessageJPanel(upc, account, ecoSystem);
        upc.add("ShortMessageJPanel_SysAdmin", smjp);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.next(upc);
    }//GEN-LAST:event_imBtnActionPerformed

    private void imBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imBtn1ActionPerformed
        InvestmentEnterprise ie = (InvestmentEnterprise) enterprise;
        ViewAccountJPanel smjp = new ViewAccountJPanel(upc, ie, ecoSystem);
        upc.add("ViewAccountJPanel", smjp);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.next(upc);        // TODO add your handling code here:
    }//GEN-LAST:event_imBtn1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton imBtn;
    private javax.swing.JButton imBtn1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_show_thephoto;
    private javax.swing.JButton myBtn;
    // End of variables declaration//GEN-END:variables
}
