/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author lingfengzhou, Chung-Yang Li
 */
public abstract class Role {
    
    private String name;
    
    public enum Type {
        SystemAdmin("System Administrator"),//eco-system administrator, manage enterprises
        EnterpriseAdmin("Enterprise Administrator"),//manage Organizations
        AccountingManager("Accounting Manager"),
        AccountingAssistant("Accounting Assistant"),
        InvestmentManager("Investment Manager"),
        InvestmentAssistant("Investment Assistant"),
        Producer("Producer"),

        Purchaser("Purchaser"),
        TradingManager("Trading Manager"),
        TransactionManager("Transaction Manager"),
        CustomerServiceManager("CustomerService Manager");
        
        
        private String value;

        private Type(String value) {
            this.value = value;
        }
        public String getValue(){
            return value;
        }
    }

    public Role(String name) {
        this.name = name;
    }
    
    public Role(){
        
    }
    
    
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem ecoSystem);

    @Override
    public String toString() {   
        return this.getClass().getTypeName();
//        return this.getClass().getName();
    }
    
    public abstract Role.Type getType();
}
