/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.CustomerServiceOrg;
import Business.Organization.Organization;
import Business.WorkQueue.InvestmentWorkRequest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lingfengzhou, Chung-Yang Li
 */
public class EnterpriseNetwork {
    
    private List<Enterprise> enterpriseList;

    public EnterpriseNetwork() {
        
        this.enterpriseList = new ArrayList<>();
        
    }

    public List<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }
    
    public Enterprise addEnterprise(Enterprise.Type type,String name){
        Enterprise enterprise = null;
        if (type.getValue().equals(Enterprise.Type.InvestmentEnterprise.getValue())){
            enterprise = new InvestmentEnterprise();
            enterprise.setName(name);
            enterpriseList.add(enterprise);
        }
        else if (type.getValue().equals(Enterprise.Type.CustodyEnterprise.getValue())){
            enterprise = new CustodyEnterprise();
            enterprise.setName(name);
            enterpriseList.add(enterprise);
        }
        
        else if (type.getValue().equals(Enterprise.Type.MallEnterprise.getValue())){
            enterprise = new MallEnterprise();
            enterprise.setName(name);
            enterpriseList.add(enterprise);
        }
//        else if (type.getValue().equals(Enterprise.Type.ExchangeEnterprise.getValue())){
//            enterprise = new ExchangeEnterprise();
//            enterpriseList.add(enterprise);
//        }
//        else if (type.getValue().equals(Enterprise.Type.DepositEnterprise.getValue())){
//            enterprise = new DepositEnterprise();
//            enterpriseList.add(enterprise);
//        }
        return enterprise;
    }
    
    public void addMatchtoMatchedCustodyOrg(InvestmentWorkRequest buyMatched){
        for (Enterprise enterprise : enterpriseList) {
            if (enterprise instanceof CustodyEnterprise && enterprise.getName().equalsIgnoreCase(buyMatched.getCustodyEnterprise())) {
                for(Organization org: enterprise.getOrganizationDirectory().getOrganizationList()){
                    if(org instanceof CustomerServiceOrg){                                
                        org.getWorkQueue().addMatchRequest(buyMatched);
                    }
                }
            }
        }
    }
    
    public void clearMatchedCustodyOrgWorkqueue(InvestmentWorkRequest buyMatched){
        for (Enterprise enterprise : enterpriseList) {
            if (enterprise instanceof CustodyEnterprise && enterprise.getName().equalsIgnoreCase(buyMatched.getCustodyEnterprise())) {
                for(Organization org: enterprise.getOrganizationDirectory().getOrganizationList()){
                    if(org instanceof CustomerServiceOrg){                                
                        org.getWorkQueue().getWorkRequestList().clear();
                    }
                }
            }
        }
    }

 
    
    public Enterprise searchByName(String entName){
        for (Enterprise e : enterpriseList){
            if(e.getName().equalsIgnoreCase(entName))
                return e;
        }
        return null;
    }
    
    
}
