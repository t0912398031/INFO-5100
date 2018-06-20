/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.AdminOrg;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.AdminRole.EnterpriseAdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author lingfengzhou
 */
public class EnterpriseAdmin extends Role{

//    @Override
//    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise) {
//        return new EnterpriseAdminWorkAreaJPanel(userProcessContainer, account, (AdminOrg)organization, enterprise);
//    }
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise,EcoSystem ecoSystem) {
        return new EnterpriseAdminWorkAreaJPanel(userProcessContainer, account, (AdminOrg)organization, enterprise, ecoSystem);
    }
    
    @Override
    public String toString() {   
        return Role.Type.EnterpriseAdmin.getValue();
    }

    @Override
    public Type getType() {
        return Role.Type.EnterpriseAdmin;
    }
}
