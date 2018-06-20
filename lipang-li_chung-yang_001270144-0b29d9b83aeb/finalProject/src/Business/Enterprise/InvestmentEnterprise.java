/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Finance.Deal;
import Business.Finance.DealRecord;
import Business.Finance.FinancialAccount.FinancialAccount;
import Business.Finance.Revenue;
import Business.Finance.RevenueHistory;
import Business.Organization.InvestmentOrg;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.WorkQueue.InvestmentWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lingfengzhou, Chung-Yang Li
 */
public class InvestmentEnterprise extends Enterprise{
    private double totalBuyDealPrice;
    private double totalSellDealPrice;
    private RevenueHistory earnedRecords;
    private RevenueHistory spentRecords;
    private Revenue totalEarned;
    private Revenue totalSpent;
    
    public InvestmentEnterprise() {
        super(Enterprise.Type.InvestmentEnterprise.getValue());
        earnedRecords = new RevenueHistory();
        spentRecords = new RevenueHistory();
        totalEarned = new Revenue();
        totalSpent = new Revenue();
        
//        DepositEnterprise.getInstance().getFinancialAccountDirectory().addFinancialAccount(this.getName());
    }

    public Revenue getTotalEarned() {
        return totalEarned;
    }

    public void setTotalEarned(Revenue totalEarned) {
        this.totalEarned = totalEarned;
    }

    public Revenue getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(Revenue totalSpent) {
        this.totalSpent = totalSpent;
    }

    public RevenueHistory getSpentRecords() {
        return spentRecords;
    }

    public RevenueHistory getEarnedRecords() {
        return earnedRecords;
    }

    public void setEarnedRecords(RevenueHistory earnedRecords) {
        this.earnedRecords = earnedRecords;
    }

    public double getTotalSellDealPrice() {
        return totalSellDealPrice;
    }

    public void setTotalSellDealPrice(double totalSellDealPrice) {
        this.totalSellDealPrice = totalSellDealPrice;
    }

    public double getTotalBuyDealPrice() {
        return totalBuyDealPrice;
    }

    public void setTotalBuyDealPrice(double totalBuyDealPrice) {
        this.totalBuyDealPrice = totalBuyDealPrice;
    }

    @Override
    public FinancialAccount getAccountInfo(String name) {
        return DepositEnterprise.getInstance().getFinancialAccountDirectory().getFinancialAccount(this.getName());
    }
    
    public double calculateSpentAndEarnEachMatch(){
        double spent = 0;
        double earned = 0;
        int buyAmount = 0;
        int sellAmount = 0;
        for(Organization org: this.getOrganizationDirectory().getOrganizationList()){
            if(org instanceof InvestmentOrg){
                for (WorkRequest request : org.getWorkQueue().getWorkRequestList()){            
                    InvestmentWorkRequest workRequest = (InvestmentWorkRequest)request;
                    if(workRequest.getStatus().matches("Filled|Trading") && workRequest.getType().equalsIgnoreCase("Buy")){
                        for(Deal deal: workRequest.getDealRecord().getDealRecord()){ 
                            buyAmount += deal.getDealAmount();
                            spent += deal.getDealPrice() * deal.getDealAmount();                       
                        }
                    }
                    if(workRequest.getStatus().matches("Filled|Trading") && workRequest.getType().equalsIgnoreCase("Sell")){
                        for(Deal deal: workRequest.getDealRecord().getDealRecord()){ 
                            sellAmount += deal.getDealAmount();
                            earned += deal.getDealPrice() * deal.getDealAmount();                       
                        }
                    }       
                }
            }
        }       
        int spendRecordSize = this.getSpentRecords().getRevenueList().size();
        int earnedRecordSize = this.getEarnedRecords().getRevenueList().size();
        if(spendRecordSize > 0 && earnedRecordSize >0){
            Revenue previousSpendRecord = this.getSpentRecords().getRevenueList().get(spendRecordSize-1);
            Revenue previousEarnedRecord = this.getEarnedRecords().getRevenueList().get(earnedRecordSize-1);
            sellAmount -= totalEarned.getDealAmount();
            earned -= totalEarned.getDealPrice();
            buyAmount -= totalSpent.getDealAmount();
            spent -= totalSpent.getDealPrice();
        System.out.println(previousEarnedRecord.getDealAmount());
        System.out.println(previousEarnedRecord.getDealPrice());
        System.out.println(previousSpendRecord.getDealAmount());
        System.out.println(previousSpendRecord.getDealPrice());   
        }
//        System.out.println(buyAmount);
//        System.out.println(spent);
//        System.out.println(sellAmount);
//        System.out.println(earned);
        this.getSpentRecords().addRevenueRecord(buyAmount, spent);
        this.getEarnedRecords().addRevenueRecord(sellAmount, earned);

        this.setTotalSpent(new Revenue(buyAmount+this.totalSpent.getDealAmount(), spent+this.totalSpent.getDealPrice()));
        this.setTotalEarned(new Revenue(sellAmount+this.totalEarned.getDealAmount(), earned+this.totalEarned.getDealPrice()));
        
        return 0;
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
        orgTypes.add(Organization.Type.Logistics);
        orgTypes.add(Organization.Type.Investment);
        return orgTypes;
        
    }
}
