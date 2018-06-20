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
import UserInterface.CustodianEnterprise.AccountingJPanel;
import UserInterface.CustodianEnterprise.AccountingWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author lingfengzhou
 */
public class AccountingAssistant extends Role{

//    @Override
//    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise) {
//        return new AccountingJPanel(userProcessContainer, account, (AccountingOrg)organization, enterprise);
//    }
      @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem ecoSystem) {
        return new AccountingWorkAreaJPanel(userProcessContainer, account, (AccountingOrg)organization, enterprise, ecoSystem);
    }
    
    
    @Override
    public String toString() {   
        return Role.Type.AccountingAssistant.getValue();
    }

    @Override
    public Type getType() {
        return Role.Type.AccountingAssistant;
    }
    
}
