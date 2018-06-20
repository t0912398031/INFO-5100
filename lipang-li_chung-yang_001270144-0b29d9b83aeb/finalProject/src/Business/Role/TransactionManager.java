/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.TransactionOrg;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.DepositEnterprise.TransactionManagerWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Chung-Yang Li
 */
public class TransactionManager extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem ecoSystem) {
        return new TransactionManagerWorkAreaJPanel(userProcessContainer, account, (TransactionOrg)organization, enterprise, ecoSystem);
    }
    @Override
    public String toString() {   
        return Role.Type.TransactionManager.getValue();
    }

    @Override
    public Type getType() {
        return Role.Type.TransactionManager;
    }
    
}
