/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Finance.FinancialAccount.FinancialAccount;
import Business.Organization.Organization;
import Business.Role.Role;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lingfengzhou
 */
public class CustodyEnterprise extends Enterprise{
    
    private int maxAmount;
    private int minAmount;
    private double rate;
    public CustodyEnterprise() {
        super(Enterprise.Type.CustodyEnterprise.getValue());
//        DepositEnterprise.getInstance().getFinancialAccountDirectory().addFinancialAccount(this.getName());
    }

    public int getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(int minAmount) {
        this.minAmount = minAmount;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public FinancialAccount getAccountInfo(String name) {
        return DepositEnterprise.getInstance().getFinancialAccountDirectory().getFinancialAccount(this.getName());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }

    @Override
    public List<Organization.Type> getSupportedOrg() {
        List<Organization.Type> orgTypes = new ArrayList<>();
        orgTypes.add(Organization.Type.Accounting);
        orgTypes.add(Organization.Type.Admin);
        orgTypes.add(Organization.Type.CustomerService);
        orgTypes.add(Organization.Type.Trading);
        return orgTypes;
        
    }
}
