/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Enterprise.InvestmentEnterprise;
import Business.Finance.Deal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lingfengzhou, Chung-Yang Li
 */
public class WorkQueue {
    
    private List<WorkRequest> workRequestList;

    public WorkQueue() {
        this.workRequestList = new ArrayList<>();
    }

    public List<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }
    public void addWorkRequest(WorkRequest workRequest){
        workRequestList.add(workRequest);
    }
    
    public void addMatchRequest(InvestmentWorkRequest workRequest){
        workRequestList.add(workRequest);
    }
    public void addNewMatchRequest(InvestmentWorkRequest workRequest){
//        InvestmentWorkRequest matchRequest = new InvestmentWorkRequest();
        InvestmentWorkRequest matchRequest = workRequest;
//        matchRequest.setWorkNumber(workRequest.getWorkNumber());
//        matchRequest.setRequestDate(workRequest.getRequestDate());
//        matchRequest.setAmount(workRequest.getAmount());
        matchRequest.setInitialAmount(workRequest.getAmount());
//        matchRequest.setInvestmentEnterprise(workRequest.getInvestmentEnterprise());
//        matchRequest.setCustodyEnterprise(workRequest.getCustodyEnterprise());
        matchRequest.setPrice(workRequest.getPrice());
//        matchRequest.setType(workRequest.getType());
        matchRequest.setStatus("Ready to trade");
        workRequestList.add(matchRequest);
    }
    
    public void removeWorkRequest(WorkRequest workRequest){
        workRequestList.remove(workRequest);
    }
    
    public void removeAllWorkRequest(){
        workRequestList.removeAll(workRequestList);
    }
    
//    public double calculateAveragePrice(TransactionOrg matchingOrg){
//        int amount = 0;
//        double price = 0;
//        
//        for (WorkRequest request : matchingOrg.getWorkQueue().getWorkRequestList()){            
//            InvestmentWorkRequest workRequest = (InvestmentWorkRequest)request;
//            if(workRequest.getStatus().matches("Filled|Trading") && workRequest.getType().equalsIgnoreCase("Buy")){
//                for(Deal deal: workRequest.getDealRecord().getDealRecord()){
//                    amount += deal.getDealAmount();
//                    price += deal.getDealPrice() * deal.getDealAmount();
//                }
//            }
//        }
//        matchingOrg.addDailyTransactionPrice(price/amount);
//        amount += matchingOrg.getTotalAmount();
//        price += matchingOrg.getTotalPrice();
//        matchingOrg.setAverageHistoryPrice(price/amount);        
//        return price/amount;
//    }
    
    public double calculateTotalBuyDealPrice(InvestmentEnterprise enterprise){
        double buyPrice = 0;
        double sellPrice = 0;
        for (WorkRequest request : workRequestList){            
            InvestmentWorkRequest workRequest = (InvestmentWorkRequest)request;
            if(enterprise.getName().equalsIgnoreCase(workRequest.getInvestmentEnterprise())){
                if(workRequest.getStatus().matches("Filled|Trading") && workRequest.getType().equalsIgnoreCase("Buy")){
                    for(Deal deal: workRequest.getDealRecord().getDealRecord()){ 
                        buyPrice += deal.getDealPrice() * deal.getDealAmount();                       
                    }
                }
                if(workRequest.getStatus().matches("Filled|Trading") && workRequest.getType().equalsIgnoreCase("Sell")){
                    for(Deal deal: workRequest.getDealRecord().getDealRecord()){ 
                        sellPrice += deal.getDealPrice() * deal.getDealAmount();                       
                    }
                }
                
            }
        }
        enterprise.setTotalBuyDealPrice(buyPrice + enterprise.getTotalBuyDealPrice());
        enterprise.setTotalSellDealPrice(sellPrice + enterprise.getTotalSellDealPrice());
        return enterprise.getTotalBuyDealPrice();
    }
    
    

}
