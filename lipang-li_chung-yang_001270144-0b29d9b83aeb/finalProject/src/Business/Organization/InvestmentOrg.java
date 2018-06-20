/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.InvestmentAssistant;
import Business.Role.InvestmentManager;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author lingfengzhou
 */
public class InvestmentOrg extends Organization{
    
    public InvestmentOrg() {
        super(Organization.Type.Investment.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new InvestmentManager());
        roles.add(new InvestmentAssistant());
        return roles;
    }
    
    
}
