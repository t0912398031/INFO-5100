/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.CustodianEnterprise;

import UserInterface.AdminRole.*;
import Business.EcoSystem;
import Business.Enterprise.CustodyEnterprise;
import Business.Enterprise.Enterprise;
import Business.Organization.AccountingOrg;
import Business.Organization.AdminOrg;
import Business.Organization.Organization;
import Business.Organization.TradingOrg;
import Business.UserAccount.UserAccount;
import UserInterface.ShortMessage.ShortMessageJPanel;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Chung-Yang Li
 */
public class TradingManagerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AccountingWorkAreaJPanel
     */
    private JPanel upc;
    private TradingOrg organization;
    private UserAccount account;
    private Enterprise enterprise;
    private EcoSystem ecoSystem;
    public TradingManagerWorkAreaJPanel(JPanel upc, UserAccount account, TradingOrg organization, Enterprise enterprise, EcoSystem ecoSystem) {
        initComponents();
        this.upc = upc;
        this.account = account;
        this.organization = organization;
        this.enterprise = enterprise;
        this.ecoSystem = ecoSystem;
        setBackground(new java.awt.Color(255, 255, 153));
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
        btnManageOrg = new javax.swing.JButton();
        InMail = new javax.swing.JButton();
        InMail1 = new javax.swing.JButton();
        lbl_show_thephoto = new javax.swing.JLabel();

        jLabel4.setFont(new java.awt.Font("新細明體", 0, 24)); // NOI18N
        jLabel4.setText("Trading Manager Work Area");

        btnManageOrg.setText("Trading");
        btnManageOrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageOrgActionPerformed(evt);
            }
        });

        InMail.setText("InMail");
        InMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InMailActionPerformed(evt);
            }
        });

        InMail1.setText("Manage Rate");
        InMail1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InMail1ActionPerformed(evt);
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
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnManageOrg, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(InMail, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(InMail1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_show_thephoto)
                        .addGap(71, 71, 71))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnManageOrg)
                        .addGap(18, 18, 18)
                        .addComponent(InMail)
                        .addGap(18, 18, 18)
                        .addComponent(InMail1))
                    .addComponent(lbl_show_thephoto, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(288, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageOrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageOrgActionPerformed
        TradingJPanel mojp = new TradingJPanel(upc, account,organization,enterprise, ecoSystem);
        upc.add("TradingJPanel", mojp);
        CardLayout cardLayout = (CardLayout) upc.getLayout();
        cardLayout.next(upc);// TODO add your handling code here:
    }//GEN-LAST:event_btnManageOrgActionPerformed

    private void InMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InMailActionPerformed
        ShortMessageJPanel smjp = new ShortMessageJPanel(upc, account, ecoSystem);
        upc.add("ShortMessageJPanel_SysAdmin", smjp);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.next(upc);
    }//GEN-LAST:event_InMailActionPerformed

    private void InMail1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InMail1ActionPerformed
        CustodyEnterprise ce = (CustodyEnterprise)enterprise;
        ManageRateJPanel smjp = new ManageRateJPanel(upc, ce, ecoSystem);
        upc.add("ManageRateJPanel", smjp);
        CardLayout layout = (CardLayout) upc.getLayout();
        layout.next(upc);// TODO add your handling code here:
    }//GEN-LAST:event_InMail1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton InMail;
    private javax.swing.JButton InMail1;
    private javax.swing.JButton btnManageOrg;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbl_show_thephoto;
    // End of variables declaration//GEN-END:variables
}