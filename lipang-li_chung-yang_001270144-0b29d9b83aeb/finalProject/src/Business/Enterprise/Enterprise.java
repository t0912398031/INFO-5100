/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Finance.FinancialAccount.FinancialAccount;
import Business.Organization.OrganizationDirectory;
import Business.Organization.Organization;
import java.util.List;

/**
 *
 * @author lingfengzhou
 */
public abstract class Enterprise extends Organization{
    
    private String name;
    private String type;
    private int enterpriseID;
    private static int counter=2000;
    private OrganizationDirectory organizationDirectory;
    
    public enum Type{
        SystemMantenanceEnterprise("System Mantenance Enterprise"),
        InvestmentEnterprise("Investment Enterprise"), 
        CustodyEnterprise("Custody Enterprise"), 
//        ExchangeEnterprise("Exchange Enterprise"),
        DepositEnterprise("Deposit Enterprise"),
        MallEnterprise("Mall Enterprise");
        
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public Enterprise(String type) {
        super(null);
        this.organizationDirectory = new OrganizationDirectory();
        this.type = type;
        this.enterpriseID = counter;
        ++counter;
        
    }
    
    public Enterprise(){
        super(null);
        
    }
    
    public abstract List<Organization.Type> getSupportedOrg();
    
    public abstract FinancialAccount getAccountInfo(String name);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnterpriseID() {
        return enterpriseID;
    }


    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }
    
    @Override
    public String toString() {
        return name;
    }
    
    
    
}
