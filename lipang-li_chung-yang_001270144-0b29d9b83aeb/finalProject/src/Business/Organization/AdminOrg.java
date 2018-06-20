/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.EnterpriseAdmin;
import Business.Role.Role;
import Business.Role.SystemAdmin;
import java.util.ArrayList;

/**
 *
 * @author lingfengzhou
 */
public class AdminOrg extends Organization{
    
    public AdminOrg() {
        super(Organization.Type.Admin.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new EnterpriseAdmin());
        roles.add(new SystemAdmin());
        return roles;
    }
    
}
