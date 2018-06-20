/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.InvestmentAssistant;
import Business.Role.InvestmentManager;
import Business.Role.CustomerServiceManager;
import Business.Role.Role;
import Business.Role.TradingManager;
import java.util.ArrayList;

/**
 *
 * @author Chung-Yang Li
 */
public class CustomerServiceOrg extends Organization{

    public CustomerServiceOrg() {
        super(Organization.Type.CustomerService.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new CustomerServiceManager());
        return roles;
    }
    
    
}
