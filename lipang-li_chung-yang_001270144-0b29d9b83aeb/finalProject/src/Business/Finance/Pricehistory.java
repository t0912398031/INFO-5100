/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Finance;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lingfengzhou
 */
public class Pricehistory {
    
    private List<DailyTransactionPrice> dailyTransactionPriceList;

    public Pricehistory() {
        dailyTransactionPriceList = new ArrayList<>();
    }

    public List<DailyTransactionPrice> getDailyTransactionPriceList() {
        return dailyTransactionPriceList;
    }

    public void setDailyTransactionPriceList(List<DailyTransactionPrice> dailyTransactionPriceList) {
        this.dailyTransactionPriceList = dailyTransactionPriceList;
    }
    
    public void addDailyTransactionPrice(DailyTransactionPrice dtp){
        dailyTransactionPriceList.add(dtp);
    }
    public void addDailyTransactionPrice(int amount, double price){
        DailyTransactionPrice dtp = new DailyTransactionPrice(amount, price);
        dailyTransactionPriceList.add(dtp);
    }
    
}
