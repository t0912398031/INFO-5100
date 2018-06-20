/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Finance.FinancialAccount;

import Business.Finance.Property.CoinCollection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lingfengzhou, Chung-Yang Li
 */
public class FinancialAccountDirectory {
    
    private ArrayList<FinancialAccount> financialAccountList;

    public FinancialAccountDirectory() {
        this.financialAccountList = new ArrayList<>();
    }

    public List<FinancialAccount> getFinancialAccountList() {
        return financialAccountList;
    }
    
    public FinancialAccount addFinancialAccount(String name){
        FinancialAccount financialAccount = new FinancialAccount(name);
        financialAccountList.add(financialAccount);
        return financialAccount;
    }
    public FinancialAccount addCompleteFinancialAccount(String name, CoinCollection bitcoinAccount, Double dollorAccount){
        FinancialAccount financialAccount = new FinancialAccount(name, bitcoinAccount, dollorAccount);
        financialAccountList.add(financialAccount);
        return financialAccount;
    }
    
    public FinancialAccount getFinancialAccount(String name){
        FinancialAccount financialAccount =null;
        if(name==null) return financialAccount;
        for(FinancialAccount f:financialAccountList){
            if(f.getName().equals(name)) {
                financialAccount = f;
                break;
            }
        }
        return financialAccount;
    }
}
