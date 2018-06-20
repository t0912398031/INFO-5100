/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Finance.DailyTransactionPrice;
import Business.Finance.Deal;
import Business.Finance.Pricehistory;
import Business.Role.Role;
import Business.Role.TradingManager;
import Business.Role.TransactionManager;
import Business.WorkQueue.InvestmentWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lingfengzhou
 * @author Chung-Yang Li
 */
public class TransactionOrg extends Organization{
    private double totalPrice;
    private int totalAmount;
    private double averageHistoryPrice;
    private double currentAveragePrice;
    private Pricehistory pricehistory;
    private double Dailyturnover;

    public TransactionOrg() {
        super(Organization.Type.Transaction.getValue());
        this.pricehistory = new Pricehistory();
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new TransactionManager());
        return roles;
    }

    public double getCurrentAveragePrice() {
        return currentAveragePrice;
    }

    public void setCurrentAveragePrice(double currentAveragePrice) {
        this.currentAveragePrice = currentAveragePrice;
    }

    public double getDailyturnover() {
        return Dailyturnover;
    }

    public void setDailyturnover(double Dailyturnover) {
        this.Dailyturnover = Dailyturnover;
    }

    public double getAverageHistoryPrice() {
        return averageHistoryPrice;
    }

    public void setAverageHistoryPrice(double averageHistoryPrice) {
        this.averageHistoryPrice = averageHistoryPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Pricehistory getPricehistory() {
        return pricehistory;
    }

    public void setPricehistory(Pricehistory pricehistory) {
        this.pricehistory = pricehistory;
    }

    
    public double calculateAveragePrice(){
        int amount = 0;
        double price = 0;
        int dailyAmount = 0;
        double dailyPrice = 0;
        for (WorkRequest request : this.getWorkQueue().getWorkRequestList()){            
            InvestmentWorkRequest workRequest = (InvestmentWorkRequest)request;
            if(workRequest.getStatus().matches("Filled|Trading") && workRequest.getType().equalsIgnoreCase("Buy")){
                for(Deal deal: workRequest.getDealRecord().getDealRecord()){
                    amount += deal.getDealAmount();
                    price += deal.getDealPrice() * deal.getDealAmount();
                }
            }
        }
        dailyAmount = amount - this.getTotalAmount();
        dailyPrice = price - this.getTotalPrice();     
        if(dailyAmount == 0) return 0.00;
        this.pricehistory.addDailyTransactionPrice(dailyAmount,dailyPrice/dailyAmount);
        this.setCurrentAveragePrice(dailyPrice/dailyAmount);
//        System.out.println(pricehistory.getDailyTransactionPriceList().size());
//        System.out.println(pricehistory.getDailyTransactionPriceList().get(pricehistory.getDailyTransactionPriceList().size()-1).getDealPrice());
//        System.out.println(price/amount);
//        amount += this.getTotalAmount();
//        price += this.getTotalPrice();
        this.setTotalAmount(amount);
        this.setTotalPrice(price);
        this.setAverageHistoryPrice(price/amount);        
        return price/amount;
    }
}
