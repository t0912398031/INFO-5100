/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author lingfengzhou, Chung-Yang Li
 */
public class OrganizationDirectory {
    
    private List<Organization> organizationList;

    public OrganizationDirectory() {
        
        this.organizationList = new ArrayList<>();
    }

    public List<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization addOrganization(Organization.Type type){
        Organization organization = null;
        if (type.getValue().equals(Organization.Type.Admin.getValue())){
            organization = new AdminOrg();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Accounting.getValue())){
            organization = new AccountingOrg();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Investment.getValue())){
            organization = new InvestmentOrg();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Trading.getValue())){
            organization = new TradingOrg();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.CustomerService.getValue())){
            organization = new CustomerServiceOrg();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Transaction.getValue())){
            organization = new TransactionOrg();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Inventory.getValue())){
            organization = new InventoryOrg();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Organization.Type.Logistics.getValue())){
            organization = new LogisticsOrg();
            organizationList.add(organization);
        }
        
        return organization;
    }
    public Organization searchOrgByType(Organization.Type type){
        List<Organization> list = this.getOrganizationList().stream().filter(n->n.getName().equalsIgnoreCase(type.getValue())).collect(Collectors.toList());
        if(list.size() == 0) return null;
        return list.get(0);
    }
    
}
