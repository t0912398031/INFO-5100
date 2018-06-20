/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.LogisticsOrg;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.BitCoinMall.PurchaserWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author JIN
 */
public class Purchaser  extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem ecoSystem) {
    return new PurchaserWorkAreaJPanel(userProcessContainer, account, (LogisticsOrg)organization, enterprise, ecoSystem);
    } //To change body of generated methods, choose Tools | Templates.

    @Override
    public Type getType() {
        return Role.Type.Purchaser;
    }
    
    @Override
    public String toString() {   
        return Role.Type.Purchaser.getValue();
    }
    
    
}
