/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.BitCoinMall.Order;
import Business.BitCoinMall.OrderItem;
import Business.EcoSystem;
import Business.Finance.CoinTransaction.TransactionHistory;
import Business.Finance.Property.Coin;
import Business.Finance.FinancialAccount.FinancialAccount;
import Business.Finance.FinancialAccount.FinancialAccountDirectory;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.WorkQueue.InvestmentWorkRequest;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author lingfengzhou, Chung-Yang Li
 */
public class DepositEnterprise extends Enterprise{
    
    private static DepositEnterprise depositEnterprise;
    private FinancialAccountDirectory financialAccountDirectory;
    private TransactionHistory transactionHistory;
    
    private DepositEnterprise() {
        super(Enterprise.Type.DepositEnterprise.getValue());
        this.financialAccountDirectory = new FinancialAccountDirectory();
        this.transactionHistory = TransactionHistory.getTransactionHistory();
    }
    
    public static synchronized DepositEnterprise getInstance(){
        if(depositEnterprise==null){
            depositEnterprise = new DepositEnterprise();
            depositEnterprise.setName("Universal Bank");
        }
        return depositEnterprise;
    }

    public FinancialAccountDirectory getFinancialAccountDirectory() {
        return financialAccountDirectory;
    }

    @Override
    public FinancialAccount getAccountInfo(String name) {
        return financialAccountDirectory.getFinancialAccount(name);
    }

    public TransactionHistory getTransactionHistory() {
        return transactionHistory;
    }
    
    
    public void matchTradingRequest(InvestmentWorkRequest buyRequest, InvestmentWorkRequest sellRequest, EcoSystem ecoSystem){
        int buyAmount = buyRequest.getAmount();
        double buyPrice = buyRequest.getPrice();
        int sellAmount = sellRequest.getAmount();
        double sellPrice = sellRequest.getPrice();        
        if(buyPrice < sellPrice) return;
        
        String buyer = buyRequest.getInvestmentEnterprise();
        String seller = sellRequest.getInvestmentEnterprise();        
        FinancialAccount buyerAccount = null;
        FinancialAccount sellerAccount = null;     
        for(FinancialAccount financialAccount: financialAccountDirectory.getFinancialAccountList()){
            if(financialAccount.getName().equalsIgnoreCase(buyer)){
                buyerAccount = financialAccount;
            }    
        }
        for(FinancialAccount financialAccount: financialAccountDirectory.getFinancialAccountList()){
            if(financialAccount.getName().equalsIgnoreCase(seller)){
                sellerAccount = financialAccount;
            }        
        }       
        
        /**
         * Coin validation , if fake coin exists return
        */
        if(!validateSellerCoin(sellerAccount)) {
            sellRequest.setStatus("Suspended");
            return;
        }    
        
        /**
         * calculate dealAmount
         */
        
        int dealAmount = buyAmount;
        int bitCoinOfSeller = sellerAccount.getCoinCollection().getCoinList().size();
        if(buyAmount > sellAmount) dealAmount = Math.min(sellAmount, bitCoinOfSeller);           
        if(buyerAccount.getDollorAccount() < sellPrice*dealAmount){ 
            dealAmount = (int)Math.floor(buyerAccount.getDollorAccount()/sellPrice);
        }                
        if(dealAmount==0) return; 

        /**
         * custody rate
        */ 
        double buyServiceRate = buyRequest.getRate();
        double sellServiceRate = sellRequest.getRate();
        FinancialAccount buyRequestCustodyAccount = null;
        FinancialAccount sellRequestCustodyAccount = null;

        for(FinancialAccount financialAccount: financialAccountDirectory.getFinancialAccountList()){
            if(financialAccount.getName().equalsIgnoreCase(buyRequest.getCustodyEnterprise())){
                buyRequestCustodyAccount = financialAccount;
            }    
        }
        for(FinancialAccount financialAccount: financialAccountDirectory.getFinancialAccountList()){
            if(financialAccount.getName().equalsIgnoreCase(sellRequest.getCustodyEnterprise())){
                sellRequestCustodyAccount = financialAccount;
            }    
        }
            
        /**
         * Begin to transaction
        */             

        for(int i = 0; i< dealAmount; i++){
            Coin coin = sellerAccount.getCoinCollection().getCoinList().get(0);
            transactionHistory.createTransaction(coin.getCoinKey(), sellerAccount.getName(), buyerAccount.getName(),coin.getType());
            sellerAccount.getCoinCollection().transferBitCoin(coin, buyerAccount);              
        }
            
        /*Service Fee*/
        double actualSpend = sellPrice * dealAmount * (1 + buyServiceRate);
        double actualEarn = sellPrice * dealAmount * (1 + sellServiceRate);
        double custodyBuyRequestEarn = sellPrice * dealAmount * buyServiceRate;
        double custodySellRequestEarn = sellPrice * dealAmount * sellServiceRate;
        sellerAccount.setDollorAccount(sellerAccount.getDollorAccount() + actualEarn);
        buyerAccount.setDollorAccount(buyerAccount.getDollorAccount() - actualSpend);  
        buyRequestCustodyAccount.setDollorAccount(buyRequestCustodyAccount.getDollorAccount() + custodyBuyRequestEarn);
        sellRequestCustodyAccount.setDollorAccount(sellRequestCustodyAccount.getDollorAccount() + custodySellRequestEarn);

        buyRequest.setAmount(buyRequest.getAmount() - dealAmount);
        sellRequest.setAmount(sellRequest.getAmount() - dealAmount);
        buyRequest.getDealRecord().addDeal(dealAmount, sellPrice);
        sellRequest.getDealRecord().addDeal(dealAmount, sellPrice);
        buyRequest.setStatus("Trading");
        sellRequest.setStatus("Trading");  
        if(buyRequest.getAmount() == 0) buyRequest.setStatus("Filled");
        if(sellRequest.getAmount() == 0) sellRequest.setStatus("Filled");                   
    }   
    
    public boolean validateSellerCoin(FinancialAccount sellerAccount){
        if(sellerAccount.getCoinCollection().getCoinList().isEmpty()) return false;
        for(Coin c:sellerAccount.getCoinCollection().getCoinList()){
            if(!transactionHistory.validateCoin(c.getCoinKey(),sellerAccount.getName())) return false;
        }
        return true;     
        
    }
    
    public void checkout(Order order, Enterprise enterprise, MallEnterprise mallenterprise) {
        FinancialAccount buyerAccount = this.getAccountInfo(enterprise.getName());
        FinancialAccount mallAcc = this.getAccountInfo(mallenterprise.getName());

        /**
         * 
         */
        for (int i = 0; i < order.getTotalPrice(); i++) {
            Coin coin = buyerAccount.getCoinCollection().getCoinList().get(0);
            transactionHistory.createTransaction(coin.getCoinKey(), buyerAccount.getName(), mallAcc.getName(), coin.getType());
            buyerAccount.getCoinCollection().transferBitCoin(coin, mallAcc);
        }
        order.setStatus("Paid");

    }
    
    public boolean checkCoinAmount(int orderPrice, FinancialAccount buyerAccount){
        if (orderPrice>buyerAccount.getCoinCollection().getCoinList().size()) {
            
            return true;
            
        }
        return false;
        
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
    @Override
    public List<Organization.Type> getSupportedOrg() {
        List<Organization.Type> orgTypes = new ArrayList<>();
        orgTypes.add(Organization.Type.Transaction);
        orgTypes.add(Organization.Type.Admin);
        return orgTypes;
        
    }
}
