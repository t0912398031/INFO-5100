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
import UserInterface.SystemMantenanceEnterprise.SystemAdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author lingfengzhou
 */
public class SystemAdmin extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization,Enterprise enterprise, EcoSystem ecoSystem) {
            return new SystemAdminWorkAreaJPanel(userProcessContainer, account, (AdminOrg)organization,enterprise, ecoSystem);
    }
    @Override
    public String toString() {   
        return Role.Type.SystemAdmin.getValue();
    }

    @Override
    public Type getType() {
        return Role.Type.SystemAdmin;
    }
}
