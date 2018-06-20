/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Finance;

import java.util.ArrayList;

/**
 *
 * @author Chung-Yang Li
 */
public class DealRecord {
    private ArrayList<Deal> dealRecord;

    public DealRecord() {
        this.dealRecord = new ArrayList<>();
    }

    public ArrayList<Deal> getDealRecord() {
        return dealRecord;
    }
    
    public Deal addDeal(Deal deal){
        dealRecord.add(deal);
        return deal;
    }
    
    public Deal addDeal(int amount, double price){
        Deal deal = new Deal();
        deal.setDealAmount(amount);
        deal.setDealPrice(price);
        dealRecord.add(deal);
        return deal;
    }

}
