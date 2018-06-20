/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.AccountingOrg;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.InvestmentEnterprise.AccountingManagerWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author lingfengzhou, Chung-Yang Li
 */
public class AccountingManager extends Role{

//    @Override
//    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise) {
//        return new AccountingManagerWorkAreaJPanel(userProcessContainer, account, (AccountingOrg)organization, enterprise);
//    }
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem ecoSystem) {
        return new AccountingManagerWorkAreaJPanel(userProcessContainer, account, (AccountingOrg)organization, enterprise, ecoSystem);
    }
    
    
    @Override
    public String toString() {   
        return Role.Type.AccountingManager.getValue();
    }

    @Override
    public Type getType() {
        return Role.Type.AccountingManager;
    }
}
