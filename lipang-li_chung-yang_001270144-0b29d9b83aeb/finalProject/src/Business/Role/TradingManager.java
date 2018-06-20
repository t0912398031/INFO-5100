/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.TradingOrg;
import Business.UserAccount.UserAccount;
import UserInterface.CustodianEnterprise.TradingManagerWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author lingfengzhou
 */
public class TradingManager extends  Role{

//    @Override
//    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise) {
//        return new TradingJPanel(userProcessContainer, account, (TradingOrg)organization, enterprise);
//    }
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem ecoSystem) {
        return new TradingManagerWorkAreaJPanel(userProcessContainer, account, (TradingOrg)organization, enterprise, ecoSystem);
    }
    @Override
    public String toString() {   
        return Role.Type.TradingManager.getValue();
    }

    @Override
    public Type getType() {
        return Role.Type.TradingManager;
    }
}
