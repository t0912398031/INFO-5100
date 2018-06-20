/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author Chung-Yang Li
 */
public class AccountDirectory {
    
    private ArrayList<Account> accountList;
    
    public AccountDirectory(){
        this.accountList = new ArrayList<>();
    }

    public ArrayList<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(ArrayList<Account> a) {
        this.accountList = a;
    }
    
    public Account addAccount(){
        Account a = new Account();
        accountList.add(a);
        return a;
    }
    
    public void deleteAccount(Account a){
        accountList.remove(a);
    }
    
    public Account searchAccount(String accountNum){
        for(Account a: accountList){
            if(a.getAccountNum().equals(accountNum)){
                return a;
            }
        }
        return null;
    }
    
    
}
