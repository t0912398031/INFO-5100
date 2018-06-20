/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Finance.CoinTransaction;

import Business.Finance.Property.Coin;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author lingfengzhou
 */
public class TransactionHistory {
    
    private static TransactionHistory transactionHistory;
    private List<Transaction> transactionList;

    private  TransactionHistory() {
        
        this.transactionList = new ArrayList<>();
        
    }
    
    public static synchronized TransactionHistory getTransactionHistory(){
         if(transactionHistory==null){
            transactionHistory = new TransactionHistory();
         }
         return transactionHistory;
        
    }
    
    public List<Transaction> getTransactionList(){
        return this.transactionList.stream().collect(Collectors.toCollection(ArrayList::new));
    }
    
    public void createTransaction(String coinNum, String prevOwner, String curOwner,String type){
        Transaction transaction = new Transaction(LocalDateTime.now(), coinNum, prevOwner, curOwner,type);
        this.transactionList.add(transaction);
    }
    
    public List<Transaction> searchTransactionHistory(String coinNum){
        List<Transaction>  res = transactionList.stream().filter(n -> n.getCoinNum().equals(coinNum)).collect(Collectors.toCollection(ArrayList::new));
        return res;
    }
    
    public boolean validateCoin(String coinNum, String curOwner){
        List<Transaction> res = searchTransactionHistory(coinNum);
        if(res.isEmpty()) return false;
        if(!res.get(res.size()-1).getCurOwner().equalsIgnoreCase(curOwner)) return false;
        return true;
    }
    
}
