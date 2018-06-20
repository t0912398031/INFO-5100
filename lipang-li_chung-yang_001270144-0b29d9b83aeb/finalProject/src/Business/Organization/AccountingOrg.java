/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.AccountingAssistant;
import Business.Role.AccountingManager;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author lingfengzhou
 */
public class AccountingOrg extends Organization{
    
    public AccountingOrg() {
        super(Organization.Type.Accounting.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new AccountingManager());
        roles.add(new AccountingAssistant());
        return roles;
    }
    
}
