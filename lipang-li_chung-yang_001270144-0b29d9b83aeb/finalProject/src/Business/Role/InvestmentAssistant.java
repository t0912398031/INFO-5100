/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.InvestmentOrg;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.InvestmentEnterprise.InvestmentAssistantWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author lingfengzhou, Chung-Yang Li
 */
public class InvestmentAssistant extends Role{

//    @Override
//    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise) {
//        return new InvestmentAssistantWorkAreaJPanel(userProcessContainer, account, (InvestmentOrg)organization, enterprise);
//    }
      @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem ecoSystem) {
        return new InvestmentAssistantWorkAreaJPanel(userProcessContainer, account, (InvestmentOrg)organization, enterprise, ecoSystem);
    }
    
    @Override
    public String toString() {   
        return Role.Type.InvestmentAssistant.getValue();
    }
    
    public Role.Type getType(){
        return Role.Type.InvestmentAssistant;
    }
}
