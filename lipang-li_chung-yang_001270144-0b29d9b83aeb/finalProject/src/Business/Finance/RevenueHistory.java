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
public class RevenueHistory {
    
    private List<Revenue> revenueList;

    public RevenueHistory() {
        revenueList = new ArrayList<>();
    }

    public List<Revenue> getRevenueList() {
        return revenueList;
    }

    public void setRevenueList(List<Revenue> revenueList) {
        this.revenueList = revenueList;
    }
    
    public void addRevenueRecord(Revenue dtp){
        revenueList.add(dtp);
    }
    public void addRevenueRecord(int amount, double price){
        Revenue dtp = new Revenue(amount, price);
        revenueList.add(dtp);
    }
    
}
